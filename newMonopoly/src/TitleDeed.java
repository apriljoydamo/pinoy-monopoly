
public class TitleDeed {
	private int[] rentEstate = new int [6] ;
	private int[] rentStation = new int[4];
	private int[] rentUtility = new int[2];
	private int estateMortgageValue;
	private int stationMortgageValue;
	private int utilityMortgageValue;
	private int estateRedeemValue;
	private int stationRedeemValue;
	private int utilityRedeemValue;
	private int housePrice;
	
	public TitleDeed(int rentEstate0, int rentEstate1, int rentEstate2, int rentEstate3, int rentEstate4, int rentEstate5, int estateMortgageValue, int housePrice){
		this.rentEstate[0] = rentEstate0; //rent
		this.rentEstate[1] = rentEstate1; //1house
		this.rentEstate[2] = rentEstate2; //2house
		this.rentEstate[3] = rentEstate3; //3house
		this.rentEstate[4] = rentEstate4; //4house
		this.rentEstate[5] = rentEstate5; //hotel
		this.estateMortgageValue = estateMortgageValue;
		this.estateRedeemValue = (int) (estateMortgageValue*1.1);
		this.housePrice = housePrice;
	}
	
	public TitleDeed(int rentStation0, int rentStation1, int rentStation2, int rentStation3, int stationMortgageValue){
		this.rentStation[0] = rentStation0;
		this.rentStation[1] = rentStation1;
		this.rentStation[2] = rentStation2;
		this.rentStation[3] = rentStation3;
		this.stationMortgageValue = stationMortgageValue;
		this.stationRedeemValue = (int) (stationMortgageValue*1.1);
		
	}
	
	public TitleDeed(int rentUtility0, int rentUtility1, int utilityMortgageValue){
		this.rentUtility[0] = rentUtility0;
		this.rentUtility[1] = rentUtility1;
		this.utilityMortgageValue = utilityMortgageValue;
		this.utilityRedeemValue = (int) (utilityMortgageValue*1.1);
		
	}
	
	
	public void setRentEstate(int[] rentEstate) {
		this.rentEstate = rentEstate;
	}
	public int[] getRentEstate() {
		return rentEstate;
	}
	public void setRentStation(int[] rentStation) {
		this.rentStation = rentStation;
	}
	public int[] getRentStation() {
		return rentStation;
	}
	public void setRentUtility(int[] rentUtility) {
		this.rentUtility = rentUtility;
	}
	public int[] getRentUtility() {
		return rentUtility;
	}
	public void setEstateMortgageValue(int estateMortgageValue) {
		this.estateMortgageValue = estateMortgageValue;
	}
	public int getEstateMortgageValue() {
		return estateMortgageValue;
	}
	public void setStationMortgageValue(int stationMortgageValue) {
		this.stationMortgageValue = stationMortgageValue;
	}
	public int getStationMortgageValue() {
		return stationMortgageValue;
	}
	public void setUtilityMortgageValue(int utilityMortgageValue) {
		this.utilityMortgageValue = utilityMortgageValue;
	}
	public int getUtilityMortgageValue() {
		return utilityMortgageValue;
	}
	public void setEstateRedeemValue(int estateRedeemValue) {
		this.estateRedeemValue = estateRedeemValue;
	}
	public int getEstateRedeemValue() {
		return estateRedeemValue;
	}
	public void setStationRedeemValue(int stationRedeemValue) {
		this.stationRedeemValue = stationRedeemValue;
	}
	public int getStationRedeemValue() {
		return stationRedeemValue;
	}
	public void setUtilityRedeemValue(int utilityRedeemValue) {
		this.utilityRedeemValue = utilityRedeemValue;
	}
	public int getUtilityRedeemValue() {
		return utilityRedeemValue;
	}
	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}
	public int getHousePrice() {
		return housePrice;
	}
}
