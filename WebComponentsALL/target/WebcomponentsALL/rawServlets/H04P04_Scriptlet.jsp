<%--
  Created by IntelliJ IDEA.
  User: ERICF
  Date: 30/08/2019
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My first scriplet</title>
</head>
<body>

<h1>4.4.1.a Scriptlets</h1>
<% out.println ("Hello Scriptlet");%>

<h1>4.4.1.b Scriptlets with a loop</h1>
<% for (int i = 0; i < 5; i++) { %>
<p>Hello Scriptlet, 5 times!</p>
<%}%>

<h1>4.4.2. Expressions</h1>
<% String text1 = "This is a String object";%>
<%=text1%>

<h1>4.4.3. declaraties van member-variabelen en member-methoden</h1>
<%!
    /// Declaration of a member variable
    private String text2= "Hello member variable";

    // Declaration of a member method
    private String reverse(String t){
        StringBuilder sb = new StringBuilder (t);
        return sb.reverse ().toString ();
    }
%>
<br/>
<%=reverse(text2)%>
<footer>
    <p>
        -----------------
    </p>
    <p><a href="index.html">Back to index</a></p>
    <p>
        -----------------
    </p>
</footer>
</body>
</html>
