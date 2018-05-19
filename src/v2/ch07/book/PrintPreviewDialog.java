package v2.ch07.book;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * This class implements a generic print preview dialog.
 */
public class PrintPreviewDialog extends JDialog {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	private PrintPreviewCanvas canvas;

	/**
	* Constructs a print preview dialog.
	* @param p a Printable
	* @param pf the page format
	* @param pages the number of pages in p
	*/
	public PrintPreviewDialog(Printable p, PageFormat pf, int pages) {
		Book book = new Book();
		book.append(p, pf, pages);
		layoutUI(book);
	}

	/**
	* Constructs a print preview dialog.
	* @param b a Book
	*/
	public PrintPreviewDialog(Book b) {
		layoutUI(b);
	}

	/**
	* Lays out the UI of the dialog.
	* @param book the book to be previewed
	*/
	public void layoutUI(Book book) {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		canvas = new PrintPreviewCanvas(book);
		add(canvas, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();

		JButton nextButton = new JButton("Next");
		buttonPanel.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.flipPage(1);
			}
		});

		JButton previousButton = new JButton("Previous");
		buttonPanel.add(previousButton);
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.flipPage(-1);
			}
		});

		JButton closeButton = new JButton("Close");
		buttonPanel.add(closeButton);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});

		add(buttonPanel, BorderLayout.SOUTH);
	}
}
