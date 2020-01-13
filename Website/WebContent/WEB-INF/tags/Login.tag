<%@ tag language="java" pageEncoding="UTF-8"%>

<%@taglib prefix="er" tagdir="/WEB-INF/tags"%>

 

 <div class = "backDrop"></div>
      
      
       <form method=post>
 
 

        <er:error/>
<div class="arrange">
   		<p>Sign in</p>
   		<p Style="font-size:13px">To continue</p>
   							
   <div class="enter">
   <input type=text name=lname placeholder= Name>
   </div>
		
	<div class="enterWithIcon">
	
	<input type=password name=lpass placeholder= Password>
	
    <button type="submit" onclick="submit" style="border: 0; background: none;">
          
            <i class="fa fa-sign-in fa-3x" ></i>
            
          </button>

	</div>
  
	    <a href = addAccount>Create Account</a>
	 </div>
	</form>
	


    



