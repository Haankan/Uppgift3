import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SearchFrame extends JFrame {

	private String message = "Hej hej hej sdasadsa ";
	private JLabel lab1 = new JLabel(message);

	JPanel textPanel;

	private JTextArea jta = new JTextArea(30,45);
// knappar
	private JButton b1 = new JButton("Search for member ID");

		ActionListener aLb1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Search Code exec");
		textPanel.setVisible(false);
		message = "Resultat String Search for member id";
		textPanel.setVisible(true);
		}
	};
    private JButton b2 = new JButton("Search for Leaders in specifik team");
    	ActionListener aLb2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Search Code exec");
		textPanel.setVisible(false);
		message = "Resultat String Search for leader in team";
		textPanel.setVisible(true);

		}
   };
   private JButton b3 = new JButton("Order all members");
    	ActionListener aLb3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Underlista");
		textPanel.setVisible(false);
		message = "Sorterar alla members";
		textPanel.setVisible(true);
		}
   };
   private JButton b4 = new JButton("Search for specifik Team");
    	ActionListener aLb4 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Specifikt lag skrivs ut");
		textPanel.setVisible(false);
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

	jta.setOpaque(true);
	jta.insert(message,0);
	textPanel.add(jta,g1);

	buttonPanel.add(b1); 
	buttonPanel.add(b2);
	buttonPanel.add(b3);
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