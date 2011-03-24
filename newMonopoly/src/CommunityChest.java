import java.util.Random;


public class CommunityChest extends Block {
	
	private int communityChestRandom;
	
	public int shuffleCommunityChest(){
		Random random = new Random();
		setCommunityChestRandom(random.nextInt(16) + 1);
		
		switch(getCommunityChestRandom()){
        case 1:
                System.out.println("Bank error in your favour. Collect P200.");
                break;
        case 2:
        		System.out.println("Pay hospital P100.");
                break;
        case 3:
        		System.out.println("You have won second price in beauty contest. Collect P10.");
                break;
        case 4:
        		System.out.println("Income tax refund. Collect P20.");
                break;
        case 5:
        		System.out.println("Pay a P10 fine or take a CHANCE.");
                break;
        case 6:
        		System.out.println("Pay your insurance premium P50.");
        		break;
        case 7:
    			System.out.println("From sale of stock you get P50.");
    			break;
        case 8:
	    		System.out.println("Recieve interest on 7% preference shares P25.");
	    		break;
        case 9:
	    		System.out.println("Advance to GO.");
	    		break;
        case 10:
	    		System.out.println("Go back to Old Kent Road.");
	    		break;
        case 11:
	    		System.out.println("Get out of Jail Key.");
	    		break;
        case 12:
	    		System.out.println("It is your birthday. Collect P10 from each player.");
	    		break;
        case 13:
	    		System.out.println("Doctor's fee. Pay P50.");
	    		break;
        case 14:
	    		System.out.println("Annuity matures. Collect P100.");
	    		break;
        case 15:
	    		System.out.println("GO TO JAIL.");
	    		break;
        case 16:
	    		System.out.println("You inherit P100.");
	    		break;
        }
		
		return communityChestRandom;
	}
	
	

//////////GETTER and SETTER//////////

	public void setCommunityChestRandom(int communityChestRandom) {
		this.communityChestRandom = communityChestRandom;
	}


	public int getCommunityChestRandom() {
		return communityChestRandom;
	}
	
////////////////////////////////////////

	public CommunityChest(String name, int location){
		super(name, location);
		
	}
}
