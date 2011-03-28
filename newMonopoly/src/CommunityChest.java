import java.util.Random;

public class CommunityChest{
	
	Players playerOrder[] = new Players[8];
	private int x = 0;
	
	private int cChestRandom;
	
	Random random = new Random();
	
	public int shuffleCchest(){
		Random random = new Random();
		setcChestRandom(random.nextInt(16)+ 1);
		System.out.println("Community Chest Shuffle Result " + cChestRandom);
		return getcChestRandom();
	}
	
	public void bankError(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 200);
		System.out.println("Bank error in your favour. Collect P200.");
	}
	
	public void payHospital(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 100);
		System.out.println("Pay hospital P100.");
	}
	
	public void wonBeautyContest(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 10);
		System.out.println("You have won second price in beauty contest. Collect P10.");
	}
	
	public void taxRefund(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 20);
		System.out.println("Income tax refund. Collect P20.");
	}
	
	public void payOrChance(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 10);
		System.out.println("Pay a P10 fine or take a CHANCE.");
	}
	
	public void payInsurance(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
		System.out.println("Pay your insurance premium P50.");
	}
	
	public void saleOfStock(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 50);
		System.out.println("From sale of stock you get P50.");
	}
	
	public void recieveInterest(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 25);
		System.out.println("Recieve interest on 7% preference shares P25.");
	}
	
	public void advanceToGo(){
		System.out.println("Advance to GO.");
	}
	
	public void goBackToOldKentRoad(){
		System.out.println("Go back to Old Kent Road.");
	}
	
	public void jailFreeKey(){
		System.out.println("Get out of Jail Key.");
	}
	
	public void yourBirthday(){
		System.out.println("It is your birthday. Collect P10 from each player.");
	}
	
	public void doctorsFee(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - 50);
		System.out.println("Doctor's fee. Pay P50.");
	}
	
	public void annuityMatures(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
		System.out.println("Annuity matures. Collect P100.");
	}
	
	public void goToJail(){
		System.out.println("GO TO JAIL.");
	}
	
	public void inheritMoney(){
//		playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + 100);
		System.out.println("You inherit P100.");
	}
//////////GETTER and SETTER//////////
	
	
	public void setcChestRandom(int cChestRandom) {
		this.cChestRandom = cChestRandom;
	}


	public int getcChestRandom() {
		return cChestRandom;
	}

}
