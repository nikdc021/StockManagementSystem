package stock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

class CRUDProduct implements ProductCRUD {

	private Connection conn =  new DatabaseConnect().connect();
	
	@Override
	public int addProduct(Product p) {
		int x = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into products(name,stock,price) values(?,?,?)");
			ps.setString(1, p.getName());
			ps.setInt(2, p.getStock());
			ps.setFloat(3, p.getPrice());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return x;
	}

	@Override
	public int updateProduct(Product p) {
		int x = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("update products set price = ?, stock = ? where name = ?");
			ps.setString(3, p.getName());
			ps.setInt(2, p.getStock());
			ps.setFloat(1, p.getPrice());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return x;
	}

	@Override
	public Product viewProduct(String itemName) {
		Product p = new Product();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from products where name = ?");
			ps.setString(1, itemName);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				p.setName(itemName);
				p.setPrice(rs.getFloat("price"));
				p.setStock(rs.getInt("stock"));
			} else {
				p = null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return p;
	}

	@Override
	public int deleteProduct(String itemName) {
		int x = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("delete from products where name=?");
			ps.setString(1, itemName);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return x;
	}
	
	public int purchase(int stock,String itemName) {
		int x = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("update products set stock = stock + ? where name = ?");
			ps.setString(2, itemName);
			ps.setInt(1, stock);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return x;
	}
	
	public int sale(int stock,String itemName) {
		int x = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement("update products set stock = stock - ? where name = ?");
			ps.setString(2, itemName);
			ps.setInt(1, stock);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return x;
	}
	
	boolean checkExistance(String itemName) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from products where name = ?");
			ps.setString(1, itemName);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
}
