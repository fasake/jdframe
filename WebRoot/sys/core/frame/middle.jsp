<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>左栏开关</title>
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.topbg {
	background-image: url(/images/sys/main_16.gif);
	background-repeat: repeat-x;
	background-position: 0px 0px;
}
-->
</style>
</head>

<body>
<table width="9" height="100%" border="0" cellpadding="0" cellspacing="0" background="/images/sys/main2_61.gif">
  <tr>
    <td class="topbg"><img   src="/images/sys/main_42.gif"   alt="关闭左栏" width="9" height="103"  border="0" class="buttont0"   onclick="javascript:parent.show2(this);"></td>
  </tr>
</table>
</body>
</html>
