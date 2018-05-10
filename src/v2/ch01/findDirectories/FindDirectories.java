package v2.ch01.findDirectories;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

/**
 * @version 1.1 2012-05-31
 * @author Cay Horstmann
 */
public class FindDirectories {
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get(args.length == 0 ? System.getProperty("user.home") : args[0]);
		if (dir.toAbsolutePath().toString().equals("/home/niu")) {
			dir = Paths.get(dir.toString(), "Downloads");
		}
		System.out.println(dir);
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
			// 查询所有的文件
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file+"{"+attrs.size()/1024.00/1024.00+"m}");
				return FileVisitResult.CONTINUE;
			}

			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}

			// 查询所有的目录
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
				System.out.println(dir + "{" + attrs.creationTime() + "}");
				return FileVisitResult.CONTINUE;

			}
		});
	}
}
