import javax.swing.*;
import java.awt.*;

public class FramePlateau 
{
    public static void main(String[] args) 
    {
        Plateau plateau = new Plateau();
        Pioche pioche = new Pioche();
        int taille = pioche.getTaille();

        JFrame frame = new JFrame("La route des épices");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(880, 486);

        ImageIcon imageIcon = new ImageIcon("images/plateau.png");
        Image image = imageIcon.getImage();

        for (int i = 0; i < taille; i++) 
        {
            Jeton j = pioche.tirerJeton();
            if (j != null) 
            {
                plateau.ajouterRessource(j);
            }
        }

        JPanel mainPanel = new JPanel() 
        {
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

                for (int i = 0; i < plateau.getNB_LIG_MAX(); i++) 
                {
                    for (int j = 0; j < plateau.getNB_COL_MAX(); j++)                       
                    {
                        Epice epice = plateau.getEpice(i, j);                                   //Récupères les épices selon le parcours du plateau

                        if (epice != null) 
                        {
                            String chemImage = "images/" + epice.getCouleur().getSymbole();     //Récupères le nom des images selon la couleur des épices
                            ImageIcon epIcon = new ImageIcon(chemImage);
                            Image epImage = epIcon.getImage();
                            
                            int tailleCel = 85;
                            int ecartHor = 75;
                            int ecartVer = 35;
                            int x = ecartHor + j * (tailleCel + ecartHor);
                            int y = 15 + i * (tailleCel + ecartVer);

                            g.drawImage(epImage, x, y, tailleCel, tailleCel, this);
                        }
                    }
                }

                for (int i = 0; i < plateau.getNbPiece(); i++) 
                {
                    ImageIcon epIcon = new ImageIcon("images/bronze.png");
                    Image epImage = epIcon.getImage();

                    int tailleCel = 70;
                    int ecartHor = 15;
                    int x = 79 + i * (tailleCel + ecartHor);
                    int y = 400;

                    g.drawImage(epImage, x, y, tailleCel, tailleCel, this);
                }
            }
        };

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
