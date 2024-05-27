import java.util.ArrayList;
import java.util.List;

public class Controleur 
{
    private Jeu          jeu     = new Jeu()        ;
    private List<Joueur> joueurs = new ArrayList<>();

    public Controleur()
    {
        this.joueurs = jeu.getJoueurs();
        
        System.out.println("Les joueurs sont : ");
        for (Joueur joueur : this.joueurs) 
        {
            System.out.println(joueur.getNom());
        }
    }



    public static void main(String[] args) 
    {
        new Controleur();    
    }
}
