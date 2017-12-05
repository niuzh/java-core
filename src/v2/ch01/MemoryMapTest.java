package v2.ch01;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
 * 内存映射
 * @author niu
 *
 */
public class MemoryMapTest {

	public static long checksumInputStream(Path fileName) throws IOException {
		try(InputStream inputStream=Files.newInputStream(fileName)){
			CRC32 crc=new CRC32();
			int c;
			while ((c=inputStream.read())!=-1) {
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checksumBufferedInputStream(Path fileName) throws IOException {
		try(InputStream inputStream=new BufferedInputStream(Files.newInputStream(fileName))){
			CRC32 crc=new CRC32();
			int c;
			while ((c=inputStream.read())!=-1) {
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checksumRandomAccessInputStream(Path fileName) throws IOException {
		try(RandomAccessFile inputStream=new RandomAccessFile(fileName.toFile(),"r")){
			CRC32 crc=new CRC32();
			int c;
			while ((c=inputStream.read())!=-1) {
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checksumMappedFile(Path fileName) throws IOException {
		try(FileChannel channel=FileChannel.open(fileName)){
			CRC32 crc=new CRC32();
			int length=(int)channel.size();
			MappedByteBuffer buffer=channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
			for (int i = 0; i < length; i++) {
				int c=buffer.get(i);
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	public static void main(String[] args) throws IOException {
		String filePath="/home/niu/Documents/tool/jdk1.8.0_131/jre/lib/rt.jar";
		MemoryMapTest test=new MemoryMapTest();
		Path path=Paths.get(filePath);
		int msize=(int) (path.toFile().length()/1024/1024);
		System.out.println("size:"+msize+"M");
		msize=(int) (path.toFile().length()/1000/1000);
		System.out.println("size:"+msize+"M");
		System.out.println("checksumInputStream");
		long start=System.currentTimeMillis();
		long crcValue=test.checksumInputStream(path);
		System.out.println((System.currentTimeMillis()-start)+"milliseconds");
		start=System.currentTimeMillis();
		crcValue=test.checksumBufferedInputStream(path);
		System.out.println("checksumBufferedInputStream");
		System.out.println((System.currentTimeMillis()-start)+"milliseconds");
		start=System.currentTimeMillis();
		crcValue=test.checksumRandomAccessInputStream(path);
		System.out.println("checksumRandomAccessInputStream");
		System.out.println((System.currentTimeMillis()-start)+"milliseconds");
		start=System.currentTimeMillis();
		crcValue=test.checksumMappedFile(path);
		System.out.println("checksumMappedFile");
		System.out.println((System.currentTimeMillis()-start)+"milliseconds");
	}

}
