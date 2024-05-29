import java.util.List;
import java.util.ArrayList;

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
