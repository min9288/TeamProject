package kiosk.vo;

public class Menu {
	public String name;
	public int price;
	public String species;
	
	public Menu() {
		super();
	}
	public Menu(String name, String species, int price) {
		this.name = name;
		this.species = species;
		this.price = price;
	}
	
	
	
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
