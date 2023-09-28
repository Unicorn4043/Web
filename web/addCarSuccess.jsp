<%-- 
    Document   : addCarSuccess
    Created on : 13 ก.ค. 2566, 16:05:49
    Author     : SciLab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Car" %>

<h2>เพิ่มรถยนต์</h2>

<%
   Car car = (Car) session.getAttribute("car");
    out.println("ข้อมูลรถ: " + car.getName() + ", " + car.getType()+", ");
    for(String n : car.getNutrient()){
        out.print(n + " ");
    }
    out.println(car.getdrive() + "," + car.getPrice() + car.getURL() +"<br/>");
%>
<br/>
<a href="updateCar.jsp">เพิ่มข้อมูลรถอีก<a/>
<a href="index.html">home<a/>