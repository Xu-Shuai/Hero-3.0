package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.MyEquipment;
import model.MyEquipmentMeranag;

/**
 * Servlet implementation class hero_yxServlet
 */
@WebServlet("/yx")
public class hero_yxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hero_yxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Hero_yxManager hero=new Hero_yxManager();
		int cp=Integer.parseInt(request.getParameter("cp"));
		List<Hero_yx> heros_yx=new ArrayList<Hero_yx>();
		heros_yx=hero.allHero(cp);
		request.setAttribute("heros_yx", heros_yx);
		RequestDispatcher dis=request.getRequestDispatcher("/main/yx.jsp");	
		dis.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		String herosName = request.getParameter("herosName");
		String herosNickName = request.getParameter("herosNickName");
		String herosImgM = "/image-yx/"+request.getParameter("herosImgM");
		String herosImgB = "/image-yx/"+request.getParameter("herosImgB");
		String herosDesc = request.getParameter("herosDesc");
		Hero_yxManager hero=new Hero_yxManager();
		
		PrintWriter out = response.getWriter();
        out.println("<response>");
        boolean isExists;
        isExists = hero.findByUsername(herosName);
        
       if(isExists){
              out.println("<res>" + "用户名已存在" + "</res>");
       }else{
              out.println("<res></res>");
       }
       
        out.println("</response>");
        out.close();
		
		
		Hero_yx hero_yx = new Hero_yx();
		hero_yx.setHerosName(herosName);
		hero_yx.setHerosNickName(herosNickName);
		hero_yx.setHerosImgM(herosImgM);
		hero_yx.setHerosImgB(herosImgB);
		hero_yx.setHerosDesc(herosDesc);
		hero.addHero(hero_yx);
		
		List<Hero_yx> heros_yx = new ArrayList<Hero_yx>();
		heros_yx = hero.allHero(1);
		request.setAttribute("heros_yx", heros_yx);
		RequestDispatcher dis = request.getRequestDispatcher("/main/yx.jsp");
		dis.forward(request, response);
	}

}
