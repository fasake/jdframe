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
	UserProfile userprofile = (UserProfile)session.getAttribute(Tokens._USER_PROFILE);
	//动态提取用户公告
	String noticeContent = userprofile.initUserNotice(userprofile.getUser().getUser_zzjg_dm());
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
	background-repeat: no-repeat;
	background-position: left bottom;
}

-->
</style>
 
<link href="/css/sys/main.css" rel="stylesheet" type="text/css">

<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/interface/dsm.js'></script>


</head>

<body  class="mainbody">
	<table width="220" height="50%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="mainbodytable">
    <tr >
    	<td height="22" valign="top"  >
	    	<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0" background="/images/sys/main_26.gif" class="noboder">
	      		<tr>
	        		<td width="120" height="22" background="/images/sys/main_23.gif">&nbsp;系统公告</td>
	        		<td width="41"   background="/images/sys/main_25.gif"><img src="/images/sys/SPACER.GIF" width="41" height="15"></td>
	        		<td>&nbsp;</td>
	     		</tr>
	    	</table>
    	</td>
   </tr>
   <tr>
   	<td style="height:100%">
   	      <%=noticeContent %>
   	    
   	</td>
   </tr>
  </table>
  <table width="220" height="50%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="mainbodytable">
    <tr>
    	<td height="22"  valign="top">
	    	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" background="/images/sys/main_26.gif" class="noboder">
	      		<tr>
	        		<td width="120" height="22" background="/images/sys/main_23.gif">&nbsp;系统监控</td>
	        		<td width="41" background="/images/sys/main_25.gif"><img src="/images/sys/SPACER.GIF" width="41" height="15"></td>
	        		<td>&nbsp;</td>
	     		</tr>
	    	</table>
	    	 
    	</td>
    	 
   </tr>
   <tr>
   	<td height="100%" valign="top">
   	   <div style="with:100px;height:20px;margin:5px; background-color: mintcream;"> 
   	      <div id = "dprogress" style="with:10px;margin:2px; "></div>
   	      <div id = "dmemory"  style="with:10px;margin:2px; "></div>
   	      <div id = "dthread"  style="with:10px;margin:2px; "></div>
   	   </div>
   	</td>
   </tr>
  </table>
 
</body>
<script type="text/javascript">
var dcount = 0;
var mcount = 0;
var arrayObj = new Array("|","/","-","\\");
function showNotice(id){
	window.showModalDialog("/com/jdframe/sys/core/notice/preview?var.notice_id="+id,window, 'dialogWidth:800px;dialogHeight:530px;center:yes;help:no;resizable:no;status:no;');
}

function dwrInvoker_memory(d){
	var m = d.split(",");
	if(m.length > 0){
		var pm = m[0];//percent used memory
		var cm = m[1];//current used memory
		var mm = m[2];//max allowed memory
		var usage_percent = Math.round(cm / mm * 100);
		var istr = "";
		if(usage_percent >= 95){
			istr = "[<font color='red'>Blocker</font>]   ";
		}else if(usage_percent >= 90){
			istr = "[<font color='red'>Critical</font>]   ";
		}else if(usage_percent >= 80){
			istr = "[<font color='red'>Warning</font>]   ";
		}else  if(usage_percent >= 50){
			istr = "[<font color='blue'>Health</font>]    ";
		}else{
			istr = "[<font color='blue'>Idle</font>]    ";
		}
		document.all.dmemory.innerHTML = "<ul><li> <b>Memory Usage:</b> " + istr + "</li></ul>";
		document.all.dmemory.title = "Used:"+cm+" Max:"+mm;
	}
	
}
function dwrInvoker_thread(d){
	var m = d.split(",");
	if(m.length > 0){
		var pc = m[0];//percent block/action
		var ac = m[1];//active count
		var bc = m[2];//block count
		var pc = m[3];//peak count
		var usage_percent = Math.round(bc / ac * 100);
		var istr = "";
		if(usage_percent >= 80){
			istr = " [<font color='red'>Blocker</font>]  ";
		}else if(usage_percent >= 40){
			istr = " [<font color='red'>Critical</font>]  ";
		}else if(usage_percent >= 20){
			istr = " [<font color='red'>Warning</font>]  ";
		}else if(usage_percent >= 10){
			istr = " [<font color='blue'>Health</font>]    ";
		}else{
			istr = " [<font color='blue'>Idle</font>]     ";
		}
		document.all.dthread.innerHTML = "<ul><li> <b>Thread Usage:</b> " + istr + "</li></ul>";
		document.all.dthread.title = "Block:"+bc+" Active:"+ac +" Peak:"+pc;
	}
}

function doMonitor(){
	try{
		var msg = "System Monitor Is Running [ "+arrayObj[dcount]+" ]";
		
		dcount = dcount + 1;
		mcount = mcount + 1;
		if(dcount >= 4){
			dcount = 0;
		}
		document.all.dprogress.innerHTML = msg;
		if((mcount % 5) == 0 ){
			dsm.hcMemory(dwrInvoker_memory);
			dsm.hcThread(dwrInvoker_thread);
		} 
	}catch(e){}
	
}

window.setInterval("doMonitor()",2000);
</script>
</html>
