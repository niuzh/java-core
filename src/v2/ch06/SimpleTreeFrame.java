package v2.ch06;

import java.awt.EventQueue;
import java.math.BigDecimal;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


public class SimpleTreeFrame extends JFrame {

	public SimpleTreeFrame() {
		setSize(300,200);
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("World");
		root.setUserObject(new BigDecimal(100));
		DefaultMutableTreeNode country=new DefaultMutableTreeNode("USA");
		root.add(country);
		DefaultMutableTreeNode state=new DefaultMutableTreeNode("California");
		country.add(state);
		DefaultMutableTreeNode city=new DefaultMutableTreeNode("San Jose");
		state.add(city);
		root.add(country);
		state=new DefaultMutableTreeNode("Michigan");
		country.add(state);
		city=new DefaultMutableTreeNode("Ann Arbor");
		state.add(city);
		country=new DefaultMutableTreeNode("中国");
		root.add(country);
		state=new DefaultMutableTreeNode("北京");
		state.setAllowsChildren(true);
		country.add(state);
		state=new DefaultMutableTreeNode("四川");
		country.add(state);
		city=new DefaultMutableTreeNode("成都");
		city.setAllowsChildren(false);
		state.add(city);
		JTree tree=new JTree(root,true);
		add(new JScrollPane(tree));
		//tree.setRootVisible(false);
		pack();
		Enumeration enumeration=root.breadthFirstEnumeration();
		while (enumeration.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) enumeration.nextElement();
			System.out.println(node.getUserObject());
		}
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node =(DefaultMutableTreeNode)((JTree) e.getSource()).getLastSelectedPathComponent();
				System.out.println(node.getUserObject());
			}
		});
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame=new SimpleTreeFrame();
				frame.setSize(300, 200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	}

}
