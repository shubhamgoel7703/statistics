<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ page import="java.io.*,java.util.*,java.sql.*" %>
   
   
   
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

<title>Emp Under You</title>

</head>
<body >


<div id="tableContainer-1">
  <div id="tableContainer-2">

<form action="info.do" method="post">

	<input name="editProfile" style="display:none" />
	<input name="activeUser" style="display:none" value="${activeUser}" />
	<input name="activeEmail" style="display:none" value="${activeEmail }" />


<table id="myTable" width="40%" align="center" border="0" bordercolor="#339999" bgcolor="#eeeeee" style=" background-color:rgba(255, 255, 255, 0.99);"  >

<tr>
		<td align="Center">
		<div id="header">&nbsp;
		<div align="center">Employees Under you with close roll off date
		<p align="right" >
		<!-- <input id="button" onclick="setEditSave()" src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Feedbin-Icon-home-edit.svg/2000px-Feedbin-Icon-home-edit.svg.png" height="35" width="35" type="image" ></input> -->
		<!-- <button type="button"  style="background:transparent; border: 0; " onclick="setEditSave()" id="editButton"><img style="background:transparent;  border: 0; " src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Feedbin-Icon-home-edit.svg/2000px-Feedbin-Icon-home-edit.svg.png"  height="35" width="35" /></button>
		<input id="saveButton" disabled="disabled" style="opacity: 0.2;"  src="https://alexberkowitz.files.wordpress.com/2013/09/save.png" height="35" width="35" type="image" ></input>
 -->	</p>
		
		<input name="save" value="save" style="display:none" />
		
		</div>
		</div>
		
		<!-- header end -->
		<br/>
		
		
	
		<table id="tableData" cellpadding="20" cellspacing="20" >
	
	<%-- <bean:write name="EmpForm" property="empUnderList"/> --%>
		<tr>
    <th>User Name</th>
    <th>EnterpriseId</th>
   <!--  <th>EmailId</th> -->
   <!--  <th>Date Of Joining<font size="1.4">(YYYY-MM-DD)</font></th> -->
    <th>Roll Off Date <font size="1.4">(DD-MMM-YYYY)</font></th>
    <!-- <th>Location</th> -->
    <th>Level</th>
    <th>Attrition Type</th>
    <th>TurnOver type</th>
     <!-- <th>Supervisor</th> -->
     
    
		 </tr>
			
		<jstlcore:forEach items="${empUnderList}" var="event"  >
							<tr align="center">
							
							<td align="center"><jstlcore:out value="${event.username}"></jstlcore:out></td>
							<td align="center"><jstlcore:out value="${event.emailId}"></jstlcore:out></td>
							<%-- <td align="center"><jstlcore:out value="${event.emailId}"></jstlcore:out></td> --%>
							<%-- <td align="center"><jstlcore:out value="${event.doj}"></jstlcore:out></td> --%>
							<td align="center"><jstlcore:out value="${event.rollOffDate}"></jstlcore:out></td>
							<%-- <td align="center"><jstlcore:out value="${event.location}"></jstlcore:out></td> --%>
							<td align="center"><jstlcore:out value="${event.level}"></jstlcore:out></td>
							<td align="center"><jstlcore:out value="${event.attritionType}"></jstlcore:out></td>
							<td align="center"><jstlcore:out value="${event.turnOverType}"></jstlcore:out></td>
							<td align="center"><input type="image" height="35" width="35" src="css/edit.png" value="<jstlcore:out value="${event.username}"></jstlcore:out>" name="editButton"></td>
							</tr>
						</jstlcore:forEach>
		
		
		</table>
		 <input type="hidden" name="userId" value="">  
		</td>
		</tr>
		
</table>
</form>
</div>
</div>

<!-- <script type="text/javascript">

function setEditSave() {

	//console.log("working");
	
	/* if(document.getElementById("myTable").contentEditable!='true')
		{
document.getElementById("myTable").contentEditable=true;
		}
	
	else if(document.getElementById("myTable").contentEditable!='false')
	{
		document.getElementById("myTable").contentEditable=false;
	}
	
	if(document.getElementById("button").src=="https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Feedbin-Icon-home-edit.svg/2000px-Feedbin-Icon-home-edit.svg.png")
		document.getElementById("button").src="https://alexberkowitz.files.wordpress.com/2013/09/save.png";
	
	else if(document.getElementById("button").src=="https://alexberkowitz.files.wordpress.com/2013/09/save.png")
	{
	//	document.getElementById("button").src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Feedbin-Icon-home-edit.svg/2000px-Feedbin-Icon-home-edit.svg.png";
		window.open("profile.do","_self")
	} */
	

	
	
	if(document.getElementById("saveButton").style.opacity =='0.2')
		{
		var r = confirm("Want to go in Edit mode ? Are you Sure ?");
		
		if (r == true) 
		{
		document.getElementById("myTable").contentEditable=true;
		document.getElementById("editButton").style.opacity = '0.2';
		document.getElementById("saveButton").style.opacity = "1";
		document.getElementById("editButton").disabled =true;
		document.getElementById("saveButton").disabled =false;
		console.log("save active");
		
		
		}
		}
	
	/*  else if(document.getElementById("editButton").style.opacity =='0.2')
		{
		var r = confirm("Want to Save ? Are you Sure ?");
		
		if (r == true) 
		{
		document.getElementById("myTable").contentEditable=false;
		document.getElementById("saveButton").style.opacity = '0.2';
		document.getElementById("editButton").style.opacity = '1';
		document.getElementById("editButton").disabled =false;
		document.getElementById("saveButton").disabled =true;
		console.log("edit active");
		
		var x = document.getElementById("tableData");
		
		 cells = x.getElementsByTagName('td');
		 console.log(cells.length);
		 console.log("coming");
		for (var i=0,len=cells.length; i<len; i++){
		   // cells[i].onclick = function(){
		        console.log( cells[i]);
		        // if you know it's going to be numeric:
		       // console.log(parseInt(this.innerHTML),10);
		        
		    
		}
		   
		
		
		} 				
		} 
		*/
		
	
}

</script> -->
</body>
</html>