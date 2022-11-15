<%--
  Created by IntelliJ IDEA.
  User: bstevary
  Date: 10/11/2022
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <title>login</title>
</head>
<body  >
<div id="stx" >
            <div id="rtx">
            <form autocomplete="off" action="login" method="post">
                <div>
                    <label for="UserName">UserName</label>
                    <input type="text" name="UserName" id="UserName">
                </div>
                <div>
                    <label for="Password">Password</label>
                    <input type="password" name="Password" id="Password">
                </div>

             <div class="form_action--button">
                    <input type="submit" value="Login">
                    <input type="reset" value="Clear">
                </div>
            </form>

        </div>

        </div>


</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: bstevary
  Date: 13/11/2022
  Time: 01:37
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" import="java.util.*" %>
<html>
<head>
    <title>Data Page</title>
</head>
<body>
<table border="1" width="303">
    <tr>
        <td width="119"><b>ID</b></td>
        <td width="168"><b>Message</b></td>
    </tr>
    <%Iterator itr;%>
    <% List data= (List)request.getAttribute("data");
        for (itr=data.iterator(); itr.hasNext(); )
        {
    %>
    <tr>
        <td width="119"><%=itr.next()%></td>
        <td width="168"><%=itr.next()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
