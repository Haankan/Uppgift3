import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiFrame extends JFrame {

	private JLabel lab1 = new JLabel("välj ett av följande alternativ");

// knappar
	private JButton b1 = new JButton("RegistryCare");
    private JButton b2 = new JButton("SearchNdestroy");
   

// konstruktor	
	public GuiFrame(){
//Frame	
	setExtendedState(Frame.MAXIMIZED_BOTH);

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

	add(textPanel,BorderLayout.NORTH);
	add(buttonPanel, BorderLayout.SOUTH);
	buttonPanel.add(b1); 
	buttonPanel.add(b2);

	
	
	

	//buttonPanel.add(lab1,BorderLayout.CENTER);
	//buttonPanel.add(b1,BorderLayout.WEST);
   // buttonPanel.add(b2,BorderLayout.EAST);*/

// must do's	
	setTitle("-Huvudmeny-");
	setBackground(Color.white);
	// buttonPanel.setBackground(Color.white);
	setVisible(true);
	pack();
	setLocationRelativeTo(null); 
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		public static void main(String[] args) {
			GuiFrame dem = new GuiFrame();
		}


}
