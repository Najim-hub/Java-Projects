package Sql;


	import java.util.ArrayList;


	import java.util.Scanner;

	public class DB_App {
		
		public static void main(String[] args) {
			
			int choice = 0;
			DB_Access db = new DB_Access();
			Scanner s = new Scanner(System.in);
			
		/*	while(choice != 9) {
				
				choice = displayMenu();
				
				switch(choice) {
				
				case 1:
					
					ArrayList<Project> all = db.getAllData();
					displayListOfProducts(all);
					break;
					
				case 2:
					// search for a product and display it
					System.out.print("Enter value to search with: ");
					String val = s.nextLine();
					
					ArrayList<Project> found = db.searchProduct(val);
					
					displayListOfProducts(found);
					
					break;
					
					
					
					
				case 3:
					
					// add a new product
					Project p = getProductData();
					db.insertProduct(p);
					break;
					
				case 4:
					
					
					
					
					// modify a product
					System.out.print("enter id of product to be modified: ");
					
					int pid = s.nextInt();
					
					Project myp = getProductData();
					
					db.modifyProduct(pid, myp);
					
					break;
					
					
					
					
					
					
				case 5:
					// delete a product
					System.out.print("Enter row number of product to be removed: ");
					int id = s.nextInt();
					if(db.deleteProduct(id))
						System.out.println("product has been successfully deleted");
					else
						System.out.println("error, product was not removed, id is wrong");
					break;
				case 9:
					System.exit(0);
					break;
				}
				*/
			}

		

		public static int displayMenu() {
			System.out.print("Menu:\n" +
							"1. Get all products\n" +
							"2. Search for product\n" +
							"3. Add a product\n" +
							"4. Modify a product\n"+
							"5. Delete a product\n"+
							"9. Exit\n");
			
			Scanner s = new Scanner(System.in);
			int choice;
			do {
				System.out.print("Enter your choice: ");
				choice = s.nextInt();
			}while( !(choice >=1 && choice <=5 || choice == 9) );

			return choice;
		}
		
		public static Project getProductData() {
			
			Project p = null;
			Scanner s = new Scanner(System.in);
			
			System.out.print("Enter product name: ");
			String name = s.nextLine();
			
			System.out.print("Enter product description: ");
			String desc = s.nextLine();
			
			System.out.print("Enter product quantity: ");
			int qty = s.nextInt();
			
			System.out.print("Enter product price: ");
			double price = s.nextDouble();
			
			System.out.println("Enter any color you like: ");
			String color = s.next();
			
			p = new Project(-1, name, desc, qty, price, color);
			
			return p;
		}
		
		public static String displayProduct(Project p) {
			
			/*System.out.print("Enter value to search with: ");
			String val = s.nextLine();
			
			ArrayList<Project> found = db.searchProduct(val);
			
			displayListOfProducts(found);
			*/
			String finding = new String();
			finding=  p.getName()+" " +
					p.getDescription()+ " " + p.getQuantity() + " " +p.getPrice() + " " + p.getColor();
			
			//System.out.println(finding);
			//System.out.println(p.getColor());
			
			return finding;
		}
		
		public  String displayListOfProducts(ArrayList<Project> list) {
		
			Project p = new Project();
			
			String okayThisIsLong = new String();
			
			for(Project ps : list) {
				okayThisIsLong =	displayProduct(ps);
				
				//return displayProduct(p);
			}
			
			return okayThisIsLong;
		}
	}

