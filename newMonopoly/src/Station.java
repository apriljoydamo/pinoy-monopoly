
public class Station extends Property{
	private boolean isMortgaged;
	public Station(String name, int location, int price, boolean isOwned, TitleDeed titledeed){
		this.setPrice(price);
		this.setName(name);
		this.setLocation(location);
		this.setOwned(isOwned);
		this.setTitledeed(titledeed);
	}

	public void setMortgaged(boolean isMortgaged) {
		this.isMortgaged = isMortgaged;
	}

	public boolean isMortgaged() {
		return isMortgaged;
	}
}