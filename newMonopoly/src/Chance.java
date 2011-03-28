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
	
	public void speedingFine(){
		System.out.println("Speeding fine P15.");
    }
	
	public void bankDividend(){
		System.out.println("Bank pays you dividend of P50.");
	}
	
	public void paySchoolFees(){
		System.out.println("Pay school fees of P150.");
	}
	
	public void buildingMatures(){
		System.out.println("Your building loan matures. Receive P150.");
	}
	
	public void drunkInCharge(){
		System.out.println("Drunk in Charge. Fine P20.");						    		
	}
	
	public void wonCrosswordCompetition(){
		System.out.println("You have won a crossword competition. Collect P100.");
	}
	
	
///////////////GETTER and SETTER ///////////////
		
	public int getChanceRandom() {
		return chanceRandom;
	}
	
	
	public void setChanceRandom(int chanceRandom) {
		this.chanceRandom = chanceRandom;
	}

}
