<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String addUrl = basePath + "rest/myparam/query";
%>
<html>
<body>
    <h2>Hello World!</h2>
    <form action="<%=addUrl%>" method="post">
        param:<input type="text" name="msg" id="msg"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>