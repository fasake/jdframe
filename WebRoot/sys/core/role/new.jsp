<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%@ taglib prefix="msg" uri="msgTag" %>
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
<title>新建角色基本信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<link rel="StyleSheet" href="/css/tree/dtree.css" type="text/css" />
<script type="text/javascript" src="/css/tree/dtree.js"></script>
<link rel="stylesheet" type="text/css" href="/css/sys/main.css">
<script type="text/javascript" src="/js/sys/common_funcs.js"></script>
<script type="text/javascript" src="/js/sys/progress.js"></script>

</head>
<body>
	<div class="topBar">
		<table  height="98%" width="98%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp;系统管理&gt;&gt;系统角色管理&gt;&gt;新建</td>
				<td>
	              <div style="width:100%;font-size:10pt;padding:2px" align="right">
		               <a href="javascript:history.back();">[back]&nbsp;&nbsp;</a>
	              </div>
              </td>
			</tr>
		</table>
	</div>
	<s:form action="new" namespace="/com/jdframe/sys/core/role"  onsubmit="doprogress()">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr height="5">
				<td width="15" nowrap="nowrap">&nbsp;</td>
				<td width="100%">&nbsp;</td>
				<td width="15" nowrap="nowrap">&nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td width="50%">
					<table class="editGrid">
						<tr height="30">
							<td class="highLightNormal" width="15%" nowrap="nowrap"
								colspan="4">&nbsp; 新建系统角色 :</td>
						</tr>
						 
						<tr class="repCnd">
							<td class="repCndLb">角色名称:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.role_name" size="80" maxlength="50"></s:textfield><font color="red">&nbsp;&nbsp;(必选性)</font>
							 </td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">角色描述:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.role_desc" size="80"></s:textfield><font color="red">&nbsp;&nbsp;(可选性)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">角色范围:</td>
							<td class="repCndEditRight">
							<s:select list="#{'1':'本单位及下级','2':'本单位','3':'本部门'}" name="var.role_scope"></s:select>
							<font color="red">&nbsp;&nbsp;(必选性，用于判断系统角色应用范围)</font>
						     </td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">系统菜单树:</td>
							<td style="border:1px solid #999; padding:1px 3px;white-space:nowrap;width:100% " valign="top">
							<s:hidden name="var.role_menu_id"></s:hidden>
							<div style="width:100%;height:400px;overflow:auto;">
							<!--checkbox.name =  dtree_ckbox -->
							  <script type="text/javascript">
							    <s:property value="menuTree"/>
							  </script>
							</div>
							</td>
						</tr>
						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
								<s:submit  accesskey="S" value="保存(S)" onclick="check();"> </s:submit> &nbsp;&nbsp;&nbsp;&nbsp; 
								<s:reset value="清空(C)" accesskey="C"></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						
					</table>
					
				</td>
				<td>
				
				</td>
				
			</tr>
			
		</table>
	</s:form>
	<!-- 消息检测器 -->
	<msg:checker/>
	
<script type="text/javascript">

	function check(){
		 
		var role_name = document.getElementsByName("var.role_name")[0].value;
		if(trim(role_name)=='' || trim(role_name).length > 50 ){
			alert('请输入 角色名称！');
			return false;
		}
		 
		return save();
	}
 
function save(){
	var menuids = "";
	var menus = document.getElementsByName("dtree_ckbox");
	for(var n=0;n<menus.length;n++){
		if(menus[n].checked == true){
				menuids = menuids+menus[n].value+",";
		}
	}
	if(menuids.lastIndexOf(",")==menuids.length-1){
		menuids = menuids.substr(0,menuids.length-1);
	}
	document.getElementsByName("var.role_menu_id")[0].value = menuids;
	return true;
}
</script>
</body>
 
 
</html>
