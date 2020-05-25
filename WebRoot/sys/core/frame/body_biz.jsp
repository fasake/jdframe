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
	<link rel="stylesheet" href="/css/sys/stylesheet.css" type="text/css">
	<style type="text/css">
		.Tab_LiActive {  display:block;height:18px; margin-top:4px; width:120px; line-height:22px; cursor:hand; float:left;background-image: url(/images/sys/main_menu01.gif); color:#fff; overflow:hidden;display:inline;}
		.Tab_LiNoActive {  display:block;height:18px; margin-top:4px; width:120px; line-height:22px; cursor:hand; float:left;background-image: url(/images/sys/main_menu02.gif);; color:#B9B9B9; overflow:hidden;display:inline;}
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
			background-image: url(/images/sys/mainbg.jpg);
		}
		.line_top {
			BORDER-TOP: #487dd9 1px solid; TEXT-ALIGN: center
		}
		.font_huib { color:#696969; letter-spacing:5px;}
			input {
			font-size: 9pt;
			line-height: 12pt;
			border: 1px #999999 solid;
			background-color: #FFFFFF;
			color: #404040;
			}
			td { font-size:12px; color:#000000; line-height:20px;}
			img { border: 0px}
			
			.table_shenhui { background-color:#DEDEDE; border:1px solid #828282; text-align:center;}
			.table_hui { background-color:#F1F1F1; border:1px solid #828282;border-top: 0px;}

	</style>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title></title>

		<link rel="stylesheet" href="/css/sys/stylesheet.css" type="text/css">
		<link rel="stylesheet" href="/css/sys/content.css" type="text/css">
		
<script type="text/javascript" src="/js/sys/frame.js"></script>		
<script type="text/javascript" src="/js/sys/store.js"></script>


	</head>
	<body class='frbody' onload="initTab();">

	<input type="hidden" id="previousWinId" value="NONE_PreviousWinId" />
	<div id="rightbk">
		<table width="100%"  border="0" cellpadding="0" cellspacing="0" background="/images/sys/index_24.jpg" class="frbody">
			<tr height="16">
			
				<td id="titletd" width="98%" background="/images/sys/main_26_01.jpg" height="25">
					<div id="tabtitle"></div>
				</td>
				
				<td   background="/images/sys/main_26_01.jpg"  height='25'  >
					<div id="closeDiv" style="display:none"><img src="/images/sys/main_26close.gif"   alt='¹Ø±Õ' onClick="javascript:subDivUrl();"/></div>
				</td>
				
			</tr>

			<tr   valign="top">
				<td colspan='2' valign="top">
					<div id="tabcontent">
					</div>

				</td>
			</tr>
		</table>
		
		

<div style="height:15px; display:block;background-color:#e4e2e4">&nbsp;</div>




		
</div>
</body>
</html>
<script language="javascript">

function initTab(){
	
 	storeFrame =window.top['main'];
 	if(!storeFrame){
 		alert("加载脚本异常，请刷新页面重试！");
 	}
	DeDocument =storeFrame.document;
	if(!DeDocument){
		alert("加载脚本异常，请刷新页面重试！");
	}
	if(!storeFrame.window.temp3){
	    storeFrame.window.eval("var temp3= new Array();");
	}
	    
	window.onerror=fnErrorTrap;
	function fnErrorTrap(){}
	
}
	

</script>
