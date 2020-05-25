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
<title>用户密码修改</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/sys/progress.js"></script>
</head>
<body>
  


	<div class="topBar">
		<table height="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp;系统管理&gt;&gt;用户管理&gt;&gt;用户密码修改&gt;&gt;</td>
			</tr>
		</table>
	</div>
	<s:form   action="changePwd"  namespace="/com/jdframe/sys/core/user" target="_self" onsubmit="doprogress()">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr height="5">
				<td width="15" nowrap="nowrap">&nbsp;</td>
				<td width="100%">&nbsp;</td>
				<td width="15" nowrap="nowrap">&nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td>
				
					<table class="editGrid">
						<tr height="30">
							<td class="highLightNormal" width="15%" nowrap="nowrap"
								colspan="4">&nbsp; 用户信息 :</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">用户ID:</td>
							<td class="repCndEditRight">
							    <s:property value="var.user_id"/>
								<s:hidden name="var.user_id"></s:hidden>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">用户代码:</td>
							<td class="repCndEditRight">
							    <s:property value="var.user_dm"/>
								<s:hidden name="var.user_dm"></s:hidden>
							 </td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">用户名称:</td>
							<td class="repCndEditRight">
							    <s:property value="var.user_name"/>
							    <s:hidden name="var.user_name"></s:hidden>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">原密码:</td>
							<td class="repCndEditRight">
							   <s:password name="var.user_pwd" size="20" maxlength="18"></s:password>
							   <font color="red">&nbsp;&nbsp;(必选性)</font>
						    </td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">新密码:</td>
							<td class="repCndEditRight">
							    <s:password name="password" size="20" maxlength="18"></s:password>
							   <font color="red">&nbsp;&nbsp;(必选性，长度大于6位)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">新密码确认:</td>
							<td  class="repCndEditRight">
							   <s:password name="password_comfirm" size="20" maxlength="18"></s:password>
							   <font color="red">&nbsp;&nbsp;(必选性，长度大于6位)</font>
							</td>
						</tr>

						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
							<s:submit  accesskey="S" value="保存(S)" onclick="return check();"> </s:submit> &nbsp;&nbsp;&nbsp;&nbsp; 
							<s:reset value="重置(C)" accesskey="C"></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
	</s:form>
	<msg:checker/>
	<script type="text/javascript">
	
	function check(){
		var upwd = document.getElementsByName("var.user_pwd")[0].value;
		var pwd = document.getElementsByName("password")[0].value;
		var pwdc = document.getElementsByName("password_comfirm")[0].value;
		if(upwd=='' ||  upwd.length < 6){
			alert('请输入原密码');
			return false;
		}
		if(pwd.length < 6){
			alert('请输入新密码，密码长度必须大于6位！');
			return false;
		}
		if(pwd != pwdc){
			alert('两次新密码不匹配，请重新输入！');
			return false;
		}
		return true;
	}
	</script>
</body>
</html>