import java.util.*;

public class Pioche
{
	private ArrayList<Carte> pioche;

	public Pioche()
	{
		this.pioche = new ArrayList<>();
		this.initPioche();
	}

	public Carte tirerCarte()
	{
		if(!this.pioche.isEmpty())
		{
			return this.pioche.remove(0);
		}
		else
		{
			this.initPioche();	//Remélange la défausse avant de piocher une nouvelle carte
			return this.pioche.remove(0);
		}
	}

	private void initPioche()	//Initialise la pioche selon l'exemple
	{
		this.pioche.add( Carte.OR          );
		this.pioche.add( Carte.OR          );
		this.pioche.add( Carte.OR          );
		this.pioche.add( Carte.OR          );
		this.pioche.add( Carte.DIAMANT     );
		this.pioche.add( Carte.DIAMANT     );
		this.pioche.add( Carte.DIAMANT     );
		this.pioche.add( Carte.DIAMANT     );
		this.pioche.add( Carte.SINGETPERRO );
		this.pioche.add( Carte.SINGETPERRO );
		this.pioche.add( Carte.SINGETPERRO );
		this.pioche.add( Carte.BATEAU2     );
		this.pioche.add( Carte.BATEAU2     );
		this.pioche.add( Carte.BATEAU3     );
		this.pioche.add( Carte.BATEAU3     ); 
		this.pioche.add( Carte.BATEAU4     );
		this.pioche.add( Carte.BATEAU4     );
		this.pioche.add( Carte.SORCIERE    );
		this.pioche.add( Carte.SORCIERE    );
		this.pioche.add( Carte.SORCIERE    );
		this.pioche.add( Carte.SORCIERE    );
		this.pioche.add( Carte.PIRATE      );
		this.pioche.add( Carte.PIRATE      );
		this.pioche.add( Carte.PIRATE      );
		this.pioche.add( Carte.PIRATE      );
		this.pioche.add( Carte.MORT1       );
		this.pioche.add( Carte.MORT1       );
		this.pioche.add( Carte.MORT1       );
		this.pioche.add( Carte.MORT2       );
		this.pioche.add( Carte.MORT2       );
		this.pioche.add( Carte.COFFRE      );
		this.pioche.add( Carte.COFFRE      );
		this.pioche.add( Carte.COFFRE      );
		this.pioche.add( Carte.COFFRE      );

		Collections.shuffle(pioche); // Ici fonction permettant de mélanger la pioche (fonctionne)
	}

	public int getTaille()
	{
		return this.pioche.size();
	}
}