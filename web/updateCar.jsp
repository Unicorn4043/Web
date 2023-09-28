<%-- 
    Document   : updateFood
    Created on : Jan 21, 2019, 7:50:23 PM
    Author     : Wasana Ngaogate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.Car" %>

<h2>แก้ไขรถยนต์</h2>

<%
   Car car = (Car) session.getAttribute("car");
    out.println("ข้อมูลเดิม: " + car.getName() + ", " + car.getType()+", ");
    for(String n : car.getNutrient()){
        out.print(n + " ");
    }
    out.println(car.getdrive() + "," + car.getPrice() + ","+car.getURL() + "<br/>");
%>

<form action="AddNewCar">
    <table>
        <tr><td>ชื่อ:</td>
            <td><input type="text" name="car" value="<%= car.getName() %>"></td>
        <tr><td>ประเภท:</td>
            <td>
                <select name="cartype">
                    <option value="ซีดาน">ซีดาน</option>
                    <option value="คูเป้">คูเป้</option>
                    <option value="เอสยูวี">เอสยูวี</option>  
                </select>
            </td>
        </tr>
        <tr><td>ระบบเกียร์รถยนต์:</td>
            <td>
                <input type="checkbox" name="nutrient" value="เกียร์ออโต้">เกียร์ออโต้
                <input type="checkbox" name="nutrient" value="เกียร์แมนนวล">เกียร์แมนนวล<br>
                <input type="checkbox" name="nutrient" value="เกียร์กึ่งอัตโนมัติ">เกียร์กึ่งอัตโนมัติ
                <input type="checkbox" name="nutrient" value="เกียร์ออโต้ แบบคลัทช์คู่">เกียร์ออโต้ แบบคลัทช์คู่<br>
            </td>
        </tr>
        <tr><td>ระบบขับเคลื่อน:</td>
            <td>
                <input type="radio" name="drive" value="2 ล้อ">2 ล้อ
                <input type="radio" name="drive" value="4 ล้อ">4 ล้อ
            </td>
        </tr>
        <tr><td>ราคา:</td><td><input type="text" name="price" value="<%= car.getPrice() %>"></td></tr>
        <tr><td>ลิ้งเว็ปไซต์:</td><td><input type="text" name="ีurl"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" value="เพิ่มรถยนต์"></td></tr>
    </table>
</form>
        
<% session.removeAttribute("car"); %>