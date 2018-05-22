package v2.ch09.classLoader;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This program demonstrates a custom class loader that decrypts class files.
 * @version 1.23 2012-06-08
 * @author Cay Horstmann
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new ClassLoaderFrame();
				frame.setTitle("ClassLoaderTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * This frame contains two text fields for the name of the class to load and the decryption key.
 */
class ClassLoaderFrame extends JFrame {
	private JTextField keyField = new JTextField("3", 4);
	private JTextField nameField = new JTextField("Calculator", 30);
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	public ClassLoaderFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLayout(new GridBagLayout());
		add(new JLabel("Class"), new GBC(0, 0).setAnchor(GBC.EAST));
		add(nameField, new GBC(1, 0).setWeight(100, 0).setAnchor(GBC.WEST));
		add(new JLabel("Key"), new GBC(0, 1).setAnchor(GBC.EAST));
		add(keyField, new GBC(1, 1).setWeight(100, 0).setAnchor(GBC.WEST));
		JButton loadButton = new JButton("Load");
		add(loadButton, new GBC(0, 2, 2, 1));
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				runClass(nameField.getText(), keyField.getText());
			}
		});
		pack();
	}

	/**
	* Runs the main method of a given class.
	* @param name the class name
	* @param key the decryption key for the class files
	*/
	public void runClass(String name, String key) {
		try {
			ClassLoader loader = new CryptoClassLoader(Integer.parseInt(key));
			Class<?> c = loader.loadClass(name);
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object) new String[] {});
		} catch (Throwable e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}

}

/**
 * This class loader loads encrypted class files.
 */
class CryptoClassLoader extends ClassLoader {
	private int key;

	/**
	* Constructs a crypto class loader.
	* @param k the decryption key
	*/
	public CryptoClassLoader(int k) {
		key = k;
	}

	// 查询类字节码，并调用defineClass方法将字节码传给虚拟机
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] classBytes = null;
			// 获取正常类的字节码
			classBytes = loadClassBytes(name);
			Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
			if (cl == null)
				throw new ClassNotFoundException(name);
			return cl;
		} catch (IOException e) {
			throw new ClassNotFoundException(name);
		}
	}

	/**
	* Loads and decrypt the class file bytes.
	* @param name the class name
	* @return an array with the class file bytes
	*/
	private byte[] loadClassBytes(String name) throws IOException {
		String cname = ("v2.ch09.classLoader." + name).replace('.', '/') + ".caesar";
		byte[] bytes = Files.readAllBytes(Paths.get("/home", "niu", "workspace", "java-core9/src/", cname));
		for (int i = 0; i < bytes.length; i++)
			bytes[i] = (byte) (bytes[i] - key);
		return bytes;
	}
}
