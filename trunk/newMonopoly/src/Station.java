
public class Station extends Property{
	
	public Station(String name, int location, int price, boolean isOwned, TitleDeed titledeed){
		this.setPrice(price);
		this.setName(name);
		this.setLocation(location);
		this.setOwned(isOwned);
		this.setTitledeed(titledeed);
	}
}