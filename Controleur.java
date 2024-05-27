import java.util.ArrayList;
import java.util.List;

public class Controleur 
{
    private Jeu          jeu     = new Jeu()        ;
    private List<List<Object>> tabScore = new ArrayList<>();

    public Controleur()
    {
        for (Joueur joueur : jeu.getJoueurs()) 
        {
            List<Object> joueurInfo = new ArrayList<>();
            joueurInfo.add(joueur.getNom());
            joueurInfo.add(joueur.getScore());
            this.tabScore.add(joueurInfo);
        }

        System.out.println("Les joueurs sont : ");
        
        for (List<Object> joueurInfo : this.tabScore) 
        {
            System.out.println("Nom: " + joueurInfo.get(0) + ", Score: " + joueurInfo.get(1));
        }
    }



    public static void main(String[] args) 
    {
        new Controleur();    
    }
}
