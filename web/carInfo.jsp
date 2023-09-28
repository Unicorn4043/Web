<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Srikai Food Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        h1 {
            color: #333333;
        }
        .food-info {
            text-align: left;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Srikai Food Information</h1>
        <div class="food-info">
            <p><strong>Name:</strong> <%= request.getAttribute("name") %></p>
            <p><strong>Type:</strong> <%= request.getAttribute("type") %></p>
            <p><strong>Nutrient:</strong> <%= request.getAttribute("nutrient") %></p>
            <p><strong>Spicy:</strong> <%= request.getAttribute("spicy") %></p>
            <p><strong>Price:</strong> <%= request.getAttribute("price") %></p>
        </div>
    </div>
</body>
</html>
