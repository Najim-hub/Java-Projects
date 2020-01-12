package application;
	
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;


import Sql.DB_Access;
import Sql.DB_App;
import Sql.DB_Vars;
import Sql.Project;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



	public class Main extends Application implements DB_Vars {
		
		private Connection con;
		private Statement st;
		
		   TableColumn ids = new TableColumn("ID");
		   
		   TableColumn name = new TableColumn("Name");
		   TableColumn desc = new TableColumn("Description");
		   TableColumn quan = new TableColumn("Quantity");
		   TableColumn price = new TableColumn("Price");
		   TableColumn color = new TableColumn("Color");
		   
	 	//private ObservableList<Project> test = FXCollections.observableArrayList();

		
		
		DB_Access db = new DB_Access();
		
		
		
		
        @SuppressWarnings("unchecked")
		public  TableView<Project> SetTables() {
        	
         TableView <Project> table = new TableView<>();
        	
       
        ids.setCellValueFactory(new PropertyValueFactory <>("id"));
        
         
        name.setCellValueFactory(new PropertyValueFactory <>("Name"));
        
        
       
        desc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        
        
       
        quan.setCellValueFactory(new PropertyValueFactory <>("Quantity"));
        
        
        
        price.setCellValueFactory(new PropertyValueFactory <>("Price"));
        
        
        color.setCellValueFactory(new PropertyValueFactory <>("Color"));
        
        table.setItems(advocado());
        
        
        table.getColumns().addAll(ids,name,desc,quan,price,color);
        
       
        
      
        
        
		return table;
        
        
        }
        
        Label bt = new Label();
        
        
       
        private ObservableList<Project> advocado() {
           
        	ObservableList<Project> arrs = FXCollections.observableArrayList();
           
            
            String sql = "select "
            		+ "* from AppleProducts";
			try {
				
				ResultSet rs = st.executeQuery(sql);
				
				
				while(rs.next()) {
					
					Project p = new Project(rs.getInt(1),
											rs.getString(2),
											rs.getString(3),
											rs.getInt(4),
			                                rs.getDouble(5),
											rs.getString(6));
					
					
				arrs.add(p);
				}
				
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

            return arrs;
            
        }
        
        	
        	
	         //private Button add = new Button("Add to Table") ;
	         
	         
	          HBox button = new HBox();
	          
	        
	  		
		
		    public void start(Stage stage) throws IOException {
		    	
		    	
		    	SetTables().setEditable(true);
		        
		    	final TextField addId = new TextField();
		        addId.setPromptText("ID");
		        addId.setMaxWidth(ids.getPrefWidth());
		        
		        
		        final TextField addName= new TextField();
		        addName.setMaxWidth(name.getPrefWidth());
		        addName.setPromptText("Name");
		        
		        
		        final TextField addDesc = new TextField();
		        addDesc.setMaxWidth(name.getPrefWidth());
		        addDesc.setPromptText("Description ");
		        
		        final TextField addQuan = new TextField();
		        addQuan.setMaxWidth(name.getPrefWidth());
		        addQuan.setPromptText("Quantity");
		        
		        final TextField addPrice = new TextField();
		        addPrice.setMaxWidth(name.getPrefWidth());
		        addPrice.setPromptText("Price");
		        
		        
		        final TextField addColor = new TextField();
		        addColor.setMaxWidth(name.getPrefWidth());
		        addColor.setPromptText("Color");
		        
		        final TextField deleteRow = new TextField();
		        deleteRow.setMaxWidth(name.getPrefWidth());
		        deleteRow.setPromptText("ID");
		        
		        
		        
		        
		        //final String results = new TextField[searches.size()];
		        
		        final TextArea all = new TextArea();
		        
		        deleteRow.setPromptText("ID");
		        	
		         
		        final Button adds = new Button("Add");
		        
		        final Button deletes = new Button("Delete");
		        
		        final Button mod = new Button("Modify");
		       
		        final Button back = new Button("Back");
		        
		        deletes.setOnAction((e)-> {
		        	
                //Project p = new Project();
		  			
		        	Alert alert = new Alert(AlertType.CONFIRMATION);
	                  
		            ButtonType delete= new ButtonType("Delete information");
		            ButtonType Cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		            alert.getButtonTypes().setAll(delete, Cancel);

		          Optional<ButtonType> result = alert.showAndWait();
		          
		          if (result.get() == delete){
		        	  
		        	  
		  		//deleteRow.getText();
		  		
		  		
		  			
		        int row = Integer.parseInt(deleteRow.getText());
		         
				db.deleteProduct(row);
				
			
				//advocado().remove(row);
				
				deleteRow.clear();
				
				Scene scene = new Scene(new Group());
		    	 stage.setTitle("Store");
		         stage.setWidth(700);
		         stage.setHeight(606);
		  
		         
		         
		         final Label label = new Label("Product Details");
		    
		         final VBox vbox = new VBox();
		         vbox.setSpacing(5);
		         
		         vbox.getChildren().addAll(label, SetTables(),button);
		  
		         ((Group) scene.getRoot()).getChildren().addAll(vbox);
		  
			   	stage.setScene(scene);
		          
		         stage.show();
				
		          }
		        });
		        
		        
		        Button search = new Button("search");
		        
		        
		        
		        search.setOnAction((e)->{
		        	
		        	ArrayList<Project> searches = new ArrayList<Project>();
		        	
		        	
		        	
		        	//String found = new String();
		        	
		        	
		        	searches  = db.searchProduct(deleteRow.getText());
		        	 
		        	

			        Project p = new Project();
			        
			        DB_App n = new DB_App();
			        
			        n.displayListOfProducts(searches);
			        
			        
			        ArrayList<String> findings = new ArrayList<String>();
		           
		        	
		        	
		        	all.appendText(n.displayListOfProducts(searches));
		        	  
		        	
		        	final VBox box = new VBox();
		        	final VBox second = new VBox();
			         box.setSpacing(2);
			         box.getChildren().addAll(all, back);
		        
		        	Scene scene = new Scene(box );
			    	 stage.setTitle("Results");
			         stage.setWidth(700);
			         stage.setHeight(606);
			  
			         
			         
			         final Label label = new Label("Product Details");
			    
				   	stage.setScene(scene);
			          
			         stage.show();
			         
			         if(n.displayListOfProducts(searches) == null ) {
			        	 
			        	 Alert a = new Alert(AlertType.INFORMATION);
	                        a.setContentText("Sorry, not found!");
	                        
	                        a.show();
			         }
		        
		        		
		        		 
		        	
		        }
		        
		        );
		        
		       back.setOnAction((e)->{
		    	   
		    	   Scene scene = new Scene(new Group());
			    	 stage.setTitle("Store");
			    	 stage.setWidth(900);
			         stage.setHeight(800);
			  
			         
			         
			         final Label label = new Label("Product Details");
			    
			         final VBox vbox = new VBox();
			         vbox.setSpacing(5);
			         
			         vbox.getChildren().addAll(label, SetTables(),button, mod);
			  
			         ((Group) scene.getRoot()).getChildren().addAll(vbox);
			  
			         
			         
					stage.setScene(scene);
			          
			         stage.show();
			
			        all.clear();
		    	   
		       });
		        mod.setOnAction((e)-> {
		        	
		        	  Project p = new Project();
		        	
		        	
		        	
		        	String sql = "update "
		        			+ "AppleProducts  "
		        			+ "set name=?, description=? ," 
		        			+ "quantity=?, price =? , color=?  where id=?";
		        			
		        			try {
		        				
		        				PreparedStatement pst = con.prepareStatement(sql , ResultSet.TYPE_SCROLL_SENSITIVE,
		        						ResultSet.CONCUR_UPDATABLE);
		        				
		        			/*	
		        				pst.setString(1, p.getName());
		        				pst.setString(2, p.getDescription());
		        				pst.setInt(3, p.getQuantity());
		        				pst.setDouble(4, p.getPrice());
		        				pst.setInt(5, Integer.parseInt(deleteRow.getText()));
		        			
		        				pst.setString(6, p.getColor());
		        				*/
		        				
		        				p = new Project(-1, addName.getText(), addDesc.getText(), Integer.parseInt(addQuan.getText()),
		        						Double.parseDouble(addPrice.getText()),addColor.getText());
		        						
		        						//Project myp = new Project();
		        				
		        						DB_App one = new DB_App();
		        				
		        						Project myp = p;
		        						
		        						db.modifyProduct(Integer.parseInt(deleteRow.getText()), myp);
		        				
		        				
		        						//addColor.getText());
		        						
		        						addName.clear();
		        						addDesc.clear();
		        						addQuan.clear();
		        						addPrice.clear();
		        						addColor.clear();
		        						
		        						Scene scene = new Scene(new Group());
		        				    	 stage.setTitle("Store");
		        				    	  stage.setWidth(700);
		        					         stage.setHeight(800);
		        				  
		        				         
		        				         
		        				         final Label label = new Label("Product Details");
		        				    
		        				         final VBox vbox = new VBox();
		        				         vbox.setSpacing(5);
		        				         
		        				         vbox.getChildren().addAll(label, SetTables(),button, mod);
		        				  
		        				         ((Group) scene.getRoot()).getChildren().addAll(vbox);
		        				  
		        				         
		        				         
		        						stage.setScene(scene);
		        				          
		        				         stage.show();
		        				
		        				        
		        			}
		        			catch(SQLException exp) {
		        				
		        				exp.printStackTrace();
		        				
		        			}
		        	
		        	
		        	
		        });
		        
		        
		        adds.setOnAction((e) -> 
		        
		        {  
                      if(addName.getText() == ("")) {
                    	  
                    	  
 			        	 Alert a = new Alert(AlertType.INFORMATION);
 	                        a.setContentText("Theres an empty field");
 	                        
 	                       a.showAndWait();
 	                        
 	                       
                    	  
                      }
		        		
		        	Project p = new Project();
		  			
		  			
		  			p = new Project(-1,  addName.getText(), addDesc.getText(), Integer.parseInt(
		  					addQuan.getText()),
		  					Double.parseDouble(addPrice.getText()),
		  					addColor.getText());
		        	
		         
				db.insertProduct(p);
				advocado().add(p);
				
				
				addName.clear();
				addDesc.clear();
				addQuan.clear();
				addPrice.clear();
				addColor.clear();
				
		        	
				
				Scene scene = new Scene(new Group());
		    	 stage.setTitle("Store");
		    	 stage.setWidth(900);
		         stage.setHeight(800);
		  
		         
		         
		         final Label label = new Label("Product Details");
		    
		         final VBox vbox = new VBox();
		         
		         vbox.setSpacing(5);
		         
		         vbox.getChildren().addAll(label, SetTables(),button, mod );
		  
		         ((Group) scene.getRoot()).getChildren().addAll(vbox);
		  
				 stage.setScene(scene);
		          
		         stage.show();
		        	
		        	
		        	
		        });
		        
		        button.getChildren().addAll(addName,addDesc,addQuan,addPrice,addColor,adds,deleteRow,deletes,mod,search);
		        button.setSpacing(2.3);
		    
		    	
		    	 
		    	 Scene scene = new Scene(new Group());
		    	 stage.setTitle("Store");
		    	  stage.setWidth(900);
			         stage.setHeight(800);
		  
		         
		         
		         final Label label = new Label("Product Details");
		    
		         final VBox vbox = new VBox();
		         vbox.setSpacing(5);
		         vbox.setPadding(new Insets(10, 0, 0, 10));
		         vbox.getChildren().addAll(label, SetTables(),button);
		  
		         ((Group) scene.getRoot()).getChildren().addAll(vbox);
		  
		         stage.setScene(scene);
		          
		         stage.show();
		    	
		    	
		         
		       
		    }
		    
		   
		    
		    public Main() {
				try {
					Class.forName(driver);
					
					con = DriverManager.getConnection(url, uname, upass);
					
					st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
												ResultSet.CONCUR_UPDATABLE);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		    
	    public static void main(String[] args) {
	        launch(args);
	    }

	}	
