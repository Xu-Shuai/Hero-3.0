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
    //查询单个装备信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//转码
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));//从表单获得英雄id
		MyEquipmentMeranag mem=new MyEquipmentMeranag();
		List<MyEquipment> myEquipments=new ArrayList<MyEquipment>();
		myEquipments=mem.oneEquipment(id);
		request.setAttribute("oneEquipments", myEquipments);
		
		MyEquipmentMeranag mem01=new MyEquipmentMeranag();
		List<MyEquipment> myEquipments01=new ArrayList<MyEquipment>();
		myEquipments01=mem01.allZb(1);
		request.setAttribute("myEquipments", myEquipments01);
		
		RequestDispatcher dis=request.getRequestDispatcher("/main/xs.jsp");	
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
