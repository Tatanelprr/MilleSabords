import java.util.ArrayList;
import java.util.List;

public class Controleur 
{
    private Jeu          jeu     = new Jeu()        ;
    private List<Joueur> tabScore = new ArrayList<>();

    public Controleur()
    {
        this.tabScore = jeu.getJoueurs();
        
        System.out.println("Les joueurs sont : ");
        for (Joueur joueur : this.tabScore) 
        {
            System.out.println(joueur.getNom());
        }
    }



    public static void main(String[] args) 
    {
        new Controleur();    
    }
}
