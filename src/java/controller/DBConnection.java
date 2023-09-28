
package controller;

import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.Arrays;
import model.Car;
/**
 *
 * @author SciLab
 */
public class DBConnection {
       public boolean insertNewCar(Car car) {
        boolean result = false;
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car",
                    "root", "1234");

            Statement statement;
            statement = connection.createStatement();

            // สร้าง String nutrient ที่มีค่าสารอาหารต่าง ๆ คั่นด้วย ;
            String nutrient = "";
            int nl = car.getNutrient().length;
            
            // วนลูปสร้างแค่ food.getNutrient().length ลบ 1 เพื่อไม่ให้มี ; ปิดท้าย String
            for(int i=0; i < nl - 1; i++){
                nutrient = nutrient + car.getNutrient()[i] + ";";
            }
            // เพิ่มค่า nutrient ตำแหน่งสุดท้ายเข้าไป
            nutrient = nutrient + car.getNutrient()[nl-1];
            
            String query = "INSERT INTO car "
                    + "(name, type, nutrient, drive, price,url) "
                    + "VALUES('"
                    + car.getName() + "','"
                    + car.getType() + "','"
                    + nutrient + "','"
                    + car.getdrive() + "',"
                    + car.getPrice() + ")"
                    + car.getURL() + "',";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);	// executeUpdate returns row count ****
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return result;

    }
  public void testRetrieve() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car",
                    "root", "1234");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select name from car");
            String name;
            while (resultSet.next()) {
                name = resultSet.getString("name").trim();
                System.out.println(" name : " + name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

   

public Car getCar(String name) {
    Car car = new Car();
    Connection connection = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car",
                "root", "1234");

        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet;
        String query = "SELECT * FROM car WHERE name='" + name + "'";
        System.out.println(">>>>>>>>>> query=" + query);

        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            car.setName(resultSet.getString("name"));
            car.setType(resultSet.getString("type"));
            car.setdrive(resultSet.getString("drive"));
            car.setPrice(resultSet.getInt("price"));
            car.setURL(resultSet.getString("url"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (ClassNotFoundException | SQLException exception) {
        System.out.println(exception);
    }

    // Set default values for empty fields
    if (car.getName() == null || car.getName().isEmpty()) {
        car.setName("Default Name");
    }
    if (car.getType() == null || car.getType().isEmpty()) {
        car.setType("Default Type");
    }
    if (car.getdrive() == null || car.getdrive().isEmpty()) {
        car.setdrive("Default Drive");
    }
     if (car.getURL() == null || car.getURL().isEmpty()) {
        car.setURL("Default URL");
    }

    return car;


    }   

}


