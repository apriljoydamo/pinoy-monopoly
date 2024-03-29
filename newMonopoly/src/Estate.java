
public class Estate extends Property{
	private int numberOfHouse, numberOfHotels, colorGroup;

	public Estate(String name, int location, int price, int colorGroup, boolean isOwned, boolean isMortgaged, TitleDeed titledeed){
		this.setPrice(price);
		this.setName(name);
		this.setLocation(location);
		this.setColorGroup(colorGroup);
		this.setOwned(isOwned);
		this.setMortgaged(isMortgaged);
		this.setTitledeed(titledeed);
		
	}

	public void setNumberOfHouse(int numberOfHouse) {
		this.numberOfHouse = numberOfHouse;
	}

	public int getNumberOfHouse() {
		return numberOfHouse;
	}

	public void setColorGroup(int colorGroup) {
		this.colorGroup = colorGroup;
	}

	public int getColorGroup() {
		return colorGroup;
	}

	public void setNumberOfHotels(int numberOfHotels) {
		this.numberOfHotels = numberOfHotels;
	}

	public int getNumberOfHotels() {
		return numberOfHotels;
	}

	
}
