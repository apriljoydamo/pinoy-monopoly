import java.util.Random;

public class Chance{
	
	Players playerOrder[] = new Players[8];
	Random random = new Random();
	private int chanceRandom;
	
	public void shuffleChance(){
		Random random = new Random();
		setChanceRandom(random.nextInt(14)+ 1);
	}
	
	public int getChanceRandom() {
		return chanceRandom;
	}

	public void setChanceRandom(int chanceRandom) {
		this.chanceRandom = chanceRandom;
	}

}
