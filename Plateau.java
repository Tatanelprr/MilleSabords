import java.util.ArrayList;
import java.util.List;

public class Plateau {
	
	private final int NB_PIECE_MAX = 8;
	private int nbPiece;

	private final int NB_COL_MAX = 5;
	private final int NB_LIG_MAX = 3;
	private List<List<Epice>> plateau;

	private int score;
	private String detailScore;

	public Plateau()
	{
		this.plateau = new ArrayList<>(NB_LIG_MAX);
        
		for (int i = 0; i < NB_LIG_MAX; i++) 
		{
            ArrayList<Epice> ligne = new ArrayList<>(NB_COL_MAX);								//Le plateau est initialisé sous la forme d'une double liste
            
			for (int j = 0; j < NB_COL_MAX; j++) 
			{
                ligne.add(null);
            }
			plateau.add(ligne);
		}
		this.nbPiece = 0;
		this.score = 0;
		this.detailScore = "";
	}

	public int getScore()
	{
		this.score();
		return this.score;
	}

	public Epice getEpice(int i, int j)
	{
		return this.plateau.get(i).get(j);
	}

	public int getNB_LIG_MAX()
	{
		return this.NB_LIG_MAX;
	}

	public int getNB_COL_MAX()
	{
		return this.NB_COL_MAX;
	}

	public int getNbPiece()
	{
		return this.nbPiece;
	}

	public String getDetailScore()
	{
		return this.detailScore;
	}

	public boolean ajouterRessource( Jeton r )
	{
		if (r.getType() instanceof Piece) 														//Regardes si le jeton est une pièce
		{
			Piece piece = (Piece) r.getType();													//Caste le jeton en pièce
			
			if ( (piece.getValeur() + this.nbPiece) <= this.NB_PIECE_MAX)						//Vérifie à ne pas excéder le nombre de pièces max
			{
				this.nbPiece += piece.getValeur();
				return true;
			}
			return false;
		}

		else if (r.getType() instanceof Epice)													//Regardes si le jeton est une épice
		{
			Epice epice = (Epice) r.getType();													//Caste le jeton en pièce
			
			for (int i = 1; i < (NB_LIG_MAX); i++) 
			{
				for (int j = 0; j < NB_COL_MAX; j++) 		
				{
					if ( plateau.get(i).get(j) == epice && plateau.get(i - 1).get(j) == null)	//Vérifie si l'épice est déjà présente ou non 
																								//puis vérifies que la case du dessus soit libre
					{
						plateau.get(i - 1).set(j, epice);										//Effectues l'échange
						this.triColonnes(i - 1, j);
						return true;
					}
				}
			}
			
			int i = 2;

			for (int j = 0; j < NB_COL_MAX; j++)												//Si la première condition n' a pas pu placer l'épice,
																								// celle ci vérifies si il reste de la place en bas du tableau
			{
				if ( plateau.get(i).get(j) == null )
				{
					plateau.get(i).set(j, epice);
					return true;
				}
			}

			return false;
		}
		return false;
	}

	public void score()
	{
		int i;
		int j = 0;

		this.detailScore = "Detail :\n	";
		this.detailScore += ( String.format("%-15s", "Pieces ") + ": ");

		if ( this.nbPiece > 1)																	//Regardes si il y a plus d'une pièce car 1 pièce = 0 score
		{
			this.score += this.nbPiece * this.nbPiece;
			this.detailScore += (this.nbPiece * this.nbPiece) + " pt\n	";
		}

		for (j = 0; j < NB_COL_MAX; j++)
		{
			int casesRemplies = 0;
			
			for (i = 0; i < NB_LIG_MAX; i++)
			{
				if (plateau.get(i).get(j) != null)
				{
					casesRemplies++;															//Compte le nombre de cases remplies par colonnes
				}
			}

			switch (casesRemplies) 
			{
				case 0:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 0 + "  pt\n	";
					break;
				case 1:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 0 + "  pt\n	";
					break;
				case 2:
					this.score += 2;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 2 + "  pt\n	";
					break;
				case 3:
					this.score += 10;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 10 + " pt\n	";
					break;
				default:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Colonne " + (j + 1)) + ": ") + 0 + "  pt\n	";
					break;
			}
		}
		
		for (i = 0; i < NB_LIG_MAX; i++) 
		{
            int casesRemplies = 0;

            for (j = 0; j < NB_COL_MAX; j++) 
			{
                if (plateau.get(i).get(j) != null) 
				{
                    casesRemplies++;															//Compte le nombre de cases remplies par lignes
                }
            }
            switch (casesRemplies) 
			{
				case 0:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 0 + "  pt\n	";
					break;
				case 1:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 0 + "  pt\n	";
					break;
				case 2:
					this.score += 2;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 2 + "  pt\n	";
					break;
				case 3:
					this.score += 5;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 5 + "  pt\n	";
					break;
				case 4:
					this.score += 9;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 9 + "  pt\n	";
					break;
				case 5:
					this.score += 14;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 14 + " pt\n	";
					break;
				default:
					this.score += 0;
					this.detailScore += (String.format("%-15s", "Ligne " + (i + 1)) + ": ") + 0 + "  pt\n	";
					break;
			}
        }
	}

	public String toString() 
	{
		String sRet;
		String sep = "+-----";
	
		sRet = "";
		for (int i = 0; i < NB_LIG_MAX; i++) 
		{
			for (int j = 0; j < NB_COL_MAX; j++) 
			{
				sRet += sep;
			}
			sRet += "+ \n";
			for (int j = 0; j < NB_COL_MAX; j++) 
			{
				sRet += "| ";
				if (plateau.get(i).get(j) == null) 
				{ 
					sRet += "    ";
				} 
				else 
				{
				sRet += plateau.get(i).get(j).getLibCourt(); 
				sRet += " ";
				}
			}
			sRet += "|\n";
		}

		for (int j = 0; j < NB_COL_MAX; j++) 
		{
			sRet += sep;
		}
		sRet += "+";
	
		return sRet;
	}


	public void triColonnes(int i, int j)
	{
		if (j > 0 && i >= 0)																	//Vérifies que i ne soit pas null et que j soit supérieur à 0 car
																								// utilisation de j - 1 par la suite
		{
			while (j > 0 && plateau.get(i).get(j - 1) == null)									//Permet de checker chaque si la case qui vient d'être placée est
																								//plus haute que la case la plus haute de la colonne de gauche
																								//Permet aussi de vérifier que j reste non nul
			{
				for (int i2 = 0; i2 < NB_LIG_MAX; i2++) 
				{
					Epice tmp = this.plateau.get(i2).get(j - 1);

					this.plateau.get(i2).set(j - 1, this.plateau.get(i2).get(j));
					this.plateau.get(i2).set(j,   tmp);	
				}
				j--;
			}
		}
	}

}