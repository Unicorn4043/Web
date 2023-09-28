<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>เพิ่มรถยนต์</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h2 {
            color: #333;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 20px auto;
        }

        table {
            width: 100%;
        }

        table td {
            padding: 10px;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="checkbox"],
        input[type="radio"] {
            margin-right: 5px;
        }

        input[type="submit"] {
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <h2>เพิ่มรถยนต์</h2>
    <form action="AddNewCar2">
        <table>
           <table>
        <tr><td>ชื่อ:</td><td><input type="text" name="carname"></td>
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
        <tr><td>ราคา:</td><td><input type="text" name="price"></td></tr>
        <tr><td>ลิ้งเว็ปไซต์:</td><td><input type="text" name="ีurl"></td></tr>
        <tr><td>&nbsp;</td><td><input type="submit" value="เพิ่มรถยนต์"></td></tr>
    </table>
        </table>
    </form>
</body>
</html>
