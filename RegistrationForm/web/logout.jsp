<%-- 
    Document   : logout
    Created on : 31-Jul-2023, 2:34:02 pm
    Author     : Nivedha.S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<body>
		<% session.invalidate(); %> <!-- HERE WE ARE INVALIDATE THE SESSION, SO THAT NO VALUES WILL BE PRESENT IN SESSION -->
		<jsp:forward page="index.html"/>
	</body>
</html>
