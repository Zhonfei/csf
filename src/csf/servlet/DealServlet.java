package csf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csf.entity.MyForm;
import csf.service.DealService;
import csf.tools.Tools;

/**
 * Servlet implementation class DealServlet
 */
@WebServlet("/DealServlet")
public class DealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".......");
		String tabelName = request.getParameter("tabelName");
		String fieldsName = request.getParameter("fieldsName");
		String beanp = request.getParameter("beanPath");
		String daop = request.getParameter("daoPath");
		String servicep = request.getParameter("servicePath");
		String serviceimplp = request.getParameter("serviceimplPath");
		String controllerp = request.getParameter("controllerPath");
		MyForm form = new MyForm(tabelName,fieldsName,beanp,daop,servicep,serviceimplp,controllerp);
		System.out.println(form);
		if(Tools.objNotNull(form)){
			DealService ds = new DealService();
			try{
				ds.deal(form);
				request.getRequestDispatcher("success.html").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println("ÄÚÈÝÎ´Ìî³äÍêÕû");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
