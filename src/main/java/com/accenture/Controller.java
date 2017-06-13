package com.accenture;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class Controller extends Action
{
Model model = new Model();
	
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
	 HttpSession session = request.getSession();
	 
	
	if(mapping.getPath().contains("Dashboard"))
	{
		System.out.println("in dashboard");
	DashboardDataForm dashForm = (DashboardDataForm) form;
	
	DashboardDataForm dash = model.RetriveDashBoardData();
	
	dashForm.setEmpCount(dash.getEmpCount());
	dashForm.setAseCount(dash.getAseCount());
	dashForm.setAseCountPercentage(dash.getAseCountPercentage());
	dashForm.setAsePlusScCount(dash.getAsePlusScCount());
	dashForm.setAsePlusScPer(dash.getAsePlusScPer());
	dashForm.setGcpCount(dash.getGcpCount());
	dashForm.setFemaleCount(dash.getFemaleCount());
	dashForm.setMaleCount(dash.getMaleCount());
	dashForm.setGcpCountPercentage(dash.getGcpCountPercentage());
	dashForm.setLoanedResourceCount(dash.getLoanedResourceCount());
	dashForm.setAmCount(dash.getAmCount());
	dashForm.setmCount(dash.getmCount());
	dashForm.setSeCount(dash.getSeCount());
	dashForm.setSmCount(dash.getSmCount());
	dashForm.setsExecCount(dash.getsExecCount());
	dashForm.setSseCount(dash.getSseCount());
	dashForm.setTlCount(dash.getTlCount());
	dashForm.setEmpCountChange(dash.getEmpCountChange());
	dashForm.setAseCountChange(dash.getAseCountChange());
	dashForm.setAsePlusSeCountChange(dash.getAsePlusSeCountChange());
	dashForm.setGcpCountChange(dash.getGcpCountChange());
	dashForm.setDiversityRatioChange(dash.getDiversityRatioChange());
	dashForm.setLoanResourceChange(dash.getLoanResourceChange());
	
	 request.setAttribute("AttritionCountList", dash.getAttritionCountList());
	 request.setAttribute("AttritionPercentageList",  dash.getAttritionPercentageList());
	 request.setAttribute("TurnOverCountList", dash.getTurnOverCountList());
	 request.setAttribute("TurnOverPercentageList",  dash.getTurnOverPercentagetList());

	 ArrayList<String> PieChartList = new ArrayList<String>();
	 PieChartList.add(dash.getOtherJobRollOffNumber());
	 PieChartList.add(dash.getHigherStudiesRollOffNumber());
	 PieChartList.add(dash.getLocChangeRollOffNumber());
	 PieChartList.add(dash.getPersonnalIssueRollOffNumber());
	 PieChartList.add(dash.getHealthRollOffCount());
	 request.setAttribute("PieChartList", PieChartList);
	 
	 request.setAttribute("GreenList", dash.getGreenList());
	 request.setAttribute("RedList", dash.getRedList());
	 request.setAttribute("NeutralList", dash.getNeutralList());
	 
	 request.setAttribute("OJP",dash.getOtherJobRollOffPercentage());
	 request.setAttribute("LCP",dash.getLocChangeRollOffPercentage());
	 request.setAttribute("HSP",dash.getHigherStudiesRollOffPercentage());
	 request.setAttribute("HIP",dash.getHealthRollOffPercentage());
	 request.setAttribute("PIP",dash.getPersonnalIssueRollOffPercentage());
	
	 request.setAttribute("list",dash.getEmpAddSubList());
	
	 dashForm.setAseCountUp(dash.getAseCountUp());
	 dashForm.setAseCountDown(dash.getAseCountDown());
	 dashForm.setOther1Up(dash.getOther1Up());
	 dashForm.setOther1Down(dash.getOther1Down());
	 dashForm.setAsePlusSeCountUp(dash.getAsePlusSeCountUp());
	 dashForm.setAsePlusSeCountDown(dash.getAsePlusSeCountDown());
	 dashForm.setOther2Up(dash.getOther2Up());
	 dashForm.setOther2Down(dash.getOther2Down());
	 dashForm.setFemaleCountUp(dash.getFemaleCountUp());
	 dashForm.setFemaleCountDown(dash.getFemaleCountDown());
	 dashForm.setMaleCountUp(dash.getMaleCountUp());
	 dashForm.setMaleCountDown(dash.getMaleCountDown());
	 
	 request.setAttribute("addList",dash.getLRAddList());
	 request.setAttribute("subList",dash.getLRSubList());

	System.out.println("in dashboardEnd");
	 
	 return mapping.findForward("success");
	}
	
	
	
	else if(mapping.getPath().contains("addUser"))
	{
		
		return mapping.findForward("success");
	}
	
	
	
	else if(mapping.getPath().contains("info"))
	{
		
		if(request.getParameter("editProfile")!=null)
		{
			System.out.println("coming  in edit profile");
			 String password = request.getParameter("activeUser");
			
			 System.out.println(password);
				EmployeeForm empForm = (EmployeeForm) form;
				EmployeeForm emp=model.SearchUserProfile(request.getParameter("editButton"));
				
				 empForm.setUsername(emp.getUsername());
				 empForm.setDoj(emp.getDoj());
				 empForm.setEmailId(emp.getEmailId());
				 empForm.setEnterpriseId(emp.getEnterpriseId());
	
				 
				 request.setAttribute("rollOffDateJava", emp.getRollOffDate());
				 request.setAttribute("turnOverTypeJava", emp.getTurnOverType());
				 request.setAttribute("attritionTypeJava", emp.getAttritionType());
				 request.setAttribute("locationJava", emp.getLocation());
				 request.setAttribute("levelJava", emp.getLevel());
				 
				 request.setAttribute("turnOverListJava", emp.getTurnOverTypeList());
				 request.setAttribute("attritionListJava", emp.getAttritionTypeList());
				 request.setAttribute("locationListJava", emp.getLocationList());
				 request.setAttribute("levelListJava", emp.getLevelList());
				 
				
				 
				 if(empForm.getUsername()==null)
				 {
					empForm.setErrorMessgae("Invalid id/password!!!");
					
					return mapping.findForward("failed");
				 }
				 else
				 {
					 return mapping.findForward("successEditProfile");
				 }
		
		}
		
		else if(request.getParameter("returnInfo")!=null)
		{
			return mapping.findForward("failed");
		}
		
		else
		{
			
			// normal login 
			 
		System.out.println(session.getAttribute("sessionUsername") +"uniquesssssss");
			
		EmployeeForm empForm = (EmployeeForm) form;
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 
		 System.out.println(email); System.out.println(password);
		 
		 EmployeeForm emp = new EmployeeForm();
		 
		 if(email!=null & password!=null)
		  emp =model.SearchUser(email, password);
		 
		 else
		 emp =model.SearchUser(session.getAttribute("sessionUsername").toString(), session.getAttribute("sessionPassword").toString());
		 
		 empForm.setUsername(emp.getUsername());
		// empForm.setUsername(emp.getSupervisor());
		 empForm.setEmailId(emp.getEmailId());
	
	 
		 
		 if(empForm.getUsername()==null)
		 {
			 System.out.println("username empty");
			empForm.setErrorMessgae("Invalid id/password!!!");			
			return mapping.findForward("failed");
		 }
		 else
		 {
			 session.setAttribute("sessionUsername", email);
			 session.setAttribute("sessionPassword", password);
			 return mapping.findForward("success");
		 }
		}
	}
	
	else if(mapping.getPath().contains("profile"))
	{
		
		 if(request.getParameter("searchProfile")!=null)
		{
			EmployeeForm empForm = (EmployeeForm) form;
			 EmployeeForm emp=model.SearchUserProfile(request.getParameter("searchProfile"));
			
			 empForm.setUsername(emp.getUsername());
			 empForm.setDoj(emp.getDoj());
			 empForm.setEmailId(emp.getEmailId());
			 empForm.setEnterpriseId(emp.getEnterpriseId());
			 
			 request.setAttribute("rollOffDateJava", emp.getRollOffDate());
			 request.setAttribute("turnOverTypeJava", emp.getTurnOverType());
			 request.setAttribute("attritionTypeJava", emp.getAttritionType());
			 request.setAttribute("locationJava", emp.getLocation());
			 request.setAttribute("levelJava", emp.getLevel());
			 
			 request.setAttribute("turnOverListJava", emp.getTurnOverTypeList());
			 request.setAttribute("attritionListJava", emp.getAttritionTypeList());
			 request.setAttribute("locationListJava", emp.getLocationList());
			 request.setAttribute("levelListJava", emp.getLevelList());
			 
			
		 
			// System.out.println(emp.getTurnOverTypeList());
			 
			 if(empForm.getUsername()==null)
			 {
				empForm.setErrorMessgae("Invalid id/password!!!");
			return mapping.findForward("failed");
			 }
			 else
			 {				 
				 return mapping.findForward("successProfile");
			 }
		}
		
		
		else if(request.getParameter("profile")!=null)
		{
		//	System.out.println(session.getAttribute("session")+"sahi hai bhai");
			
		EmployeeForm empForm = (EmployeeForm) form;
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 
		 System.out.println(email);
		 System.out.println(password);
		
		 EmployeeForm emp =model.SearchUser(email, password);
		 
		 empForm.setUsername(emp.getUsername());
		 empForm.setDoj(emp.getDoj());
		 empForm.setEmailId(emp.getEmailId());
		 empForm.setEnterpriseId(emp.getEnterpriseId());
	//	 empForm.setLevel(emp.getLevel());
	//	 empForm.setLocation(emp.getLocation());
	//	 empForm.setAttritionType(emp.getAttritionType());
	//	 empForm.setTurnOverType(emp.getTurnOverType());
	//	 empForm.setRollOffDate(emp.getRollOffDate());
		 
	//	 System.out.println(emp.getRollOffDate());
		 
		 request.setAttribute("rollOffDateJava", emp.getRollOffDate());
		 request.setAttribute("turnOverTypeJava", emp.getTurnOverType());
		 request.setAttribute("attritionTypeJava", emp.getAttritionType());
		 request.setAttribute("locationJava", emp.getLocation());
		 request.setAttribute("levelJava", emp.getLevel());
		 
		 request.setAttribute("turnOverListJava", emp.getTurnOverTypeList());
		 request.setAttribute("attritionListJava", emp.getAttritionTypeList());
		 request.setAttribute("locationListJava", emp.getLocationList());
		 request.setAttribute("levelListJava", emp.getLevelList());
		 
		 if(empForm.getUsername()==null)
		 {
			empForm.setErrorMessgae("Invalid id/password!!!");
		return mapping.findForward("failed");
		 }
		 else
		 {
			 return mapping.findForward("successProfile");
		 }
		}
		
		 else if(request.getParameter("empUnder")!=null)
		 {
		//	ArrayList<EmployeeForm> empUnderList = new ArrayList<EmployeeForm>();
				
			 EmployeeForm empForm = (EmployeeForm) form;
			
			 System.out.println(request.getParameter("email"));
			 System.out.println(request.getParameter("username"));
			
			 EmployeeForm emp= model.EmpUnderList(request.getParameter("username"));
			 
			 empForm.setEmpUnderList(emp.getEmpUnderList());
			 
			 request.setAttribute("empUnderList", emp.getEmpUnderList());
			 
			 request.setAttribute("activeUser", request.getParameter("username"));
			 request.setAttribute("activeEmail", request.getParameter("email"));
			 
			 return mapping.findForward("successEmpUnderList");
			 
		 }
		 else if(request.getParameter("save")!=null)
		 {
			 System.out.println("coming in save in profile");
			 
			 
			 return mapping.findForward("failed");
		 }
		
		
		 else  //  taking this as save action
		 {
			 System.out.println("enter noWhere");
			 return mapping.findForward("failed");
		 }
	}
	
	
	
	else if(mapping.getPath().contains("updatedProfile"))
	{
		
	
		System.out.println("in UpdatedProfile to Info");
		
		int flag = model.UpdateProfile(request.getParameter("enterpriseIdName"),request.getParameter("rollOffDateName"),request.getParameter("locationListName"),request.getParameter("levelListName"),request.getParameter("attritionListName"),request.getParameter("turnOverListName"));
		 if(flag==1)
		 {
				EmployeeForm empForm = (EmployeeForm) form;
				
				 EmployeeForm emp = new EmployeeForm();
				 
				
				 emp =model.SearchUser(session.getAttribute("sessionUsername").toString(), session.getAttribute("sessionPassword").toString());
				 
				 empForm.setUsername(emp.getUsername());
			
				 empForm.setEmailId(emp.getEmailId());
			
			 
				
				 
				 if(empForm.getUsername()==null)
				 {
					empForm.setErrorMessgae("Invalid id/password!!!");
					
				return mapping.findForward("failed");
				 }
				 else
				 {
					
					 return mapping.findForward("success");
				 }
				}
			 
			 
			 
			 
			 
			 
			//	 return mapping.findForward("success");		 
		 
			// return mapping.findForward("success");
		 
		 else
		return mapping.findForward("failed");
	}
	

	else if(mapping.getPath().contains("save"))
	{
		 String email = request.getParameter("emailid");
		 String password = request.getParameter("password");
		 String username = request.getParameter("username");
		 String enterpriseid = request.getParameter("enterpriseid");
		 String location = request.getParameter("location");
		 String doj = request.getParameter("doj");
		 String supervisor = request.getParameter("supervisor");
		 String level = request.getParameter("level");
		
		 
		int flag = model.saveEmp(email,password,username,enterpriseid,location,doj,supervisor,level);
		 if(flag==1)
			 return mapping.findForward("success");
		 else
		return mapping.findForward("failed");
	}
	
	
	else
		 return mapping.findForward("failed");
	}
}
