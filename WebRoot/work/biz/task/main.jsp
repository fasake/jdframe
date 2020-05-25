<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%@ taglib prefix="msg" uri="msgTag" %>
<%@ taglib prefix="sc" uri="selectCodeTag" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
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
<title>Auto Generate Function</title>

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
<link rel="stylesheet" type="text/css" href="/css/sys/main.css">
<script type="text/javascript" src="/js/sys/common_funcs.js"></script>
<script type="text/javascript" src="/js/sys/progress.js"></script>

<sx:head  />

</head>
<body>
	<div class="topBar">
		<table  height="98%" width="98%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp; 自定义待办事项&gt;&gt;</td>
			</tr>
			<td>
			<!-- 
	            <div style="width:100%;font-size:10pt;padding:2px" align="right">
		          <a href="javascript:history.back();">[back]&nbsp;&nbsp;</a>
	            </div>
	          -->
            </td>
		</table>
	</div>
	<s:form action="new" namespace="/work/biz/task"  enctype="multipart/form-data" method="post" onsubmit="doprogress()">
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
							<td class="highLightNormal" width="15%" nowrap="nowrap" colspan="4">&nbsp; 待办事项选项:</td>
						</tr>
						<!-- // TODO Auto-generated  -->
						<tr class="repCnd">
							<td class="repCndLb">标题:</td>
							<td class="repCndEditRight">
								<s:textfield name="title" size="linenumber" size="40" maxlength="40"></s:textfield>
								<font color="red">显示在用户待办事项列表中的标题</font>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">优先级:</td>
							<td class="repCndEditRight">
								 <sc:select name="priority"  codeType="DM_PRIORITY"/>
							</td>
						</tr>
						 
						<tr class="repCnd">
							<td class="repCndLb">链接地址:</td>
							<td class="repCndEditRight">
								<s:textfield name="link" size="tpayer" size="40" maxlength="40"></s:textfield>
								<font color="red">用户点击待办事项后系跳转到的地址，本系统链接地址以/开头，其他系统以http,ftp等开头</font>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">接收系统:</td>
							<td class="repCndEditRight">
								<sc:select name="from" codeType="DM_SYSTEM"/>
								<font color="red">待办事项接收系统，如果是其他系统将以弹出窗口显示并自动结束待办事项</font>
							</td>
						</tr>
						 
						<tr class="repCnd">
							<td class="repCndLb">到期日期:</td>
							<td class="repCndEditRight">
								<sx:datetimepicker  displayFormat="yyyy-MM-dd" name="enddate"    cssStyle="width:200px" ></sx:datetimepicker>
								<font color="red">待办事项到期时间</font>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">接收权限:</td>
							<td class="repCndEditRight">
								<s:textfield name="menu_id" size="tclass" size="20" maxlength="20"></s:textfield>
								<font color="red">填写菜单ID，用于判断待办事项接收范围，系统用户如果此菜单的权限就会收到本条发送的待办事项</font>
							</td>
						</tr>

						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
								<s:submit  accesskey="S" value="Submit(S)"> </s:submit> &nbsp;&nbsp;&nbsp;&nbsp; 
								<s:reset value="Reset(C)" accesskey="C"></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>	
				</td>
				<td></td>
			</tr>
		</table>
	</s:form>
	<!-- msg tag -->
	<msg:checker/>

</body>
</html>
