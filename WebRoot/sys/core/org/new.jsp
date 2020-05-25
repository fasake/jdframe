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
<title>新建组织机构基本信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/sys/common_funcs.js"></script>
<script type="text/javascript" src="/js/sys/progress.js"></script>

</head>
<body>
	<div class="topBar">
		<table height="98%" width="98%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp;系统管理&gt;&gt;组织机构管理&gt;&gt;新建&nbsp;&nbsp;<font color="red"> 当前机构:<c:conversion codeType="DM_ZZJG" codeNo="var.zzjg_dm_sj"/>(<s:property value="var.zzjg_dm_sj"/>)</font></td>
				<td>
					<div style="width:100%;font-size:10pt;padding:2px" align="right">
			          <a href="javascript:history.back();">[back]&nbsp;&nbsp;</a>
			        </div>
				</td>
			</tr>
		</table>
		
	</div>
	<s:form action="new"  namespace="/com/jdframe/sys/core/org" onsubmit="doprogress()">
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
								colspan="4">&nbsp; 新建组织机构 :</td>
								
						</tr>
					 

						<tr class="repCnd">
							<td class="repCndLb">机构代码:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.zzjg_dm" size="80"  maxLength="20" ></s:textfield><font color="red">&nbsp;&nbsp;(必选性)</font>
							 </td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">机构全称:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.zzjg_name" size="80"></s:textfield><font color="red">&nbsp;&nbsp;(必选性)</font></td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">机构简称:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.zzjg_jc" size="80"></s:textfield><font color="red">&nbsp;&nbsp;(必选性)</font></td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">机构地址:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.zzjg_dz" size="80"></s:textfield><font color="red">&nbsp;&nbsp;(可选性)</font></td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">机构电话:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.zzjg_dh"></s:textfield><font color="red">&nbsp;&nbsp;(可选性)</font></td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">机构坐标:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.zzjg_coord"></s:textfield><font color="red">&nbsp;&nbsp;(可选性)</font></td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">机构类型:</td>
							<td class="repCndEditRight">
							<s:select list="#{'J':'机构','B':'部门'}"   name="var.zzjg_bz"></s:select><font color="red">&nbsp;&nbsp;(必须性)</font>
						     </td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">上级机构代码:</td>
							<td class="repCndEditRight">
							        <s:hidden name="var.zzjg_dm_sj"></s:hidden>
									<c:conversion codeType="DM_ZZJG" codeNo="var.zzjg_dm_sj"/><font color="red">&nbsp;&nbsp;(必须性)</font>
									</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">机构职责:</td>
							<td class="repCndEditRight"><s:textarea
									name="var.zzjg_resp" rows="13" cols="80"></s:textarea><font color="red">&nbsp;&nbsp;(可选性)</font>
							</td>
						</tr>

						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
							<s:submit  accesskey="S" value="保存(S)"> </s:submit> &nbsp;&nbsp;&nbsp;&nbsp; 
							<s:reset value="清空(C)" accesskey="C"></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
									
						</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
      <!-- 消息检测器 -->
	<msg:checker/>
	</s:form>
 
</body>
</html>
