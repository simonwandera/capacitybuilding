<%@ page isErrorPage="true" %>
<html>
<body>
    <%
        String name=(String)session.getAttribute("userName");
        out.print("Hello hello "+ name);

        String newName=(String)pageContext.getAttribute("user",PageContext.SESSION_SCOPE);

        out.print("Hello hello "+ newName);

        out.prim
    %>

     Sorry following exception occurred:<%= exception %>
</body>
</html>