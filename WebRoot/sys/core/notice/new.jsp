<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%@ taglib prefix="msg" uri="msgTag" %>
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
<title>新建公告基本信息</title>

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
				<td class="topTitle">&nbsp;&nbsp;系统管理&gt;&gt;系统公告管理&gt;&gt;新建</td>
				<td>
	              <div style="width:100%;font-size:10pt;padding:2px" align="right">
		               <a href="javascript:history.back();">[back]&nbsp;&nbsp;</a>
	              </div>
              </td>
			</tr>
		</table>
	</div>
	<s:form action="new" namespace="/com/jdframe/sys/core/notice" enctype="multipart/form-data" method="post"  onsubmit="doprogress()">
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
								colspan="4">&nbsp; 新建系统公告 :</td>
						</tr>
						 

						<tr class="repCnd">
							<td class="repCndLb">公告标题:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.notice_title" size="80"></s:textfield><font color="red">&nbsp;&nbsp;(必选性)</font>
							 </td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">公告级别:</td>
							<td class="repCndEditRight">
							<s:select list="#{'1':'非常紧急','2':'紧急','3':'一般'}" name="var.notice_level"></s:select>
							<font color="red">&nbsp;&nbsp;(必选性，不可修改)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">公告到期日期:</td>
							<td class="repCndEditRight">
							<sx:datetimepicker displayFormat="yyyy-MM-dd" name="var.notice_expire_date"  id="notice_expire_date"   cssStyle="width:200px" ></sx:datetimepicker>
							<font color="red">&nbsp;&nbsp;(必选性)</font>
						     </td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">公告内容:</td>
							<td class="repCndEditRight">
								<s:textarea	name="var.notice_content" rows="20" cols="80"> </s:textarea> <font color="red">&nbsp;&nbsp;(必选性)</font>
							 </td>
						</tr> 
						<tr class="repCnd">
							<td class="repCndLb">附件:</td>
							<td class="repCndEditRight">
							    <s:file name="attach" size="60"></s:file>
							 </td>
						</tr>
						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
								<s:submit  accesskey="S" value="保存(S)"   > </s:submit> &nbsp;&nbsp;&nbsp;&nbsp; 
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
		
</body>
</html>
