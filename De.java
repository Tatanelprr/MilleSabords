import java.util.List;
import java.util.ArrayList;

public enum De 
{
	DE1 ( null, 1 ),
	DE2 ( null, 2 ),
	DE3 ( null, 3 ),
	DE4 ( null, 4 ),
	DE5 ( null, 5 ),
	DE6 ( null, 6 ),
	DE7 ( null, 7 ),
	DE8 ( null, 8 );

	private String  face;
	private boolean verrouille;
	private int     id;

	private De(String face, int id)
	{
		this.face = face;
		this.verrouille = false;
		this.id = id;
	}

	public void setFace()
	{
		int lancer = (int) (Math.random() * 6) + 1;

		switch (lancer) {
			case 1:
				this.face = "DéDiamant.jpg";
				break;
		
			case 2:
				this.face = "DéEpées.jpg";
				break;

			case 3:
				this.face = "DéMort.jpg";
				break;

			case 4:
				this.face = "DéOr.jpg";
				break;

			case 5:
				this.face = "DéPerroquet.jpg";
				break;

			case 6:
				this.face = "DéSinge.jpg";
				break;

			default:
				this.face = null;
				break;
		}
	}

	public String getFace()
	{
		return this.face;
	}

	public String getFaceVerrouille()
	{
		return this.face;
	}

	public boolean getVerrouille()
	{
		return this.verrouille;
	}

	public void setVerrouille(boolean verrouille) 
	{
        this.verrouille = verrouille;
    }

	public int getId()
	{
		return this.id;
	}

	public static List<De> getDes() 
	{
        List<De> des = new ArrayList<>();
        for (De de : De.values()) 
		{
            des.add(de);
        }
        return des;
    }
}
