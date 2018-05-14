package v2.ch04.view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.sql.rowset.*;
import javax.swing.*;

import v2.ch04.test.TestDB;

/**
 * This program uses metadata to display arbitrary tables in a database.
 * @version 1.32 2012-01-26
 * @author Cay Horstmann
 */
public class ViewDB
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new ViewDBFrame();
               frame.setTitle("ViewDB");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * The frame that holds the data panel and the navigation buttons.
 */
class ViewDBFrame extends JFrame
{
   private JButton previousButton;
   private JButton nextButton;
   private JButton deleteButton;
   private JButton saveButton;
   private DataPanel dataPanel;
   private Component scrollPane;
   private JComboBox<String> tableNames;
   private CachedRowSet crs;

   public ViewDBFrame()
   {
      tableNames = new JComboBox<String>();
      tableNames.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               showTable((String) tableNames.getSelectedItem());
            }
         });
      add(tableNames, BorderLayout.NORTH);

      try
      {
         try (Connection conn = TestDB.getConnection())
         {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet mrs = meta.getTables(null, null, null, new String[] { "TABLE" });
            while (mrs.next())
               tableNames.addItem(mrs.getString(3));
         }
      }
      catch (SQLException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
      catch (IOException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }

      JPanel buttonPanel = new JPanel();
      add(buttonPanel, BorderLayout.SOUTH);

      previousButton = new JButton("Previous");
      previousButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               showPreviousRow();
            }
         });
      buttonPanel.add(previousButton);

      nextButton = new JButton("Next");
      nextButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               showNextRow();
            }
         });
      buttonPanel.add(nextButton);

      deleteButton = new JButton("Delete");
      deleteButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               deleteRow();
            }
         });
      buttonPanel.add(deleteButton);

      saveButton = new JButton("Save");
      saveButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               saveChanges();
            }
         });
      buttonPanel.add(saveButton);
      pack();
   }

   /**
    * Prepares the text fields for showing a new table, and shows the first row.
    * @param tableName the name of the table to display
 * @throws IOException 
    */
   public void showTable(String tableName)
   {
      try
      {
         try (Connection conn = TestDB.getConnection())
         {
            // get result set
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * FROM " + tableName);
            // copy into cached row set
            RowSetFactory factory = RowSetProvider.newFactory();            
            crs = factory.createCachedRowSet();
            crs.setTableName(tableName);
            crs.populate(result);            
         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         if (scrollPane != null) remove(scrollPane);
         dataPanel = new DataPanel(crs);
         scrollPane = new JScrollPane(dataPanel);
         add(scrollPane, BorderLayout.CENTER);
         validate();
         showNextRow();
      }
      catch (SQLException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
   }

   /**
    * Moves to the previous table row.
    */
   public void showPreviousRow()
   {
      try
      {
         if (crs == null || crs.isFirst()) return;
         crs.previous();
         dataPanel.showRow(crs);
      }
      catch (SQLException e)
      {
         for (Throwable t : e)
            t.printStackTrace();
      }
   }

   /**
    * Moves to the next table row.
    */
   public void showNextRow()
   {
      try
      {
         if (crs == null || crs.isLast()) return;
         crs.next();
         dataPanel.showRow(crs);
      }
      catch (SQLException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
   }

   /**
    * Deletes current table row.
    */
   public void deleteRow()
   {
      try
      {
         try (Connection conn = TestDB.getConnection())
         {
            crs.deleteRow();
            crs.acceptChanges(conn);
            if (crs.isAfterLast()) 
               if (!crs.last()) crs = null;
            dataPanel.showRow(crs);
         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      catch (SQLException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
   }

   /**
    * Saves all changes.
    */
   public void saveChanges()
   {
      try
      {
         try (Connection conn = TestDB.getConnection())
         {
            dataPanel.setRow(crs);
            crs.acceptChanges(conn);
         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      catch (SQLException e)
      {
         JOptionPane.showMessageDialog(this, e);
      }
   }
}

/**
 * This panel displays the contents of a result set.
 */
class DataPanel extends JPanel
{
   private java.util.List<JTextField> fields;

   /**
    * Constructs the data panel.
    * @param rs the result set whose contents this panel displays
    */
   public DataPanel(RowSet rs) throws SQLException
   {
      fields = new ArrayList<>();
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridwidth = 1;
      gbc.gridheight = 1;

      ResultSetMetaData rsmd = rs.getMetaData();
      for (int i = 1; i <= rsmd.getColumnCount(); i++)
      {
         gbc.gridy = i - 1;

         String columnName = rsmd.getColumnLabel(i);
         gbc.gridx = 0;
         gbc.anchor = GridBagConstraints.EAST;
         add(new JLabel(columnName), gbc);

         int columnWidth = rsmd.getColumnDisplaySize(i);
         JTextField tb = new JTextField(columnWidth);
         if (!rsmd.getColumnClassName(i).equals("java.lang.String"))
            tb.setEditable(false);
               
         fields.add(tb);

         gbc.gridx = 1;
         gbc.anchor = GridBagConstraints.WEST;
         add(tb, gbc);
      }
   }

   /**
    * Shows a database row by populating all text fields with the column values.
    */
   public void showRow(ResultSet rs) throws SQLException
   {
      for (int i = 1; i <= fields.size(); i++)
      {
         String field = rs == null ? "" : rs.getString(i);
         JTextField tb = fields.get(i - 1);
         tb.setText(field);
      }
   }
   
   /**
    * Updates changed data into the current row of the row set.
    */
   public void setRow(RowSet rs) throws SQLException
   {
      for (int i = 1; i <= fields.size(); i++)
      {
         String field = rs.getString(i);
         JTextField tb = fields.get(i - 1);
         if (!field.equals(tb.getText()))
            rs.updateString(i, tb.getText());
      }
      rs.updateRow();
   }
}
