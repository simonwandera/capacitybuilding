<%@ include file="header.html" %>
<body>

    <%@ page import="java.util.Date"%>

    <%@ page errorPage="page.jsp"%>
    Today is: <%= new Date() %>

    <div class="page-header">
        <h3 class="page-title m-auto"><% session.getAttribute("userName"); %></h3>
    </div>

</body>
</html>