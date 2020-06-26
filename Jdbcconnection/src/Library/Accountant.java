package Library;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Accountant 
{
	Accountant acc=null;
	InputStreamReader isr = null;
	BufferedReader buff = null;

	public void addStudent(BufferedReader buff,Connection con) throws Exception
	{	
		acc.isr = new InputStreamReader(System.in);
		acc.buff = new BufferedReader(acc.isr);

		System.out.println("Enter Student Name : ");
		String name=buff.readLine();

		System.out.println("Enter Student Email : ");
		String email=buff.readLine();

		System.out.println("Enter Student Course : ");
		String course=buff.readLine();

		System.out.println("Enter Student Fees : ");
		String fees=buff.readLine();

		System.out.println("Enter Student Paid Fess : ");
		String paid=buff.readLine();

		System.out.println("Enter Student Due Fees : ");
		String due=buff.readLine();

		System.out.println("Enter Student Address : ");
		String address=buff.readLine();

		System.out.println("Enter Student City : ");
		String city=buff.readLine();

		System.out.println("Enter Student State : ");
		String state=buff.readLine();

		System.out.println("Enter Student Country : ");
		String country=buff.readLine();

		System.out.println("Enter Student ContactNo : ");
		String contact=buff.readLine();

		PreparedStatement stmtInsert = con.prepareStatement("insert into student_tb values(?,?,?,?,?,?,?,?,?,?,?)");

		stmtInsert.setString(1, name);
		stmtInsert.setString(2, email);
		stmtInsert.setString(3, course);
		stmtInsert.setString(4, fees);
		stmtInsert.setString(5, paid);
		stmtInsert.setString(6, due);
		stmtInsert.setString(7, address);
		stmtInsert.setString(8, city);
		stmtInsert.setString(9, state);
		stmtInsert.setString(10, country);
		stmtInsert.setString(11, contact);

		System.out.println(stmtInsert.executeUpdate() + " ");

	}

	public void viewStudent(BufferedReader buff,Connection con) throws Exception
	{
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from student_tb");

		while (rs.next())
		{
			System.out.println(rs.getString(1) + " ======= " + rs.getString(2) + " ====== " + rs.getString(3) + " ====== " + rs.getString(4)+ " ====== " + rs.getString(5)+ " ====== " + rs.getString(6)+ " ====== " + rs.getString(7)+ " ====== " + rs.getString(8)+ " ====== " + rs.getString(9)+ " ====== " + rs.getString(10)+ " ====== " + rs.getString(11));
		}
	}

	public void editStudent(BufferedReader buff,Connection con) throws Exception
	{	
		acc.isr = new InputStreamReader(System.in);
		acc.buff = new BufferedReader(acc.isr);


		System.out.println("Enter Your Name = ");
		String name=buff.readLine();

		System.out.println("Enter your Choice : ");
		System.out.println("1. Update Email\n2. Update Course\n3. Update Fees\n4. Update Payment Paid\n5. Update Payment Due\n6. Update Address\n7. Update City\n8. Update State\n9. Update Country\n10. Update ContactNo");
		String ch=buff.readLine();
		switch (Integer.parseInt(ch)) 
		{
		case 1 :	System.out.println("Enter The new Email you want to give : ");
					String nEmail=buff.readLine();
					PreparedStatement stmtUpdate = con.prepareStatement("update student_tb set student_email=? where student_name=?");
					stmtUpdate.setString(1, nEmail); 
					stmtUpdate.setString(2, name); 
					System.out.println(stmtUpdate.executeUpdate() + " No of Student Details Updated");
					break;

		case 2 :	System.out.println("Enter The new Course you want to give : ");
					String nCou=buff.readLine();
					PreparedStatement stmtUpdate1 = con.prepareStatement("update student_tb set student_course=? where student_name=?");
					stmtUpdate1.setString(1, nCou); 
					stmtUpdate1.setString(2, name); 
					System.out.println(stmtUpdate1.executeUpdate() + " No of Student Details Updated");
					break;			

		case 3 :	System.out.println("Enter The new Fees you want to give : ");
					String nFees=buff.readLine();
					PreparedStatement stmtUpdate2 = con.prepareStatement("update student_tb set student_fees=? where student_name=?");
					stmtUpdate2.setString(1, nFees); 
					stmtUpdate2.setString(2, name); 
					System.out.println(stmtUpdate2.executeUpdate() + " No of Student Details Updated");
					break;

		case 4 :	System.out.println("Enter The new Payment Paid Amount you want to give : ");
					String nPPaid=buff.readLine();
					PreparedStatement stmtUpdate3 = con.prepareStatement("update student_tb set student_paid=? where student_name=?");
					stmtUpdate3.setString(1, nPPaid); 
					stmtUpdate3.setString(2, name); 
					System.out.println(stmtUpdate3.executeUpdate() + " No of Student Details Updated");
					break;			

		case 5 :	System.out.println("Enter The new Due Payment Amount you want to give : ");
					String nDpay=buff.readLine();
					PreparedStatement stmtUpdate4 = con.prepareStatement("update student_tb set student_due=? where student_name=?");
					stmtUpdate4.setString(1, nDpay); 
					stmtUpdate4.setString(2, name); 
					System.out.println(stmtUpdate4.executeUpdate() + " No of Student Details Updated");
					break;				

		case 6 :	System.out.println("Enter The new Address you want to give : ");
					String nAdd=buff.readLine();
					PreparedStatement stmtUpdate5 = con.prepareStatement("update student_tb set student_address=? where student_name=?");
					stmtUpdate5.setString(1, nAdd); 
					stmtUpdate5.setString(2, name); 
					System.out.println(stmtUpdate5.executeUpdate() + " No of Student Details Updated");
					break;			

		case 7 :	System.out.println("Enter The new City you want to give : ");
					String nCity=buff.readLine();
					PreparedStatement stmtUpdate6 = con.prepareStatement("update student_tb set student_city=? where student_name=?");
					stmtUpdate6.setString(1, nCity); 
					stmtUpdate6.setString(2, name); 
					System.out.println(stmtUpdate6.executeUpdate() + " No of Student Details Updated");
					break;	

		case 8 :	System.out.println("Enter The new State you want to give : ");
					String nState=buff.readLine();
					PreparedStatement stmtUpdate7 = con.prepareStatement("update student_tb set student_state=? where student_name=?");
					stmtUpdate7.setString(1, nState); 
					stmtUpdate7.setString(2, name); 
					System.out.println(stmtUpdate7.executeUpdate() + " No of Student Details Updated");
					break;

		case 9 :	System.out.println("Enter The new Country you want to give : ");
					String nCountry=buff.readLine();
					PreparedStatement stmtUpdate8 = con.prepareStatement("update student_tb set student_country=? where student_name=?");
					stmtUpdate8.setString(1, nCountry); 
					stmtUpdate8.setString(2, name); 
					System.out.println(stmtUpdate8.executeUpdate() + " No of Student Details Updated");
					break;	

		case 10 :	System.out.println("Enter The new Contact No you want to give : ");
					String nCN=buff.readLine();
					PreparedStatement stmtUpdate9 = con.prepareStatement("update student_tb set student_contactno=? where student_name=?");
					stmtUpdate9.setString(1, nCN); 
					stmtUpdate9.setString(2, name); 
					System.out.println(stmtUpdate9.executeUpdate() + " No of Student Details Updated");
					break;	

		default:
			break;
		}

	}

}