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
    //分页显示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int cp=Integer.parseInt(request.getParameter("cp"));
		MyEquipmentMeranag mem=new MyEquipmentMeranag();		
		List<MyEquipment> myEquipments=new ArrayList<MyEquipment>();
		myEquipments=mem.allZb(cp);
		request.setAttribute("myEquipments", myEquipments);
		RequestDispatcher dis=request.getRequestDispatcher("/main/xs.jsp");	
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//修改
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
		myEquipments=mem.allZb(1);
		request.setAttribute("myEquipments", myEquipments);
		RequestDispatcher dis=request.getRequestDispatcher("/main/xs.jsp");	
		dis.forward(request, response);
	}

}
