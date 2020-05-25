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
<title>设立登记</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/sys/progress.js"></script>
<sx:head  />
</head>
<body >
  


	<div class="topBar">
		<table height="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp;登记管理&gt;&gt;设立登记(待办事项测试)&gt;&gt;</td>
			</tr>
		</table>
	</div>
	<s:form action="updateSldj"  namespace="/com/jdframe/work/biz/swdj"  onsubmit="doprogress()">
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
								colspan="4">&nbsp; 设立登记 :</td>
						</tr>
						 

						<tr class="repCnd">
							<td class="repCndLb">纳税人名称:</td>
							<td class="repCndEditRight">
								<s:textfield name="dj_nsrxx.nsrmc" size="80"></s:textfield>
							 </td>
						</tr>

						 

						<tr class="repCnd">
							<td class="repCndLb">法定代表人名称:</td>
							<td class="repCndEditRight"><s:textfield
									name="dj_nsrxx.fddbrmc" size="80"></s:textfield></td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">法定代表人证件号码:</td>
							<td class="repCndEditRight"><s:textfield
									name="dj_nsrxx.fddbrzjhm" size="80"></s:textfield></td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">证照类型:</td>
							<td class="repCndEditRight">
							<s:select list="#{'01':'税务登记证' }" name="dj_nsrxx.swdjzlxDm"></s:select>
							   
							</td>
						</tr>
 

						<tr class="repCnd">
							<td class="repCndLb">登记证经营期限起始日期:</td>
							<td class="repCndEditRight">
							       <sx:datetimepicker displayFormat="yyyy-MM-dd" name="dj_nsrxx.djzjyqxqsrq"    cssStyle="width:200px" ></sx:datetimepicker>
						     </td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">登记证经营期限终止日期:</td>
							<td class="repCndEditRight">
							        
							       <sx:datetimepicker displayFormat="yyyy-MM-dd" name="dj_nsrxx.djzjyqxzzrq"    cssStyle="width:200px" ></sx:datetimepicker>
							 </td>
						</tr>

						 

						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
							<s:submit  accesskey="S" value="保存(S)" > </s:submit> &nbsp;&nbsp;&nbsp;&nbsp; 
							<s:reset value="清空(C)" accesskey="C"></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
									</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
	<!-- 消息检测器 -->
	<msg:checker/>
    <script type="text/javascript" src="/js/sys/progress.js"></script>
</body>
</html>