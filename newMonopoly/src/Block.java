

public class Block {
	private int location, type;
	private String name;
	private Station station;
	private Utilities utilities;
	private Estate estate;
	private Property property;
	
	public Block(){
		
	}
	
	public Block(String name, int location){
		this.setName(name);
		this.setLocation(location);
	}
	
	public Block(Estate estate) {
		this.setEstate(estate);
		this.setType(1);
	}
	public Block(Station station) {
		this.setStation(station);
		this.setType(2);
	}
	
	public Block(Utilities utilities) {
		this.setUtilities(utilities);
		this.setType(3);
	}
	
	public Block(Property property){
		this.setProperty(property);
	}
	
////////////////////////GETTERS AND SETTERS/////////////////////////////

	public void setLocation(int location) {
		this.location = location;
	}
	public int getLocation() {
		return location;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setStation(Station station){
		this.station = station;
	}
	public Station getStation() {
		return station;
	}
	
	public void setUtilities(Utilities utilities){
		this.utilities = utilities;
	}
	public Utilities getUtilities() {
		return utilities;
	}
	
	public void setEstate(Estate estate){
		this.estate = estate;
	}
	public Estate getEstate() {
		return estate;
	}

	public void setProperty(Property property){
		this.property = property;
	}
	public Property getProperty() {
		// TODO Auto-generated method stub
		return property;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
	
}
