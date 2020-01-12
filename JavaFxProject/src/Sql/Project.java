package Sql;


public class Project {

	private int id;
	private String name;
	private String description;
	private int quantity;
	private double price;
	private String color;

	
	public Project() {
		super();
	
	}
	public Project(int id, String name, String description, int quantity, double price, String color) {
		super();
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.color = color;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
public String getColor() {
		return color;
		
	}
public void setColor(String color) {
		this.color = color;
	
}
	

}
	
