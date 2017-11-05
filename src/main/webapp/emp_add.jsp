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
        number:<input type="text" name="empo" id="empo"><br>
        sal:<input type="text" name="sal" id="sal"><br>
        hirdate:<input type="text" name="hirdate" id="hirdate"><br>
        photo:<input type="file" name="photo" id="photo"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>