<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Confirmation Page</title>
  <style>
    body {
      background-color: cyan;
      margin: 0;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      font-family: Arial, sans-serif;
    }

    .message-box {
      background-color: white;
      padding: 30px 40px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
      text-align: center;
    }

    h5 {
      color: #00796b;
      font-size: 20px;
    }
  </style>
</head>
<body>
  <div class="message-box">
    <%
      Integer rows = (Integer) request.getAttribute("rowsaffected");
      if (rows != null && rows != 0) {
          out.print("<h5>Registration Successful</h5>");
      } else {
          out.print("<h5>Registration Failed</h5>");
      }
    %>
  </div>
</body>
</html>
