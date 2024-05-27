public enum Piece implements IRessource
{
	BRONZE (1),
	ARGENT (2),
	OR     (5);

	private int valeur;

	private Piece( int valeur )
	{
		this.valeur = valeur;
	}

	public int getValeur()
	{
		return this.valeur;
	}

	public String toString()
	{
		String sRet = ("Piece " + String.format("%-15s", this.name()) + ": ") ;	
		return sRet;
	}
}