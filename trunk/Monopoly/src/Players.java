import java.util.Scanner;

public class Players {
	private String Name;
	private int StartMoney;
	int PlayersPlaying;
	String[] players = new String[8];
	boolean Multi;
	
	
		
	Scanner scanner = new Scanner(System.in);
	
	public void chooseSoloOrMulti(){
		
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
		
	public void addPlayerName(){
		if (Multi == false) {
			System.out.println("Enter Name: ");
			for(int x = 0; x < 1; x++){
				Name = scanner.next();
				players[x] = Name;
			}	
		}
		if (Multi == true && PlayersPlaying > 1 && PlayersPlaying <= 8){
			for(int j = 0; j < PlayersPlaying; j++){
				System.out.println("Enter Name: ");
				Name = scanner.next();
				players[j] = Name;
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
	players.chooseSoloOrMulti();
	System.out.println("Add Player Name.");
	players.addPlayerName();
	System.out.println("List of Players.");
	players.printPlayers();
	players.addPlayer();
	System.out.println("New set of players.");
	players.addPlayerName();
	players.printPlayers();
	players.initializeStartMoney();
	
}
}