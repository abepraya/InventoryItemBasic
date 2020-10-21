package inventory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {
	public static void main(String[] args) {
		int maxSize, menuChoice;

		Scanner in = new Scanner(System.in);
		maxSize = getNumProducts(in);

		if (maxSize == 0) {
			System.out.println("No products required!\n\n");
		} else {
			Product[] products = new Product[maxSize];
			addToInventory(products, in);
			do {
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice, products, in);
			} while (menuChoice != 0);
		}
		in.close();
	}

	// method displayInventory = menampilkan barang beserta data yang telah input
	public static void displayInventory(Product[] products) {
		for (Product produsen : products) {
			System.out.println(produsen);
		}
	}

	// method addToInventory = menambah data product
	public static void addToInventory(Product[] products, Scanner in) {
		// inisiasi variabel
		int tempNumber, tempQty;
		double tempPrice;
		String tempName;
		try {
			for (int i = 0; i < products.length; i++) {
				in.nextLine();
				System.out.print("ID ITEM NUMBER\t\t: ");
				tempNumber = in.nextInt();
				System.out.print("PRODUCT NAME\t\t: ");
				tempName = in.next();
				System.out.print("QUANTITY\t\t: ");
				tempQty = in.nextInt();
				System.out.print("PRICE\t\t\t: ");
				tempPrice = in.nextDouble();
				System.out.print("\n\n");

				Product newProduct = new Product(tempNumber, tempName, tempQty, tempPrice);
				products[i] = newProduct;
			}
		} catch (InputMismatchException e) {
			System.out.println("Incorrect data type!");
			in.nextLine();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

	// method getNumProducts = menentukan jumlah product yang ingin ditambahkan
	public static int getNumProducts(Scanner in) {
		// inisiasi variabel
		int maxSize = -1;
		do {
			try {
				// menentukan jumlah barang yang ingin ditambahkan
				System.out.println("Enter the number of products you would like to add");
				System.out.print("Enter 0 (zero) if you do not wish to add products :");
				maxSize = in.nextInt();

				// validasi input maxSize
				if (maxSize < 0) { // nilai negatif akan memberikan pesan "incorrect value entered!"
					System.out.println("Incorrect Value entered\n\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!\n\n");
				in.nextLine();
			} catch (Exception e) {
				System.out.println(e);
			}

		} while (maxSize < 0);
		return maxSize;
	}
	
	// method getMenuOption = mencetak tampilan menu dan menerima input int menu
	public static int getMenuOption(Scanner in) {

		int inputMenu = -1;
		do {
			try {
				System.out.println("1. View Inventory");
				System.out.println("2. Add Stock");
				System.out.println("3. Deduct Stock");
				System.out.println("4. Discontinue Product");
				System.out.println("0. Exit");
				System.out.print("Please enter a menu option: ");
				inputMenu = in.nextInt();
			} catch (Exception e) {
				System.out.println(e);
				in.nextLine();
			}

		} while (inputMenu > 4 || inputMenu < 0);
		return inputMenu;
	}
	
	//method ProductNumber = meminta index yang disimpan dalam array products untuk melakukan pengoperasin add/deduct
	public static int getProductNumber(Product[] products, Scanner in) {
		int productChoice = -1;

		for (int i = 0; i < products.length; i++) {
			System.out.printf("\nPRODUCT NAME\t\t: %s\n", products[i].getNameProduct());
			System.out.printf("QUANTITY\t\t: %d\n\n", products[i].getQty());
		}

		do {
			try {
				System.out.print("Index Product [0 - Product length]: ");
				productChoice = in.nextInt();

			}catch (IndexOutOfBoundsException e) {
				System.out.println("Index start from 0 to Product length !");
				in.nextLine();
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		} while (productChoice < 0 || productChoice > products.length);

		return productChoice;
	}
	
	//method addInventory = melakukan penambahan quantity suatu product yang terpilih dari ProductNumber
	public static void addInventory(Product[] products, Scanner in) {
		int productChoice, updateValue = -1;

		productChoice = getProductNumber(products, in);
		do {
				System.out.println("How many products do you want to add?");
				updateValue = in.nextInt();
				if (updateValue < 0) {
					System.out.println("Invalid Input! [Should be more than 0]");
				}
		} while (updateValue < 0);
		products[productChoice].addingInventory(updateValue);
		System.out.println("\nDONE!\n\n");

	}
	
	//method deductInventory = melakukan pengurangan quantity suatu product yang terpilih dari ProductNumber
	public static void deductInventory(Product[] products, Scanner in) {
		int productChoice, updateValue = 0;

		productChoice = getProductNumber(products, in);
		do {
				System.out.println("How many products do you want to deduct?");
				updateValue = in.nextInt();
				if (updateValue < 0) {
					System.out.println("Invalid Input! [Shouldn't less than 0]");
				}
		} while (updateValue < 0);
		products[productChoice].deductingInventory(updateValue);
		System.out.println("\nDONE!\n\n");
	}
	
	//method discontinueInventory = menonaktifkan (dengan boolean) suatu product yang bernilai true menjadi false
	public static void discontinueInventory(Product[] products, Scanner in) {
		int productChoice;
		productChoice = getProductNumber(products, in);
		products[productChoice].setItemStatus(false);
	}
	
	//executeMenuChoice = memilih perintah dalam MenuOption dari permintaan user terkait input yang diberikan
	public static void executeMenuChoice(int menuChoice, Product[] products, Scanner in) {
		switch (menuChoice) {
		case 1: {
			System.out.println("\n\nView Product List\n");
			displayInventory(products);
			break;
		}
		case 2: {
			System.out.println("\n\nAdd Stock\n");
			addInventory(products, in);
			break;
		}
		case 3: {
			System.out.println("\n\nDeduct Stock\n");
			deductInventory(products, in);
			break;
		}
		case 4: {
			System.out.println("\n\nDiscontinue Stock\n");
			discontinueInventory(products, in);
			break;
		}
		case 0: {
			System.out.println("Closing the Program !");
			break;
		}
		default:
			System.out.println("Invalid Input");
		}
	}
}
