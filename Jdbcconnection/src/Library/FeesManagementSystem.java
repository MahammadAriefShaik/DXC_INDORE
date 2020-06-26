package Library;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

class jdbc<T> {
	T obj;

	void create(T obj) { 
		this.obj = obj;
	}

	T getInstance() { 
		return obj;
	}
}
	public class FeesManagementSystem {

		Admin mAdmin=null;
		Accountant mAccountant=null;
		InputStreamReader isr = null;
		BufferedReader buff = null;

		public static void main(String[] args) throws Exception 
		{	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql//localhost:3306/fms_db","root","root");

			FeesManagementSystem mObject=new FeesManagementSystem();

			mObject.isr = new InputStreamReader(System.in);
			mObject.buff = new BufferedReader(mObject.isr);

			System.out.println(" The Fees Managment System \n\n");
			System.out.println("Enter your Choice : ");
			System.out.println("1. AdminLogIn \n2. Accountant");

			String mChoice=mObject.buff.readLine();

			if (mChoice.equalsIgnoreCase("1")) 
			{
				System.out.println("Enter Your UserName : ");
				String uName=mObject.buff.readLine();
				System.out.println("Enter Your Password : ");
				String passWord=mObject.buff.readLine();
				if (uName.equals("Admin") && passWord.equals("admin123")) 
				{
					jdbc<Admin> obj = new jdbc<Admin>();
					obj.create(new Admin());
					mObject.mAdmin = obj.getInstance();
					System.out.println("1. AddAccountant\n2. ViewAccountant \n3. LogOut");
					String opaChoice=mObject.buff.readLine();
					switch (Integer.parseInt(opaChoice)) 
					{
						case 1 :  mObject.mAdmin.addAccountant(mObject.buff,con);
						          break;

						case 2 :  mObject.mAdmin.viewAccountant(mObject.buff,con);
				          		  break;

						case 3 :  System.exit(0);
				          		  break;

						default:  System.out.println("* Sorry You Have Enterd a Wrong Choice *");

						break;
					}
				}
			}
			else if(mChoice.equalsIgnoreCase("2"))
			{
				jdbc<Accountant> obj = new jdbc<Accountant>();
				obj.create(new Accountant());
				mObject.mAccountant = obj.getInstance();
				System.out.println("1. Add Student\n2. View Student\n3. Edit Student\n4. LogOut");
				String opaChoice=mObject.buff.readLine();
				switch (Integer.parseInt(opaChoice)) 
				{
					case 1 :  mObject.mAccountant.addStudent(mObject.buff,con);
					          break;

					case 2 :  mObject.mAccountant.viewStudent(mObject.buff,con);
			          		  break;

					case 3 :  mObject.mAccountant.editStudent(mObject.buff,con);
	          		  		  break; 		  

					case 4 :  System.exit(0);
	          		  		  break;

					default:  System.out.println(" You Have Enterd a Wrong Choice ");
							  break;
				}
			}
		}
}