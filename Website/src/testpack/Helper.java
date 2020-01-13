package testpack;

public class Helper {

public static boolean isPassValid(String pass) {
		
		boolean val = true;
		
        
		if(pass.trim().equalsIgnoreCase("")) val = false;
		
		return val;
		
	}
	
	
	public static boolean isUserValid(String uname) {
		
		
         boolean val = true;
		
        
		if(uname.trim().equalsIgnoreCase("")) val = false;
		
		return val;
		
		
	}
	
	
	
	public static boolean isFullName(String fname) {
		
		
		      boolean val = true;
			
	        
			if(fname.trim().equalsIgnoreCase("")) val = false;
			
			return val;
		
		
		
		
		
	}
}
