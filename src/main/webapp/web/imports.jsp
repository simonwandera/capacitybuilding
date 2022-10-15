<html>
<body>

    <%@ page import="java.util.Date"%>

    <%@ page errorPage="page.jsp"%>
    Today is: <%= new Date() %>

    <%= 100/0 %>

</body>
</html>