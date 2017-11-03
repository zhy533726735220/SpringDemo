<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String addUrl = basePath + "pages/emp/add.action";
%>
<html>
<body>
    <h2>Hello World!</h2>
    <form action="<%=addUrl%>" method="post" enctype="multipart/form-data">
        name:<input type="text" name="ename" id="ename"><br>
        photo:<input type="file" name="photo" id="photo"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>