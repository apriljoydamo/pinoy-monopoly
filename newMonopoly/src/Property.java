
public class Property extends Block{
	
	private int price = 0, intOwner;
	private String propertyName = null, ownerName = null;
	private boolean isOwned = false, isMortgaged = false;
	private TitleDeed titledeed;
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}
	public boolean isOwned() {
		return isOwned;
	}
	public void setTitledeed(TitleDeed titledeed) {
		this.titledeed = titledeed;
	}
	public TitleDeed getTitledeed() {
		return titledeed;
	}
	public void setIntOwner(int intOwner) {
		this.intOwner = intOwner;
	}
	public int getIntOwner() {
		return intOwner;
	}
	public void setMortgaged(boolean isMortgaged) {
		this.isMortgaged = isMortgaged;
	}
	public boolean isMortgaged() {
		return isMortgaged;
	}
}
