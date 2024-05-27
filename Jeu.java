public class Jeu 
{
    private Pioche pioche = new Pioche();

    private boolean dernierTour;
    public static void main(String[] args) 
    {
        Jeu jeu = new Jeu();
    }

    private Jeu()
    {
        this.dernierTour = false;
    }

    public void Jouer()
    {
        for (int i = 0; i < 40; i++) 
        {
            Carte c;
            c = this.pioche.tirerCarte();
            System.out.println(c.getSymbole());
        }  
    }
}
