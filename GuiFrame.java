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
	add(lab1);
	JPanel buttonPanel = new JPanel(new GridLayout(2, 2));

	buttonPanel.add(b1); 
	buttonPanel.add(b2);
	add(buttonPanel);
	setTitle("-Huvudmeny-");
	setVisible(true);
	pack();
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		public static void main(String[] args) {
			GuiFrame dem = new GuiFrame();
		}


}
