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
	JPanel errorPanel;

	JFrame errorFrame = new JFrame();

	int personRole;

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
	private JLabel slashes = new JLabel("------");
	private JLabel slashes2 = new JLabel("------");
	private JLabel slashes3 = new JLabel("------");

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
		String inputDialogID = JOptionPane.showInputDialog(errorFrame, "Enter ID on Member");
		updatePanel.setVisible(false);
		id.setText(inputDialogID);
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
		
		//textPanel.setVisible(false);
		//updatePanel.setVisible(false);

		ArrayList<String> a = new ArrayList<String>();
        //jta.setText("");



        
        if(idcr.getText().equals("")){
        	
        	JOptionPane.showMessageDialog(errorFrame, 
  						"You must insert ID", "Failure", JOptionPane.ERROR_MESSAGE);
        	throw new IllegalStateException("Stoping program");
        	 }

		String aId = idcr.getText();
        String givenN = givenName.getText();
        String familyN = familyName.getText();
        String emailinput = email.getText();
        String dBirth = birth.getText();
        String mSince = memberSince.getText();
        String aGender = "soWrong";

       // String isActive = active.getText();
        //String team = jTextField9.getText();
        int pId = 0;
         pId = Integer.parseInt(aId);
         // _----_
         if (aCheckBox8.isSelected() == false && aCheckBox9.isSelected() == false || aCheckBox10.isSelected() == false && aCheckBox11.isSelected() == false 
            		|| givenN.equals("")||familyN.equals("")||emailinput.equals("")||dBirth.equals("")||mSince.equals("")
            		|| aCheckBox12.isSelected() == false && aCheckBox13.isSelected() == false && aCheckBox14.isSelected() == false){
            			


            			JOptionPane.showMessageDialog(errorFrame, 
  						"You must insert all values", "Failure", JOptionPane.ERROR_MESSAGE);
  						
						//stmt.executeUpdate("delete from medlem where id = " + "'" + pId + "'");

            			throw new IllegalStateException("Stoping program");
            		}

         //----
        int pActive = 3;
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:minDatabas");
            System.out.println("Opened database successfully");

         	stmt = c.createStatement();
         	String testID = "false";
// Här ligger problemet, koden funkade fint tills man pushar,
         	
         	/*ResultSet rs = stmt.executeQuery("select id from medlem where id = " + "'" + pId + "'");
         	
         	if (rs.getInt(1) > 0) {
         		System.out.println("medlem finns redan");
         		JOptionPane.showMessageDialog(errorFrame, 
  						"Member does already exist ", "Failure", JOptionPane.ERROR_MESSAGE);
         			textPanel.setVisible(false);
         			givenName.setText("");
         					idcr.setText("");
							familyName.setText("");
							email.setText("");
							gender.setText("");
							birth.setText("");
							memberSince.setText("");
								if (aCheckBox9.isSelected()) {
            			 				aCheckBox9.setSelected(false);
      			 						  }
								if (aCheckBox8.isSelected()) {
           							  aCheckBox8.setSelected(false);
       										 }
       							if (aCheckBox10.isSelected()) {
            					 		aCheckBox10.setSelected(false);
      			 						  }
								if (aCheckBox11.isSelected()) {
           							  aCheckBox11.setSelected(false);
      							 }
      							 if (aCheckBox12.isSelected()) {
           							  aCheckBox12.setSelected(false);
       										 }
       							if (aCheckBox13.isSelected()) {
            					 		aCheckBox13.setSelected(false);
      			 						  }
								if (aCheckBox14.isSelected()) {
           							  aCheckBox14.setSelected(false);
      							 }
      				throw new IllegalStateException("Stoping program, duo to member already exists");	
         	
         	} else {*/


         		//------
         		
         		//------
         	
            String sql = "insert into medlem (id,givenName,familyName,email,gender,birth,memberSince,active) " + "VALUES (" + pId + ",'" + givenN + "','" + familyN + "','" + emailinput + "','" + aGender + "','" + dBirth + "','" + mSince + "'," + pActive + ");";
            stmt.executeUpdate(sql);


            	if (aCheckBox8.isSelected() == true) {
            	    
                
                	stmt.executeUpdate("UPDATE medlem SET active ='1' where id = " + "'" + pId + "'");

            		}
            	if (aCheckBox9.isSelected() == true) {
            	    stmt.executeUpdate("UPDATE medlem SET active ='0' where id = " + "'" + pId + "'");
             			   
                
            		}
            	// början Man kvinna
            	if (aCheckBox10.isSelected() == true) {
            	    
                
                stmt.executeUpdate("UPDATE medlem SET gender ='Man' where id = " + "'" + pId + "'");

            		}
            	if (aCheckBox11.isSelected() == true) {
            	    stmt.executeUpdate("UPDATE medlem SET gender ='Kvinna' where id = " + "'" + pId + "'");
             			   
                
            		}
            	//Checkbox Role för Create
            		if (aCheckBox12.isSelected() == true) {
                	
                	personRole = 0;
               	 	String sql3 = "insert into funktion (id,role) " + "VALUES (" + pId + ",'" + personRole + "');";
                	stmt.executeUpdate(sql3);

          		  }
          			  if (aCheckBox13.isSelected() == true) {
          			  	
             		   personRole = 1;
                		String sql3 = "insert into funktion (id,role) " + "VALUES (" + pId + ",'" + personRole + "');";
               			 stmt.executeUpdate(sql3);

            	}
            	if (aCheckBox14.isSelected() == true) {
            		
            	    personRole = 2;
             		String sql3 = "insert into funktion (id,role) " + "VALUES (" + pId + ",'" + personRole + "');";
               		 stmt.executeUpdate(sql3);

            	}
       	


            	if (aCheckBox8.isSelected() == false && aCheckBox9.isSelected() == false || aCheckBox10.isSelected() == false && aCheckBox11.isSelected() == false 
            		|| givenN.equals("")||familyN.equals("")||emailinput.equals("")||aGender.equals("")||dBirth.equals("")||mSince.equals("")
            		|| aCheckBox12.isSelected() == false && aCheckBox13.isSelected() == false && aCheckBox14.isSelected() == false){
            			


            			JOptionPane.showMessageDialog(errorFrame, 
  						"You must insert all values", "Failure", JOptionPane.ERROR_MESSAGE);
  						
						stmt.executeUpdate("delete from medlem where id = " + "'" + pId + "'");

            			throw new IllegalStateException("Stoping program");
            		}

            		//pushar ny medlem
           JOptionPane.showMessageDialog(null, "You have now created a new member :" + pId);
           textPanel.setVisible(false);
         			givenName.setText("");
         					idcr.setText("");
							familyName.setText("");
							email.setText("");
							gender.setText("");
							birth.setText("");
							memberSince.setText("");
								if (aCheckBox9.isSelected()) {
            			 				aCheckBox9.setSelected(false);
      			 						  }
								if (aCheckBox8.isSelected()) {
           							  aCheckBox8.setSelected(false);
       										 }
       							if (aCheckBox10.isSelected()) {
            					 		aCheckBox10.setSelected(false);
      			 						  }
								if (aCheckBox11.isSelected()) {
           							  aCheckBox11.setSelected(false);
      							 }
      							 if (aCheckBox12.isSelected()) {
           							  aCheckBox12.setSelected(false);
       										 }
       							if (aCheckBox13.isSelected()) {
            					 		aCheckBox13.setSelected(false);
      			 						  }
								if (aCheckBox14.isSelected()) {
           							  aCheckBox14.setSelected(false);
      							 }
      		 // här ska de in en } om vi anv if i try member exists
      				 // slut else if not member already exists . rad 173


            } catch (Exception error) {

            System.out.println(error.getMessage());
            error.printStackTrace();
            JOptionPane.showMessageDialog(errorFrame, 
  						"Member does already exist ", "Failure", JOptionPane.ERROR_MESSAGE);
            	clearText();

           	
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
			//String inpRole	= role.getText();
			
			//String actUnParsed = activeUpd.getText();
		try {
				if (inpID.equals("")){
			System.out.println("NollPointerException");
			JOptionPane.showMessageDialog(errorFrame, 
  				"You must insert all values", "Failure", JOptionPane.ERROR_MESSAGE);
            }else{	
            				int idexp = Integer.parseInt(inpID);
            				//int actExp = Integer.parseInt(actUnParsed);
            				//int roleExp = Integer.parseInt(inpRole);

            	Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:minDatabas");
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                //stmt = c.createStatement();
                //stmt.executeUpdate("UPDATE medlem SET active = "+"'" + actExp + "'" + " where id = " + "'" + idexp + "'");
                //System.out.println("UPDATE medlem SET role = " + "'"+ roleExp + "' ,active = "+"'" + actExp + "'" + " where id = " + "'" + idexp + "'");

               // stmt.executeUpdate("UPDATE funktion SET role = "+"'" + roleExp + "'" + " where id = " + "'" + idexp + "'");
                	try{
            			String sq201 = "select givenName from medlem WHERE id = " + "'" + idexp + "'" + ";";
            		stmt.executeUpdate(sq201);
                	

                }catch(Exception sqle){
                	
   					System.out.println(sqle.getMessage());
                	JOptionPane.showMessageDialog(errorFrame, 
  					"Couldn't remove/update this member", "Failure", JOptionPane.ERROR_MESSAGE);
               	 }
               	 String sq11 = "delete from funktion WHERE id = " + "'" + idexp + "'" + ";";
            		stmt.executeUpdate(sq11);
            
                if (aCheckBox1.isSelected() == true) {
                	
                	personRole = 0;
               	 	String sql3 = "insert into funktion (id,role) " + "VALUES (" + idexp + ",'" + personRole + "');";
                	stmt.executeUpdate(sql3);

          		  }
          			  if (aCheckBox2.isSelected() == true) {
          			  	
             		   personRole = 1;
                		String sql3 = "insert into funktion (id,role) " + "VALUES (" + idexp + ",'" + personRole + "');";
               			 stmt.executeUpdate(sql3);

            	}
            	if (aCheckBox3.isSelected() == true) {
            		
            	    personRole = 2;
             		String sql3 = "insert into funktion (id,role) " + "VALUES (" + idexp + ",'" + personRole + "');";
               		 stmt.executeUpdate(sql3);

            	}

            	if (aCheckBox1.isSelected() == false && aCheckBox2.isSelected() == false && aCheckBox3.isSelected() == false
            		&& aCheckBox7.isSelected() == false){
            					JOptionPane.showMessageDialog(errorFrame, 
  						"You must Choose a Role", "Failure", JOptionPane.ERROR_MESSAGE);
  							
								if (aCheckBox1.isSelected()) {
            			 				aCheckBox1.setSelected(false);
      			 						  }
								if (aCheckBox2.isSelected()) {
           							  aCheckBox2.setSelected(false);
       										 }
       							if (aCheckBox3.isSelected()) {
            					 		aCheckBox3.setSelected(false);
      			 						  }
      			 				if (aCheckBox5.isSelected()) {
            					 		aCheckBox5.setSelected(false);
      			 						  }
      			 				if (aCheckBox6.isSelected()) {
            					 		aCheckBox6.setSelected(false);
      			 						  }
								


						stmt.executeUpdate("delete from funktion where id = " + "'" + idexp + "'");
						throw new IllegalStateException("Stoping program duo to Role choice");
						
            	}

            	

            	if (aCheckBox4.isSelected() == true) {
            	    
             			   
                String newInputMail = JOptionPane.showInputDialog(errorFrame, "Enter the new Emailadress for member "+idexp);
                	stmt.executeUpdate("UPDATE medlem SET email = "+"'" + newInputMail + "'" + " where id = " + "'" + idexp + "'");
            	}
            	if (aCheckBox5.isSelected() == true) {
            	    
                
                stmt.executeUpdate("UPDATE medlem SET active ='1' where id = " + "'" + idexp + "'");

            	}
            	if (aCheckBox6.isSelected() == true) {
            	    stmt.executeUpdate("UPDATE medlem SET active ='0' where id = " + "'" + idexp + "'");
             			   
                
            	}
            	if (aCheckBox7.isSelected() == true) {
            		try{
            		stmt.executeUpdate("delete from medlem where id = " + "'" + idexp + "'");
                stmt.executeUpdate("delete from children where pid = " + "'" + idexp + "'");
                 stmt.executeUpdate("delete from children where cid = " + "'" + idexp + "'");
                stmt.executeUpdate("delete from funktion where id = " + "'" + idexp + "'");
                	JOptionPane.showMessageDialog(null, "You have now deleted member :" + idexp);
                }catch(Exception errar){
                	JOptionPane.showMessageDialog(errorFrame, 
  					"Couldn't remove/update this member", "Failure", JOptionPane.ERROR_MESSAGE);
               	 }
            	}

            } // else ends
                
                JOptionPane.showMessageDialog(errorFrame, "Congratulations! you have successfully updated a member");
                updatePanel.setVisible(false);
                System.out.println("Succesfull update");

                } catch ( Exception err){
                	System.out.println("NollPointerException");
                	System.out.println(err.getMessage());
                	
                }	
		}
   };
 
  		JCheckBox aCheckBox1 = new JCheckBox("Player");
     	JCheckBox aCheckBox2 = new JCheckBox("Coach");
      	JCheckBox aCheckBox3 = new JCheckBox("Parent");
      	JCheckBox aCheckBox4 = new JCheckBox("I also whant to change the Email adress.");
      	JCheckBox aCheckBox5 = new JCheckBox("Active");
      	JCheckBox aCheckBox6 = new JCheckBox("UnActive");
      	JCheckBox aCheckBox7 = new JCheckBox("Delete Member");
      	JCheckBox aCheckBox8 = new JCheckBox("Active");
      	JCheckBox aCheckBox9 = new JCheckBox("UnActive");
      	JCheckBox aCheckBox10 = new JCheckBox("Man");
      	JCheckBox aCheckBox11 = new JCheckBox("Kvinna");
      	JCheckBox aCheckBox12 = new JCheckBox("Player");
      	JCheckBox aCheckBox13 = new JCheckBox("Coach");
      	JCheckBox aCheckBox14 = new JCheckBox("Parent");

//method clear text?
      		public void clearText(){
      						givenName.setText("");
         					idcr.setText("");
							familyName.setText("");
							email.setText("");
							gender.setText("");
							birth.setText("");
							memberSince.setText("");
								if (aCheckBox9.isSelected()) {
            			 				aCheckBox9.setSelected(false);
      			 						  }
								if (aCheckBox8.isSelected()) {
           							  aCheckBox8.setSelected(false);
       										 }
       							if (aCheckBox10.isSelected()) {
            					 		aCheckBox10.setSelected(false);
      			 						  }
								if (aCheckBox11.isSelected()) {
           							  aCheckBox11.setSelected(false);
      							 }
      							 if (aCheckBox12.isSelected()) {
           							  aCheckBox12.setSelected(false);
       										 }
       							if (aCheckBox13.isSelected()) {
            					 		aCheckBox13.setSelected(false);
      			 						  }
								if (aCheckBox14.isSelected()) {
           							  aCheckBox14.setSelected(false);
      							 }
      	}

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
	textPanel.add(aCheckBox12);
	textPanel.add(aCheckBox13);
	textPanel.add(aCheckBox14);
	textPanel.add(mail);
	textPanel.add(email);
	textPanel.add(aCheckBox10);
	textPanel.add(aCheckBox11);
	textPanel.add(birthl);
	textPanel.add(birth);
	textPanel.add(mbsl);
	textPanel.add(memberSince);
	textPanel.add(aCheckBox8);
	textPanel.add(aCheckBox9);

	textPanel.add(b4); // denna knapp är continue för skapa

	updatePanel.add(idl);
	updatePanel.add(id);
	//updatePanel.add(activelUpd);
	//updatePanel.add(activeUpd);
	updatePanel.add(aCheckBox1);
	updatePanel.add(aCheckBox2);
	updatePanel.add(aCheckBox3);
	updatePanel.add(slashes2);
	updatePanel.add(aCheckBox4);
	updatePanel.add(slashes);
	updatePanel.add(aCheckBox5);
	updatePanel.add(aCheckBox6);
	updatePanel.add(slashes3);
	updatePanel.add(aCheckBox7);
	//updatePanel.add(rolel);
	//updatePanel.add(role);
	//updatePanel.add(teaml);
	//updatePanel.add(team);
	updatePanel.add(b5);


	//errorFrame.setVisible(false);
	
	//errorPanel.add(errorFrame);
	//errorPanel.setVisible(false);
	textPanel.add(lab1,g1);
	textPanel.setVisible(false);
	updatePanel.setVisible(false);

	buttonPanel.add(b1); 
	buttonPanel.add(b2);
	buttonPanel.add(b3);
	//add(errorPanel,BorderLayout.WEST);
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