

public class Block {
	private int location;
	private String name;
	private Station station;
	private Utilities utilities;
	private Estate estate;
	private Tax tax;
	private Chance chance;
	private CommunityChest cChest;
	
	public Block(String name, int location){
		this.setName(name);
		this.setLocation(location);
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
	public Block(Station station) {
		this.station = station;
	}
	public Station getStation() {
		return station;
	}
	public Block(Utilities utilities) {
		this.utilities = utilities;
	}
	public Utilities getUtilities() {
		return utilities;
	}
	public Block(Estate estate) {
		this.estate = estate;
	}
	public Estate getEstate() {
		return estate;
	}
	public Block(Tax tax) {
		this.tax = tax;
	}
	public Tax getTax() {
		return tax;
	}
	public Block(Chance chance) {
		this.chance = chance;
	}
	public Chance getChance() {
		return chance;
	}
	public Block(CommunityChest cChest) {
		this.cChest = cChest;
	}
	public CommunityChest getcChest() {
		return cChest;
	}
	
}
