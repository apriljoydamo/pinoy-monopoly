public class Players{
	
	private String TokenName;
	private int StartMoney;
	static int PlayersPlaying;
	private String playerName;
	private int token;
	boolean Multi;
	public int LabelToken;
	
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
		PlayersPlaying = NumPlayers;
		System.out.println(PlayersPlaying);
	}

	public void addPlayerName(String Name){
			System.out.println("Enter Name: ");
				setPlayerName(Name);
				setToken(choosePlayerToken(LabelToken));
				initializeStartMoney();
				System.out.println(Name + " as " + TokenName + " has " + StartMoney);
			
	}
	
	public Players createPlayer(){
		Players players = new Players();
		players.addPlayerName(toString());
		return players;
	}
	
	public int choosePlayerToken(int LabelToken){
			switch(LabelToken){
			
			case 1:
				TokenName = "Bapor";
				System.out.println("bapor");
				break;
				
			case 2:
				TokenName = "Azkal";
				System.out.println("azkal");
				break;
				
			case 3:
				TokenName = "Iron";
				System.out.println("iron");
				break;
				
			case 4:
				TokenName = "Shoe";
				System.out.println("shoe");
				break;
				
			case 5:
				TokenName = "Money Bag";
				System.out.println("moneybag");
				break;
				
			case 6:
				TokenName = "Train";
				System.out.println("train");
				break;
				
			case 7:
				TokenName = "Thimble";
				System.out.println("thimble");
				break;
				
			case 8:
				TokenName = "Man On Horseback";
				System.out.println("man on horseback");
				break;
			
			}
		
		return LabelToken;

	}

	public void initializeStartMoney(){
				setStartMoney(1500);		
	}
	
	public void moveToken(){
				
	}
		/*if(PlayersPlaying == 1){
			do{	
				int c = 0;
				for(int x = 0; x < 1; x++){
					c++;
					System.out.println("PLAYER #1:" + players[x] + " " + "TOKEN:" + TokenName +"");
					System.out.println("Enter number of steps:");
					WalkMove = scanner.nextInt();
					
					for(int i = 1; i <= WalkMove; i++){
						System.out.println(i);
						Thread.sleep(1000);
					}
					System.out.println("next!");
				}
			}while(PlayersPlaying == 1);
		}
		
		//addPlayer();
		if(Multi == true){
			do{
				int c = 0;
				for(int x = 0; x < PlayersPlaying; x++){
					c++;
					System.out.println("PLAYER #" + c + ":" + players[x] + "  " + "TOKEN:" + token[x] +"");
					System.out.println("Enter number of steps:");
					WalkMove = scanner.nextInt();
					
					for(int i = 1; i <= WalkMove;i++){
						System.out.println(i);
						Thread.sleep(1000);
					}
					System.out.println("next!");
				}
			}while(Multi == true);
		}
		public void run() {
			while(isRunning){
				System.out.println("RUN!");
				if(LabelToken == 1){
					board.getDogToken().setLocation(board.getDogToken().getX()+1, board.getDogToken().getY()+1);
					try{
						Thread.sleep(500);
					}
					catch(InterruptedException e){}
				}
			}
		}
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e){
			if(board.isRolled == true){
				t = new Thread(this);
				isRunning = true;
				t.start();
			}else if(board.isRolled == false){
				t.stop();
				isRunning = false;
			}
			
		}
	
	}
			


public static void main(String[]args) throws InterruptedException{
	Players players = new Players();
	System.out.println("Start. Choose Player Type.");
	players.chooseSolo();
	System.out.println("Add Player Name.");
	players.addPlayerName("aj");
	players.choosePlayerToken(4);
	System.out.println("List of Players.");
	players.printPlayers();
	//players.moveToken();
	///players.printChosenToken();
	//players.addPlayer();
	players.initializeStartMoney();
	//System.out.println("New set of players.");
	//players.addPlayerName();
	//players.printPlayers();
	
}}*/

	public void setStartMoney(int startMoney) {
		StartMoney = startMoney;
	}

	public int getStartMoney() {
		return StartMoney;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public int getToken() {
		return token;
	}
}

