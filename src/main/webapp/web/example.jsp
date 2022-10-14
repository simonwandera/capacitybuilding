<html>
    <body>
        <%
        String name=request.getParameter("uname");
        out.print("welcome "+name);
        %>

        Welcome: <%= request.getParameter("uname") %>

        <%!
        int cube(int n){
        return n*n*n;
        }
        %>
        <%= "\nCube of 3 is:"+cube(3) %>

    </body>
</html>