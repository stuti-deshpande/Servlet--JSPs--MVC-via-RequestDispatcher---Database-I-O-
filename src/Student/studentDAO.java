package Student;
import java.sql.*;



public class studentDAO {
	
	    public Connection con=null;
	    
	    public studentDAO(){
	        try{
	        	System.out.println("trying server connect");
	        	Class.forName ("oracle.jdbc.driver.OracleDriver");
	        con = DriverManager.getConnection ("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g","sdeshpa2", "zeezoo");
	        }
	        catch(Exception e){
	        	System.out.println("Cannot connect to the server");
	        	e.printStackTrace();
	        }
	    }


public studentBean retrieveData(String Student_Id){
	Statement stmt = null;
	studentBean sb1=null;

	try
	{
		System.out.println("Creating statement...");
		stmt = con.createStatement();
		String sql;
	      sql = "select * from surveydetails where STUDENT_ID= '"+ Student_Id +"'";
	     ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next())
	      {
	    	  String studentid = rs.getString("STUDENT_ID");
	          String firstname = rs.getString("fstname");
	          //String lastname = rs.getString("lastname");
	          String telno = rs.getString("phone");
	          String street1 = rs.getString("street1");
	          String street2 = rs.getString("street2");
	          String city = rs.getString("city");
	          String state = rs.getString("state");
	          String zip = rs.getString("zip");
	          String email = rs.getString("email");
	          String likes = rs.getString("likemost");
	          String site = rs.getString("howtosite");
	          String data = rs.getString("numbers");
	          String mean = rs.getString("mean");
	          String sd = rs.getString("SD");
	          String URL=rs.getString("URL");
	          String Likelihood=rs.getString("Likelihood");
	          String date=rs.getString("DOS");
	          String GradMonth=rs.getString("GradMonth");
	          String Year=rs.getString("Year");
	          String comments=rs.getString("comments");
	          
	          sb1=new studentBean();
	          sb1.setStudentID(studentid);
	          sb1.setFirstName(firstname);
	          //sb1.setLastName(lastname);
	          sb1.setStreet1(street1);
	          sb1.setStreet2(street2);
	          sb1.setTelephonenum(telno);
	          sb1.setEmail(email);
	          sb1.setZip(zip);
	          sb1.setState(state);
	          sb1.setCity(city);
	          sb1.setLikeMost(likes);
	          sb1.setHowToSite(site);
	          sb1.setData(data);
	          sb1.setMean(mean);
	          sb1.setSd(sd);
	          sb1.setURL(URL);
	          sb1.setLikelihood(Likelihood);
	          sb1.setGradMonth(GradMonth);
	          sb1.setYear(Year);
	          sb1.setComments(comments);
	          sb1.setDate(date);
	          
	      }
	}
	          
	          catch(Exception e){
	          	System.out.println("Unable to retreive data");
	          	e.printStackTrace();
	          }
	       
	          return sb1;
}

	      


public void storeData(String STUDENT_ID,String fstname,String street1, String street2, String zip, String city,String state,String email,String phone,String URL,String DOS,String numbers,String howtosite,String GradMonth,String Year,String Likelihood,String mean,String SD,String likemost,String comments) throws SQLException{

{
	try{
		Statement stmt= con.createStatement();
		String sql="insert into surveydetails values ('"+STUDENT_ID+"','"+fstname+"','"+street1+"','"+street2+"','"+zip+"','"+city+"','"+state+"','"+email+"','"+phone+"','"+URL+"','"+numbers+"','"+howtosite+"','"+GradMonth+"','"+Year+"','"+Likelihood+"','"+mean+"','"+SD+"','"+likemost+"','"+comments+"','"+DOS+"')";
		stmt.executeUpdate(sql);

	
	     
}
catch(Exception e){
	System.out.println("Cannot store data in database");
	e.printStackTrace();
}
}
}
	
	
	public String  getStudentId(){
		
		ResultSet rs =null;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<ul>");
	try
	{
		Statement stmt= con.createStatement();
		String sql1="select STUDENT_ID from surveydetails";
		rs=stmt.executeQuery(sql1);
		while(rs.next()){
			stringBuilder.append("<li><a href='Myservlet?STUDENT_ID="+ rs.getString("Student_ID") +"'>"+rs.getString("Student_ID")+"</a></li>");
		}
		stringBuilder.append("</ul>");
		con.close();
	} catch (Exception e) {
		System.out.println("Cannot get student ID's: "+e.getMessage());
		e.printStackTrace();
	}
	return stringBuilder.toString();
}
		
	
	


}



