<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>公告基本信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/css/sys/main.css">
<sx:head/>
</head>
<body>
		<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
			<tr height="5">
				<td width="15" nowrap="nowrap">&nbsp;</td>
				<td width="100%">&nbsp;</td>
				<td width="15" nowrap="nowrap">&nbsp;</td>
			</tr>
			<tr height="100%">
				<td></td>
				<td  width="100%" height="100%">
					<table class="editGrid"  width="100%" height="100%">
						<tr class="repCnd"   >
							<td style="border:1px solid #999; padding:1px 3px;white-space:nowrap;width:100% " valign="top" align="center">
							  <div style="width:100%" align="center"><font size="5" color="red" style="font-weight: bold;"><s:property value="var.notice_title"/></font></div><br>
							     公告发布人:<c:conversion codeType="DM_CZRY" codeNo="var.notice_creater"/> &nbsp;&nbsp;公告发布日期<s:property value="var.notice_create_date"/>
							</td>
						</tr>
						<tr class="repCnd" height="100%">
							<td id="d_noticeContent" style="border:1px solid #999; padding:1px 3px;white-space:nowrap;width:100%;height:100% " valign="top">
							    &nbsp;&nbsp;&nbsp;&nbsp;
							   <s:property value="var.notice_content"/>
							 </td>
						</tr>
						<tr class="repCnd"  >
							<td style="border:1px solid #999; padding:1px 3px;white-space:nowrap;width:100% " valign="top">
							  公告到期日期：<s:property value="var.notice_expire_date"/>
							</td>
						</tr>
						<tr class="repCnd"  >
							<td style="border:1px solid #999; padding:1px 3px;white-space:nowrap;width:100% " valign="top">
							  公告附件：<a href="/servlet/CommonDownLoad?noticeId=<s:property value="var.notice_id"/>"><s:property value="var.notice_attach_name"/></a>
							</td>
						</tr>
						<tr class="bgLight" >
							<td  align="center" class="normalFont">
								<button onclick="javascript:window.close();return false;">关闭</button>
							</td>
						</tr>
						
					</table>
				</td>
				 
			</tr>
		</table>
</body>

</html>
