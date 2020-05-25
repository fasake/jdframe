<%@page import="com.jdframe.sys.core.model.Tokens"%>
<%@page import="com.jdframe.sys.core.model.UserProfile"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	UserProfile userProfile = (UserProfile)session.getAttribute(Tokens._USER_PROFILE);
	String userMenuHTML = userProfile.getUser().getUser_menu_html();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title></title>
<style type="text/css">
<!--
a:link {
	color: #000000;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #000000;
}
a:hover {
	text-decoration: underline;
	color: #CC6600;
}
a:active {
	text-decoration: none;
}
.mainbg {
	background-image: url(/images/sys/index_25.jpg);
	background-repeat: no-repeat;
	background-position: left bottom;
}

-->
</style>
<script type="text/javascript">
window.onerror=fnErrorTrap;
function fnErrorTrap(){}
if(!storeFrame || storeFrame == undefined){
	var storeFrame =window.top['main'];
	var DeDocument =storeFrame.document;
	var mulDocumentArray = new Array();
	if(!storeFrame || storeFrame == undefined){
		alert("加载脚本错误，请刷新页面或者重新登录！");
	}
}

</script>
<script type="text/javascript" src="/js/sys/frame.js"></script>	
<script type="text/javascript" src="/js/sys/store.js"></script>
<script type="text/javascript">
window.onerror=fnErrorTrap;
function fnErrorTrap(){}
	var storeFrame =window.top['main'];
	var DeDocument =storeFrame.document;
	var mulDocumentArray = new Array();
	var error = false;
	if(!storeFrame || storeFrame == undefined){
		error = true;
	}
	if(!DeDocument || DeDocument == undefined){
		error = true;
	}
	if(!mulDocumentArray || mulDocumentArray == undefined){
		error = true;
	}
	if(error){
		alert("加载多标签脚本异常，请刷新页面框架或者重新登录！");
	}

</script>
<script  type="text/javascript">



function show(id)
	{
		var obj = document.getElementById(id);
		var objChild = document.getElementById(id + "_2");
		objChild.style.display = objChild.style.display == "none"?"":"none";
		obj.className = objChild.style.display == "none"?"zxmenu":"zxmenub";
	}
function MM_showHideLayers() { //v9.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) 
  with (document) if (getElementById && ((obj=getElementById(args[i]))!=null)) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}

 

</script>


<link href="/css/sys/main.css" rel="stylesheet" type="text/css">

</head>

<body class="mainbody">
<table width="220" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="mainbodytable">
  <tr>
    <td height="22">
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" background="/images/sys/main_26.gif" class="noboder">
	      <tr>
	        <td width="120" height="22" background="/images/sys/main_23.gif">&nbsp;系统功能菜单</td>
	        <td width="41" background="/images/sys/main_25.gif"><img src="/images/sys/SPACER.GIF" width="41" height="15"></td>
	        <td>&nbsp;</td>
	      </tr>
	    </table>
    </td>
  </tr>
  <tr>
    <td  width="220" valign="top" class="zxmenubg">
    <%=userMenuHTML %>
   
     </td>  
    </tr>
</table>
</body>
</html>
