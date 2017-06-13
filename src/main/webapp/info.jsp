<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstlcore" %>



<html>
<head>


<style>
  html, body {
    height: 95%;
  }
  #tableContainer-1 {
    height: 100%;
    width: 100%;
    display: table;
  }
  #tableContainer-2 {
    vertical-align: middle;
    display: table-cell;
    height: 100%;
  }
  #myTable {
    margin: 0 auto;
  }
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="StyleSheet" href="css/struts.css" type="text/css" />

<title>Info</title>
</head>
<body><!--  onload="addButton()" -->

<input id="name"  style="display:none" value=<bean:write name="EmpForm" property="username"/>>



<script type="text/javascript">

function handle(e){
    
	var val = document.getElementById("transparentInput");
	
	  xmlhttp=new XMLHttpRequest();
	  xmlhttp.open("GET","/Project/SomeServlet?state="+val.value);
	  xmlhttp.send();
    
	 xmlhttp.onreadystatechange=function()
{
    if(xmlhttp.readyState == 4)
    {
        //document.getElementById("cap").value=
        var text =	xmlhttp.responseText;
        console.log(text);
        var splittedText = text.split(",");
        
       /*  var mycars = new Array();
        mycars[0]='Herr1';
        mycars[1]='Frau1';
 */
        var options = '';

        for(var i = 0; i < splittedText.length; i++)
          options += '<option value="'+splittedText[i]+'" />';

        document.getElementById('list').innerHTML = options;
        
        
      //  document.getElementById("demo").innerHTML = res[2];
    }
}

}


</script>




<div align="right" style="margin-right: 100px;">

<form action="profile.do" method="post">

<input name="sessionName" id="sessionId"  style="display:none"/>

  <input list="list" name="searchProfile" id ="transparentInput" onkeypress="handle(event)" placeholder="search"  >
  <datalist id="list">
    
  </datalist>
 <!--  <button style=" border: 0; " id="somebutton">search</button> -->
 <input type="submit" value="search" >
</form> 
</div>



<div id="tableContainer-1">
  <div id="tableContainer-2">


 

<table id="myTable"   >
			
			<tr>
			
				<td align="center" height="50"><input onClick="location.href='Dashboard.do'" src="css/dashboard.png" height="150" width="150" type='image' title="Dashboard" value="Dashboard"  ></input> </td>
			
				<td align="center" height="50"><input onclick=window.open("addUser.do","demo"); id="addUserIcon" src="css/adduser.png" height="150" width="150" type='image' value="Add" title="Add User" ></input></td>
			
			</tr>
			
			
		</table>
		<center>
	<form action="profile.do" method="post" >
	
		

			<input name="password"  style="display:none" value=<bean:write name="EmpForm" property="password"/>>
			<input name="email"  style="display:none" value=<bean:write name="EmpForm" property="emailId"/>>
		<input name="username"  style="display:none" value=<bean:write name="EmpForm" property="username"/>>
			<input src="css/profile.png" height="150" width="150" type='image' title="Profile" name="profile" value="profile" ></input>			
			<input src="css/info.png" height="150" width="150" type='image' title="Employee List" name="empUnder" value="empUnder"></input>
				
				 
			 
			
			
</form>


</center>
</div>
</div>

 
 
 
 
<script>
function addButton() {
    var text = "";
    text = document.getElementById("name").value ;
    if(text!="admin")
    	document.getElementById("addUserIcon").style.visibility = "hidden";
}



</script>

<script>
//call after page loaded
window.onload=addButton ;   // cio

</script>
</body>
</html>