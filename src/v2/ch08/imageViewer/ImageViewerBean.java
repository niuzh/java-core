package v2.ch08.imageViewer;

import java.awt.Dimension;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A bean for viewing an image.
 * @version 1.22 2012-06-10
 * @author Cay Horstmann
 */
public class ImageViewerBean extends JLabel {
	private Path path = null;
	private static final int XPREFSIZE = 200;
	private static final int YPREFSIZE = 200;

	public ImageViewerBean() {
		setBorder(BorderFactory.createEtchedBorder());
	}

	/**
	* Sets the fileName property.
	* @param fileName the image file name
	*/
	public void setFileName(String fileName) {
		path = Paths.get(fileName);
		try (InputStream in = Files.newInputStream(path)) {
			setIcon(new ImageIcon(ImageIO.read(in)));
		} catch (IOException e) {
			path = null;
			setIcon(null);
		}
	}

	/**
	* Gets the fileName property.
	* @return the image file name
	*/
	public String getFileName() {
		if (path == null)
			return "";
		else
			return path.toString();
	}

	public Dimension getPreferredSize() {
		return new Dimension(XPREFSIZE, YPREFSIZE);
	}
}
