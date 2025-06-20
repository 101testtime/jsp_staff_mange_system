<%@ page language="java" import="java.util.*,com.cn.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findbyid.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>  
  <body>
   <%
   request.setCharacterEncoding("utf-8");
  Employee emp=(Employee)session.getAttribute("emp") ;
  if (emp != null) {
%>
  <form >
      <!-- 员工编号 -->
      <label for="empno">员工编号:</label>
      <input type="text" id="empno" name="empno" value="<%= emp.getEmployeeId() %>" readonly>
      <br><br>
      
      <!-- 员工姓名 -->
      <label for="ename">员工姓名:</label>
      <input type="text" id="ename" name="ename" value="<%= emp.getEmployeeName() %>" readonly>
      <br><br>
      <!-- 员工性别 -->
      <label for="sex">员工性别:</label>
      <input type="text" id="sex" name="sex" value="<%= emp.getEmployeeSex() %>" readonly>
      <br><br>
      <!-- 员工入职日期 -->
      <label for="sex">员工入职日期:</label>
      <input type="text" id="sex" name="sex" value="<%= emp.getEmployeeDate() %>" readonly>
      <br><br>
      <!-- 薪水 -->
      <label for="sal">员工工资:</label>
      <input type="text" id="sal" name="sal" value="<%= emp.getEmployeeSalary() %>" readonly>
      <br><br>
      <!-- 岗位 -->
      <label for="sal">员工岗位:</label>
      <input type="text" id="sal" name="sal" value="<%= emp.getEmployeePosition() %>" readonly>
      <br><br>
  </form>
<%
  } else {
      // 如果emp为null，可以显示一条消息或进行其他处理
      out.print("查无此人！！！");
  }
%>
<a href="welcome.jsp">返回管理页面</a>
  </body>
</html>
