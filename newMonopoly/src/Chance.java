import java.util.Random;

public class Chance{
	
	Players playerOrder[] = new Players[8];
	Random random = new Random();
	private int chanceRandom;
	
	
	public void shuffleChance(){
		Random random = new Random();
		setChanceRandom(random.nextInt(16)+ 1);
		System.out.println("Chance Shuffle Result " + chanceRandom);
		//return getChanceRandom();
	}
	
	
///////////////GETTER and SETTER ///////////////
		
	public int getChanceRandom() {
		return chanceRandom;
	}
	
	
	public void setChanceRandom(int chanceRandom) {
		this.chanceRandom = chanceRandom;
	}

}
