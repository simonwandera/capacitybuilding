<html>
    <body>
        <%
           String name=request.getParameter("uname");
           out.print("Welcome "+name);

           session.setAttribute("userName",name);

          response.sendRedirect("page.jsp");

          pageContext.setAttribute("user",name,PageContext.SESSION_SCOPE);

        %>

    </body>
</html>