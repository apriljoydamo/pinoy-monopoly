
public class Estate extends Property{
	//private String estateName = super.getBlockName();
	
	public Estate(String name, int location, int price, boolean isOwned, TitleDeed titledeed){
		this.setPrice(price);
		this.setName(name);
		this.setLocation(location);
		this.setOwned(isOwned);
		this.setTitledeed(titledeed);
	}

}
