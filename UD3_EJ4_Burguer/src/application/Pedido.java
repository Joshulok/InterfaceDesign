package application;

public class Pedido {

	private String drink;
	private String burger;
	private int priceDrink;
	private int priceBurger;
	
	public Pedido() {
		
	}
	
	public void setPedido(String drink,int price, String burger, int price2) {
		this.drink = drink;
		this.priceDrink = price;
		this.burger = burger;
		this.priceBurger = price2;
	}
	
	public void setDrink(String drink, int price) {
		this.drink = drink;
		this.priceDrink = price;
	}
	
	public void setBurger(String burger, int price) {
		this.burger = burger;
		this.priceBurger = price;
	}
	
	public int getPriceDrink() {
		return this.priceDrink;
	}
	
	public int getPriceBurger() {
		return this.priceBurger;
	}
	
	public String getBurger() {
		return this.burger;
	}
	
	public String getDrink() {
		return this.drink;
	}
	
	public int getPrecioPedido() {
		int pedido = this.priceBurger + this.priceDrink;
		return pedido;
	}
	
	public String toString() {
		return "Drink: "+drink+" Price: " + priceDrink + "\nBurguer: "+ burger+ " Price: "+priceBurger;
	}
	
}
