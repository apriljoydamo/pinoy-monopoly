
public class Block {
	private int location;
	private String name;
	private Station station;
	private Utilities utilities;
	private Estate estate;
	private Tax tax;
	private Chance chance;
	private CommunityChest cChest;
	
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
	public void setStation(Station station) {
		this.station = station;
	}
	public Station getStation() {
		return station;
	}
	public void setUtilities(Utilities utilities) {
		this.utilities = utilities;
	}
	public Utilities getUtilities() {
		return utilities;
	}
	public void setEstate(Estate estate) {
		this.estate = estate;
	}
	public Estate getEstate() {
		return estate;
	}
	public void setTax(Tax tax) {
		this.tax = tax;
	}
	public Tax getTax() {
		return tax;
	}
	public void setChance(Chance chance) {
		this.chance = chance;
	}
	public Chance getChance() {
		return chance;
	}
	public void setcChest(CommunityChest cChest) {
		this.cChest = cChest;
	}
	public CommunityChest getcChest() {
		return cChest;
	}
	
}
