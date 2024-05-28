import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class Controleur 
{
	private Jeu		  jeu	 = new Jeu()		;
	private List<List<Object>> tabScore = new ArrayList<>();

	public Controleur()
	{
		JFrame	frame	  = new JFrame("Mille Sabords");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JPanel panel1;
		JPanel panel2;
		JPanel panel3;
		JPanel panel4;

		for (Joueur joueur : jeu.getJoueurs()) 
		{
			List<Object> joueurInfo = new ArrayList<>();
			joueurInfo.add(joueur.getNom());
			joueurInfo.add(joueur.getScore());
			this.tabScore.add(joueurInfo);
		}  

		System.out.println();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenSize.width, screenSize.height);

		ImageIcon imageIcon = new ImageIcon("images/fond.jpg");
		Image image		 = imageIcon.getImage();
		
		JPanel mainPanel = new JPanel()
		{
			protected void paintComponent(Graphics g) 
			{
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		mainPanel.setLayout(new GridLayout(2, 2));

		panel1 = new JPanel(new GridLayout(2, 1));

		

		panel2 = new JPanel(new GridLayout(1, 3));
		panel3 = new JPanel(new GridLayout(5, 9));
		panel4 = new JPanel(new GridLayout(1, 2));

		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);

		frame.add(mainPanel);
		frame.setVisible(true);
	}



	public static void main(String[] args) 
	{
		new Controleur();	
	}
}
