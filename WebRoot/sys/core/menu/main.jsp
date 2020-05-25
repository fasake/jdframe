<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统菜单管理主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
    <link rel="stylesheet" type="text/css" href="/css/sys/main.css">

  </head>
  
  <body style=" height: 620px" >
   
        <table  width="100%" height="100%"   >
         <tr valign="top"  height="630px"  >
            <td width="25%" height="100%" >
            	<iframe frameborder="1" id="frm_left" scrolling="auto"  width="100%"    height="100%" src="/sys/core/menu/tree.jsp"></iframe>
            </td>
            <td width="75%" >
            	<iframe frameborder="0" id="frm_work" scrolling="auto"  width="100%"  height="100%" src="about:blank"></iframe>
            </td>
            </tr>
        </table>
  </body>
  <script type="text/javascript">
   function showMenu(id){
	   document.getElementById("frm_work").src="/com/jdframe/sys/core/menu/query!init?var.menu_parent_id="+id;
   }

</script>
</html>
