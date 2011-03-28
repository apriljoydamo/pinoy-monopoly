import java.util.Random;

public class Chance{
	
	//GameBoard gameBoard = new GameBoard();	
	Players playerOrder[] = new Players[8];
	private int x = 0;
	
	private int chanceRandom;
	
	Random random = new Random();
	
	public int shuffleChance(){
		Random random = new Random();
		setChanceRandom(random.nextInt(16)+ 1);
		System.out.println("Chance Shuffle Result " + chanceRandom);
		return getChanceRandom();
	}
	
	public void speedingFine(){
		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 15);
	}
	
	public void bankDividend(){
		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
	}
	
	public void advanceToTrinoma(){
		
	}
	
	public void advanceToGo(){
		
	}
	
	public void paySchoolFees(){
		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 150);
	}
	
	public void advanceToMoa(){
		
	}
	
	public void jailFreeKey(){
		
	}
	
	public void streetRepairs(){
		
	}

	public void generalRepairs(){
		
	}
	
	public void advanceToShopwise(){
		
	}
	
	public void tripToBuendiaStation(){
		
	}
	
	public void buildingMatures(){
		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 150);
	}
	
	public void goToJail(){
		
	}
	
	public void goBackThreeSteps(){
		
	}
	
	public void drunkInCharge(){
		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 20);
	}
	
	public void wonCrosswordCompetition(){
		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
	}
	
	
///////////////GETTER and SETTER ///////////////
		
	public int getChanceRandom() {
		//setChanceRandom(random.nextInt(6) + 1);
		return chanceRandom;
	}
	
	
	public void setChanceRandom(int chanceRandom) {
		this.chanceRandom = chanceRandom;
	}

}
