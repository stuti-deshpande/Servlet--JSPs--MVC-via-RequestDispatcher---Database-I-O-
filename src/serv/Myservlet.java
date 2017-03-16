package serv;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Student.dataBean;
import Student.dataProcessor;
import Student.studentBean;
import Student.studentDAO;
import java.sql.*;

@WebServlet(name = "HW4", urlPatterns = { "/Myservlet" })
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			
			String Stud_Id = request.getParameter("STUDENT_ID");
			studentDAO st2 = new studentDAO();
			studentBean Sb2 = st2.retrieveData(Stud_Id);
			HttpSession session = request.getSession();
			session.setAttribute("sb2", Sb2);
			RequestDispatcher dispatcher;
			if(Sb2!=null){
			 dispatcher = request
					.getRequestDispatcher("/JSP/StudentJSP.jsp");
			dispatcher.forward(request, response);
			}
			else
			
			{
				dispatcher = request
						.getRequestDispatcher("/JSP/NoSuchStudent.jsp");
				dispatcher.forward(request, response);
			}
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception caught ");
			e.printStackTrace();
	}
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
		try {
			
			
			
			
			
			
			
			response.setHeader("Access-Control-Allow-Origin",
					"http://mason.gmu.edu");
			String Data = request.getParameter("Data").toString();
			dataProcessor DP = new dataProcessor();
			dataBean DB = DP.compute(Data);
			String Mean = Double.toString(DB.getMean());
			String SD = Double.toString(DB.getSd());
			String Studid = request.getParameter("StudentID");
			String Fname = request.getParameter("FirstName");
			//String Lname = request.getParameter("LastName");
			String Street1 = request.getParameter("street1");
			String Street2 = request.getParameter("Street2");
			String ZipCode = request.getParameter("zip");
			String City = request.getParameter("City");
			String State = request.getParameter("State");
			String Email = (String) request.getParameter("Email");
			String Tnum = request.getParameter("TelephoneNumber");
			String URL = request.getParameter("url");
			String DOS = request.getParameter("date");
			String HowtoSite = request.getParameter("Howtosite");
			String GradMonth = request.getParameter("GradMonth");
			String Year = request.getParameter("Year");
			String comments = request.getParameter("comments");
			String Likelihood = request.getParameter("Likelihood");
			String[] LikeMost = request.getParameterValues("LikeMost");
			String Like = "";
			for (int i = 0; i < LikeMost.length; i++) {
				Like += LikeMost[i] + " ";

			}
			studentDAO St = new studentDAO();
			St.storeData(Studid, Fname, Street1, Street2, ZipCode, City,
					State, Email, Tnum, URL, DOS, Data, HowtoSite, GradMonth,
					Year, Likelihood, Mean, SD, Like,comments);

			HttpSession session = request.getSession();
			session.setAttribute("db1", DB);
			String UnOrderedList = St.getStudentId();
			session.setAttribute("unOrderedList", UnOrderedList);
			System.out.println(UnOrderedList);
			RequestDispatcher dispatcher;
			if (DB.getMean() >= 90) {
				dispatcher = request
						.getRequestDispatcher("/JSP/winnerAcknowledgement.jsp");
			} else {
				dispatcher = request
						.getRequestDispatcher("/JSP/simpleAcknowledgement.jsp");
			}
			
			
			
			
			
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception caught ");
			e.printStackTrace();

		}
	}
}
