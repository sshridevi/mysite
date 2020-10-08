<html>
<body>

<script language="javascript" type="text/javascript">
<!-- 
//Browser Support Code
function ajaxFunction(){
	var ajaxRequest;  // The variable that makes Ajax possible!
	
	try{
		// Opera 8.0+, Firefox, Safari
		ajaxRequest = new XMLHttpRequest();
	} catch (e){
		// Internet Explorer Browsers
		try{
			ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try{
				ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e){
				// Something went wrong
				alert("Your browser broke!");
				return false;
			}
		}
	}
	// Create a function that will receive data sent from the server
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			var ajaxDisplay = document.getElementById('ajaxDiv');
			ajaxDisplay.style.color = "green";
			ajaxDisplay.innerHTML = ajaxRequest.responseText;
		}
	}
		//var formObject = document.forms['myForm'];
		//field =  formObject.elements['emailaddress'];
		var field = document.getElementById("emailaddress");
		
		alert(escape(field.selectedIndex.value));
		
		
	var queryString = "?emailid=" + "n@n.com";
	var url = "/mysite/getemailaddresswithAjax" + queryString;
	ajaxRequest.open("GET",  url , true);
	ajaxRequest.send(null); 
}

//-->
function xyz(){
			var ajaxDisplay = document.getElementById('ajaxDiv');
			ajaxDisplay.innerHTML = "<font color=red> you are out the context </font>";

}
</script>



<form name="myForm">
 First name <input type="text" name="firstname" id="fname"/>
Email addresslist 
<select id="emailaddress" name="emailaddress" onChange="ajaxFunction()">
	<option>n@n.com</option>
	<option>ss@yahoo.com</option>
	<option>ad123@ad.com</option>
</select>
</form>

<div id='ajaxDiv'>Intial text</div>
</body>
</html>
