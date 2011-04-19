import java.util.Random;

public class CommunityChest{
	
	Players playerOrder[] = new Players[8];
	Random random = new Random();
	private int cChestRandom;
		
	public void shuffleCchest(){
		Random random = new Random();
		setcChestRandom(random.nextInt(15)+ 1);
	}

	public void setcChestRandom(int cChestRandom) {
		this.cChestRandom = cChestRandom;
	}

	public int getcChestRandom() {
		return cChestRandom;
	}
}
