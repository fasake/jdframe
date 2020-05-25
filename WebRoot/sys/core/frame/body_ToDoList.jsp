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
	<style type="text/css">
		.frbody {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			background-color: #FFFFFF;
			SCROLLBAR-FACE-COLOR: #37b0dd;
			SCROLLBAR-HIGHLIGHT-COLOR:#ffffff;
			SCROLLBAR-SHADOW-COLOR: #ffffff;
			SCROLLBAR-3DLIGHT-COLOR:0099cc;
			SCROLLBAR-ARROW-COLOR:#1c6787;
			SCROLLBAR-TRACK-COLOR:#ddfdfd;
			SCROLLBAR-DARKSHADOW-COLOR:#1c6787;
			background-image: url(/images/sys/mainbg.jpg);
		}
		#rightbk{
			height: 99%;
			width: 100%;
			margin-top: 4px;
			margin-right: 4px;
			margin-bottom: 4px;
			margin-left: 0px;
			border: 1px solid #0099CC;
			background-color: #FFFFFF;
			background-image: url(/images/sys/mainbg.gif);
		}
	</style>
		<link rel="stylesheet" href="/css/sys/stylesheet.css" type="text/css">
		<link rel="stylesheet" href="/css/sys/content.css" type="text/css">

<script type="text/javascript">
  window.onerror=fnErrorTrap;
  function fnErrorTrap(){}

</script>
	</head>
	<body class='frbody'>
	   <table border="0" cellpadding="0" cellspacing="0" width="100%"  class="rightbk">
			
			<tr height="100%">
				<td valign="top">
				   <div   style="height: 100%">
					   <jsp:include page="/com/jdframe/sys/core/task/queryTask!init" ></jsp:include>
					</div>
				
				</td>
			</tr>
			
		</table>
	
	 
	</body>
</html>
