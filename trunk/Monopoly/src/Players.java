import java.util.Scanner;

public class Players {
	//private String Name;
	//private int LabelToken;
	private int StartMoney;
	int PlayersPlaying;
	String[] players = new String[8];
	int[] token = new int[8];
	boolean Multi;
	
		
	Scanner scanner = new Scanner(System.in);
	
	public void chooseSolo(){
		System.out.println("You choosed SOLO PLAYER.");
		PlayersPlaying = 1;
		Multi = false;
	}
	
	public void chooseMulti(){
		System.out.println("You choose MULTIPLAYER.");
		Multi = true;
	}
	
	public void EnterNumberPlayers(int NumPlayers){
		System.out.println("Enter number of Players: ");
		//PlayersPlaying = scanner.nextInt();
		PlayersPlaying = NumPlayers;
		System.out.println(PlayersPlaying);
	}
	/*public void chooseSoloOrMulti(){
		
		System.out.println("Press 1 for Solo.\nPress 2 for Multiplayer.");
		int Choose = scanner.nextInt();
		
		switch(Choose){
			case 1: 
				System.out.println("You choosed Solo Player.\nYou will be playing by yourself.\n");
				PlayersPlaying = 1;
				Multi = false;
				break;
				
			case 2:
				System.out.println("You choosed Multiplayer.\nPlease Enter the number of Players: ");
				PlayersPlaying = scanner.nextInt();
				Multi = true;
				break;
			
			default:
				System.out.println("Press 1 for Solo Player or 2 for Multiplayer.");
				break;
		}
	}
	*/
	public void printPlayers(){
			if(Multi == false){
				for(int b = 0; b < PlayersPlaying; b++){
					System.out.println(players[b]);
				}
			}
			if(Multi == true && PlayersPlaying > 1 && PlayersPlaying <= 8){
				for(int b = 0; b < PlayersPlaying; b++){
					System.out.println(players[b]);
				}
			}
			else{
				if(Multi != false && PlayersPlaying == 1){
					System.out.println("You can't play alone.");
				}
				if(PlayersPlaying > 8){
					System.out.println("Sorry. Up to 8 players only.");
				}
			}
	}
		
	public void addPlayerName(String Name){
		if (Multi == false) {
			System.out.println("Enter Name: ");
			for(int x = 0; x < 1; x++){
				//Name = scanner.next();
				//Name = name;
				players[x] = Name;
				//token[x] = choosePlayerToken(LabelToken);
				//token[x] = LabelToken;
				System.out.println(Name + " as " + token);
				//printChosenToken();
			}
			
		}
		if (Multi == true && PlayersPlaying > 1 && PlayersPlaying <= 8){
			for(int j = 0; j < PlayersPlaying; j++){
				System.out.println("Enter Name: ");
				//Name = scanner.next();
				players[j] = Name;
				//token[j] = choosePlayerToken(LabelToken);
				//token[j] = LabelToken;
				System.out.println(Name + " as " + token);
			}
		}
	}
	
	public void addPlayer(){
		if(Multi == true){
			System.out.println("Do you want to add another player? Press 1 if yes, press 2 if no.");
		}
			int YesNo = scanner.nextInt();
		
		
		switch(YesNo){
			case 1: 
				if (Multi != false && PlayersPlaying < 8){
					System.out.println("Another Player added.");
					PlayersPlaying++;
				}
				break;
			case 2: 
				System.out.println("No player added.");
				break;
				
			default:
				System.out.println("Choose either 1 or 2");
				break;
		}
		
		
	}
	
	public int choosePlayerToken(int LabelToken){
		
		/*if(Multi == true  || PlayersPlaying == 1){
			System.out.println("Choose your token before playing");
			System.out.println("[1] bapor");
			System.out.println("[2] azkal");
			System.out.println("[3] iron");
			System.out.println("[4] shoe");
			System.out.println("[5] moneybag");
			System.out.println("[6] train");
			System.out.println("[7] thimble");
			System.out.println("[8] man on horseback");
		}*/
		//LabelToken = scanner.nextInt();
		//token = LabelToken;
		
			switch(LabelToken){
			
			case 1:
				System.out.println("bapor");
				break;
				
			case 2:
				System.out.println("azkal");
				break;
				
			case 3:
				System.out.println("iron");
				break;
				
			case 4:
				System.out.println("shoe");
				break;
				
			case 5:
				System.out.println("moneybag");
				break;
				
			case 6:
				System.out.println("train");
				break;
				
			case 7:
				System.out.println("thimble");
				break;
				
			case 8:
				System.out.println("man on horseback");
				break;
			
			}
		
		return LabelToken;

	}

	
	public void printChosenToken(){
		if(Multi == false){
			for(int a = 0; a < PlayersPlaying; a++){
				System.out.println(token);
			}
		}
		if(Multi == true && PlayersPlaying > 1 && PlayersPlaying <= 8){
			for(int a = 0; a < PlayersPlaying; a++){
				System.out.println(token[a]);
			}
		}
	}

	public void initializeStartMoney(){
		if(Multi != true){
			for(int x = 0; x < PlayersPlaying; x++){
				StartMoney = 1500;
				System.out.println("Player " + players[x] + " has " + StartMoney);
			}
		}
		
		if(Multi == true){
			for(int x = 0; x < PlayersPlaying; x++){
				StartMoney = 1500;
				System.out.println("Player " + players[x] + " has " + StartMoney);
			}
		}
		
		
	}

public static void main(String[]args){
	Players players = new Players();
	System.out.println("Start. Choose Player Type.");
	//players.chooseSoloOrMulti();
	System.out.println("Add Player Name.");
	//players.addPlayerName();
	System.out.println("List of Players.");
	players.printPlayers();
	players.printChosenToken();
	players.addPlayer();
	players.initializeStartMoney();
	//System.out.println("New set of players.");
	//players.addPlayerName();
	//players.printPlayers();
	
}
}