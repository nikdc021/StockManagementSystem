package stock;

interface ProductCRUD {
	int addProduct(Product p);
	int updateProduct(Product p);
	Product viewProduct(String itemName);
	int deleteProduct(String itemName);
}

