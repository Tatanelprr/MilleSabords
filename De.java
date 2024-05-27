public enum De 
{
    DE1 ( null ),
	DE2 ( null ),
	DE3 ( null ),
	DE4 ( null ),
	DE5 ( null ),
	DE6 ( null ),
    DE7 ( null ),
    DE8 ( null );

    private String  face;
    private boolean verrouille;

    private De(String face)
    {
        this.face = face;
        this.verrouille = false;
    }

    public String setFace()
    {
        int lancer = (int) (Math.random() * 6) + 1;
        String sRet;

        switch (lancer) {
            case 1:
                sRet = "DéDiamant.jpg";
                break;
        
            case 2:
                sRet = "DéEpées.jpg";
                break;

            case 3:
                sRet = "DéMort.jpg";
                break;

            case 4:
                sRet = "DéOr.jpg";
                break;

            case 5:
                sRet = "DéPerroquet.jpg";
                break;

            case 6:
                sRet = "DéSinge.jpg";
                break;

            default:
                sRet = null;
                break;
        }
        return sRet;
    }

    public void lancer() 
    {
        for (De de : De.values()) 
        {
            if (!de.verrouille) 
            {
                de.face = de.setFace();
                System.out.println(de.name() + ": " + de.face);
            }
        }
    }

}
