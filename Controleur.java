import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class Controleur 
{
    private Jeu          jeu     = new Jeu()        ;
    private List<List<Object>> tabScore = new ArrayList<>();

    public Controleur()
    {
        JFrame    frame      = new JFrame("Mille Sabords");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        for (Joueur joueur : jeu.getJoueurs()) 
        {
            List<Object> joueurInfo = new ArrayList<>();
            joueurInfo.add(joueur.getNom());
            joueurInfo.add(joueur.getScore());
            this.tabScore.add(joueurInfo);
        }  

        System.out.println();
        System.out.println("Les joueurs sont : ");

        for (List<Object> joueurInfo : this.tabScore) 
        {
            System.out.println("Nom: " + joueurInfo.get(0) + ", Score: " + joueurInfo.get(1));
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
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        frame.add(mainPanel);
        
        frame.setVisible(true);
    }



    public static void main(String[] args) 
    {
        new Controleur();    
    }
}
