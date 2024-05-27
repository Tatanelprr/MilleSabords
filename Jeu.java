import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu 
{
    private Pioche  pioche  = new Pioche()          ;
    private Scanner scanner = new Scanner(System.in);

    private boolean dernierTour;
    private int     nbJoueur   ;

    public static void main(String[] args) 
    {
        Jeu jeu = new Jeu();
    }

    private Jeu()
    {
        this.dernierTour = false;
        
        System.out.println("Quel est le nombre de joueur ?");

        this.nbJoueur = this.scanner.nextInt();

        List<Joueur> joueurs = new ArrayList<>();
        this.scanner.nextLine();

        for (int i = 1; i <= this.nbJoueur; i++) 
        {
            String nom;
            System.out.println("Quel est le nom du joueur " + i);
            nom  = this.scanner.nextLine();
            Joueur joueur = new Joueur(nom);
            joueurs.add(joueur);
        }
    }

    public void Jouer()
    {
        while (!this.dernierTour) 
        {
            
        }
    }
}
