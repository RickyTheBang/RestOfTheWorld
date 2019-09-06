<%@ page import="classOefeningen.H04.model.Calculator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.swing.text.AsyncBoxView" %><%--
  Created by IntelliJ IDEA.
  User: ERICF
  Date: 06/09/2019
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!

%>

    <html>
    <head>
<title>Calculator</title>
</head><body>
<form method='POST'>
    ${message}  <br/>
Result: <br/>

        <p>${sessionScope.result}</p>


<input type='number' name='number' /><br />
<button name='operation' type='submit' value='+'>+</button>
<button name='operation' type='submit' value='-'>-</button>
<button name='operation' type='submit' value='*'>*</button>
<button name='operation' type='submit' value='/'>/</button>
<button name='operation' type='submit' value='CE'>CE</button>
</form></body></html>

