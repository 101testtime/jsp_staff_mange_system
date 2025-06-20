<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="employee management, system, keywords">
    <meta http-equiv="description" content="This is my employee management system page">
    <style type="text/css">
        /* 嵌入的CSS样式 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow-x: hidden; /* 防止水平滚动条 */
        }

        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
            box-sizing: border-box; /* 确保padding不影响元素总宽度 */
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .container:hover {
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            transform: translateY(-10px);
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
            font-weight: bold;
        }

        a {
            display: block;
            margin: 15px 0;
            color: #007BFF;
            text-decoration: none;
            font-size: 16px;
            transition: color 0.3s, text-decoration 0.3s;
            border-bottom: 2px solid transparent; /* 透明下划线 */
        }

        a:hover {
            color: #0056b3;
            text-decoration: none;
            border-bottom: 2px solid #0056b3; /* 鼠标悬停时显示下划线 */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>欢迎使用员工管理系统</h1>
        <a href="delbyid.jsp">删除员工信息</a>
        <a href="insert.html">添加员工信息</a>
         <a href="update.html">修改员工信息</a>
        
        <a href="findbyid.htm">按员工编号查询</a>
         <a href="findbyname.html">按员工姓名查询</a>
         <a href="findAllServlet">显示所有员工信息</a>
    </div>
</body>
</html>