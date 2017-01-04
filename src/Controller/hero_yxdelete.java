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

import model.Hero_yx;
import model.Hero_yxManager;

/**
 * Servlet implementation class hero_yxdelete
 */
@WebServlet("/hero_delete")
public class hero_yxdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hero_yxdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        request.setCharacterEncoding("utf-8");
		
		int herosID = Integer.parseInt(request.getParameter("herosID"));
		Hero_yxManager hero1=new Hero_yxManager();
		List<Hero_yx> oneheros_yx1=new ArrayList<Hero_yx>();
		oneheros_yx1=hero1.oneheros_yx(herosID);
		request.setAttribute("oneheros_yx1", oneheros_yx1);
		
		
		Hero_yxManager hero=new Hero_yxManager();
		List<Hero_yx> heros_yx=new ArrayList<Hero_yx>();
		heros_yx=hero.allHero();
		request.setAttribute("heros_yx",heros_yx );
		RequestDispatcher dis=request.getRequestDispatcher("/main/onehero.jsp");	
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hero_yxManager hero1=new Hero_yxManager();
		
		//зЊТы
        request.setCharacterEncoding("utf-8");
		
		int herosID = Integer.parseInt(request.getParameter("herosID"));
		
		hero1.deleteHero(herosID);
		
		Hero_yxManager hero=new Hero_yxManager();		
		List<Hero_yx> heros_yx=new ArrayList<Hero_yx>();
		heros_yx=hero.allHero();
		request.setAttribute("heros_yx", heros_yx);
		RequestDispatcher dis=request.getRequestDispatcher("/main/yx.jsp");	
		dis.forward(request, response);
	}

}
