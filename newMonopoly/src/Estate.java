
public class Estate extends Property{
	//private String estateName = super.getBlockName();
	
	public Estate(String name, int location, int price){
			super(name, location);
			this.setPrice(price);
	}

}
