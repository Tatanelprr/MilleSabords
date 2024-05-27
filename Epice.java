public enum Epice implements IRessource
{
	SESAME    ( Couleur.BLANC  ),
	CURCUMA   ( Couleur.JAUNE  ),
	PAPRIKA   ( Couleur.ROUGE  ),
	SAFRAN    ( Couleur.ORANGE ),
	SUMAC     ( Couleur.VIOLET ),
	CANNELLE  ( Couleur.BRUN   ),
	CARDAMONE ( Couleur.VERT   ),
	POIVRE    ( Couleur.NOIR   );

	private Couleur couleur;

	private Epice( Couleur coul )
	{
		this.couleur = coul;
	}

	public String getLibCourt()
	{
		String lib;
		String nom = this.name(); 		//Récupère le nom de l'épice

		lib = nom.substring( 0, 3);		//Récupère les 3 premiers carractère du nom

		return lib;
	}

	public Couleur getCouleur()
	{
		return this.couleur;
	}

	public String toString()
	{
		String sRet = ("Epice " + String.format("%-15s", this.name()) + ": ") ;
		return sRet;
	}

}