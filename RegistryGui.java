//package Uppgift3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class RegistryGui extends JFrame {

	JPanel textPanel;
	JPanel updatePanel;
	JPanel buttonPanel;

	String message = "";
	private JLabel idC = new JLabel("ID:");
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
	private JLabel activelUpd = new JLabel("Active");

	private JTextField idcr = new JTextField(15);
	private JTextField id = new JTextField(15);
	private JTextField givenName = new JTextField(15);
	private JTextField familyName = new JTextField(15);
	private JTextField email = new JTextField(20);
	private JTextField gender = new JTextField(6);
	private JTextField birth = new JTextField(10);
	private JTextField memberSince = new JTextField(10);
	private JTextField active = new JTextField(1);
	private JTextField role = new JTextField(1);
	private JTextField team = new JTextField(10);
	private JTextField activeUpd = new JTextField(1);

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
		role.setText("");
		activeUpd.setText("");
		updatePanel.setVisible(true);
		}
   };
   private JButton b3 = new JButton("Back");
    	ActionListener aLb3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
		}
   };
     private JButton b4 = new JButton("Continue"); // för Create
    	ActionListener aLb4 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("uppdaterar Create Member");
		//textPanel.setVisible(false);
		//updatePanel.setVisible(false);

		ArrayList<String> a = new ArrayList<String>();
        //jta.setText("");

        String aId = idcr.getText();
        String givenN = givenName.getText();
        String familyN = familyName.getText();
        String emailinput = email.getText();
        String dBirth = birth.getText();
        String mSince = memberSince.getText();
        String aGender = gender.getText();
        String isActive = active.getText();
        //String team = jTextField9.getText();

        int pId = Integer.parseInt(aId);
        int pActive = Integer.parseInt(isActive);
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:minDatabas");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            String sql = "insert into medlem (id,givenName,familyName,email,gender,birth,memberSince,active) " + "VALUES (" + pId + ",'" + givenN + "','" + familyN + "','" + aGender + "','" + dBirth + "','" + emailinput + "','" + mSince + "'," + pActive + ");";
            stmt.executeUpdate(sql);
            } catch (Exception error) {

            System.out.println(error.getMessage());

           	
        }

		}
   };
   private JButton b5 = new JButton("Continue"); // För Update
    	ActionListener aLb5 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("uppdaterar update member");

			Connection c = null;
            Statement stmt = null;
		String inpID = id.getText();
			String inpRole	= role.getText();
			
			String actUnParsed = activeUpd.getText();
		try {
				if (inpID.equals("")  || inpRole.equals("") || actUnParsed.equals("")){
			System.out.println("NollPointerException");
            }else{	
            				int idexp = Integer.parseInt(inpID);
            				int actExp = Integer.parseInt(actUnParsed);
            				int roleExp = Integer.parseInt(inpRole);

            	Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:minDatabas");
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                //stmt = c.createStatement();
                stmt.executeUpdate("UPDATE medlem SET active = "+"'" + actExp + "'" + " where id = " + "'" + idexp + "'");
                //System.out.println("UPDATE medlem SET role = " + "'"+ roleExp + "' ,active = "+"'" + actExp + "'" + " where id = " + "'" + idexp + "'");

                stmt.executeUpdate("UPDATE funktion SET role = "+"'" + roleExp + "'" + " where id = " + "'" + idexp + "'");
            }
                
                System.out.println("Succesfull update");
                } catch ( Exception err){
                	System.out.println("NollPointerException");
                	System.out.println(err.getMessage());
                	
                }	
		}
   };
 
  		/*JCheckBox aCheckBox1 = new JCheckBox("Tränare");
     	JCheckBox aCheckBox2 = new JCheckBox("Spelare");
      	JCheckBox aCheckBox3 = new JCheckBox("Förälder");*/

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
	textPanel.add(idC);
	textPanel.add(idcr);
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
	updatePanel.add(activelUpd);
	updatePanel.add(activeUpd);
	//updatePanel.add(aCheckBox1);
	//updatePanel.add(aCheckBox2);
	//updatePanel.add(aCheckBox3);
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