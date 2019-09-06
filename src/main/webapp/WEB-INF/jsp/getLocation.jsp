<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2019/4/24
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p id="demo">点击按钮获取您当前坐标（可能需要比较长的时间获取）：</p>
<button onclick="getLocation()">点我</button>
<script>
    var x=document.getElementById("demo");
    function getLocation()
    {
        if (navigator.geolocation)
        {
            navigator.geolocation.getCurrentPosition(showPosition);
        }
        else{x.innerHTML="该浏览器不支持获取地理位置。";}
    }
    function showPosition(position)
    {
        x.innerHTML="纬度: " + position.coords.latitude +
            "<br>经度: " + position.coords.longitude;
    }
</script>
</body>
</html>
