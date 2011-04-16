import java.util.ArrayList;


@SuppressWarnings("unchecked")
public class Players{
        
        private int tempOrder, totalSteps, tryForDice = 0;
        private int order = 1, startMoney = 1500, position = 0, doubleDice = 0, lastStep = 0, bailOutDice = 0;
        private String playerName;
        private Token token;
        private boolean isJailed = false, hasJailKey = false, hasCompletedColorGroup = false;
        BoardBlock bblock = new BoardBlock();
        Block block = new Block();
        private ArrayList<Station> stationList = new ArrayList<Station>();
        private ArrayList<Utilities> utilityList = new ArrayList<Utilities>();
        private ArrayList<Estate>[] colorGroupList = new ArrayList[8];
		
        

        
/////////////////////Creating a Player/////////////////////////////////////
        public Players createPlayer(String Name){
                Players players = new Players();
                players.token = new Token();
                players.setPlayerName(Name);
                players.setStartMoney(startMoney);
                //System.out.println(startMoney + " labeltoken " + labelToken);
                return players;
        }
        
        
/////////////////////GETTER AND SETTER//////////////////////////////////////
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


        public void setTotalSteps(int totalSteps) {
                this.totalSteps = totalSteps;
        }


        public int getTotalSteps() {
                return totalSteps;
        }


        public void setPosition(int position) {
                this.position = position;
        }


        public int getPosition() {
                return position;
        }


		public void setDoubleDice(int doubleDice) {
			this.doubleDice = doubleDice;
		}


		public int getDoubleDice() {
			return doubleDice;
		}


		public void setJailed(boolean isJailed) {
			this.isJailed = isJailed;
		}


		public boolean isJailed() {
			return isJailed;
		}

		public void setLastStep(int lastStep) {
			this.lastStep = lastStep;
			
		}

		public int getLastStep() {
			return lastStep;
		}

		
		public void setTryForDice(int tryForDice) {
			this.tryForDice = tryForDice;
		}


		public int getTryForDice() {
			return tryForDice;
		}

		public void setBailOutDice(int bailOutDice) {
			this.bailOutDice = bailOutDice;
		}


		public int getBailOutDice() {
			return bailOutDice;
		}
		
		public void setHasJailKey(boolean hasJailKey) {
			this.hasJailKey = hasJailKey;
		}


		public boolean hasJailKey() {
			return hasJailKey;
		}

		public void setHasCompletedColorGroup(boolean hasCompletedColorGroup) {
			this.hasCompletedColorGroup = hasCompletedColorGroup;
		}


		public boolean isHasCompletedColorGroup() {
			return hasCompletedColorGroup;
		}


		public void setStationList(ArrayList<Station> stationList) {
			this.stationList = stationList;
		}


		public ArrayList<Station> getStationList() {
			return stationList;
		}


		public void setUtilityList(ArrayList<Utilities> utilityList) {
			this.utilityList = utilityList;
		}


		public ArrayList<Utilities> getUtilityList() {
			return utilityList;
		}

		public ArrayList<Estate>[] getColorGroupList() {
			return colorGroupList;
		}


		///////////////////////////////////////METHODS//////////////////////////
	
		
		
		public void buyEstate(Estate estate, Players[] playerOrder, int x){
			for(int i=0;i<colorGroupList.length;i++){ 
				colorGroupList[i] = new ArrayList<Estate>();
			}
			estate.setOwned(true);
			estate.setIntOwner(x);
			estate.setOwnerName(playerOrder[x].getPlayerName());
			colorGroupList[bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getColorGroup()].add(bblock.getBlock()[playerOrder[x].getPosition()].getEstate());
			updateProperty();
			
			System.out.println("colorGroup: "+ bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getColorGroup());
			System.out.println("ToBeAddedInColorGroup: "+ bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getName());
			
			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getPrice());
		}
		
		public void buyStation(Station station, Players[] playerOrder, int x){
			station.setOwned(true);
			station.setIntOwner(x);
			station.setOwnerName(playerOrder[x].getPlayerName());
			getStationList().add(block.getStation());
			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - bblock.getBlock()[playerOrder[x].getPosition()].getStation().getPrice());
		}
		
		public void buyUtility(Utilities utility, Players[] playerOrder, int x){
			utility.setOwned(true);
			utility.setIntOwner(x);
			utility.setOwnerName(playerOrder[x].getPlayerName());
			getUtilityList().add(block.getUtilities());
			playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getPrice());
			
		}
		
		public void payRent(Players[] playerOrder, int x, int rent){
			int owner = 0;
            switch(bblock.getBlock()[playerOrder[x].getPosition()].getType()){
            case 1:
                    owner = bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner();
                    break;
            case 2:
                    owner = bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner();
                    break;
            case 3:
                    owner = bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner();
                    break;
            }
            
            playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - rent);      
            playerOrder[owner].setStartMoney(playerOrder[owner].getStartMoney() + rent);  
    
			System.out.println("Rent: " + rent);
			System.out.println("PaidBy: " + playerOrder[x].getPlayerName()+" Money: "+playerOrder[x].getStartMoney());
			System.out.println("Paid to: " + playerOrder[owner].getPlayerName()+" Money: "+playerOrder[owner].getStartMoney());
			
		}
		
		public int computeRent(Players[] playerOrder, int position, int x, int totalSteps){
			int owner = 0;
			int rent = 0;
			int rentType = 0;
			 
			
			switch(bblock.getBlock()[playerOrder[x].getPosition()].getType()){
			case 1:
				owner = bblock.getBlock()[playerOrder[x].getPosition()].getEstate().getIntOwner();
				rentType = bblock.getBlock()[position].getEstate().getNumberOfHouse();
				rent = bblock.getBlock()[position].getEstate().getTitledeed().getRentEstate()[rentType];
				
				 if(playerOrder[owner].hasCompletedColorGroup && bblock.getBlock()[position].getEstate().getNumberOfHouse()==0){
                   rent = rent*2;
                   System.out.println("your rent is doubled! " +rent);
                     }
				 break;
				
			case 2:
				owner = bblock.getBlock()[playerOrder[x].getPosition()].getStation().getIntOwner();
                rentType = playerOrder[owner].getStationList().size()-1;    
                rent = bblock.getBlock()[position].getStation().getTitledeed().getRentStation()[rentType];
				break;
				
			case 3:
				 owner = bblock.getBlock()[playerOrder[x].getPosition()].getUtilities().getIntOwner();
				 rentType = playerOrder[owner].getUtilityList().size()-1;  
				 rent = (bblock.getBlock()[position].getUtilities().getTitledeed().getRentUtility()[rentType])*(totalSteps);
				break;
			}
			
			return rent;
			
		}

		public void updateProperty(){
			for(int f=0; f<=7; f++){
                if(getColorGroupList()[f].size() == bblock.getColorGroupSize()[f]){
                        hasCompletedColorGroup = true;
                        f=7;
                }
                else{
                        hasCompletedColorGroup = false;
                }
			}
		}
		
		public void mortgageProperty(Players[] playerOrder, int x, int position){
			int mortgagePrice = 0;
            
            switch(bblock.getBlock()[position].getType()){
                    case 1:
                    		bblock.getBlock()[position].getEstate().setMortgaged(true);
                            mortgagePrice = bblock.getBlock()[position].getEstate().getTitledeed().getEstateMortgageValue();
                            break;
                    case 2:
                    		bblock.getBlock()[position].getStation().setMortgaged(true);
                            mortgagePrice = bblock.getBlock()[position].getStation().getTitledeed().getStationMortgageValue();
                            break;
                    case 3:
                    	bblock.getBlock()[position].getUtilities().setMortgaged(true);
                            mortgagePrice = bblock.getBlock()[position].getUtilities().getTitledeed().getUtilityMortgageValue();
                            break;
            }
            
            playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() + mortgagePrice);
            System.out.println("Mortgaged: " + bblock.getBlock()[position].getEstate().isMortgaged());
            System.out.println("Price: " + mortgagePrice);
		}
		
		public void redeemProperty(Players[] playerOrder, int x, int position){
			int redeemPrice = 0;
            
            switch(bblock.getBlock()[position].getType()){
                    case 1:
                            bblock.getBlock()[position].getEstate().setMortgaged(false);
                            redeemPrice = bblock.getBlock()[position].getEstate().getTitledeed().getEstateRedeemValue();
                            break;
                    case 2:
                    		bblock.getBlock()[position].getStation().setMortgaged(false);
                            redeemPrice = bblock.getBlock()[position].getStation().getTitledeed().getStationRedeemValue();
                            break;
                    case 3:
                    	bblock.getBlock()[position].getUtilities().setMortgaged(false);
                            redeemPrice = bblock.getBlock()[position].getUtilities().getTitledeed().getUtilityRedeemValue();
                            break;
            }
            
            playerOrder[x].setStartMoney(playerOrder[x].getStartMoney() - redeemPrice);
            System.out.println("Mortgaged: " + bblock.getBlock()[position].getEstate().isMortgaged());
            System.out.println("Price: " + redeemPrice);
		}
}

