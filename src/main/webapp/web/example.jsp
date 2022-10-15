<html>
    <body>
        <%
           String name=request.getParameter("uname");
           out.print("Welcome "+name);

           session.setAttribute("user",name);

          response.sendRedirect("page.jsp");

        %>

    </body>
</html>