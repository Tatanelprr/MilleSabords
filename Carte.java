public enum Carte
{
    OR          ( "Or.jpg"          ),
	DIAMANT     ( "Diamant.jpg"     ),
	SINGETPERRO ( "SingEtPerro.jpg" ),
	BATEAU2     ( "Bateau2.jpg"     ),
	BATEAU3     ( "Bateau3.jpg"     ),
	BATEAU4     ( "Bateau4.jpg"     ),
	SORCIERE    ( "Sorcière.jpg"    ),
	MORT1       ( "Mort1.jpg"       ),
	MORT2       ( "Mort2.jpg"       ),
	COFFRE      ( "Coffre.jpg"      ),
	PIRATE      ( "Pirate.jpg"      );

    private String symbole;


	private Carte( String symbole )
	{
		this.symbole = symbole;
	}

	public String getSymbole()
	{
		return this.symbole;
	}
}
