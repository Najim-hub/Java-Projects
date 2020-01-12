package Sql;

import java.sql.*;


import java.util.ArrayList;




	public class DB_Access implements DB_Vars {
		
		private Connection con;
		private Statement st;
		
		public DB_Access() {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, uname, upass);
				st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
											ResultSet.CONCUR_UPDATABLE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public ArrayList<Project> getAllData() {
			ArrayList<Project> all = new ArrayList<Project>();
			
			String sql = "select id, name, description, quantity, price , color from AppleProducts";
			try {
				
				String net = "";
				int nas = 0;
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					Project p = new Project(rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getInt(4),
											rs.getDouble(5),
											rs.getString(6));
					
					all.add(p);
				}
				
				
				 
				 System.out.println(all.get(5));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return all;
		}
		
		public boolean insertProduct(Project p) {
			boolean success = true;
			
			String sql = "select id, name, description, quantity, price , color from AppleProducts";
			
			try {
				ResultSet rs = st.executeQuery(sql);
		
				rs.moveToInsertRow();
				
				rs.updateString(2, p.getName());
				
				rs.updateString(3,  p.getDescription());
				
				rs.updateInt(4,  p.getQuantity());
				
				rs.updateDouble(5,  p.getPrice());
				
				rs.updateString(6, p.getColor());
				
				rs.insertRow();
				
				
			} 
			catch (SQLException e) 
			{
				success = false;
				e.printStackTrace();
			}
			
			return success;
		}
		
		public boolean deleteProduct(int row) {
			boolean success = true;
		
			String sql = "select id, name, description, quantity , price , color "+
			"from AppleProducts where id = ?" ;
			
			try {
				
				
				PreparedStatement pst = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE
						,ResultSet.CONCUR_UPDATABLE);
				
			    pst.setInt(1, row);
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					
					rs.deleteRow();
				}
				
				else {
					success = false;
				}
				
				
			} catch (SQLException e) {
				
				
				success = false;
				e.printStackTrace();
			}
			
			
			return success;
		}
			
		
		public ArrayList<Project> searchProduct(String val) {
			
			ArrayList<Project> list = new ArrayList<Project>();
			
			String sql = "select id, name, description, quantity, price , color from AppleProducts " +
			"where id = "+val;
			
			try {
				
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					Project p = new Project(rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getInt(4),
											rs.getDouble(5),
											rs.getString(6));
					list.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		public boolean modifyProduct(int id, Project p) {
			
			boolean success  = true;
			
			
		String sql = "update AppleProducts set name=?, description=? ," 
		+ "quantity=?, price =? , color=?  where id= ?";
		
		try {
			
			PreparedStatement pst = con.prepareStatement(sql , ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			
			
			pst.setString(1, p.getName());
			pst.setString(2, p.getDescription());
			pst.setInt(3, p.getQuantity());
			pst.setDouble(4, p.getPrice());
			pst.setString(5, p.getColor());
			pst.setInt(6, id);
		
			
			pst.executeUpdate();
		}
		catch(SQLException e) {
			success = false;
			e.printStackTrace();
			
		}
			return success;
		}
		
		
		
	
		
		
		
}
