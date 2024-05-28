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
        Image image         = imageIcon.getImage();
    
        JPanel mainPanel = new JPanel()
        {
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(new GridLayout(2, 2));

        panel1 = new JPanel(new GridLayout(2, 2));
        panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel3 = new JPanel(new GridLayout(5, 9));
        panel4 = new JPanel(new GridLayout(1, 2));

		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);

        //Création du panel n°1
        String[] columnNames = {"Nom", "Score"};
        Object[][] data = new Object[tabScore.size()][2];
        for (int i = 0; i < tabScore.size(); i++) 
        {
            data[i][0] = tabScore.get(i).get(0);
            data[i][1] = tabScore.get(i).get(1);
        }
        
        JTable table = new JTable(data, columnNames) 
        {
            public boolean isCellEditable(int row, int column) 
            {                
                return false;               
            };
        };

        table.setOpaque(false);
        table.setFillsViewportHeight(true);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
 
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setOpaque(false);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        tablePanel.setBorder(BorderFactory.createEmptyBorder());
 
        panel1.add(tablePanel);

        //Création du panel n°2
        if (!this.jeu.getPioche().isEmpty()) {
            ImageIcon piocheIcon = new ImageIcon("images/dos.jpg");
            // Redimensionner l'image à la taille spécifiée
            Image resizedImage = piocheIcon.getImage().getScaledInstance(102, 155, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel piocheLabel = new JLabel(resizedIcon);
            // Définir la taille préférée du JLabel
            piocheLabel.setPreferredSize(new Dimension(102, 155));
            panel2.add(piocheLabel);
        } else {
            JLabel emptyLabel = new JLabel("Pioche vide");
            panel2.add(emptyLabel);
        }
 
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
