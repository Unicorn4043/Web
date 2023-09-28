import controller.DBConnection;
import model.Car;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wasana Ngaogate
 */
@WebServlet(urlPatterns = {"/AddNewCar"})
public class AddNewCar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String carname = request.getParameter("car");
        String cartype = request.getParameter("cartype");
        String nutrient[] = request.getParameterValues("nutrient");
        String drive = request.getParameter("drive");
        String url = request.getParameter("url");
        int price = Integer.parseInt(request.getParameter("price"));
        out.println("เพิ่มรถยนต์:<br/> " + carname + "<br/>");
        out.println("ประเภทรถ: " + cartype + "<br/>");
        out.print("ระบบเกียร์: ");
        for(String n : nutrient){
            out.print(n + " ");
        }
        out.println("<br/>" + drive + " ราคา " + price + " บาท"+url);
        out.println("<br/><a href='index.html'>home</a>");
        
        Car car = new Car();
        car.setName(carname);
        car.setType(cartype);
        car.setNutrient(nutrient);
        car.setdrive(drive);
        car.setPrice(price);
        car.setURL(url);
        
         
        HttpSession session = request.getSession();
        session.setAttribute("car", car);
        ServletContext sc = getServletContext();
         RequestDispatcher rd = sc.getRequestDispatcher("/addCarSuccess.jsp");
                rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
