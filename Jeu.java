import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu 
{
    private Pioche       pioche  = new Pioche()          ;
    private Scanner      scanner = new Scanner(System.in);
    private List<Joueur> joueurs = new ArrayList<>()     ;

    private boolean dernierTour;
    private int     nbJoueur   ;

    public Jeu()
    {
        this.dernierTour = false;
        
        System.out.println("Quel est le nombre de joueur ?");

        this.nbJoueur = this.scanner.nextInt();

        this.scanner.nextLine();

        for (int i = 1; i <= this.nbJoueur; i++) 
        {
            System.out.println("Quel est le nom du joueur " + i);
            String nom  = this.scanner.nextLine();

            Joueur joueur = new Joueur(nom);
            this.joueurs.add(joueur);
        }

    }

    public void Jouer()
    {
        while (!this.dernierTour) 
        {
            
        }
    }

    public List<Joueur> getJoueurs()
    {
        return this.joueurs;
    }
}
