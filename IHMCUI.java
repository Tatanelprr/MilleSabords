public class IHMCUI {
    public IHMCUI() 
    {
        // Crée une instance de Plateau et de Pioche
        
        Plateau plateau = new Plateau();
        Pioche pioche = new Pioche();

        int taille = pioche.getTaille();
        
        // Affiche l'état initial du plateau
       
        System.out.println("Etat initial du plateau : \n");
        System.out.println(plateau.toString() + "\n");

        System.out.println(plateau.getNbPiece() + " pièce\n");

        System.out.println("Ajout des ressources à partir des jetons de la pioche\n");

        for (int i = 0; i < taille; i++)
        {
            String sRet = "";
            Jeton j = pioche.tirerJeton();
            if (j != null)
            {
                sRet = j.toString();
                if (plateau.ajouterRessource(j))
                {
                    sRet += "true";
                }
                else
                {
                    sRet += "false";
                }
            }
            System.out.println(sRet);
        }

        System.out.println("\n\nEtat final du Plateau\n");
        System.out.println(plateau.toString() + "\n");

        System.out.println(plateau.getNbPiece() + " pièces\n");

        System.out.println("Score : " + plateau.getScore());

        System.out.println(plateau.getDetailScore());

    }

    public static void main(String[] args) 
    {
        IHMCUI i = new IHMCUI();
    }
}
