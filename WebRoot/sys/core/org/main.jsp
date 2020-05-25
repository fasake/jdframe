<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Organization Manager Main-page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link rel="stylesheet" type="text/css" href="/css/sys/main.css">
  </head>
  <body style=" height: 620px" >
        <table  width="100%" height="100%"   >
         <tr valign="top"  height="630px"  >
            <td width="25%" height="100%" >
                <!-- tree on the left-->
            	<iframe frameborder="1" id="frm_left" scrolling="auto"  width="100%"    height="100%" src="/sys/core/org/tree.jsp"></iframe>
            </td>
            <td width="75%" >
                <!-- workspace on the right -->
            	<iframe frameborder="0" id="frm_work" scrolling="auto"  width="100%"  height="100%" src="about:blank"></iframe>
            </td>
            </tr>
        </table>
<script type="text/javascript">
   //init workspace
   function showOrg(id){
	   document.getElementById("frm_work").src="/com/jdframe/sys/core/org/query!init?var.zzjg_dm_sj="+id;
   }

</script>
  </body>
</html>
