package inventory;

public class Product {
	private int itemNumber;
	private String nameProduct;
	private int qty;
	private double priceItem;
	private boolean productStatus = true;

	//overloading = memiliki beberapa method dengan implementasi yang berbeda
	//Constructor kosong Product
	public Product(){

	}
	//constructor ber parameter
	public Product(int itemNumber, String nameProduct,int qty,double priceItem) {
		this.itemNumber = itemNumber;
		this.nameProduct = nameProduct;
		this.qty = qty;
		this.priceItem = priceItem;
	}
	
	//add dan deduct
	public void addingInventory(int quantity) {
		this.qty = this.qty + quantity;
	}
	public void deductingInventory(int quantity) {
		this.qty = this.qty - quantity;
	}
	
	//getter setter ItemNumber
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	//getter setter NameProduct
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	
	////getter setter Qty
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	//getter setter PriceItem
	public double getPriceItem() {
		return priceItem;
	}
	public void setPriceItem(double priceItem) {
		this.priceItem = priceItem;
	}
	
	//getter InventoryValue
	public double getInventoryValue() {
		return this.priceItem * this.qty;
	}
	
	//getter setter itemStatus
	public boolean getItemStatus() {
		return productStatus;
	}
	public void setItemStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
	
	//override toString
	@Override
	public String toString() {
		return
				"Item Number\t : " + this.getItemNumber() + 	//menampilkan id barang
				"\n" + "Name\t\t : " + this.getNameProduct() + 		//menampilkan nama barang
				"\n" + "Qty\t\t : " + this.getQty() + 			//menampilkan jumlah barang
				"\n" + "Price(per item)\t : " + this.getPriceItem() + 	//menampilkan harga per barang
				"\n" + "Total Payment\t : " + this.getInventoryValue() + 	//total harga barang
				"\n" + "Product Status\t : " + (this.getItemStatus() ? "Active" : "Discontinued")+
				"\n\n";
	}

}
