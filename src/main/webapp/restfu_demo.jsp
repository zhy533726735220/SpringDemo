<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String addUrl = basePath + "pages/emp/add.action";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-3.2.1.js" ></script>
        <script type="text/javascript" src="js/restful_demo.js" ></script>
    </head>
    <body>
    	<div id="butDiv">
    		<button id="addMember">增加用户</button>
    		<button id="editMember">编辑用户</button>
    		<button id="removeMember">删除用户</button>
    		<button id="getMember">查看用户</button>
    		<button id="listMember">查看用户列表</button>
    	</div>
    	<div id="showDiv"></div>
 	</body>
</html>