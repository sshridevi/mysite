package assign.dbaccess;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

 
/**
 * 
 * DBAccess
 *
 */

public class EMailDBAccess {
 
	/**
	 * No Argument Constructor
	 */
	public EMailDBAccess() {
		super();
	}

//Getting Connection using MS Access

	public static Connection getConnection() throws Exception{
			Connection dbConn = null;
	    try{
		String url = "jdbc:mysql://localhost:3307/durgadb";
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConn = DriverManager.getConnection(url, "root", "root");
		}
	     catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	return dbConn;
	}


//	Getting Connection

// Getting Connection using Oracle
//		public static Connection getConnection() throws Exception{
//				Connection dbConn = null;
//		    try{
//		    Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@servername:1521:dbname)";
//			dbConn = DriverManager.getConnection(url, "userid","password");
//			}
//		     catch (SQLException sqle) {
//			   sqle.printStackTrace();
//			   throw sqle;
//			}
//	             catch(Exception e) {
//			   e.printStackTrace();
//			   throw e;
//			}
//		return dbConn;
//		}
// Connection Using MYSQL	
//	public static Connection getConnection() throws Exception{
//		Connection dbConn = null;
//    try{
//    //step1:
//    Class.forName("com.mysql.jdbc.Driver");
//	//step2
//    String url = "jdbc:mysql://localhost:3306/test";
//	//step3
//	dbConn = DriverManager.getConnection(url, "root", "root");
//	}
//     catch (SQLException sqle) {
//	   sqle.printStackTrace();
//	   throw sqle;
//	}
//         catch(Exception e) {
//	   e.printStackTrace();
//	   throw e;
//	}
//return dbConn;
//}
// EMailAddress Queries
 
	//public int add(int i, int j)
	public static EMailAddressVOO getEMailAddress(String inEMailID) throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    EMailAddressVOO eMailAddress = null;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM emailaddress WHERE emailaddress = ?");
		pStmt.setString(1, inEMailID);
   		rs = pStmt.executeQuery();

		if (rs.next()) {
		eMailAddress = new EMailAddressVOO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));

		System.out.println(eMailAddress.getfName());
                System.out.println(eMailAddress.gethPhone());

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		}
             catch(Exception e) {
		   e.printStackTrace();
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return eMailAddress;
	}

	public static void addEMailAddress(EMailAddressVOO inEMailAddress) throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO emailaddress  VALUES (?,?,?,?,?,?,?,?)");
		
		pStmt.setString(1, inEMailAddress.geteMailID());
		pStmt.setString(2, inEMailAddress.getfName());
		pStmt.setString(3, inEMailAddress.getmName());
		pStmt.setString(4, inEMailAddress.getlName());
		pStmt.setString(5, inEMailAddress.gethPhone());
		pStmt.setString(6, inEMailAddress.getwPhone());
		pStmt.setString(7, inEMailAddress.getmPhone());
		pStmt.setString(8, inEMailAddress.getgroupID());
		
   		rowsInserted = pStmt.executeUpdate();

		if (rowsInserted != 1) {
			throw new Exception("Error in inserting the row");

   		}
	     	}catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}


	public static void updateEMailAddress(EMailAddressVOO inEMailAddress) throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("UPDATE emailaddress SET firstname = ?, middlename = ?, lastname = ?, homephoneno = ?, workphoneno = ?, mobileno = ?, groupid = ? where emailaddress = ?");
		pStmt.setString(1, inEMailAddress.getfName());
		pStmt.setString(2, inEMailAddress.getmName());
		pStmt.setString(3, inEMailAddress.getlName());
		pStmt.setString(4, inEMailAddress.gethPhone());
		pStmt.setString(5, inEMailAddress.getwPhone());
		pStmt.setString(6, inEMailAddress.getmPhone());
		pStmt.setString(7, inEMailAddress.getgroupID());
		pStmt.setString(8, inEMailAddress.geteMailID());
		
   		rowsUpdated = pStmt.executeUpdate();

		if (rowsUpdated != 1) {
			throw new Exception("Error in updating the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	public static void deleteEMailAddress(String inEMailID) throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsDeleted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("DELETE FROM emailaddress WHERE emailaddress = ?"); 
		pStmt.setString(1, inEMailID);
		
   		rowsDeleted = pStmt.executeUpdate();

		if (rowsDeleted != 1) {
			throw new Exception("Error in deleting the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	public static ArrayList getAllEMailAdressEntries() throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    ArrayList eMailList = new ArrayList();
	    EMailAddressVOO eMailAddress = null;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM emailaddress");

   		rs = pStmt.executeQuery();

		while (rs.next()) {
		eMailAddress = new EMailAddressVOO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
		eMailList.add(eMailAddress);
		System.out.println(eMailAddress.getfName());
                System.out.println(eMailAddress.gethPhone());

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return eMailList;
	}

	public static ArrayList getAllEMailAdressEntriesbyGroup(String inGroupID) throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
        ResultSet rs = null;
	    ArrayList eMailList = new ArrayList();
	    EMailAddressVOO eMailAddress = null;

	    try {
	    	dbConn = getConnection();
	    	pStmt = dbConn.prepareStatement("SELECT * FROM emailaddress WHERE groupid = ?");
	    	pStmt.setString(1, inGroupID);
	    	rs = pStmt.executeQuery();

	    	while (rs.next()) {
	    		eMailAddress = new EMailAddressVOO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
	    		eMailList.add(eMailAddress);
	    		System.out.println(eMailAddress.getfName());
                System.out.println(eMailAddress.gethPhone());

	    	}
	     } catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		} catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		} finally {
			rs.close();
			pStmt.close();
			dbConn.close();
	    }
	    
		return eMailList;
	}

// Group Queries

	public static Group getGroup(String inGroupID) throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    Group group = null;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM Groups WHERE groupid = ?");
		pStmt.setString(1, inGroupID);
   		rs = pStmt.executeQuery();

		if (rs.next()) {
		group = new Group(rs.getString(1), rs.getString(2));

		System.out.println(group.getgroupID());
                System.out.println(group.getgName());

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return group;
	}

	public static void addGroup(Group inGroup)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO groups VALUES (?,?)");
		pStmt.setString(1, inGroup.getgroupID());
		pStmt.setString(2, inGroup.getgName());
		
   		rowsInserted = pStmt.executeUpdate();

		if (rowsInserted != 1) {
			throw new Exception("Error in inserting the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}
 
	public static void updateGroup(Group inGroup)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("UPDATE groups SET groupId=?, firstname=?");

		pStmt.setString(1, inGroup.getgroupID());
		pStmt.setString(2, inGroup.getgName());
		
   		rowsUpdated = pStmt.executeUpdate();

		if (rowsUpdated != 1) {
			throw new Exception("Error in updating the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	public static void deleteGroup(String inGroupID) throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsDeleted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("DELETE FROM groups WHERE groupid = ?");
		pStmt.setString(1, inGroupID);
		
   		rowsDeleted = pStmt.executeUpdate();

		if (rowsDeleted != 1) {
			throw new Exception("Error in delete the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	public static ArrayList getAllGroupEntries() throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    ArrayList groupList = new ArrayList();
	    Group group = null;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM Groups");

   		rs = pStmt.executeQuery();

		if (rs.next()) {
		group = new Group(rs.getString(1), rs.getString(2));
		groupList.add(group);
		System.out.println(group.getgroupID());
                System.out.println(group.getgName());
   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return groupList;
	}

public static void main(String[] arg){
	EMailDBAccess eMailDBAccess = new EMailDBAccess();
	try{
	eMailDBAccess.getEMailAddress("aa@yahoo.com");
	} catch (Exception e){
		e.printStackTrace();
	}
}
}
 
