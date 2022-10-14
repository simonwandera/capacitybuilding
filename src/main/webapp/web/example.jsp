<html>
    <body>
        <%
        String name=request.getParameter("uname");
        out.print("welcome "+name);
        %>

        Current Time: <%= java.util.Calendar.getInstance().getTime() %>

    </body>
</html>