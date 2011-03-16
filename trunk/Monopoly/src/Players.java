


public class Players{
	
	private int startMoney = 1500;
	private String playerName;
	private Token token;
	private int tempOrder;
	private int order = 1;
	
	//FUNCTIONs

	public Players createPlayer(String Name){
		Players players = new Players();
		players.token = new Token();
		players.setPlayerName(Name);
		//players.setToken(token);
		players.setStartMoney(startMoney);
		//System.out.println(startMoney + " labeltoken " + labelToken);
		return players;
	}
	
	
	//GETTER AND SETTER
	public void setStartMoney(int startMoney) {
		this.startMoney = startMoney;
	}

	public int getStartMoney() {
		return startMoney;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setToken(Token token) {
		this.token = token;
		
	}

	public Token getToken() {
		return token;
	}


	public void setTempOrder(int tempOrder) {
		this.tempOrder = tempOrder;
	}


	public int getTempOrder() {
		return tempOrder;
	}
	

	public void setOrder(int order) {
		this.order = order;
	}


	public int getOrder() {
		return order;
	}
}

