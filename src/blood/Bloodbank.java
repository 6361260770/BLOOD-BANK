package blood;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.time.*;

 class DataBase{

	public void insert(BloodDonarReg r) throws Exception {
		// TODO Auto-generated method stub
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddb", "root", "root123");
		 System.out.println("Connected ");
		 String query="insert into donnar values(?,?,?,?,?)";
		 PreparedStatement st=connection.prepareStatement(query);
		 st.setString(1, r.name);
		 st.setLong(2,r.ph);
		 st.setString(3, r.place);
		 st.setString(4, r.bloodGroup);
		 st.setDate(5, r.date);
		 int count=st.executeUpdate();
		 System.out.println(count+" a"+"affected");
		 System.out.println("Inserted");
		 
		 
		 
	}
	
 }
		 



class BloodDonarReg{
	
	String name;
	long ph;
	String place;
	String bloodGroup;
	Date date ;
	String send;
	
	
}

class BlGroup{
	
	int a_plus=0;
	int a_minus=0;
	int b_plus=0;
	int b_minus=0;
	int ab_plus=0;
	int ab_minus=0;
	int o_plus=0;
	int o_minus=0;
	
	
	public void update(String send) throws Exception {
		
		// TODO Auto-generated method stub
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddb", "root", "root123");//Establishing connection
		System.out.println("Connected With the database successfully");
		Statement st=connection.createStatement();
		
		
		
		//String query="update blgroup "+send+"="+send+"1 where sl=1";
		String a="update blgroup set ";
		//String send="A_plus";
		String c=a.concat(send);
		String d=c.concat("=");
		String e=d.concat(send);
		String query=e.concat("+1 where sl=1;");

		int count=st.executeUpdate(query);
		System.out.println(count+"affectedCOUNTING UPDATED");
		
		
		
	}


	public void bloodAvailability() throws Exception {
		// TODO Auto-generated method stub
		int aplus,aminus,bplus,bminus,abplus,abminus,oplus,ominus;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddb", "root", "root123");//Establishing connection
	
		Statement st=connection.createStatement();
		String sql = "SELECT * FROM blooddb.blgroup;";
		ResultSet rs=st.executeQuery(sql);
		rs.next();
		
			aplus=rs.getInt("A_plus");
			aminus=rs.getInt("A_minus");
			bplus=rs.getInt("B_plus");
			bminus=rs.getInt("B_minus");
			abplus=rs.getInt("AB_plus");
			abminus=rs.getInt("AB_minus");
			oplus=rs.getInt("O_plus");
			ominus=rs.getInt("O_minus");
			
			System.out.println("A+:"+aplus+"\nA-:"+aminus+"\nB+:"+bplus+"\nB-:"+bminus+"\nAB+:"+abplus+"\nAB-:"+abminus+"\nO+:"+oplus+"\nO-:"+ominus);
			
		
	}
	
	
	
	
}
class BloodReq{
	
	
public void req(String send,int req) throws Exception {
		
		// TODO Auto-generated method stub
	//int aplus,aminus,bplus,bminus,abplus,abminus,oplus,ominus;
		int a2 = 0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddb", "root", "root123");//Establishing connection
		System.out.println("Connected With the database successfully");
		Statement st=connection.createStatement();
		
		
		
		
		String sql = "SELECT * FROM blooddb.blgroup;";
		ResultSet rs=st.executeQuery(sql);
		rs.next();
		switch(req)
		{
		case 1:a2=rs.getInt("A_plus");
		break;
		case 2:a2=rs.getInt("A_minus");
		break;
		case 3:	a2=rs.getInt("B_plus");
		break;
		case 4:	a2=rs.getInt("B_minus");
		break;
		case 5:
			a2=rs.getInt("AB_plus");
			break;
		case 6:	a2=rs.getInt("AB_minus");
		break;
		case 7:	a2=rs.getInt("O_minus");
		break;
		case 8:	a2=rs.getInt("O_plus");
		break;
		
		}
			
		if(a2!=0)
		{
		
		//String query="update blgroup set "+send+"="+send+"1 where sl=1";
		String a="update blgroup set ";
		//String send="A_plus";
		String c=a.concat(send);
		String d=c.concat("=");
		String e=d.concat(send);
		String query=e.concat("-1 where sl=1;");

		int count=st.executeUpdate(query);
		System.out.println(count+"affectedCOUNTING UPDATED");
		}
		else
		{
			System.out.println("Blood bags are not available in blood bank");
		}
		
		
	}


}
class Search{
	
	public void printInfo(String bloodGroup) throws Exception
	{
		String dname;
		long dph;
		String dplace;
		String dbloodGroup;
		Date ddate ;
		int flag=0;
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddb", "root", "root123");
		 System.out.println("Connected ");
			Statement st=connection.createStatement();
			String sql = "SELECT * FROM blooddb.donnar;";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				dname=rs.getString("name");
				dph=rs.getLong("ph");
				dplace=rs.getString("place");
				dbloodGroup=rs.getString("bloodGroup");
				ddate=rs.getDate("date");
				if(dbloodGroup.equals(bloodGroup))
				{
					System.out.println("NAME:"+dname+"   PH:"+dph+"   PLACE:"+dplace+"   BLOODGROUP:"+dbloodGroup +"   DATE:"+ddate);
					flag=1;
				}
				
			}
			if(flag==0)
			{
				System.out.println("No donar available ");
			}
	}
}
class BloodBankDonars{
	int count=0;
	public void printDonars() throws Exception
	{

		String dname;
		long dph;
		String dplace;
		String dbloodGroup;
		Date ddate ;
		
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddb", "root", "root123");
		 System.out.println("Connected ");
			Statement st=connection.createStatement();
			String sql = "SELECT * FROM blooddb.donnar;";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				dname=rs.getString("name");
				dph=rs.getLong("ph");
				dplace=rs.getString("place");
				dbloodGroup=rs.getString("bloodGroup");
				ddate=rs.getDate("date");
				
					System.out.println("NAME:"+dname+"   PH:"+dph+"   PLACE:"+dplace+"   BLOODGROUP:"+dbloodGroup +"   DATE:"+ddate);
				
			}
	}
	
	public void countAllDonar() throws Exception
	{

		
		
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddb", "root", "root123");
		 System.out.println("Connected ");
			Statement st=connection.createStatement();
			String sql = "SELECT * FROM blooddb.donnar;";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				
				count++;
				
			}
			System.out.println("TOTAL NUMBER OF DONNAR "+count);
	}
}

public class Bloodbank {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BloodDonarReg r=new BloodDonarReg();
		DataBase db=new DataBase();
		BlGroup g=new BlGroup();
		BloodReq rq=new BloodReq();
		BloodBankDonars pri=new BloodBankDonars();
		Search s=new Search();
		Scanner in=new Scanner(System.in);
		System.out.println("**************************Blood bank*********************************");
		int ch,i,no;
		String send = null;
		String bloodGroup=null;
		int req = 0;
		for(;;)
		{
			System.out.println(" ENTER \n 1:BLOOD DONAR REGISTRATION-->\n 2:BLOOD AVAILABILITY IN BANK-->\n 3:BLOOD REQIURED-->\n 4:BLOOD SEARCH-->\n 5:PRINT ALL DETAIALS-->\n 6:COUNT OF DONARS-->\n 7:EXIT-->\n");
			ch=in.nextInt();
			
			switch(ch)
			{
				case 1:System.out.println("Enter name of donor");
						r.name=in.next();
						System.out.println("Enter ph of donor");
						r.ph=in.nextLong();
						System.out.println("Enter place of donor ");
						r.place=in.next();
						System.out.println("Enter 1:A+ 2:A- 3:B+ 4:B- 5:AB+ 6:AB- 7:O- 8:O+");
						ch=in.nextInt();
						switch(ch)
						{
						
							case 1:r.send="A_plus";
							     r.bloodGroup="A+";
							break;
							
							case 2:	r.send="A_minus";
							 		r.bloodGroup="A-";
							break;
							
							case 3:r.send="B_plus";
								   r.bloodGroup="B+";
							break;
							
							case 4:r.send="B_minus";
									r.bloodGroup="B-";
							break;
							
						
							case 5:r.send="AB_plus"; 
									r.bloodGroup="AB+";
							break;
							
							case 6:r.send="AB_minus";
								r.bloodGroup="AB-";
							break;
							
							case 7:r.send="O_minus";
									r.bloodGroup="O-";
							break;
							
							case 8:r.send="O_plus";
									r.bloodGroup="O+";
							break;
						}
						
						g.update(r.send);
						r.date= Date.valueOf(LocalDate.now());
						//r=new BloodDonarReg(name,ph,place,bloodGroup,date);
						db.insert(r);
						break;
				
						
				case 2:g.bloodAvailability();		
					break;
					
				case 3:System.out.println("Enter no of blood bag required");
						no=in.nextInt();
						for(i=0;i<no;i++)
						{
							System.out.println("Enter1:A+\t2:A-\t3:B+\t4:B-\t5:AB+\t6:AB-\t7:O-\t8:O+");
							ch=in.nextInt();
							switch(ch)
							{
							
								case 1:send="A_plus";
								    req=1;
								break;
								
								case 2:	send="A_minus";
								 		req=2;
								break;
								
								case 3:send="B_plus";
									  req=3;
								break;
								
								case 4:send="B_minus";
										req=4;
								break;
								
							
								case 5:send="AB_plus"; 
										req=5;
								break;
								
								case 6:send="AB_minus";
									req=6;
								break;
								
								case 7:send="O_minus";
										req=7;
								break;
								
								case 8:send="O_plus";
										req=8;
								break;
							}
							rq.req(send,req);
							
						}
						break;
						
				case 4:	System.out.println("Enter no of blood bag required to search");
				no=in.nextInt();
				for(i=0;i<no;i++)
				{
					System.out.println("Enter\n1:A+\t2:A-\t3:B+\t4:B-\t5:AB+\t6:AB-\t7:O-\t8:O+");
					ch=in.nextInt();
					switch(ch)
					{
					
						case 1:
						     bloodGroup="A+";
						break;
						
						case 2:	
						 		bloodGroup="A-";
						break;
						
						case 3:
							  bloodGroup="B+";
						break;
						
						case 4:
								bloodGroup="B-";
						break;
						
					
						case 5:
								bloodGroup="AB+";
						break;
						
						case 6:
							bloodGroup="AB-";
						break;
						
						case 7:
								bloodGroup="O-";
						break;
						
						case 8:
								bloodGroup="O+";
						break;
					}
					s.printInfo(bloodGroup);
					
				}
				break;	
				
				case 5:pri.printDonars();
				break;
				
				case 6:pri.countAllDonar();
				break;
				
				case 7:System.exit(0);
				break;
						
			}
		}
		
		
	}

}


