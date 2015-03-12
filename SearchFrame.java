//package Uppgift3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class SearchFrame extends JFrame {

	private String message = "";
	private JLabel lab1 = new JLabel(message);

	JPanel textPanel;

	private JTextArea jta = new JTextArea(30,45);
// knappar
	private JButton b1 = new JButton("Search for member first name");

		ActionListener aLb1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Search Code exec");
		ArrayList<String> g = new ArrayList<String>();
		textPanel.setVisible(false);
		jta.setText("");
		JFrame inputframe = new JFrame("Insert Name");
    String inputname = JOptionPane.showInputDialog(inputframe, "What's the name");
		message = "Resultat String Search for member id";
		Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:minDatabas");

                System.out.println("Opened database successfully");

                stmt = c.createStatement();

              
                ResultSet rs = stmt.executeQuery("select id, givenName, familyName, gender, birth, memberSince, active from medlem where familyName = " + "'" + inputname + "'");

                while (rs.next()) {
                    g.add("\n" + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7));;
                }

                for (int i = 0; i < g.size(); i++) {
                    jta.append(g.get(i) + "\n");

                }

            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
		textPanel.setVisible(true);
			
		}
	};
    private JButton b2 = new JButton("Search for Leaders in specifik team");
    	ActionListener aLb2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Search Code exec");
		textPanel.setVisible(false);
		jta.setText("");
		JFrame inputframe = new JFrame("Insert Team");
    String inputname = JOptionPane.showInputDialog(inputframe, "Insert team");
		message = "Resultat String Search for leader in team";
		jta.append(message); 
		textPanel.setVisible(true);

		}
   };
   private JButton b3 = new JButton("Order all members by ID");
    	ActionListener aLb3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		textPanel.setVisible(false);
		//
		ArrayList<String> a = new ArrayList<String>();
        jta.setText("");
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:minDatabas");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from medlem order by id");
            while (rs.next()) {
                a.add("\n" + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7));;
                 System.out.println("Sorting done successfully");
           	} 
            } catch (Exception exc) {
            System.err.println(exc.getClass().getName() + ": " + exc.getMessage());
            
        }
        for (int i = 0; i < a.size(); i++) {
            jta.append(a.get(i) + "\n");


        }
       
        textPanel.setVisible(true);
    }
    //GEN-LAST:event_jButton3ActionPerformed
        //
		/*jta.setText("");
		message = "Sorterar alla members";
		jta.append(message); */
		
   };
   private JButton b6 = new JButton("Order all members by FamilyName");
    	ActionListener aLb6 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		textPanel.setVisible(false);

		ArrayList<String> a = new ArrayList<String>();
        jta.setText("");
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:minDatabas");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from medlem order by familyName");
            while (rs.next()) {
                a.add("\n" + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7));;
           	} 
            } catch (Exception exc) {
            System.err.println(exc.getClass().getName() + ": " + exc.getMessage());
            System.exit(0);
        }
        for (int i = 0; i < a.size(); i++) {
            jta.append(a.get(i) + "\n");

        }
        System.out.println("Sorting done successfully");
        textPanel.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed
        //
		/*jta.setText("");
		message = "Sorterar alla members";
		jta.append(message); */
		
   
   };
   private JButton b4 = new JButton("Search for specifik Team");
    	ActionListener aLb4 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Specifikt lag skrivs ut");
		textPanel.setVisible(false);
		jta.setText("");
		JFrame inputframe = new JFrame("Insert Team");
    String inputname = JOptionPane.showInputDialog(inputframe, "What's the Team");
		message = "Resultat String Search for member id";
		jta.append(message); 
		textPanel.setVisible(true);
		}
   };
   private JButton b5 = new JButton("Back");
    	ActionListener aLb5 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
		}
   };


// konstruktor	
	public SearchFrame(){

	//Actionlisteners
		b1.addActionListener(aLb1);
		b2.addActionListener(aLb2);
		b3.addActionListener(aLb3);
		b4.addActionListener(aLb4);
		b5.addActionListener(aLb5);
		b6.addActionListener(aLb6);
	//panel	
	JPanel buttonPanel = new JPanel();
  	 textPanel = new JPanel();

	setLayout(new BorderLayout());

	textPanel.setLayout(new GridBagLayout());
	GridBagConstraints g1 = new GridBagConstraints();
	
	g1.gridx = 0;
	g1.gridy = 0;
	g1.gridwidth = 2; 
	g1.gridheight = 1;

	g1.insets = new Insets(25, 25, 25, 25);

	jta.setOpaque(false);
	jta.insert(message,0);
	textPanel.add(jta,g1);

	buttonPanel.add(b1); 
	buttonPanel.add(b2);
	buttonPanel.add(b3);
	buttonPanel.add(b6);	
	buttonPanel.add(b4);
	buttonPanel.add(b5);
	
	add(textPanel,BorderLayout.CENTER);
	add(buttonPanel, BorderLayout.NORTH);
	


	// must do's
	setExtendedState(Frame.MAXIMIZED_BOTH);

	setTitle("Search");
	setBackground(Color.white);
	setVisible(true);
	pack();
	setLocationRelativeTo(null); 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	}// 
}