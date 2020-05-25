<%@page import="com.jdframe.sys.core.model.Tokens"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jdframe.sys.core.model.UserProfile" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	UserProfile profile = (UserProfile)session.getAttribute(Tokens._USER_PROFILE);
	String zzjg_name = profile.getUser().getUser_zzjg().getZzjg_name();
	String user_name = profile.getUser().getUser_name();
	String user_id  = profile.getUser().getUser_id();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title></title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	background-color: #FFFFFF;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
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
.font_w {
	font-size: 12px;
	color: #FFFFFF;
}

-->
</style>
<script type="text/JavaScript">
<!--
function jdframe_preloadImages() {  
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=jdframe_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
function jdframe_swapImgRestore() {  
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function jdframe_findObj(n, d) {  
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=jdframe_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function jdframe_swapImage() { 
  var i,j=0,x,a=jdframe_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=jdframe_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->

</script>
</head>

<body onLoad="jdframe_preloadImages('/images/sys/main2_06.gif','/images/sys/main2_08.gif','/images/sys/main2_10.gif')">
<table width="100%" height="24" border="0" cellpadding="0" cellspacing="0" background="/images/sys/main_04.gif">
 <tr>
    <td width="12"><img   src="/images/sys/main_02_v2.gif"    width="216" height="24"  border="0" ></td>
    <td class="font_b"> &nbsp;&nbsp;<FONT COLOR='BLUE'></FONT>  <a href="javascript:showUserPwd()" title="查看个人信息，修改密码"><FONT COLOR='white' style="font-size: 12px">组织机构：<%=zzjg_name %> &nbsp;&nbsp;用户名：<%=user_name %></FONT></a</td>
    <td width="15" valign="top">&nbsp;</td>
    <td width="92" valign="top"><a href="/sys/core/frame/frame_ToDoList.jsp" target="_parent" onMouseOver="jdframe_swapImage('Image3','','/images/sys/dbsy2.jpg',1)" onMouseOut="jdframe_swapImgRestore()"><img src="/images/sys/dbsy.jpg" name="Image3" width="92" height="24" border="0"></a></td>
    <td width="10" valign="top">&nbsp;</td>
    <td width="92" valign="top"><a href="/sys/core/frame/frame_biz.jsp" target="_parent" onMouseOut="jdframe_swapImgRestore()" onMouseOver="jdframe_swapImage('Image4','','/images/sys/ywcl2.jpg',1)"><img src="/images/sys/ywcl.jpg" name="Image4" width="92" height="24" border="0"></a></td>
    <td width="10" valign="top">&nbsp;</td>
    <td width="92" valign="top"><a href="/login.jsp" target="_top" onMouseOver="jdframe_swapImage('Image5','','/images/sys/main2_10.gif',1)" onMouseOut="jdframe_swapImgRestore()"><img src="/images/sys/main_10.gif" name="Image5" width="92" height="24" border="0"></a></td>
    <td width="10"></td>
    <td width="30" valign="top"><img   src="/images/sys/main_12.gif"   alt="关闭上栏" width="19" height="24"  border="0" class="buttont0"   onclick="iShow(this);"></td>
 </tr>
</table>
<script>
function iShow(obj){
  parent.show(this);
  var url = obj.src;
  if(url.indexOf('main_12.gif')!=-1){
      obj.src = '/images/sys/main2_12.gif';
  }else{
      obj.src = '/images/sys/main_12.gif';
  }
}
function showUserPwd(){
	window.open("/com/jdframe/sys/core/user/changePwd!init?var.user_id=<%=user_id %>",'_blank', 'width=800,height=330,toolbar=no,scrollbar=yes;');
}
</script>
</body>
</html>
