import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SearchFrame extends JFrame {

	//private JLabel lab1 = new JLabel("välj ett av följande alternativ");

// knappar
	private JButton b1 = new JButton("Search for member ID");

		ActionListener aLb1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Search Code exec");
		}
	};
    private JButton b2 = new JButton("Search for Leaders in specifik team");
    	ActionListener aLb2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Search Code exec");
		}
   };
   private JButton b3 = new JButton("Order all members");
    	ActionListener aLb3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Underlista");
		}
   };

// konstruktor	
	public GuiFrame(){

	//Actionlisteners
		b1.addActionListener(aLb1);
		b2.addActionListener(aLb2);
		b3.addActionListener(aLb3);
	

	//panel	
	JPanel buttonPanel = new JPanel();
  	JPanel textPanel = new JPanel();

	setLayout(new BorderLayout());

	textPanel.setLayout(new GridBagLayout());
	GridBagConstraints g1 = new GridBagConstraints();
	
	g1.gridx = 0;
	g1.gridy = 0;
	g1.gridwidth = 2; 
	g1.gridheight = 1;

	g1.insets = new Insets(25, 25, 25, 25);
	textPanel.add(lab1,g1);

	buttonPanel.add(b1); 
	buttonPanel.add(b2);
	buttonPanel.add(b3);
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