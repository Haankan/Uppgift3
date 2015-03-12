//package Uppgift3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class RegistryGui extends JFrame {

	JPanel textPanel;
	JPanel updatePanel;
	JPanel buttonPanel;

	String message = "";

	private JLabel lab1 = new JLabel(message);
	private JLabel idl = new JLabel("ID:");
	private JLabel fName = new JLabel("First Name");
	private JLabel lName = new JLabel("Last Name");
	private JLabel mail = new JLabel("Email");
	private JLabel genderl = new JLabel("Gender");
	private JLabel birthl = new JLabel("Birth");
	private JLabel mbsl = new JLabel("MemberSince");
	private JLabel activel = new JLabel("Active");
	private JLabel rolel = new JLabel("Role");
	private JLabel teaml = new JLabel("Team");


	private JTextField id = new JTextField();
	private JTextField givenName = new JTextField(15);
	private JTextField familyName = new JTextField(15);
	private JTextField email = new JTextField(20);
	private JTextField gender = new JTextField(6);
	private JTextField birth = new JTextField(10);
	private JTextField memberSince = new JTextField(10);
	private JTextField active = new JTextField();
	private JTextField role = new JTextField(1);
	private JTextField team = new JTextField(10);

	/*private JTextField name = new JTextField(40);
	private JTextField name = new JTextField(40);*/

// knappar
	private JButton b1 = new JButton("Create new member");

		ActionListener aLb1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Search Code exec");
		updatePanel.setVisible(false);
		textPanel.setVisible(false);
		id.setText("");
		givenName.setText("");
		familyName.setText("");
		email.setText("");
		gender.setText("");
		birth.setText("");
		memberSince.setText("");
		active.setText("");

		textPanel.setVisible(true);
		}
	};
    private JButton b2 = new JButton("Update member");
    	ActionListener aLb2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Search Code exec");
		textPanel.setVisible(false);
		updatePanel.setVisible(false);
		id.setText("");
		givenName.setText("");
		familyName.setText("");
		email.setText("");
		gender.setText("");
		birth.setText("");
		memberSince.setText("");
		active.setText("");
		updatePanel.setVisible(true);
		}
   };
   private JButton b3 = new JButton("Back");
    	ActionListener aLb3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
		}
   };
     private JButton b4 = new JButton("Continue");
    	ActionListener aLb4 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("uppdaterar Create Member");
		//textPanel.setVisible(false);
		//updatePanel.setVisible(false);
		Connection c = null;
            Statement stmt = null;
		String inpID = id.getText();
		int idexp = Integer.parseInt(inpID);
		try {
			Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:minDatabas");
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                // ?? måste man inte parsa Id och Active? JTextfield vill inte.
                String insertstmt = "insert into medlem (id,givenName,familyName,gender,birth,memberSince,active) " + "VALUES (" + id + ",'" + givenName + "','" + familyName + "','" + gender + "','" + birth + "','" + memberSince + "'," + active + ");";
                stmt.executeUpdate(insertstmt);
              	
                } catch (Exception err){
                	System.out.println(err.getMessage());
                		
		
				}
				//updatePanel.setVisible(true);
		}
   };
   private JButton b5 = new JButton("Continue");
    	ActionListener aLb5 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("uppdaterar update member");
			Connection c = null;
            Statement stmt = null;
		String inpID = id.getText();
		int idexp = Integer.parseInt(inpID);
		try {
			Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:minDatabas");
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                stmt.executeUpdate("delete from medlem where id = " + "'" + inpID + "'");
                stmt.executeUpdate("delete from funktion where id = " + "'" + inpID + "'");	
                System.out.println("Succesfull update");
                } catch ( Exception err){
                	System.out.println(err.getMessage());
                	
                }	
		}
   };
 
  		JCheckBox aCheckBox1 = new JCheckBox("Tränare");
     	JCheckBox aCheckBox2 = new JCheckBox("Spelare");
      	JCheckBox aCheckBox3 = new JCheckBox("Förälder");

// konstruktor	
	public RegistryGui(){

	//Actionlisteners
		b1.addActionListener(aLb1);
		b2.addActionListener(aLb2);
		b3.addActionListener(aLb3);
		b4.addActionListener(aLb4);
		b5.addActionListener(aLb5);

	//panel

	buttonPanel = new JPanel();
  	 textPanel = new JPanel();
  	 updatePanel = new JPanel();

	setLayout(new BorderLayout());

	textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
	updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.PAGE_AXIS));
	GridBagConstraints g1 = new GridBagConstraints();
	
	g1.gridx = 0;
	g1.gridy = 0;
	g1.gridwidth = 2; 
	g1.gridheight = 1;

	g1.insets = new Insets(25, 25, 25, 25);
	textPanel.add(idl);
	textPanel.add(id);
	textPanel.add(fName);
	textPanel.add(givenName);
	textPanel.add(lName);
	textPanel.add(familyName);
	textPanel.add(mail);
	textPanel.add(email);
	textPanel.add(genderl);
	textPanel.add(gender);
	textPanel.add(birthl);
	textPanel.add(birth);
	textPanel.add(mbsl);
	textPanel.add(memberSince);
	textPanel.add(activel);
	textPanel.add(active);
	textPanel.add(b4); // denna knapp är continue för skapa

	updatePanel.add(idl);
	updatePanel.add(id);
	//updatePanel.add(activel);
	//updatePanel.add(active);
	updatePanel.add(aCheckBox1);
	updatePanel.add(aCheckBox2);
	updatePanel.add(aCheckBox3);
	updatePanel.add(rolel);
	updatePanel.add(role);
	updatePanel.add(teaml);
	updatePanel.add(team);
	updatePanel.add(b5);



	textPanel.add(lab1,g1);
	textPanel.setVisible(false);
	updatePanel.setVisible(false);

	buttonPanel.add(b1); 
	buttonPanel.add(b2);
	buttonPanel.add(b3);
	
	add(updatePanel,BorderLayout.SOUTH);
	add(textPanel,BorderLayout.CENTER);

	add(buttonPanel, BorderLayout.NORTH);
	


	// must do's
	setExtendedState(Frame.MAXIMIZED_BOTH);

	setTitle("Registry");
	setBackground(Color.white);
	setVisible(true);
	pack();
	setLocationRelativeTo(null); 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	}// 
}