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
	 * ��ʾĳһ��Ӣ�ۣ��鿴�ͱ༭ĳһ��Ӣ��ʱ�����õ����������
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MyheroManager manager = new MyheroManager();//���ɹ������manager.
		int id = Integer.parseInt(request.getParameter("id"));//��get��url���id,�Եõ�hero
		String isChange = request.getParameter("is_change");//��get��url���is_change��ֵ,���ж���Ҫ�鿴���Ǳ༭һ��Ӣ�ۡ�
		String directPage = "";//��Ҫת���ҳ�档
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * ��ʾĳһ��Ӣ�ۣ��鿴�ͱ༭ĳһ��Ӣ��ʱ�����õ����������
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
