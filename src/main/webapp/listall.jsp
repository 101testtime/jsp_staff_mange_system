<%@ page language="java" import="java.util.*,com.cn.model.*" pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    
    <title>My JSP 'listall.jsp' starting page</title>  
    
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
	List all=(List)session.getAttribute("list");  
	if (all == null || all.isEmpty()) {  
	    out.println("暂无员工信息记录");  
	} else {  
	    Iterator<Employee> iter = all.iterator() ;  
%>  

<center>  
<h1>魔力公司员工信息一览表</h1>  
<table border="1" width="80%">   
	<tr  bgcolor="red">  
		<td>雇员编号</td>  
		<td>雇员姓名</td>  
		<td>雇员性别</td>  
		<td>雇佣日期</td>  
		<td>基本工资</td>  
		<td>员工岗位</td>  
	</tr>  
<%  
	    while(iter.hasNext()){  
	    	Employee emp = iter.next() ;  
		if (emp == null) {  
		    continue;  
		}  
%>  
	<tr>  
		<td><%=emp.getEmployeeId()%></td>   
		<td><%=emp.getEmployeeName()%></td>  
		<td><%=emp.getEmployeeSex()%></td>  
		<td><%=emp.getEmployeeDate()%></td>  
		<td><%=emp.getEmployeeSalary()%></td> 
		<td><%=emp.getEmployeePosition()%></td>
	</tr>  
<%  
	    }  
	}  
%>  
</table>  
</center>  

    <a href="welcome.jsp">返回管理界面</a>  
  </body>  
</html>