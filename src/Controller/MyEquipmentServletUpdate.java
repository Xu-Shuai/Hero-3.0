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
 * Servlet implementation class MyEquipmentServletUpdate
 */
@WebServlet("/xsUpdate")
public class MyEquipmentServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEquipmentServletUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyEquipmentMeranag mem=new MyEquipmentMeranag();
		//转码
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");//从表单获得英雄name
		String bd = request.getParameter("bd");//从表单获得英雄name
		String sx = request.getParameter("sx");//从表单获得英雄name
		Integer id=Integer.parseInt(request.getParameter("id"));
		MyEquipment myEquipment=new MyEquipment();
		myEquipment.setId(id);
		myEquipment.setName(name);
		myEquipment.setBd(bd);
		myEquipment.setSx(sx);
		mem.modifyMyhero(myEquipment);
		
		List<MyEquipment> myEquipments=new ArrayList<MyEquipment>();
		myEquipments=mem.allMusic();
		request.setAttribute("myEquipments", myEquipments);
		RequestDispatcher dis=request.getRequestDispatcher("/xs");	
		dis.forward(request, response);
	}

}
