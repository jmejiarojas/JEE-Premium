<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String parametro = request.getParameter("numero");
		int numero = 0;
		
		if(parametro != null){
			numero = Integer.parseInt(parametro);
		}else{
			numero = 99;
		}
		
		out.println("Tabla del: " + numero);
		out.println("<br>");
		for(int i = 1; i<= 12 ; i++){
			out.println(numero + "*" + i + " = " + (numero*i));
			out.print("<br>");
		}
	%>
</body>
</html>