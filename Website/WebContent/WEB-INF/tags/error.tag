<%@ tag language="java" pageEncoding="UTF-8"%>


<link rel="stylesheet" type="text/css" href="LoginError.css">

<%

	if( request.getAttribute("error") != null )
{
	%>

<script>
// When the user clicks on div, open the popup
function myFunction()
{
  var popup = document.getElementById("myPopup");
  popup.classList.toggle("show");
}

window.onload = myFunction;

</script>

<div class="popup" onclick="myFunction()">
  <span class="popuptext" id="myPopup" style=" font-size:11.9px">${error}</span>
</div>

<% 

}

%>