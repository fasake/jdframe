<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统菜单树</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta content="MSHTML 6.00.2600.0" name=GENERATOR>
	<link rel="stylesheet" type="text/css" href="/css/sys/main.css">
 <style type="text/css">
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		SCROLLBAR-FACE-COLOR: #37b0dd;
		SCROLLBAR-HIGHLIGHT-COLOR:#ffffff;
		SCROLLBAR-SHADOW-COLOR: #ffffff;
		SCROLLBAR-3DLIGHT-COLOR:0099cc;
		SCROLLBAR-ARROW-COLOR:#1c6787;
		SCROLLBAR-TRACK-COLOR:#ddfdfd;
		SCROLLBAR-DARKSHADOW-COLOR:#1c6787;
	}
	</style>
  <sx:head/>
  </head>
<body>
<script language="JavaScript" type="text/javascript">
    dojo.event.topic.subscribe("treeSelected", function treeNodeSelected(node) {
        dojo.io.bind({
            url: "<s:url value='/com/jdframe/sys/core/menu/treeSelected.action'/>?nodeId="+node.node.widgetId,
            load: function(type, data, evt) {
                var divDisplay = dojo.byId("displayId");
                divDisplay.innerHTML=data;
            },
            mimeType: "text/html"
        });
        window.parent.showMenu(node.node.widgetId);
    });
</script>
<s:url id="nodesUrl" namespace="/com/jdframe/sys/core/menu" action="getNodes" />
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top" id="td_tree">
    <div style="float:left; margin-right: 50px;">
       <sx:tree id="dorg_tree" href="%{#nodesUrl}" treeSelectedTopic="treeSelected" />
    </div>
     
	</td>
  </tr>
</table>
 
</body>
</html>
