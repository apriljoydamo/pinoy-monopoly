
public class Estate extends Property{
	private int numberOfHouse, numberOfHotels, colorGroup;
	private boolean isMortgaged;
    //0 brown
    //1 blue
    //2 pink
    //3 orange
    //4 red
    //5 yellow
    //6 green
    //7 dark blue
	
	public Estate(String name, int location, int price, int colorGroup, boolean isOwned, TitleDeed titledeed){
		this.setPrice(price);
		this.setName(name);
		this.setLocation(location);
		this.setColorGroup(colorGroup);
		this.setOwned(isOwned);
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

	public void setMortgaged(boolean isMortgaged) {
		this.isMortgaged = isMortgaged;
	}

	public boolean isMortgaged() {
		return isMortgaged;
	}

}
