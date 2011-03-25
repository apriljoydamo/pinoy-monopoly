

public class Chance{
	
	
	private int chanceRandom;
	
	public void shuffleChance(int chance){
        switch(chance){
        case 1:
                System.out.println("Speeding fine P15.");
                break;
        case 2:
        		System.out.println("Bank pays you dividend of P50.");
                break;
        case 3:
        		System.out.println("Advance to Trinoma. If you pass GO collect P200.");
                break;
        case 4:
        		System.out.println("Advance to GO.");
                break;
        case 5:
        		System.out.println("Pay school fees of P150.");
                break;
        case 6:
        		System.out.println("Advance to SM Mall of Asia.");
        		break;
        case 7:
    			System.out.println("Get out of Jail Free Key.");
    			break;
        case 8:
	    		System.out.println("Your are assessed forr street rpairs. P40 per house, P115 per hotel.");
	    		break;
        case 9:
	    		System.out.println("Make general repairs on all of your buildings. For each house pay P25. For each hotel pay P100.");
	    		break;
        case 10:
	    		System.out.println("Advance to Shopwise. If you pass GO collect P200.");
	    		break;
        case 11:
	    		System.out.println("Take a trip to Buendia Station. If you pass GO collect P200.");
	    		break;
        case 12:
	    		System.out.println("Your building loan matures. Receive P150.");
	    		break;
        case 13:
	    		System.out.println("GO TO JAIL.");
	    		break;
        case 14:
	    		System.out.println("Go back three spaces.");
	    		break;
        case 15:
	    		System.out.println("Drunk in Charge. Fine P20.");
	    		break;
        case 16:
	    		System.out.println("You have won a crossword competition. Collect P100.");
	    		break;
        }
	}
	
	
///////////////GETTER and SETTER ///////////////
		
	public int getChanceRandom() {
		//setChanceRandom(random.nextInt(6) + 1);
		return chanceRandom;
	}
	
	
	public void setChanceRandom(int randomChance) {
		this.chanceRandom = randomChance;
	}

}
