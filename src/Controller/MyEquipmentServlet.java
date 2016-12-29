package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyEquipment;
import model.MyEquipmentMeranag;

/**
 * Servlet implementation class MyEquipmentServlet
 */
@WebServlet("/xs")
public class MyEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEquipmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyEquipmentMeranag mem=new MyEquipmentMeranag();
		List<MyEquipment> myEquipments=new ArrayList<MyEquipment>();
		myEquipments=mem.allMusic();
		request.setAttribute("myEquipments", myEquipments);
		RequestDispatcher dis=request.getRequestDispatcher("/main/xs.jsp");	
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
