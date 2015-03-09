import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiFrame extends JFrame {

	private JLabel lab1 = new JLabel("välj ett av följande alternativ");

// knappar
	private JButton b1 = new JButton("RegistryCare");

		ActionListener aLb1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Startar Registry ändrare");
		}
	};
    private JButton b2 = new JButton("SearchNdestroy");
    	ActionListener aLb2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.out.println("Kör Search");
		}
   };

// konstruktor	
	public GuiFrame(){

	//Actionlisteners
		b1.addActionListener(aLb1);
		b2.addActionListener(aLb2);
	//setExtendedState(Frame.MAXIMIZED_BOTH);

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
	add(textPanel,BorderLayout.NORTH);
	add(buttonPanel, BorderLayout.SOUTH);
	


	// must do's	
	setTitle("-Huvudmeny-");
	setBackground(Color.white);
	setVisible(true);
	pack();
	setLocationRelativeTo(null); 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	}// konstruktor ends

		public static void main(String[] args) {
			GuiFrame dem = new GuiFrame();
		}


}
