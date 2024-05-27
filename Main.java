public class Main 
{
    private Pioche pioche = new Pioche();
    public static void main(String[] args) 
    {
        Main main = new Main();
    }

    private Main()
    {
        for (int i = 0; i < 40; i++) 
        {
            Carte c;
            c = this.pioche.tirerCarte();
            System.out.println(c.getSymbole());
        }  
    }
}
