package stock;

import java.util.Scanner;

class Sale {
	
	private Scanner sc = new Scanner(System.in);
	private int choice = 0;
	private String itemName = new String();
	private CRUDProduct proOperate = new CRUDProduct();
	
	void sale() {

		while (choice != 2) {
			System.out.println("---------Sale Product---------");
			System.out.println();
			System.out.println("Enter Product Name");
			itemName = sc.next();
			int stock;

			if (proOperate.checkExistance(itemName)) {
				System.out.println("How many quantity you want to sell?");
				stock = sc.nextInt();

				int x = proOperate.sale(stock,itemName);
				
				if (x > 0) {
					System.out.println("Product Sold successfully!");
				} else {
					System.out.println("Product Selling failed!");
				}
			} else {
				System.out.println("The Product Doesn't Exists!");
			}

			System.out.println("Do you want to sell more product?");
			System.out.println("1) Yes");
			System.out.println("2) No");

			choice = sc.nextInt();
		}
	}
}
