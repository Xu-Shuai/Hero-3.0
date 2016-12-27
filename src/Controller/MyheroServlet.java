package Controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyheroManager;

/**
 * Servlet implementation class myhero
 */
@WebServlet("/myhero")
public class MyheroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyheroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * 显示某一个英雄，查看和编辑某一个英雄时都会用到这个方法。
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyheroManager manager = new MyheroManager();//生成管理对象manager.
		int id = Integer.parseInt(request.getParameter("id"));//从get的url获得id,以得到hero
		String isChange = request.getParameter("is_change");//从get的url获得is_change的值,以判断是要查看还是编辑一个英雄。
		String directPage = "";//将要转向的页面。
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * 显示某一个英雄，查看和编辑某一个英雄时都会用到这个方法。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
