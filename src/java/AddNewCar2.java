
import controller.DBConnection;
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
import model.Car;
/**
 *
 * @author User
 */
@WebServlet(urlPatterns = {"/AddNewCar2"})
public class AddNewCar2 extends HttpServlet {

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

        try {
            HttpSession session = request.getSession();
            Car car = (Car) session.getAttribute("car");

            if (car == null) {
                // get food detail
                String carname = request.getParameter("carname");
                String cartype = request.getParameter("cartype");
                String nutrient[] = request.getParameterValues("nutrient");
                String drive = request.getParameter("drive");
                int price = Integer.parseInt(request.getParameter("price"));

                car = new Car();
                car.setName(carname);
                car.setType(cartype);
                car.setNutrient(nutrient);
                car.setdrive(drive);
                car.setPrice(price);
                session.setAttribute("car", car);

                // print page "แก้ไข"
                out.println("<html><body>");
                out.println("<form action='AddNewCar2'>");
                out.println("new car is submited.</br>");
                out.println("<input type='submit' value='แก้ไข 1'>");
                out.println("<br/><a href='dashboard.html'>home</a>");
                out.println("</form></body></html>");
                
            } else {
                out.println("<html><body>");                
                out.println("แก้ไขรถยนต์:<br/> ");
                out.println("<form action='AddNewCar2'>");
                out.println("ชื่อ: <input type='text' value='" + car.getName() + "' name='carname'><br/>");
               
                out.println("<select name='cartype'>");
                String gettype = car.getType();
                String a1 = "ซีดาน";
                String a2 = "คูเป้";
                String a3 = "เอสยูวี";
                
                if (gettype.equals(a1)) {
                    a1 = "selected";
                    a2 = " ";
                    a3 = " ";
                } else if (gettype.equals(a2)) {
                    a2 = "selected";
                    a1 = " ";
                    a3 = " ";
                } else if (gettype.equals(a3)) {
                    a3 = "selected";
                    a2 = " ";
                    a1 = " ";
                } else {
                }
                out.println("<option value='ซีดาน' " + a1 + " >ซีดาน</option>");
                out.println("<option value='คูเป้' " + a2 + " >คูเป้</option>");
                out.println("<option value='เอสยูวี' " + a1 + " >เอสยูวี</option></select></br>");
               
                String getan[] = car.getNutrient();
                String cb1 = "เกียร์ออโต้";
                String cb2 = "เกียร์แมนนวล";
                String cb3 = "เกียร์กึ่งอัตโนมัติ";
                String cb4 = "เกียร์ออโต้ แบบคลัทช์คู่";
                

                for (String an : getan) {
                    if (an.equals(cb1)) {
                        cb1 = "เกียร์ออโต้' checked";
                    } else if (an.equals(cb2)) {
                        cb2 = "เกียร์แมนนวล' checked";
                    } else if (an.equals(cb3)) {
                        cb3 = "เกียร์กึ่งอัตโนมัติ' checked";
                    } else if (an.equals(cb4)) {
                        cb4 = "เกียร์ออโต้ แบบคลัทช์คู่' checked";
                    }
                }
        
                out.println("</select></br><br/> <span>ระบบเกียร์รถยนต์</span><br/>");
                out.println("<input type='checkbox' id='cb1' name='Nutrient'  value='" + cb1 +">");
                out.println("<label for='cb1'>เกียร์ออโต้</label><br/>");
                out.println("<input type='checkbox' id='cb2' name='Nutrient' value='" + cb2 +">");
                out.println("<label for='cb2'>เกียร์แมนนวล</label><br/>");
                out.println("<input type='checkbox' id='cb3' name='Nutrient' value='" + cb3 +">");
                out.println("<label for='cb3'>เกียร์กึ่งอัตโนมัติ</label><br/><br/>");
                out.println("<input type='checkbox' id='cb4' name='Nutrient' value='" + cb4 +">");
                out.println("<label for='cb4'>เกียร์ออโต้ แบบคลัทช์คู่</label><br/><br/>");
                
                
                 String getsize = car.getdrive();
                String s1 = "2 ล้อ";
                String s2 = "4 ล้อ";

                if (getsize.equals(s1)) {
                    s1 = "2 ล้อ' checked";
                } else if (getsize.equals(s2)) {
                    s2 = "4 ล้อ' checked";
                }
                out.println("ระบบขับเคลื่อน:");
                out.println("<input type='radio' id='2' name='drive' value='" + s1 + ">");
                out.println("<label for='2'>2 ล้อ</label><br/>");
                out.println("<input type='radio' id='4' name='drive' value='" + s2 + ">");
                out.println("<label for='4'>4 ล้อ</label><br/>");
           
                out.println("ราคา:");
                out.println("<input type='text' name='price'></br>");
                out.println("ลิ้งเว็ปไซต์:");
                out.println("<input type='text' name='url'></br>");
                out.println("<form action='AddNewCar2'>");
                out.println("<input type='submit' value='แก้ไข 2'>");
                
                out.println("</form>");
                out.println("</body></html>");
                session.removeAttribute("car");
            }
         
         DBConnection dbConnection = new DBConnection();
        if(!dbConnection.insertNewCar(car)){
            System.out.println(">>> AddNewFoodMySQL ERROR");
        }
        
               
        } catch (Exception e) {
            e.printStackTrace();
        }

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
