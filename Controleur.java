import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur 
{
	private Jeu jeu = new Jeu();

	private List<List<Object>> tabScore = new ArrayList<>();
    private List<JLabel>       deLabels = new ArrayList<>();

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
        panel2 = new JPanel(new BorderLayout());
        panel3 = new JPanel(new GridLayout(2, 4));
        panel4 = new JPanel(new BorderLayout());

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

		ImageIcon scoreIcon = new ImageIcon("images/Score.jpg");
        Image resizedScore = scoreIcon.getImage().getScaledInstance(204, 310, Image.SCALE_SMOOTH);
        ImageIcon resizedScorIcon = new ImageIcon(resizedScore);
        JLabel scoreLabel = new JLabel(resizedScorIcon);
        scoreLabel.setPreferredSize(new Dimension(204, 310));

        panel2.add(scoreLabel, BorderLayout.EAST);

        ImageIcon carteIcon = new ImageIcon("images/" + this.jeu.getCarte().getSymbole());
        Image resizedCarte = carteIcon.getImage().getScaledInstance(204, 310, Image.SCALE_SMOOTH);
        ImageIcon resizedCartIcon = new ImageIcon(resizedCarte);
        JLabel carteLabel = new JLabel(resizedCartIcon);
        carteLabel.setPreferredSize(new Dimension(204, 310));

        panel2.add(carteLabel, BorderLayout.WEST);

        if (!this.jeu.getPioche().isEmpty()) 
        {
            ImageIcon piocheIcon = new ImageIcon("images/dos.jpg");
            Image resizedImage = piocheIcon.getImage().getScaledInstance(204, 310, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel piocheLabel = new JLabel(resizedIcon);
            piocheLabel.setPreferredSize(new Dimension(204, 310));

            panel2.add(piocheLabel, BorderLayout.CENTER);
        } 
        else 
        {
            JLabel emptyLabel = new JLabel("Pioche vide");
            panel2.add(emptyLabel);
        }

        //Création du panel n°3
        
        for (De de : De.values()) 
        {
            ImageIcon deIcon = new ImageIcon("images/" + de.getFace());
            Image resizedDe = deIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon resizedDeIcon = new ImageIcon(resizedDe);
            JLabel deLabel = new JLabel(resizedDeIcon);
            deLabel.setPreferredSize(new Dimension(100, 100));

            deLabels.add(deLabel);
            panel3.add(deLabel);
        }

        //Création du panel n°4
        JButton lancerButton = new JButton("Lancer");
        JButton finDuTour    = new JButton("Fin du tour");

        lancerButton.setPreferredSize(new Dimension(150, 50));
        lancerButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                jeu.lancer();
                updateDeFaces();
            }
        });
        
        
        finDuTour.setPreferredSize(new Dimension(150, 50));

        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(lancerButton);
        panelBoutons.add(finDuTour);

        panelBoutons.setOpaque(false);

        panel4.add(panelBoutons, BorderLayout.SOUTH);
 
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
 
        frame.add(mainPanel);
        frame.setVisible(true);
	}

    private ImageIcon redimensionnerImage(ImageIcon icon, int width, int height) 
    {
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private void updateDeFaces()
    {
        List<De> des = jeu.getDes();
        for (int i = 0; i < des.size(); i++) 
        {
            De de = des.get(i);
            ImageIcon deIcon = new ImageIcon("images/" + de.getFace());
            Image resizedDe = deIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon resizedDeIcon = new ImageIcon(resizedDe);
            deLabels.get(i).setIcon(resizedDeIcon);
        }
    }


	public static void main(String[] args) 
	{
		new Controleur();	
	}
}
