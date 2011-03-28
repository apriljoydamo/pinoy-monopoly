import java.util.Random;

public class CommunityChest{
	
	Players playerOrder[] = new Players[8];
	Random random = new Random();
	private int cChestRandom;
	
	
	public void shuffleCchest(){
		Random random = new Random();
		setcChestRandom(random.nextInt(16)+ 1);
		System.out.println("Community Chest Shuffle Result: " + cChestRandom);
		//return getcChestRandom();
	}
	
	public void bankError(){
		System.out.println("Bank error in your favour. Collect P200.");
		
	}
	
	public void payHospital(){
		System.out.println("Pay hospital P100.");
	}
	
	public void wonBeautyContest(){
		System.out.println("You have won second price in beauty contest. Collect P10.");
	}
	
	public void taxRefund(){
		System.out.println("Income tax refund. Collect P20.");
	}
	
	public void payOrChance(){
		System.out.println("Pay a P10 fine or take a CHANCE.");
	}
	
	public void payInsurance(){
		System.out.println("Pay your insurance premium P50.");
	}
	
	public void saleOfStock(){
		System.out.println("From sale of stock you get P50.");
	}
	
	public void recieveInterest(){
		System.out.println("Recieve interest on 7% preference shares P25.");
	}
	
	public void yourBirthday(){
		System.out.println("It is your birthday. Collect P10 from each player.");
	}
	
	public void doctorsFee(){
		System.out.println("Doctor's fee. Pay P50.");
	}
	
	public void annuityMatures(){
		System.out.println("Annuity matures. Collect P100.");
	}
	
	public void inheritMoney(){
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
