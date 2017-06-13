package com.accenture;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;




public class Model
{
	private Connection connection = null;
	private PreparedStatement statement = null;
	

	public EmployeeForm EmpUnderList(String supervisor) throws SQLException, ClassNotFoundException
	{
		
		 java.util.Date d = (java.util.Date) Calendar.getInstance().getTime();
		 java.util.Date dateBefore = new java.util.Date(d.getTime() + 92 * 24 * 3600 * 1000l  );
		 java.sql.Date sqlDateFuture = new java.sql.Date(dateBefore.getTime());
		 
		System.out.println(sqlDateFuture);
		
		connection = DBHelper.createConnection();
		statement = connection.prepareStatement("SELECT * FROM starwooddatabase WHERE supervisor=? and End_Date<?");
		statement.setString(1, supervisor);
		statement.setDate(2, sqlDateFuture);
		
		ResultSet rs=statement.executeQuery();
		
		EmployeeForm emp; 
		EmployeeForm returnEmp = new EmployeeForm(); 
		ArrayList<EmployeeForm> empUnderList = new ArrayList<EmployeeForm>();
		
		while(rs.next())
		{
			emp = new EmployeeForm();
			
			emp.setUsername(rs.getString("Resource_first_name")+" "+rs.getString("resource_last_name"));
			/*emp.setSupervisor(rs.getString("supervisor"));*/
			//emp.setPassword(rs.getString("password"));
			/*emp.setLocation(rs.getString("Work_city"));*/
			emp.setLevel(rs.getString("Career_Level"));
			/*emp.setEnterpriseId(rs.getString("Personnel_No"));*/
			emp.setEmailId(rs.getString("Resource_Enterprise_ID"));
			/*emp.setDoj(rs.getString("Candidate_Filled_Date"));*/
			
			/*emp.setRollOffDate(rs.getString("End_Date"));*/
			emp.setAttritionType(rs.getString("Attrition_type"));
			emp.setTurnOverType(rs.getString("Disengagement_Type"));
			
			//System.out.println(rs.getString("Attrition_type"));
			//System.out.println(rs.getString("Disengagement_Type"));
			 java.util.Date date = rs.getDate("End_Date");
			// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// sdf.format(new Date(date));
			System.out.println(new SimpleDateFormat("dd-MMM-yyyy").format(date));
			String rollOffDate =  new SimpleDateFormat("dd-MMM-yyyy").format(date);
			emp.setRollOffDate(rollOffDate);
			
			
			empUnderList.add(emp);
		}
		
		
		
		returnEmp.setEmpUnderList(empUnderList);
		
		System.out.println(empUnderList.size());
		
	return returnEmp;
		//returnEmp.setEmpUnderList(empUnderList);
		
		
	}
	
	public String SearchFiveUserName(String like) throws SQLException, ClassNotFoundException
	{
		connection = DBHelper.createConnection();
		System.out.println(like+"yes in model class");
		String pass="";
	
	  	statement = connection.prepareStatement("SELECT CONCAT(Resource_first_name,' ', resource_last_name) as fullName FROM starwooddatabase WHERE  CONCAT(Resource_first_name,' ', resource_last_name) like ?");
	  	statement.setString(1, like+"%");
	  //	statement.setString(2, like+"%");
	  	ResultSet rs=statement.executeQuery();
	  	
	  	int count=0;
		while(rs.next())
		{
			if(count<5)
			{
			pass= pass + rs.getString("fullName")+",";
			count++;
			}
		}	
	  
		
		return pass;
	}
	
	
	public EmployeeForm SearchUserProfile(String name) throws ClassNotFoundException, SQLException
	{
		EmployeeForm  emp = new EmployeeForm();
		
		connection = DBHelper.createConnection();
		

		statement = connection.prepareStatement("SELECT * FROM starwooddatabase WHERE CONCAT(Resource_first_name,' ', resource_last_name)=?");
		statement.setString(1, name);
		ResultSet rs=statement.executeQuery();
	
		while(rs.next())
		{
		
		emp.setUsername(rs.getString("Resource_first_name")+" "+rs.getString("resource_last_name"));
		emp.setSupervisor(rs.getString("supervisor"));
		//emp.setPassword(rs.getString("password"));
		emp.setLocation(rs.getString("Work_city"));
		emp.setLevel(rs.getString("Career_Level"));
		emp.setEnterpriseId(rs.getString("Personnel_id"));
		emp.setEmailId(rs.getString("Resource_Enterprise_ID"));
		/*emp.setDoj(rs.getString("Candidate_Filled_Date"));
		emp.setRollOffDate(rs.getString("End_Date"));*/
		emp.setAttritionType(rs.getString("Attrition_type"));
		emp.setTurnOverType(rs.getString("Disengagement_Type"));
				
	//	System.out.println(rs.getString("Disengagement_Type"));		
	
		 java.util.Date date = rs.getDate("End_Date");
		 		 
			String rollOffDate =  new SimpleDateFormat("dd-MMM-yyyy").format(date);
			emp.setRollOffDate(rollOffDate);
			
			date = rs.getDate("Candidate_Filled_Date");
			String joinDate =  new SimpleDateFormat("dd-MMM-yyyy").format(date);
			emp.setDoj(joinDate);
		
		}
		
		EmployeeForm  empTemp1 = new EmployeeForm();
		EmployeeForm  empTemp2 = new EmployeeForm();
		empTemp2=ListMaker(empTemp1);
		
		emp.setTurnOverTypeList(empTemp2.getTurnOverTypeList());
		emp.setAttritionTypeList(empTemp2.getAttritionTypeList());
		emp.setLevelList(empTemp2.getLevelList());
		emp.setLocationList(empTemp2.getLocationList());
		
		DBHelper.closeConnection();
		return emp;
	
	}
	
	
	
	public EmployeeForm ListMaker(EmployeeForm emp) throws SQLException
	{
		 ArrayList<String> attritionTypeList = new ArrayList<String>();
		 ArrayList<String> levelList = new ArrayList<String>();
		 ArrayList<String> locationList = new ArrayList<String>();
		 ArrayList<String> turnOverTypeList = new ArrayList<String>();
		
		statement = connection.prepareStatement("SELECT DISTINCT Disengagement_Type FROM starwooddatabase");
		ResultSet rs1=statement.executeQuery();
		while(rs1.next())
		{
			turnOverTypeList.add(rs1.getString("Disengagement_Type"));
		}
		
		statement = connection.prepareStatement("SELECT DISTINCT Attrition_Type FROM starwooddatabase");
		ResultSet rs2=statement.executeQuery();
		while(rs2.next())
		{
			attritionTypeList.add(rs2.getString("Attrition_Type"));
		}
		
		statement = connection.prepareStatement("SELECT DISTINCT Career_Level FROM starwooddatabase");
		ResultSet rs3=statement.executeQuery();
		while(rs3.next())
		{
			levelList.add(rs3.getString("Career_Level"));
		}
		
		statement = connection.prepareStatement("SELECT DISTINCT Work_city FROM starwooddatabase");
		ResultSet rs4=statement.executeQuery();
		while(rs4.next())
		{
			locationList.add(rs4.getString("Work_city"));
		//	System.out.println(rs4.getString("Work_city"));
		}
		
		emp.setTurnOverTypeList(turnOverTypeList);
		emp.setAttritionTypeList(attritionTypeList);
		emp.setLevelList(levelList);
		emp.setLocationList(locationList);
		
		return emp;
	}
	
	
	
	
	public EmployeeForm SearchUser(String email,String password) throws SQLException, ClassNotFoundException
	{
		
			EmployeeForm  emp = new EmployeeForm();
		
			connection = DBHelper.createConnection();
		  
		  	statement = connection.prepareStatement("SELECT * FROM USERS WHERE (EMAILID=? OR USERNAME=?)  AND PASSWORD=?");
		  	statement.setString(1, email);
		  	statement.setString(2, email);
			statement.setString(3, password);
		  
		  
		
			ResultSet rs0=statement.executeQuery();
			System.out.println("in search user");
			while(rs0.next())
			{
				System.out.println("in search starwooddatabase");
				statement = connection.prepareStatement("SELECT * FROM starwooddatabase WHERE Resource_Enterprise_ID=? OR  CONCAT(Resource_first_name,' ', resource_last_name)=?");
				statement.setString(1, email);
				statement.setString(2, email);
					
				ResultSet rs=statement.executeQuery();
			
		
			
			
			while(rs.next())
			{
				System.out.println("in table");
				emp.setUsername(rs.getString("Resource_first_name")+" "+rs.getString("resource_last_name"));
				emp.setSupervisor(rs.getString("supervisor"));
				//emp.setPassword(rs.getString("password"));
				emp.setLocation(rs.getString("Work_city"));
				emp.setLevel(rs.getString("Career_Level"));
				emp.setEnterpriseId(rs.getString("Personnel_id"));
				emp.setEmailId(rs.getString("Resource_Enterprise_ID"));
				//emp.setDoj(rs.getString("Candidate_Filled_Date"));
			//	emp.setRollOffDate(rs.getString("End_Date"));
				emp.setAttritionType(rs.getString("Attrition_type"));
				emp.setTurnOverType(rs.getString("Disengagement_Type"));
				
				 java.util.Date date = rs.getDate("Candidate_Filled_Date");
					String joinDate =  new SimpleDateFormat("dd-MMM-yyyy").format(date);
					System.out.println(joinDate);
					emp.setDoj(joinDate);
					
					date = rs.getDate("End_Date");
				//	System.out.println(date);
					String rollOffDate =  new SimpleDateFormat("dd-MMM-yyyy").format(date);
				//	System.out.println(rollOffDate);
					emp.setRollOffDate(rollOffDate);
				
							
			}
			
			}
	
			
			EmployeeForm  empTemp1 = new EmployeeForm();
			EmployeeForm  empTemp2 = new EmployeeForm();
			empTemp2=ListMaker(empTemp1);
			
			emp.setTurnOverTypeList(empTemp2.getTurnOverTypeList());
			emp.setAttritionTypeList(empTemp2.getAttritionTypeList());
			emp.setLevelList(empTemp2.getLevelList());
			emp.setLocationList(empTemp2.getLocationList());
			
			 DBHelper.closeConnection();
			return emp;
	}

	
	public int saveEmp(String email,String password,String username,String enterpriseid,String location,String doj,String supervisor,String Career_Level) throws ClassNotFoundException, SQLException
	{
		connection = DBHelper.createConnection();
		statement = connection.prepareStatement("INSERT INTO USERS(USERNAME,PASSWORD,EMAILID,ENTERPRISEID,LEVEL,LOCATION,SUPERVISOR,DOJ) VALUES(?,?,?,?,?,?,?,?)");
		statement.setString(1, username);
		statement.setString(2, password);
		statement.setString(3, email);
		statement.setString(4, enterpriseid);
		statement.setString(5, Career_Level);
		statement.setString(6, location);
		statement.setString(7, supervisor);
		statement.setString(8, doj);

		int rs=statement.executeUpdate();
		
		return rs;
		
	}
	
	public int UpdateProfile(String email,String rollOffDate,String location,String Career_Level,String attritionType,String turnOverType) throws ClassNotFoundException, SQLException, ParseException
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = rollOffDate;

			java.util.Date date = (java.util.Date) formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter2.format(date));
		
		connection = DBHelper.createConnection();
	//	CAST('2014-02-28 08:14:57' AS DATETIME)
		statement = connection.prepareStatement("UPDATE starwooddatabase SET End_Date = CAST(? AS DATE) ,Work_city=?,Career_Level=?,Disengagement_Type=?,Attrition_type=? WHERE Resource_Enterprise_ID=?");
		statement.setString(1, formatter2.format(date));
		statement.setString(2, location);
		statement.setString(3, Career_Level);
		statement.setString(5, attritionType);
		statement.setString(4, turnOverType);
		statement.setString(6, email);
		

		int rs=statement.executeUpdate();

		return rs;
		
	}
	
	
public DashboardDataForm RetriveDashBoardData() throws ClassNotFoundException, SQLException, ParseException
{
	 connection = DBHelper.createConnection();
	 DashboardDataForm dashform = new DashboardDataForm();
	 java.util.Date date = Calendar.getInstance().getTime();
	 java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	 
	 java.util.Date d = (java.util.Date) Calendar.getInstance().getTime();
	 java.util.Date dateBefore = new java.util.Date(d.getTime() - 7 * 24 * 3600 * 1000l  );
	 java.sql.Date sqlDatePast = new java.sql.Date(dateBefore.getTime());
	 
	 
	 //   Emp Count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ?  ");
		statement.setDate(1, (Date) sqlDate);
		ResultSet rs=statement.executeQuery();	
		int totalEmp =0;		
		while(rs.next())
		{
			totalEmp=rs.getInt("count");			
		}		
		dashform.setEmpCount(Integer.toString(totalEmp));
		// Emp Count  //
		
		
		
		// ASE count and percentage //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ? AND End_Date > ?  ");
		statement.setString(1, "12 Associate");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs1=statement.executeQuery();	
		int aseCount =0;	float aseCountPercentage=0.0f;	
		while(rs1.next())
		{
			aseCount=rs1.getInt("count");			
		}	
		dashform.setAseCount(Integer.toString(aseCount));
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		DecimalFormat df1 = new DecimalFormat();
		df1.setMaximumFractionDigits(1);
		
		aseCountPercentage = ((float)(aseCount*100)/totalEmp);
		
		dashform.setAseCountPercentage(df.format(aseCountPercentage).toString());
		
		
		
		// ASE count and percentage //
		
		
		
		
		// ASE + SE count and percentage //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where (Career_Level = ? or Career_Level=? ) AND End_Date > ? ");
		statement.setString(1, "12 Associate");
		statement.setString(2, "11 Analyst");
		statement.setDate(3, (Date) sqlDate);
		ResultSet rs2=statement.executeQuery();	
		int asePlusScCount =0;	float asePlusScCountPercentage=0.0f;	
		
		while(rs2.next())
		{
			asePlusScCount=rs2.getInt("count");			
		}	
		dashform.setAsePlusScCount(Integer.toString(asePlusScCount));
		
		asePlusScCountPercentage = ((float)(asePlusScCount*100)/totalEmp);
		
		dashform.setAsePlusScPer(df.format(asePlusScCountPercentage).toString());
		
		// ASE + SE count and percentage //
		
		
		//  GCP count  //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where gcp like ?  AND End_Date > ? ");
		statement.setString(1, "Yes%");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs3=statement.executeQuery();	
		int gcpCount =0;		
		while(rs3.next())
		{
			gcpCount=rs3.getInt("count");			
		}		
		dashform.setGcpCount(Integer.toString(gcpCount));
		float gcpCountPercentage =0.0f;
		
		gcpCountPercentage = ((float)(gcpCount*100)/totalEmp);
		dashform.setGcpCountPercentage(df.format(gcpCountPercentage).toString());
		//  GCP count  //
		
		
		// male count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where gender = ?  AND End_Date > ? ");
		statement.setString(1, "male");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs4=statement.executeQuery();	
		int maleCount =0;	float maleCountPercentage=0.0f;	
		while(rs4.next())
		{
			maleCount=rs4.getInt("count");			
		}		
		
		maleCountPercentage= (float)(maleCount*100)/totalEmp;
		dashform.setMaleCount(df1.format(maleCountPercentage).toString());
		
		// male count //
		
		
		// female count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where gender = ?  AND End_Date > ? ");
		statement.setString(1, "female");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs5=statement.executeQuery();	
		int femaleCount =0;		float femaleCountPercentage=0.0f;	
		while(rs5.next())
		{
			femaleCount=rs5.getInt("count");			
		}
				
		femaleCountPercentage= (float)(femaleCount*100)/totalEmp;
		dashform.setFemaleCount(df1.format(femaleCountPercentage).toString());
		// female count //
				
				
		// lr count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where rate_type = ?  AND End_Date > ? ");
		statement.setString(1, "loaned");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs6=statement.executeQuery();	
		int lrCount =0;		
		while(rs6.next())
		{
			lrCount=rs6.getInt("count");			
		}
			
		dashform.setLoanedResourceCount(Integer.toString(lrCount));
		// lr count //
		
		
		// am count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ?  AND End_Date > ? ");
		statement.setString(1, "8 Consultant");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs7=statement.executeQuery();	
		int amCount =0;		
		while(rs7.next())
		{
			amCount=rs7.getInt("count");			
		}
			
		float amCountPer=0.0f;
		amCountPer = ((float)(amCount*100)/totalEmp);	
		dashform.setAmCount(df.format(amCountPer).toString());
		
		// am count //
		
		
		// m count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ?  AND End_Date > ? ");
		statement.setString(1, "7 Manager");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs8=statement.executeQuery();	
		int mCount =0;		
		while(rs8.next())
		{
			mCount=rs8.getInt("count");			
		}
		
		float mCountPer=0.0f;
		mCountPer = ((float)(mCount*100)/totalEmp);				
		dashform.setmCount(df.format(mCountPer).toString());
		// m count //
		
		
		
		// se count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ?  AND End_Date > ? ");
		statement.setString(1, "11 Analyst");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs9=statement.executeQuery();	
		int seCount =0;		
		while(rs9.next())
		{
			seCount=rs9.getInt("count");			
		}
		
		float seCountPer=0.0f;
		seCountPer = ((float)(seCount*100)/totalEmp);				
		dashform.setSeCount(df.format(seCountPer).toString());
		// se count //
				
		
		// sm count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ?  AND End_Date > ? ");
		statement.setString(1, "6 Senior Manager");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs10=statement.executeQuery();	
		int smCount =0;		
		while(rs10.next())
		{
			smCount=rs10.getInt("count");			
		}
		
		float smCountPer=0.0f;
		smCountPer = ((float)(smCount*100)/totalEmp);							
		dashform.setSmCount(df.format(smCountPer).toString());
		// sm count //
		
		
		
		// S. Exec count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ?  AND End_Date > ? ");
		statement.setString(1, "Contractor");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs11=statement.executeQuery();	
		int sExecCount =0;		
		while(rs11.next())
		{
			sExecCount=rs11.getInt("count");			
		}
			
		
		float sExecCountPer=0.0f;
		sExecCountPer = ((float)(sExecCount*100)/totalEmp);					
		dashform.setsExecCount(df.format(sExecCountPer).toString());
		// S. Exec count //
				
				
		
		// sse count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ?  AND End_Date > ? ");
		statement.setString(1, "10 Analyst");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs12=statement.executeQuery();	
		int sseCount =0;		
		while(rs12.next())
		{
			sseCount=rs12.getInt("count");			
		}
				
		float sseCountPer=0.0f;
		sseCountPer = ((float)(sseCount*100)/totalEmp);				
		dashform.setSseCount(df.format(sseCountPer).toString());
		// sse count //
				
				
		// tl count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ?  AND End_Date > ? ");
		statement.setString(1, "9 Consultant");
		statement.setDate(2, (Date) sqlDate);
		ResultSet rs13=statement.executeQuery();	
		int tlCount =0;		
		while(rs13.next())
		{
			tlCount=rs13.getInt("count");			
		}
			
		float tlCountPer=0.0f;
		tlCountPer = ((float)(tlCount*100)/totalEmp);				
		dashform.setTlCount(df.format(tlCountPer).toString());
		// tl count //
		
		
		// emp count change //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Candidate_Filled_Date <= ?  ");  //Candidate Filled Date
		statement.setDate(1, (Date) sqlDatePast);
		statement.setDate(2, (Date) sqlDatePast);
		ResultSet rs14=statement.executeQuery();	
		int pastTotalEmp =0;
		while(rs14.next())
		{
			pastTotalEmp=rs14.getInt("count");			
		}		
		float empCountChange=0.0f;
	
		empCountChange = ((float)((totalEmp-pastTotalEmp)*100)/totalEmp);
		dashform.setEmpCountChange(df.format(empCountChange).toString());
		// emp count change //
		
		
		// ase count change //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Career_Level = ? AND End_Date > ? and Candidate_Filled_Date <= ? ");
		statement.setString(1, "12 Associate");
		statement.setDate(2, (Date) sqlDatePast);
		statement.setDate(3, (Date) sqlDatePast);
		ResultSet rs15=statement.executeQuery();	
		int pastAseCount =0;
		while(rs15.next())
		{
			pastAseCount=rs15.getInt("count");			
		}		
		float pastAseCountPercentage=0.0f;
				
		pastAseCountPercentage = ((float)((pastAseCount)*100)/pastTotalEmp);
		
		float AsePercentageChange = (float)(aseCountPercentage-pastAseCountPercentage);
		
		dashform.setAseCountChange(df.format(AsePercentageChange).toString());
		// ase count change //
		
		
		// ase+se count change //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where (Career_Level = ? or Career_Level=? ) AND End_Date > ? and Candidate_Filled_Date <= ?");
		statement.setString(1, "12 Associate");
		statement.setString(2, "11 Analyst");
		statement.setDate(3, (Date) sqlDatePast);
		statement.setDate(4, (Date) sqlDatePast);
		ResultSet rs16=statement.executeQuery();	
		int pastAsePlusSeCount =0;
		while(rs16.next())
		{
			pastAsePlusSeCount=rs16.getInt("count");			
		}		
		float pastAsePlusSeCountPercentage=0.0f;							
		
		pastAsePlusSeCountPercentage = ((float)((pastAsePlusSeCount)*100)/pastTotalEmp);
		
		float AsePlusSePercentageChange = (float)(asePlusScCountPercentage-pastAsePlusSeCountPercentage);
		
		dashform.setAsePlusSeCountChange(df.format(AsePlusSePercentageChange).toString());
		System.out.println(AsePlusSePercentageChange);
		System.out.println(df.format(AsePlusSePercentageChange).toString());
		// ase+se count change //
		
		
		// gcp count change //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where gcp like ?  AND End_Date > ? and Candidate_Filled_Date <= ? ");
		statement.setString(1, "Yes%");
		statement.setDate(2, (Date) sqlDatePast);
		statement.setDate(3, (Date) sqlDatePast);
		ResultSet rs17=statement.executeQuery();	
		int pastGcpCount =0;
		while(rs17.next())
		{
			pastGcpCount=rs17.getInt("count");			
		}		
		float pastGcpCountChange=0.0f;
						
				
		pastGcpCountChange = ((float)((gcpCount-pastGcpCount)*100)/gcpCount);
		dashform.setGcpCountChange(df.format(pastGcpCountChange).toString());
		// gcp count change //
		
		
		// female count change //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where gender = ?  AND End_Date > ? and Candidate_Filled_Date <= ? ");
		statement.setString(1, "female");
		statement.setDate(2, (Date) sqlDatePast);
		statement.setDate(3, (Date) sqlDatePast);
		ResultSet rs18=statement.executeQuery();	
		int PastFemaleCount =0;
		while(rs18.next())
		{
			PastFemaleCount=rs18.getInt("count");			
		}		
		float PastFemalePercentage=0.0f;
								
				
		PastFemalePercentage = ((float)((PastFemaleCount)*100)/totalEmp);
			
		float FemalePercentageChange = (float)(femaleCountPercentage-PastFemalePercentage);
		
		dashform.setDiversityRatioChange(df.format(FemalePercentageChange).toString());
		// female count change //
		
		
		
		// loan count change //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where rate_type = ?  AND End_Date > ?  and Candidate_Filled_Date <= ?");
		statement.setString(1, "loaned");
		statement.setDate(2, (Date) sqlDatePast);
		statement.setDate(3, (Date) sqlDatePast);
		ResultSet rs19=statement.executeQuery();	
		int PastLoanCount =0;
		while(rs19.next())
		{
			PastLoanCount=rs19.getInt("count");			
		}		
	
		dashform.setLoanResourceChange(Integer.toString(PastLoanCount-lrCount));
		
		// loan count change //
		
		
		 //   GreenList Count //
		ArrayList<String> greenList = new ArrayList<String>();
		
		// ase
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "12 Associate");
		statement.setString(3, "ADM Category II");
		
		ResultSet rs20=statement.executeQuery();	
		int greenCount =0;		
		while(rs20.next())
		{
			greenCount=rs20.getInt("count");			
		}
		if(greenCount>0)
		{
			greenList.add("[1,2,"+greenCount+"]");
		}
		
		
		// se
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "11 Analyst");
		statement.setString(3, "ADM Category III");
		
		ResultSet rs21=statement.executeQuery();	
		while(rs21.next())
		{
			greenCount=rs21.getInt("count");			
		}
		if(greenCount>0)
		{
			greenList.add("[2,3,"+greenCount+"]");
		}
		
		//sse
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "10 Analyst");
		statement.setString(3, "ADM Category IV");
		
		ResultSet rs22=statement.executeQuery();	
		while(rs22.next())
		{
			greenCount=rs22.getInt("count");			
		}
		if(greenCount>0)
		{
			greenList.add("[3,4,"+greenCount+"]");
		}
	
		//tl
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "9 Consultant");
		statement.setString(3, "ADM Category V");
		
		ResultSet rs23=statement.executeQuery();	
		while(rs23.next())
		{
			greenCount=rs23.getInt("count");			
		}
		if(greenCount>0)
		{
			greenList.add("[4,5,"+greenCount+"]");
		}
		
		
		// am
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "8 Consultant");
		statement.setString(3, "ADM Category VI");
		
		ResultSet rs24=statement.executeQuery();	
		while(rs24.next())
		{
			greenCount=rs24.getInt("count");			
		}
		if(greenCount>0)
		{
			greenList.add("[5,6,"+greenCount+"]");
		}
		
		// m
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "7 Manager");
		statement.setString(3, "ADM Category VII");
		
		ResultSet rs25=statement.executeQuery();	
		while(rs25.next())
		{
			greenCount=rs25.getInt("count");			
		}
		if(greenCount>0)
		{
			greenList.add("[6,7,"+greenCount+"]");
		}
		
		dashform.setGreenList(greenList);
		// GreenList Count  //
		
		
		
		
		
		 //   RedList Count //
		ArrayList<String> redList = new ArrayList<String>();
		
		// sm
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "6 Senior Manager");
		statement.setString(3, "ADM Category VI");
		
		ResultSet rs26=statement.executeQuery();	
		int redCount =0;		
		while(rs26.next())
		{
			redCount=rs26.getInt("count");			
		}
		if(redCount>0)
		{
			redList.add("[7,6,"+redCount+"]");
		}
		
		
		// se
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "11 Analyst");
		statement.setString(3, "ADM Category I");
		
		ResultSet rs27=statement.executeQuery();	
		while(rs27.next())
		{
			redCount=rs27.getInt("count");			
		}
		if(redCount>0)
		{
			redList.add("[2,1,"+redCount+"]");
		}
		
		//sse
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "10 Analyst");
		statement.setString(3, "ADM Category II");
		
		ResultSet rs28=statement.executeQuery();	
		while(rs28.next())
		{
			redCount=rs28.getInt("count");			
		}
		if(redCount>0)
		{
			redList.add("[3,2,"+redCount+"]");
		}
	
		//tl
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "9 Consultant");
		statement.setString(3, "ADM Category III");
		
		ResultSet rs29=statement.executeQuery();	
		while(rs29.next())
		{
			redCount=rs29.getInt("count");			
		}
		if(redCount>0)
		{
			redList.add("[4,3,"+redCount+"]");
		}
		
		
		// am
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "8 Consultant");
		statement.setString(3, "ADM Category IV");
		
		ResultSet rs30=statement.executeQuery();	
		while(rs30.next())
		{
			redCount=rs30.getInt("count");			
		}
		if(redCount>0)
		{
			redList.add("[5,4,"+redCount+"]");
		}
		
		// m
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "7 Manager");
		statement.setString(3, "ADM Category V");
		
		ResultSet rs31=statement.executeQuery();	
		while(rs31.next())
		{
			redCount=rs31.getInt("count");			
		}
		if(redCount>0)
		{
			redList.add("[6,5,"+redCount+"]");
		}
		
		dashform.setRedList(redList);
		// RedList Count  //
		
		
		
		
		
		 //   NeutralList Count //
		ArrayList<String> neutralList = new ArrayList<String>();
		
		// sm
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "6 Senior Manager");
		statement.setString(3, "ADM Category VII");
		
		ResultSet rs32=statement.executeQuery();	
		int neutralCount =0;		
		while(rs32.next())
		{
			neutralCount=rs32.getInt("count");			
		}
		if(neutralCount>0)
		{
			neutralList.add("[7,7,"+neutralCount+"]");
		}
		
		// ase
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "12 Associate");
		statement.setString(3, "ADM Category I");
				
		ResultSet rs33=statement.executeQuery();			
		while(rs33.next())
		{
			neutralCount=rs33.getInt("count");			
		}
		if(neutralCount>0)
		{
			neutralList.add("[1,1,"+neutralCount+"]");
		}
		
		
		// se
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "11 Analyst");
		statement.setString(3, "ADM Category II");
		
		ResultSet rs34=statement.executeQuery();	
		while(rs34.next())
		{
			neutralCount=rs34.getInt("count");			
		}
		if(neutralCount>0)
		{
			neutralList.add("[2,2,"+neutralCount+"]");
		}
		
		//sse
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "10 Analyst");
		statement.setString(3, "ADM Category III");
		
		ResultSet rs35=statement.executeQuery();	
		while(rs35.next())
		{
			neutralCount=rs35.getInt("count");			
		}
		if(neutralCount>0)
		{
			neutralList.add("[3,3,"+neutralCount+"]");
		}
	
		//tl
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "9 Consultant");
		statement.setString(3, "ADM Category IV");
		
		ResultSet rs36=statement.executeQuery();	
		while(rs36.next())
		{
			neutralCount=rs36.getInt("count");			
		}
		if(neutralCount>0)
		{
			neutralList.add("[4,4,"+neutralCount+"]");
		}
		
		
		// am
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "8 Consultant");
		statement.setString(3, "ADM Category V");
		
		ResultSet rs37=statement.executeQuery();	
		while(rs37.next())
		{
			neutralCount=rs37.getInt("count");			
		}
		if(neutralCount>0)
		{
			neutralList.add("[5,5,"+neutralCount+"]");
		}
		
		// m
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date > ? and Career_Level=? and category =? ");
		statement.setDate(1, (Date) sqlDate);
		statement.setString(2, "7 Manager");
		statement.setString(3, "ADM Category VI");
		
		ResultSet rs38=statement.executeQuery();	
		while(rs38.next())
		{
			neutralCount=rs38.getInt("count");			
		}
		if(neutralCount>0)
		{
			neutralList.add("[6,6,"+neutralCount+"]");
		}
		
		dashform.setNeutralList(neutralList);
		// NeutralList Count  //
		
		
	
		 
		 //   Roll off Count //
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Attrition_type != ? or Attrition_type != ?  ");
		statement.setString(1,null );
		statement.setString(2,"" );
		ResultSet rs39=statement.executeQuery();	
		int totalRollOff =0;		
		while(rs39.next())
		{
			totalRollOff=rs39.getInt("count");			
		}	
		System.out.println(totalRollOff);
		
		// other job roll off count
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Attrition_type = ? ");
		statement.setString(1,"Other Job" );
		
		ResultSet rs40=statement.executeQuery();	
		int rollOffCount =0;		
		while(rs40.next())
		{
			rollOffCount=rs40.getInt("count");			
		}	
		
		dashform.setOtherJobRollOffNumber(Integer.toString(rollOffCount));
		dashform.setOtherJobRollOffPercentage(df.format(((float)(rollOffCount*100)/totalRollOff)).toString());
	
		
		
		// Higher studies roll off count
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Attrition_type = ? ");
		statement.setString(1,"Higher Studies" );
				
		ResultSet rs41=statement.executeQuery();	
		rollOffCount=0;	
		while(rs41.next())
		{
			rollOffCount=rs41.getInt("count");			
		}	
			
		dashform.setHigherStudiesRollOffNumber(Integer.toString(rollOffCount));
		dashform.setHigherStudiesRollOffPercentage(df.format(((float)(rollOffCount*100)/totalRollOff)).toString());
	
		
		// location change roll off count
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Attrition_type = ? ");
		statement.setString(1,"Location Change" );
						
		ResultSet rs42=statement.executeQuery();	
		rollOffCount=0;		
		while(rs42.next())
		{
			rollOffCount=rs42.getInt("count");			
		}	
				
		dashform.setLocChangeRollOffNumber(Integer.toString(rollOffCount));
		//df.format(AsePlusSePercentageChange).toString()
		dashform.setLocChangeRollOffPercentage(df.format((float)(rollOffCount*100)/totalRollOff).toString());
	
		
		// Personal issue roll off count
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Attrition_type = ? ");
		statement.setString(1,"Personnal Issue" );
						
		ResultSet rs43=statement.executeQuery();	
		rollOffCount=0;	
		while(rs43.next())
		{
			rollOffCount=rs43.getInt("count");			
		}	
		
		dashform.setPersonnalIssueRollOffNumber(Integer.toString(rollOffCount));	
		dashform.setPersonnalIssueRollOffPercentage(df.format((float)(rollOffCount*100)/totalRollOff).toString());
	
		
		
		
		// Health issue roll off count
				statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Attrition_type = ? ");
				statement.setString(1,"Health" );
								
				ResultSet rs43h=statement.executeQuery();	
				rollOffCount=0;	
				while(rs43h.next())
				{
					rollOffCount=rs43h.getInt("count");			
				}	
				
				dashform.setHealthRollOffCount(Integer.toString(rollOffCount));	
				dashform.setHealthRollOffPercentage(df.format((float)(rollOffCount*100)/totalRollOff).toString());
			
		
		
	//	dashform.setEmpCount(Integer.toString(totalRollOff));
		// Roll off Count  //
		
		
		
		
		// Attrition count & Percentage
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where (Disengagement_Type = ?) And (End_Date>=? and End_Date<?)");
		statement.setString(1,"Resignation" );				
		
		ArrayList<String> AttritionCountList = new ArrayList<String>();
		ArrayList<String> AttritionPercentageList = new ArrayList<String>();
		
		
	
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ); 
		ArrayList<String> DateList = new ArrayList<String>();
		String[] otherList = new String[] {"2016-01-01","2016-02-01","2016-03-01","2016-04-01","2016-05-01","2016-06-01","2016-07-01","2016-08-01","2016-09-01","2016-10-01","2016-11-01","2016-12-01","2017-01-01"};
		DateList.addAll(java.util.Arrays.asList(otherList));
		
		int dateCount=0;
		for(int i=0;i<12;i++)
		{
			java.util.Date utilDateStart = dateFormat.parse(DateList.get(dateCount));	
			java.sql.Date sqlDateStart = new java.sql.Date(utilDateStart.getTime());
			 
			java.util.Date utilDateEnd = dateFormat.parse(DateList.get(dateCount+1));	
			java.sql.Date sqlDateEnd = new java.sql.Date(utilDateEnd.getTime());
			  
			statement.setDate(2,sqlDateStart);
			statement.setDate(3,sqlDateEnd );
			
			ResultSet rs44=statement.executeQuery();	
			rollOffCount=0;	
			while(rs44.next())
			{
				rollOffCount=rs44.getInt("count");			
			}	
		
			AttritionCountList.add(Integer.toString(rollOffCount));
		
			float  AttritionPercentage=0.0f;
			AttritionPercentage = ((float)((rollOffCount)*100)/totalEmp);		
			AttritionPercentageList.add(df.format(AttritionPercentage).toString());
			
			dateCount++;
		}
		
		dashform.setAttritionCountList(AttritionCountList);	
		dashform.setAttritionPercentageList(AttritionPercentageList);
		
		
		
		
		
		
		// Turn Over count & Percentage
		statement = connection.prepareStatement("select count(*) as count from starwooddatabase where (Disengagement_Type = ? or Disengagement_Type = ? or Disengagement_Type = ? or Disengagement_Type = ? or Disengagement_Type = ?) And (End_Date>=? and End_Date<?) ");
		statement.setString(1,"New Role in Accenture" );
		statement.setString(2,"Resignation" );
		statement.setString(3,"Resource Relocation request" );
		statement.setString(4,"Pyramid Refresh" );
		statement.setString(5,"Performance issue – Accenture initiated" );
	

		
		
		
		ArrayList<String> TurnOverCountList = new ArrayList<String>();
		ArrayList<String> TurnOverPercentagetList = new ArrayList<String>();
		
		
		 dateCount=0;
		for(int i=0;i<12;i++)
		{
			java.util.Date utilDateStart = dateFormat.parse(DateList.get(dateCount));	
			java.sql.Date sqlDateStart = new java.sql.Date(utilDateStart.getTime());
			 
			java.util.Date utilDateEnd = dateFormat.parse(DateList.get(dateCount+1));	
			java.sql.Date sqlDateEnd = new java.sql.Date(utilDateEnd.getTime());
			  
			statement.setDate(6,sqlDateStart);
			statement.setDate(7,sqlDateEnd );
			
			ResultSet rs45=statement.executeQuery();	
			rollOffCount=0;	
			while(rs45.next())
			{
				rollOffCount=rs45.getInt("count");			
			}	
		
			TurnOverCountList.add(Integer.toString(rollOffCount));
		
			float  AttritionPercentage=0.0f;
			AttritionPercentage = ((float)((rollOffCount)*100)/totalEmp);		
			TurnOverPercentagetList.add(df.format(AttritionPercentage).toString());
			
			dateCount++;
		}
		
		dashform.setTurnOverCountList(TurnOverCountList);	
		dashform.setTurnOverPercentagetList(TurnOverPercentagetList);
		
		// Turn Over count & Percentage
		
	
		// check point
		
		// total employee change add sub list ///
		
		ArrayList<String> empAddList = new ArrayList<String>();	
		ArrayList<String> empSubList = new ArrayList<String>();	
	
		
			statement = connection.prepareStatement("select Resource_first_name as fname, resource_last_name AS lname, Career_Level AS Career_Level from starwooddatabase where Candidate_Filled_Date>? And Candidate_Filled_Date<=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			
			ResultSet rs46=statement.executeQuery();	
	
			while(rs46.next())
			{
				if(rs46.getString("Career_Level")!=null)
				empAddList.add("+"+rs46.getString("fname")+" "+rs46.getString("lname")+"("+rs46.getString("Career_Level")+")");			
			}	
			
	
			statement = connection.prepareStatement("select  Resource_first_name as fname, resource_last_name AS lname, Career_Level AS Career_Level from starwooddatabase where End_Date>? And End_Date<=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			
			ResultSet rs47=statement.executeQuery();	
			
			while(rs47.next())
			{
				if(rs47.getString("Career_Level")!=null)
				empSubList.add("-"+rs47.getString("fname")+" "+rs47.getString("lname")+"("+rs47.getString("Career_Level")+")");	
			}	
						
			
			ArrayList<DashboardDataForm> empAddSubList = new ArrayList<DashboardDataForm>();
			 DashboardDataForm obj;
			
			 System.out.println((empAddList).size());
			 System.out.println((empSubList).size());
			 
			 for(int i =0;i<empSubList.size();i++)
			 {
				 System.out.println((empSubList).get(i));
			 }
			 
			 if((empAddList).size()<(empSubList).size())
			 {
				 for(int i=0;i<(empSubList).size();i++)
				 {
					 obj = new DashboardDataForm();
					 
					 if((empAddList).size()>=i+1)
					 obj.setEmpAdd(ListModifier(empAddList).get(i));
					 
					 obj.setEmpSub((ListModifier(empSubList)).get(i));
						 
					 empAddSubList.add(obj);
				 }
			 }
			
			 else
			 {
				 for(int i=0;i<(empAddList).size();i++)
				 {
					 obj = new DashboardDataForm();
					 
					 if((empSubList).size()>=i+1)
					 obj.setEmpSub(ListModifier(empSubList).get(i));
					 
					 obj.setEmpAdd(ListModifier(empAddList).get(i));
					 
					 empAddSubList.add(obj);
				 }
			 }
			 
			 
			dashform.setEmpAddSubList(empAddSubList);
			 
			// total employee change add sub list ///
		
		
			
			// total ase/other/ase+se up/down count //	
			
			// ase up
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Candidate_Filled_Date>? And Candidate_Filled_Date<=? and Career_Level=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "12 Associate");
			
			ResultSet rs48=statement.executeQuery();	
			while(rs48.next())
			{
				dashform.setAseCountUp(Integer.toString((rs48.getInt("count"))));			
			}
			
			// ase down
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date>? And End_Date<=? and Career_Level=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "12 Associate");
			
			ResultSet rs49=statement.executeQuery();	
			while(rs49.next())
			{
				dashform.setAseCountDown(Integer.toString((rs49.getInt("count"))));			
			}
			
			// other 1 up
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Candidate_Filled_Date>? And Candidate_Filled_Date<=? and Career_Level!=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "12 Associate");
			
			ResultSet rs50=statement.executeQuery();	
			while(rs50.next())
			{
				dashform.setOther1Up(Integer.toString((rs50.getInt("count"))));			
			}
			
			// other1 down
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date>? And End_Date<=? and Career_Level!=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "12 Associate");
			
			ResultSet rs51=statement.executeQuery();	
			while(rs51.next())
			{
				dashform.setOther1Down(Integer.toString((rs51.getInt("count"))));			
			}
			
			
			// ase + se count up
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Candidate_Filled_Date>? And Candidate_Filled_Date<=? and (Career_Level=? or Career_Level=?) ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "12 Associate");
			statement.setString(4, "11 Analyst");
			
			ResultSet rs52=statement.executeQuery();	
			while(rs52.next())
			{
				dashform.setAsePlusSeCountUp(Integer.toString((rs52.getInt("count"))));			
			}
			
		
			// ase + se count down
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date>? And End_Date<=? and (Career_Level=? or Career_Level=?) ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "12 Associate");
			statement.setString(4, "11 Analyst");
			
			ResultSet rs53=statement.executeQuery();	
			while(rs53.next())
			{
				dashform.setAsePlusSeCountDown(Integer.toString((rs53.getInt("count"))));			
			}
	
			
			// other 2 up
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Candidate_Filled_Date>? And Candidate_Filled_Date<=? and Career_Level!=? and Career_Level!=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "12 Associate");
			statement.setString(4, "11 Analyst");
			
			ResultSet rs54=statement.executeQuery();	
			while(rs54.next())
			{
				dashform.setOther2Up(Integer.toString((rs54.getInt("count"))));			
			}
			
			// other 2 down
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date>? And End_Date<=? and Career_Level!=? and Career_Level!=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "12 Associate");
			statement.setString(4, "11 Analyst");
			
			ResultSet rs55=statement.executeQuery();	
			while(rs55.next())
			{
				dashform.setOther2Down(Integer.toString((rs55.getInt("count"))));			
			}
			
			
			// female count up
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Candidate_Filled_Date>? And Candidate_Filled_Date<=? and gender=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "female");
			
			ResultSet rs56=statement.executeQuery();	
			while(rs56.next())
			{
				dashform.setFemaleCountUp(Integer.toString((rs56.getInt("count"))));			
			}
			
			// female count down
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date>? And End_Date<=? and gender=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "female");
			
			ResultSet rs57=statement.executeQuery();	
			while(rs57.next())
			{
				dashform.setFemaleCountDown(Integer.toString((rs57.getInt("count"))));			
			}
			
			// male count up
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where Candidate_Filled_Date>? And Candidate_Filled_Date<=? and gender=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "male");
			
			ResultSet rs58=statement.executeQuery();	
			while(rs58.next())
			{
				dashform.setMaleCountUp(Integer.toString((rs58.getInt("count"))));			
			}
			
			// male count down
			statement = connection.prepareStatement("select count(*) as count from starwooddatabase where End_Date>? And End_Date<=? and gender=? ");
			statement.setDate(2,sqlDate);
			statement.setDate(1,sqlDatePast );
			statement.setString(3, "male");
			
			ResultSet rs59=statement.executeQuery();	
			while(rs59.next())
			{
				dashform.setMaleCountDown(Integer.toString((rs59.getInt("count"))));			
			}
			
			
			
			
			
			
			
			
			// LR up/down List		
			
			ArrayList<String> LRAddList = new ArrayList<String>();	
			ArrayList<String> LRSubList = new ArrayList<String>();	
		
			statement = connection.prepareStatement("select CONCAT(Resource_first_name,' ', resource_last_name) as name, Career_Level as Career_Level from starwooddatabase where rate_type = ?  AND Candidate_Filled_Date > ?  and Candidate_Filled_Date <= ?");
			statement.setDate(3,sqlDate);
			statement.setDate(2,sqlDatePast );
			statement.setString(1,"loaned" );
			
			ResultSet rs60=statement.executeQuery();	
	
			while(rs60.next())
			{
				if(rs60.getString("Career_Level")!=null)
				LRAddList.add("+"+rs60.getString("name")+"("+rs60.getString("Career_Level")+")");			
			}	
			
	
			statement = connection.prepareStatement("select CONCAT(Resource_first_name,' ', resource_last_name) as name, Career_Level as Career_Level from starwooddatabase where rate_type = ?  AND End_Date > ?  and End_Date <= ?");
			statement.setDate(3,sqlDate);
			statement.setDate(2,sqlDatePast );
			statement.setString(1,"loaned" );
			
			ResultSet rs61=statement.executeQuery();	
			
			while(rs61.next())
			{
				if(rs61.getString("Career_Level")!=null)
				LRSubList.add("-"+rs61.getString("name")+"("+rs61.getString("Career_Level")+")");	
			}	
			
			dashform.setLRAddList(ListModifier(LRAddList));
			dashform.setLRSubList(ListModifier(LRSubList));
			
			/*ArrayList<DashboardDataForm> LRAddSubList = new ArrayList<DashboardDataForm>();
			
			
			 if((LRAddList).size()<(LRSubList).size())
			 {
				 for(int i=0;i<(LRSubList).size();i++)
				 {
					
					 
					 if((LRAddList).size()>=i+1)
					 obj.setEmpAdd(ListModifier(LRAddList).get(i));
					 
					 obj.setEmpSub(ListModifier(LRSubList).get(i));
					// System.out.println(ListModifier(LRSubList).get(i));
					 LRAddSubList.add(obj);
				 }
			 }
			
			 else
			 {
				 for(int i=0;i<(LRAddList).size();i++)
				 {
					 obj = new DashboardDataForm();
					 
					 if((LRSubList).size()>=i+1)
					 obj.setEmpAdd(ListModifier(LRSubList).get(i));
					 
					 obj.setEmpSub(ListModifier(LRAddList).get(i));
					 
					 LRAddSubList.add(obj);
				 }
			 }*/
			 
			
			
		//	System.out.println(LRAddSubList);
		//	System.out.println(LRSubList);
			
			
			
			
	//	System.out.println(sqlDate.toString());
	//	System.out.println(sqlDatePast.toString());
			
	//	System.out.println(utilDateTest.toString());
	//	System.out.println(DateList);
	
		
		 DBHelper.closeConnection();
		return dashform;
}

public ArrayList<String> ListModifier(ArrayList<String> list)
{
	ArrayList<String> empListModified = new ArrayList<String>();	
	
	for(int i=0;i<list.size();i++)
	{
	if(((String) list.get(i)).endsWith("(12 Associate)"))
		empListModified.add((String) list.get(i));
		
	}
	
	for(int i=0;i<list.size();i++)
	{
	if(((String) list.get(i)).endsWith("(11 Analyst)"))
		empListModified.add((String) list.get(i));
	}
	
	for(int i=0;i<list.size();i++)
	{
	if(((String) list.get(i)).endsWith("(10 Analyst)"))
		empListModified.add((String) list.get(i));
	}
	
	for(int i=0;i<list.size();i++)
	{
	if(((String) list.get(i)).endsWith("(9 Consultant)"))
		empListModified.add((String) list.get(i));
	}
	
	
	for(int i=0;i<list.size();i++)
	{
	if(((String) list.get(i)).endsWith("(Contractor)"))
		empListModified.add((String) list.get(i));
	}
	
	
	for(int i=0;i<list.size();i++)
	{
	if(((String) list.get(i)).endsWith("(8 Consultant)"))
		empListModified.add((String) list.get(i));
	}
	
	
	for(int i=0;i<list.size();i++)
	{
	if(((String) list.get(i)).endsWith("(7 Manager)"))
		empListModified.add((String) list.get(i));
	}
	
	for(int i=0;i<list.size();i++)
	{
	if(((String) list.get(i)).endsWith("(6 Senior Manager)"))
		empListModified.add((String) list.get(i));
	}
	
	return empListModified;
}

}
