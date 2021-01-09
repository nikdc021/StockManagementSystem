package stock;

import java.util.Scanner;

class Purchase {
	
	private Scanner sc = new Scanner(System.in);
	private int choice = 0;
	private String itemName = new String();
	private CRUDProduct proOperate = new CRUDProduct();
	
	void purchase() {
		
		while (choice != 2) {
			System.out.println("---------Purchase Product---------");
			System.out.println();
			System.out.println("Enter Product Name");
			itemName = sc.next();
			int stock;

			if (proOperate.checkExistance(itemName)) {
				System.out.println("How many quantity you purchased?");
				stock = sc.nextInt();

				int x = proOperate.purchase(stock,itemName);

				if (x > 0) {
					System.out.println("Product Purchased successfully!");
				} else {
					System.out.println("Product Purchase failed!");
				}
			} else {
				System.out.println("The Product Doesn't Exists!");
			}

			System.out.println("Do you want to purchase more product?");
			System.out.println("1) Yes");
			System.out.println("2) No");

			choice = sc.nextInt();
		}
	}
}
