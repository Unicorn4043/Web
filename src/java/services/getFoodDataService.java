/*
Demo web services
servlet class: getFoodDataService.java
aim: to provide JSON food data via REST
author: wasana ngaogate
date: 22 July 2023
 */
package services;

import controller.DBConnection;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import org.json.JSONArray;
import org.json.JSONObject;

public class getFoodDataService extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        String requestUrl = request.getRequestURI();
        String name = requestUrl.substring("/getFoodDataService/".length());        
       
        name = URLDecoder.decode( name, "UTF-8" );
        System.out.println(">>>>>>>>>>getFoodDataService: name=" + name);
        
        // retrieve food from MySQL: table food
        DBConnection dbConnection = new DBConnection();
//        String name = "ยำหมูยอ"; 
        Car car = dbConnection.getCar(name);

        if (car != null) {
            String json = "\n";
            json += "\"ชื่อรุ่น\": " + JSONObject.quote(car.getName()) + ",\n";
            json += "\"ประเภทรถ\": " + JSONObject.quote(car.getType()) + ",\n";
            json += "\"ระบบขับเคลื่อน\": " + JSONObject.quote(car.getdrive()) + ",\n";
            json += "\"ราคา\": " + "\n"+ JSONObject.quote(Integer.toString(car.getPrice()));
            json += "\"ลิ้ง\": " + JSONObject.quote(car.getURL()) + ",\n";
            json += "";
          
            // ERROR: java.io.CharConversionException: Not an ISO 8859-1 character:
//            response.getOutputStream().println(json);
            // ต้องใช้ response.getWriter()
            
            response.getWriter().print(json);
        } else {
//            response.getOutputStream().println("{}");
            response.getWriter().print("erroe");
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
