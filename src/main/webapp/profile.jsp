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

<link rel="stylesheet" href="css/bootstrap.min.css">  

<script src="jquery/jquery.min.js"></script> 
<script src="jquery/moment.js"></script>

<script src="jquery/bootstrap-datetimepicker.min.js"></script>

<title>Profile</title>
</head>
<body onload="setParameter();" >


<input id="turnOverTypeId"  style="display:none" value="${turnOverTypeJava }" />
 <input id="attritionTypeId"  style="display:none" value="${attritionTypeJava }" />
 <input id="locationId"  style="display:none" value="${locationJava }" />
 <input id="levelId"  style="display:none" value="${levelJava }" />
 <input id="rollOffDateId"  style="display:none" value="${rollOffDateJava }" />

<div id="tableContainer-1">
<div id="tableContainer-2">

<form action="updatedProfile.do" method="post" id="theForm" >


<input style="display:none"  name="enterpriseIdName"  value="<bean:write name="EmpForm" property="emailId" />">

<table id="myTable" width="40%" align="center" border="0" bordercolor="#339999" bgcolor="#eeeeee" style=" background-color:rgba(255, 255, 255, 0.99);"  >

<tr>
		<td align="Center">
		<div id="header">&nbsp;
		<div align="center">Details</div>
		</div>
		<!-- header end -->
		<br/>
		
		
		
		<table>
			
			<tr>
				<td height="50"><font color="brown">User Name</font></td><td align="center" height="50"><font  color="brown">:</font></td>
				<td style="padding-left:20px" height="50"><bean:write name="EmpForm" property="username" /> </td>
			</tr>
			
			<tr>
				<td height="50"><font color="brown">Enterprise Id</font></td><td align="center" height="50"><font color="brown">:</font></td>
				<td style="padding-left:20px"style="padding-left:20px" height="50"><bean:write name="EmpForm" property="emailId" />
				</td>
			</tr>
			<tr>
				<td height="50"><font color="brown">Date Of Joining<font size="1.4"></font></font></td><td align="center" height="50"><font color="brown">:</font></td>
				<td style="padding-left:20px" height="50"><bean:write name="EmpForm" property="doj"/>
				</td>
			</tr>
			
			<tr>
				<td height="50"><font color="brown">Roll Off Date <font size="1.4"></font></font></td><td align="center" height="50"><font color="brown">:</font></td>
				<%-- <td style="padding-left:20px" height="50"><bean:write name="EmpForm" property="rollOffDate"/>
				</td> --%>
				<td style="padding-left: 20px;" height="50"> 
				
				<div class="form-group">
                <div class='input-group date' id='datetimepicker5'>
                    <input name="rollOffDateName" style="background-color:rgba(255, 255, 255, 0) ; border: 0px; " id="rollOffDateInput" type='text' class="form-control" disabled />
                    <span class="input-group-addon">
                        <span  class="glyphicon glyphicon-calendar" ></span>
                    </span>
                </div>
            </div>
                   
                    </td>
			</tr>
			
			<tr>
				<td height="50"><font color="brown">Location</font> </td><td align="center" height="50"><font color="brown">:</font>
				<%-- <td height="50"><bean:write name="EmpForm" property="location"/>
				</td> --%>
				
				<td style="padding-left:20px"><select name="locationListName" id="locationList" style="background-color:rgba(255, 255, 255, 0); border: 0px;"disabled>
  <!-- <option >India - Bangalore - BDC7B - SEZ </option>
  <option> -  - Client Onsite - Within India</option>
  <option>India - Bangalore</option>
  <option>USA - Stamford - Client Onsite - Out of India</option>
  <option> -  - Client Onsite - Out of India </option> -->
  
  				<jstlcore:forEach items="${locationListJava}" var="event"  >
	  				<option> <jstlcore:out value="${event}"></jstlcore:out> </option>
	  			</jstlcore:forEach>
</select>
   </td>
				
			</tr>
			<tr>
				<td height="50"><font color="brown">Level</font></td><td align="center" height="50"><font color="brown">:</font></td>
				<%-- <td height="50"><input list="levelList" value="<bean:write name="EmpForm" property="level" />" style="background-color:rgba(255, 255, 255, 0); border: 0px; " readonly>
				
				 <datalist id="levelList">
    				<option value="Internet Explorer">
  					<option value="Firefox">
 					 <option value="Chrome">
 					 <option value="Opera">
 					 <option value="Safari">
 				 </datalist>
				
				</td> --%>
				
				<td style="padding-left:20px"><select name="levelListName" id="levelList" style="background-color:rgba(255, 255, 255, 0); border: 0px;"disabled>
 <!--  <option value="volvo">Ase</option>
  <option value="saab">Se</option>
  <option value="opel">Sse</option>
  <option value="audi">Tl</option> -->
  
  				<jstlcore:forEach items="${levelListJava}" var="event"  >
	  				<option> <jstlcore:out value="${event}"></jstlcore:out> </option>
	  			</jstlcore:forEach>
  
</select>
   </td>
				
			</tr>
			<tr>
				<td height="50"><font color="brown">Attrition Type</font></td><td align="center" height="50"><font color="brown">:</font></td>
				<%-- <td height="50"><bean:write name="EmpForm" property="attritionType"/>
				</td> --%>
				
				<td style="padding-left:20px"><select name="attritionListName" id="AttritionList" style="background-color:rgba(255, 255, 255, 0); border: 0px;"disabled>
  				<!-- <option >Nil</option>
  				<option >R-Location Change</option>
 				 <option >R-Higher Studies</option>
 				 <option >R-Health Issue</option> -->
 				  
 				  <jstlcore:forEach items="${attritionListJava}" var="event"  >
	  				<option> <jstlcore:out value="${event}"></jstlcore:out> </option>
	  			</jstlcore:forEach>
</select>
   </td>
				
			</tr>
			<tr>
				<td height="50"><font color="brown">TurnOver Type</font></td>
				<td align="center" height="50"><font color="brown">:</font></td>
				<%-- <td height="50"><bean:write name="EmpForm" property="turnOverType"/>
				</td> --%>
				
				
				<td style="padding-left:20px"><select name="turnOverListName" id="turnOverList" style="background-color:rgba(255, 255, 255, 0); border: 0px;"disabled>
  				<!-- <option >Resignation</option>
  				<option >Project End</option>
 				 <option >RRC</option>
 				 <option >Client initiated-Performance</option> -->
 				 
 				  <jstlcore:forEach items="${turnOverListJava}" var="event"  >
					 <option> <jstlcore:out value="${event}"></jstlcore:out></option>
	 				</jstlcore:forEach>
	 				
					</select>
   </td>
				
			</tr>
			
			<tr>
				<td></td>
			</tr>
			<tr>
				<!-- <td></td><td></td><td align="right"><input id="editSaveButton" type="image" height="50" width="50" onclick="myFunction()" src="css/edit.png"><td></td><td> <input type="image" src="css/close.png" width="50" height="50" onclick="history.back()" > </td> -->
				<td></td><td></td><td align="right"><button style="background:transparent; border: 0"; type="button"  onclick="myFunction()"><image id="editSaveButton" src="css/edit.png"> </image> </button> <td></td><td> <button style="background:transparent; border: 0""; type="button"   onclick="history.back()" ><image src="css/close.png" > </image></button> </td>
			</tr>
			
			<tr>
				<td> </td>
			</tr>
			
		</table>
		<br />
		</td>
	</tr>
</table>
</form>
 <script>
function myFunction() {
	if( document.getElementById("levelList").disabled == true)
		{
		var r = confirm("Want to go in Edit mode ? Are you Sure ?");
		if (r == true) 
		{
    document.getElementById("levelList").disabled = false;
    document.getElementById("locationList").disabled = false;
    document.getElementById("AttritionList").disabled = false;
    document.getElementById("turnOverList").disabled = false;
    document.getElementById("rollOffDateInput").disabled = false;
    document.getElementById("editSaveButton").src="css/save.png";
    
		}
		}
	else if( document.getElementById("levelList").disabled == false)
		{
		
		var r = confirm("Do you want to Save ? Are you Sure ?");	
		if (r == true) 
		{
	   /*   document.getElementById("levelList").disabled = true;
	    document.getElementById("locationList").disabled = true;
	    document.getElementById("AttritionList").disabled = true;
	    document.getElementById("turnOverList").disabled = true;
	    document.getElementById("rollOffDateInput").disabled = true;
	    document.getElementById("editSaveButton").src="css/edit.png";  */
	  //  document.getElementById("editSaveButton").type=submit;
	    document.getElementById('theForm').submit();
		}
		}
}


$(function () {
    $('#datetimepicker5').datetimepicker({
        defaultDate:  document.getElementById("rollOffDateId").value,
        format: 'DD/MMM/YYYY'
    });
});

function setParameter() {
	/* var temp = "a";
	var mySelect = document.getElementById('mySelect');

	for(var i, j = 0; i = mySelect.options[j]; j++) {
	    if(i.value == temp) {
	        mySelect.selectedIndex = j;
	        break;
	    }

} */

	// document.getElementById("turnOverTypeId").selectedIndex = 3;
	console.log(document.getElementById("locationId").value);
	 document.getElementById("turnOverList").value = document.getElementById("turnOverTypeId").value;
	 document.getElementById("AttritionList").value = document.getElementById("attritionTypeId").value;
	 document.getElementById("locationList").value = document.getElementById("locationId").value;
	 document.getElementById("levelList").value = document.getElementById("levelId").value;

}


</script>


</div>
</div>
</body>
</html>