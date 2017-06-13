<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<%
   session.setAttribute( "theName", "adminNamehai" );
%>

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

<link rel="StyleSheet" href="css/struts.css" type="text/css" />

<script type="text/javascript">
function validateForm()
{
var uname=document.forms["logForm"]["USERNAME"].value;
var password=document.forms["logForm"]["PASSWORD"].value;
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
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn Page</title>
</head>
<body >



<div id="tableContainer-1">
  <div id="tableContainer-2">

<form  method="post" name="logForm" action="info.do" onsubmit="return validateForm()">


<table id="myTable" width="25%" align="center" border="0" bordercolor="#339999" style="background-color:rgba(255, 255, 255, 0.6); "   ><!-- bgcolor="#eeeeee" -->
	<tr>
		<td align="Center">
		<div id="header">&nbsp;
		<div align="center">Starwood Hotels and Resorts</div>
		</div>
		<!-- header end -->
		<br/>
		<table>
			<tr>
				<!--content begin -->
				<td colspan="2" align="center">
				<div id="content">
				<h3>Portal Login Page</h3>
				</div>
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" id ="transparentInput" placeholder="id/username"  ></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="transparentInput" placeholder="password">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input  src="css/next.png" height="35" width="35" type="image" value=" Login "></input> <br />
				</td>
			</tr>
			<%-- <tr>
				<td colspan="2" align="center"><span class="error"><bean:write name="EmpForm" property="errorMessage"/></span></td>
			</tr>  --%>
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

</div>
</div>


</body>
</html>