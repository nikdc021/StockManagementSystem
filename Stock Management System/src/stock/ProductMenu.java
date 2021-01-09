package stock;

import java.util.Scanner;

class ProductMenu {
	private Scanner sc = new Scanner(System.in);
	private int choice = 0, choice1 = 0;
	private CRUDProduct proOperate = new CRUDProduct();
	private Product product = new Product();
	
	void menu() {
		while (choice != 5) {
			System.out.println("---------Products---------");
			System.out.println();
			System.out.println("1) Add");
			System.out.println("2) Update");
			System.out.println("3) View");
			System.out.println("4) Delete");
			System.out.println("5) Exit");
			System.out.println("Enter your choice :-");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addProduct();
				break;
			case 2:
				updateProduct();
				break;
			case 3:
				viewProduct();
				break;
			case 4:
				deleteProduct();
				break;
			case 5:
				break;
			default:
				System.out.println("Please enter valid choice!");
			}
		}
	}
	
	void addProduct() {
		choice1 = 0;
		
		while (choice1 != 2) {
			System.out.println("---------Add Product---------");
			System.out.println();
			System.out.println("Enter Product Name");
			product.setName(sc.next());

			if (proOperate.checkExistance(product.getName())) {
				System.out.println("The Product Name Already Exists!");
			} else {
				System.out.println("Enter Product Price");
				product.setPrice(sc.nextFloat());

				System.out.println("Enter Product Stock");
				product.setStock(sc.nextInt());

				int x = proOperate.addProduct(product);
				
				if (x > 0) {
					System.out.println("Product Entered successfully!");
				} else {
					System.out.println("Product Entry failed!");
				}
			}

			askAgain();
			choice1 = sc.nextInt();
		}
	}
	
	void updateProduct() {
		choice1 = 0;
		
		while (choice1 != 2) {
			System.out.println("---------Update Product---------");
			System.out.println();
			System.out.println("Enter Product Name");
			product.setName(sc.next());

				if (!proOperate.checkExistance(product.getName())) {
					System.out.println("The Product Doesn't Exists!");
				} else {
					System.out.println("Enter Product Price");
					product.setPrice(sc.nextFloat());

					System.out.println("Enter Product Stock");
					product.setStock(sc.nextInt());

					int x = proOperate.updateProduct(product);
					
					if (x > 0) {
						System.out.println("Product Updated successfully!");
					} else {
						System.out.println("Product Updation failed!");
					}
				}

				askAgain();
				choice1 = sc.nextInt();
		}
	}
	
	void viewProduct() {
		choice1 = 0;
		
		while (choice1 != 2) {
			System.out.println("---------View Product---------");
			System.out.println();
			System.out.println("Enter Product Name");
			product.setName(sc.next());

			Product p = proOperate.viewProduct(product.getName());
			
			if (p!=null) {
				System.out.println("Product details :- ");
				System.out.println("Name - " + p.getName());
				System.out.println("Price - " + p.getPrice());
				System.out.println("Stock - " + p.getStock());
			} else {
				System.out.println("The Product Doesn't Exists!");
			}

			askAgain();
			choice1 = sc.nextInt();
		}
	}
	
	void deleteProduct() {
		choice1 = 0;
		
		while (choice1 != 2) {
			System.out.println("---------Delete Product---------");
			System.out.println();
			System.out.println("Enter Product Name");
			product.setName(sc.next());

			if (!proOperate.checkExistance(product.getName())) {
				System.out.println("The Product Doesn't Exists!");
			} else {
				
				int x = proOperate.deleteProduct(product.getName());
				
				if (x > 0) {
					System.out.println("Product Deleted successfully!");
				} else {
					System.out.println("Product Deletion failed!");
				}
			}

			askAgain();
			choice1 = sc.nextInt();
		}
	}
	
	void askAgain() {
		System.out.println("Do you want to delete more product?");
		System.out.println("1) Yes");
		System.out.println("2) No");
	}
	
}
