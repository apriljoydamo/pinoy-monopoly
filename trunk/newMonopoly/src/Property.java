

public abstract class Property extends Block {
	private int owner, price;
	
	
/////////////////////GETTERS AND SETTERS///////////////////////////////
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public int getOwner() {
		return owner;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

}
