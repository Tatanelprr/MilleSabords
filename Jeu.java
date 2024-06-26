import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu 
{
	private Pioche		 pioche  = new Pioche()		  ;
	private Scanner		 scanner = new Scanner(System.in);
	private List<Joueur> joueurs = new ArrayList<>()  ;
	
	private Carte   carte		;
	private Joueur  joueuractif ;
	private boolean dernierTour ;
	private int		nbJoueur = 0;

	public Jeu()
	{
		this.dernierTour = false;
		
		while (nbJoueur < 2 || nbJoueur > 5)
		{
			System.out.println("Le nombre de joueurs doit être entre 2 et 5");
			System.out.println("Quel est le nombre de joueur ?");

			this.nbJoueur = this.scanner.nextInt();
		}
		

		this.scanner.nextLine();

		for (int i = 1; i <= this.nbJoueur; i++) 
		{
			System.out.println("Quel est le nom du joueur " + i);
			String nom  = this.scanner.nextLine();

			Joueur joueur = new Joueur(nom);
			this.joueurs.add(joueur);

		}
		this.joueuractif = this.joueurs.get(0);
		this.carte = this.pioche.tirerCarte();
	}

	public void lancer() 
	{
		List<De> des = getDes();
		for (De de : des)
		{
			if (!de.getVerrouille()) 
			{
				de.setFace();
			}
		}
	}
	public Pioche getPioche()
	{
		return this.pioche;
	}

	public List<Joueur> getJoueurs()
	{
		return this.joueurs;
	}

	public boolean getDernierTour()
	{
		return this.dernierTour;
	}

	public Joueur getJoueurActif()
	{
		return this.joueuractif;
	}

	public int getNbJoueur()
	{
		return this.nbJoueur;
	}

	public Carte getCarte()
	{
		return this.carte;
	}

	public List<De> getDes()
	{
		List<De> des = new ArrayList<>();
		for (De de : De.values()) 
		{
			des.add(de);
		}
		return des;
	}

	public void setCarte(Carte c)
	{
		this.carte = c;
	}

	public void finDuTour() 
	{
		this.setCarte(this.getPioche().tirerCarte());

		for (De de : De.values()) 
		{
			de.setVerrouille(false);
		}


		for (int i = 0; i < this.nbJoueur; i++) 
		{
			if (this.joueurs.get(i) == this.joueuractif) 
			{
				i++;
				if (i == this.nbJoueur) 
				{ 
					this.joueuractif = this.joueurs.get(0);
				} 
				else 
				{
					this.joueuractif = this.joueurs.get(i);
				}
				break;
			}
		}
	}
	
}
