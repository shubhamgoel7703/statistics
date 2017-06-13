<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script type="text/javascript">
function isNumeric(value) {
	  if (value=="" || value == null || !value.toString().match(/^[-]?\d*\.?\d*$/))
	  { return false;
	  }
	  return true;
	}	
	
function isNumericlevel(value) {
	  if (value=="" || value == null || !value.toString().match(/^[-]?\d*\.?\d*$/))
	  { return false;
	  }
	  var num = parseInt(value);
	  if(num>0 && num <15)
	  return true;
	  
	  else
		  return false;
	}	
function echeck(str) {
	   var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;   
		   return emailPattern.test(str);   							
}

function validateForm()
{
var uname=document.forms["logForm"]["username"].value;
var password=document.forms["logForm"]["password"].value;
var location=document.forms["logForm"]["location"].value;
var emailid=document.forms["logForm"]["emailid"].value;
var enterpriseid=document.forms["logForm"]["enterpriseid"].value;
var level=document.forms["logForm"]["level"].value;

var doj=document.forms["logForm"]["doj"].value;


if (uname==null || uname=="")
{
alert("Please provide Username");
return false;
}
if (password==null || password=="")
{
alert("Please provide Password");
return false;
}
if (location==null || location=="")
{
alert("Please provide location");
return false;
}
if (emailid==null || emailid=="")
{
alert("Please provide emailid");
return false;
}
if (enterpriseid==null || enterpriseid=="")
{
alert("Please provide enterpriseid");
return false;
}
if (level==null || level=="")
{
alert("Please provide level");
return false;
}

if (doj==null || doj=="")
{
alert("Please provide doj");
return false;
}
if (echeck(emailid)==false){
	alert("Invalid EmailID");
	return false;
}
if(isNumeric(enterpriseid)==false)
{
	alert("Invalid enterprise id");
	return false;
}
if(isNumericlevel(level)==false)
{
	alert("Invalid level i.e(1-15)");
	return false;
}


}
</script>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" href="css/struts.css" type="text/css" />
<title>Add User</title>
</head>
<body>

<form method="post" name="logForm" action="save.do" onsubmit="return validateForm()">
<input name="id" value="save" style="display:none"/>
<table width="80%" align="center" border="0" bgcolor="#eeeeee" style="background-color:rgba(255, 255, 255, 0.8);" bordercolor="#339999" style="margin-left:10px;"  >
	<tr>
		<td align="Center">
		<div id="header">&nbsp;
		<div align="center">Fill Details</div>
		</div>
		<!-- header end -->
		<br/>
		<table>
			
			<tr>
				<td height="50">User Name</td>
				<td height="50"><input type="text" name="username" id="transparentInput"></td>
			</tr>
			<tr>
				<td height="50">EnterpriseId </td>
				<td height="50"><input type="text" name="enterpriseid" id="transparentInput">
				</td>
			</tr>
			<tr>
				<td height="50">EmailId</td>
				<td height="50"><input type="text" name="emailid" id="transparentInput">
				</td>
			</tr>
				<tr>
				<td height="50">Password</td>
				<td height="50"><input type="password" name="password" id="transparentInput">
				</td>
			</tr>
			<tr>
				<td height="50">DOJ</td>
				<td height="50"><input type="text" name="doj" id="transparentInput">
				</td>
			</tr>
			<tr>
				<td height="50">Location</td>
				<td height="50"><input type="text" name="location" id="transparentInput">
				</td>
			</tr>
			<tr>
				<td height="50">Level</td>
				<td height="50"><input type="text" name="level" id="transparentInput">
				</td>
			</tr>
			<tr>
				<td height="50">Supervisor</td>
				<td height="50"><input type="text" name="supervisor" id="transparentInput">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input height="50" width="50" src="css/save.png"  type="image" value=" Save "></input> <br />
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			
		</table>
		<br />
		</td>
	</tr>
</table>
</form>
</body>
</html>