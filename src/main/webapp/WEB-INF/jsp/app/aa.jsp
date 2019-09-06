<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
%>
<html>
<head>
    <title>Title</title>
    <script src="<%=basePath%>js/jquery.js"></script>
</head>
<body>
en
</body>
<script  type="text/javascript">
   /* window.onload(function () {
        alert(22);
    });
    jQuery(document).ready(function() {
        alert(1);
    });*/
</script>
</html>
