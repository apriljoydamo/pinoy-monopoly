
public class Property extends Block{
	
	private int price = 0;
	private String propertyName = null, ownerName = null;
	private boolean isOwned = false;
	//private String name;// = super.getBlockName();
	
	
	////////////////////////////GETTERS AND SETTERS/////////////////////
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
}
