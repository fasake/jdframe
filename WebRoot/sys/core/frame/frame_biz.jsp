<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>..::JDFrame(J2EE Develop Frame)::..</title>

<script>   
  var   strColumns_Current1   =   "73,*";   
  var   bsplit=true   ;
  
  function   show(obj){   
  if(!obj){return false; }  
  if(bsplit){
	    hidetoc()   
        bsplit=false;   
        obj.src="images/main2_12.gif";   
        obj.alt="恢复上栏";   
      }else{
    	showtoc()   
        bsplit=true;   
        obj.src="images/main_12.gif";   
        obj.alt="关闭上栏"   
      }   
  }   
  function hidetoc(){   
          strColumns_Current1=document.getElementsByName("mainframe")[0].rows   
          document.getElementsByName("mainframe")[0].rows="*,100%"; 
      }   
  function showtoc(){   
	  document.getElementsByName("mainframe")[0].rows=strColumns_Current1;   
      }   
  </script>
<script>   
  var   strColumns_Current2   =   "198,*";   
  var   bsplit2=true   
  function   show2(obj)   
  {   
  if(!   obj)   return   false;   
  if   (bsplit2)   
      {hidetoc2()   
        bsplit2=false;   
        obj.src="/images/sys/main2_42.gif";   
        obj.alt="恢复左栏";   
      }   
  else   
      {showtoc2()   
        bsplit2=true;   
        obj.src="/images/sys/main_42.gif";   
        obj.alt="关闭左栏"   
      }   
  }   
  function   hidetoc2()   
      {   
          strColumns_Current2=document.getElementsByName("split2")[0].cols  
          document.getElementsByName("split2")[0].cols="*,100%";   
      }   
  function   showtoc2()   
      {   
	  document.getElementsByName("split2")[0].cols=strColumns_Current2;   
      }   

 
</script> 
 
</head>

<frameset rows="73,*" frameborder="no" border="0" framespacing="0" name="mainframe" onLoad="moveTo(0,0);resizeTo(screen.width,screen.height);">
  <frame src="/sys/core/frame/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  <frameset rows="24,*,15" frameborder="no" border="0" framespacing="0">
		<frame src="/sys/core/frame/navigation.jsp" name="topFrame1" scrolling="No" noresize="noresize" id="topFrame1" />
		<frameset cols="198,*" frameborder="NO" border="0" framespacing="0" name="split2">
		<frame src="/sys/core/frame/left_biz.jsp" name="leftFrame" scrolling="NO" noresize>
		<frameset cols="9,*" frameborder="NO" border="0" framespacing="0">
		  <frame src="/sys/core/frame/middle.jsp" name="leftFrame1" scrolling="NO" noresize>
		  <frame src="/sys/core/frame/body_biz.jsp" name="main" id="main" scrolling="auto" />
		 </frameset>
		
	</frameset>
		<frame src="/sys/core/frame/foot.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
  </frameset>
</frameset>
<noframes><body>
</body>
</noframes></html>
