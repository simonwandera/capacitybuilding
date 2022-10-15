<%@ page isErrorPage="true" %>
<html>
<body>

<h1>This is an error page</h1>
    <%
        String name=(String)session.getAttribute("userName");
        out.print("Hello hello "+ name);

        String newName=(String)pageContext.getAttribute("user",PageContext.SESSION_SCOPE);

        out.print("Hello hello "+ newName);

        out.print("An error occurred " + exception);
    %>

</body>
</html>