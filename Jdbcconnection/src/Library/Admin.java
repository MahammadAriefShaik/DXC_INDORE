package Library;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Admin
{
	Admin an=null;
	InputStreamReader isr = null;
	BufferedReader buff = null;

	public void addAccountant(BufferedReader buff,java.sql.Connection con) throws Exception
	{	
		an.isr = new InputStreamReader(System.in);
		an.buff = new BufferedReader(an.isr);

		System.out.println("Enter Accountant Name : ");
		String ename=buff.readLine();

		System.out.println("Enter Accountant Email : ");
		String email=buff.readLine();

		System.out.println("Enter Accountant PassWord : ");
		String psd=buff.readLine();

		System.out.println("Enter Accountant ContactNo : ");
		String cont=buff.readLine();

		PreparedStatement stmtInsert = con.prepareStatement("insert into accountant_db values(?,?,?,?)");

		stmtInsert.setString(1, ename);
		stmtInsert.setString(2, email);
		stmtInsert.setString(3, psd);
		stmtInsert.setString(4, cont);

		System.out.println(stmtInsert.executeUpdate() + " ");

	}

	public void viewAccountant(BufferedReader buff,java.sql.Connection con) throws Exception
	{
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from accountant_db");

		while (rs.next())
		{
			System.out.println(rs.getString(1) + " ======= " + rs.getString(2) + " ====== " + rs.getString(3) + " ====== " + rs.getString(4));
		}
	}
}
