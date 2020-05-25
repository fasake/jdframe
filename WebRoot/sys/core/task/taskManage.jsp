<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%@ taglib prefix="p" uri="pageTag" %>
<%@ taglib prefix="msg" uri="msgTag" %>
<%@ taglib prefix="sc" uri="selectCodeTag" %>
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
<title>个人待办事项查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/sys/progress.js"></script>
<style type="text/css">
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
	</style>
</head>
<script type="text/javascript">
  window.onerror=fnErrorTrap;
  function fnErrorTrap(){}

</script>
<body class='frbody'>
	<s:form   action="queryTask"  namespace="/com/jdframe/sys/core/task" onsubmit="doprogress()">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr height="5">
				<td width="15" nowrap="nowrap">&nbsp;</td>
				<td width="100%">&nbsp;</td>
				<td width="15" nowrap="nowrap">&nbsp;</td>
			</tr>
			<tr>
				<td></td>
				<td valign="top">
					<table class="editGrid">
						<tr height="30">
							<td class="highLightNormal"   nowrap="nowrap" colspan="2">
							   &nbsp; 待办事项查询 
							</td>
						</tr>
						
						<tr class="repCnd">
							<td class="repCndLb">待办事项标题:</td>
							<td class="repCndEditRight">
								<s:textfield name="task_title" size="40" maxlength="38"></s:textfield><font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">待办事项状态:</td>
							<td class="repCndEditRight">
							<%--
							    <s:select list="#{'0':'未处理','1':'已处理','2':'已处理(过期)' }" name="task_status"></s:select>
							   --%>
							    <sc:select name="task_status" codeType="DM_TASK_STATUS"/>
							    
							</td>
						</tr>
						
						
						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
							<s:submit  accesskey="S" value="查询(S)" > </s:submit> &nbsp;&nbsp;&nbsp;&nbsp;
							<s:reset value="重置(C)" accesskey="C" ></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td valign="top">
				   <table  class="editGrid" cellspacing="0" cellpadding="0" border="0" width="100%">
				      <tr height="30">
						<td class="highLightNormal" colspan="3" nowrap="nowrap">
							&nbsp; 待办事项列表
						</td>
					 </tr>
					 
					 <tr>
						<td width="5">&nbsp;  </td>
						<td width="100%" id="tagsContainer">
							<div>
								<table id="sortTbl" class="editGrid" width="100%">
								   <!-- 翻页表头 固定写法-->
									<tr class="editGridHd">
										<td class="editGridHd" nowrap="nowrap" width="5%">
											待办事项ID
										</td>
										<td class="editGridHd" nowrap="nowrap" width="25%">
											待办事项标题
										</td>
										<td class="editGridHd" nowrap="nowrap" width="10%">
											待办事项发送者
										</td>
										<td class="editGridHd" nowrap="nowrap" width="15%">
											待办事项创建日期
										</td>
										<td class="editGridHd" nowrap="nowrap" width="15%">
											待办事项到期日期
										</td>
										<td class="editGridHd" nowrap="nowrap" width="10%">
											待办事项状态
										</td>
										<td class="editGridHd" nowrap="nowrap" width="10%">
											待办事项级别
										</td>
										<td class="editGridHd" nowrap="nowrap" width="10%">
											待办事项发送系统
										</td>
					                </tr>
					                <!-- 翻页数据 ,固定写法，变量必须是pagenationList-->
					                 <s:iterator value="pagenationList"  var="task">
					                   <tr class="editGrid" type="data">
											<td class="editGrid"  align="right">
												<s:property value="#task.task_id"/>
											</td>
											<td class="editGrid" align="left" style="background:ivory url(/images/sys/taskTitle.gif) no-repeat center left">
											&nbsp;&nbsp;
											<s:if test='#task.task_status!="0"'>
											   <s:property value="#task.task_title"/> &nbsp;&nbsp;
											</s:if>
											<s:if test='#task.task_status=="0"'>
											   <s:if test='#task.task_from=="01"'>
											       <a href="/servlet/doTaskServlet?task_id=<s:property value="#task.task_id" />" Style="cursor: hand" target="_self"><s:property value="#task.task_title"/></a>&nbsp;&nbsp;
											   </s:if>
											   <s:if test='#task.task_from!="01"'>
						                            <a href="/servlet/doTaskServlet?task_id=<s:property value="#task.task_id" />"  Style="cursor: hand" target="_blank"><s:property value="#task.task_title"/></a>&nbsp;&nbsp;					       
											   </s:if>
											   
											</s:if>
											</td>
											<td class="editGrid" align="left">
											    <c:conversion codeType="DM_CZRY" codeNo="#task.task_sender"/>
											</td>
											<td class="editGrid">
											   <s:property value="#task.task_create_date"/>
											</td>
											<td class="editGrid">
											   <s:property value="#task.task_expire_date"/> 
											</td>
											<td class="editGrid">
											   <c:conversion codeType="DM_TASK_STATUS" codeNo="#task.task_status"/>
											</td>
											<td class="editGrid">
											    <c:conversion codeType="DM_PRIORITY" codeNo="#task.task_priority"/>
											</td>
											<td class="editGrid">
											   <c:conversion codeType="DM_SYSTEM" codeNo="#task.task_from"/>
											</td>
									   </tr>
					                 </s:iterator>
					                <!-- 翻页标签 ,固定写法-->
					                <tr class="editGridHd">
										<td class="editGridHd" nowrap="nowrap" align="center" width="100%" colspan="8">
											<p:pages pageSize="10"  />
										</td>
										 
					                </tr>
							</table>
					   </div>
					 </td>
					 <td width="5">&nbsp;  </td>
				 </tr>
				</table>	
			  </td>
			  <td></td>
			</tr>
		</table>
	</s:form>
	<!-- 消息检测器 -->
	<msg:checker/>
    
</body>
</html>