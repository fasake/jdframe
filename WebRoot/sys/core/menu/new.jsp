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
<title>新建菜单基本信息</title>

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
		<table  height="98%" width="98%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp;系统管理&gt;&gt;系统菜单管理&gt;&gt;新建
                &nbsp;&nbsp;<font color="red"> 当前菜单节点:<c:conversion codeType="DM_MENU" codeNo="var.menu_parent_id"/>(<s:property value="var.menu_parent_id"/>)</font></td>
                <td>
	              <div style="width:100%;font-size:10pt;padding:2px" align="right">
		               <a href="javascript:history.back();">[back]&nbsp;&nbsp;</a>
	              </div>
              </td>
			</tr>
		</table>
	</div>
	<s:form action="new"  namespace="/com/jdframe/sys/core/menu" onsubmit="doprogress()">
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
								colspan="4">&nbsp; 新建系统菜单 :</td>
						</tr>
						 

						<tr class="repCnd">
							<td class="repCndLb">菜单名称:</td>
							<td class="repCndEditRight">
							<s:hidden name="var.menu_parent_id"></s:hidden>
								<s:textfield name="var.menu_name" size="80"></s:textfield><font color="red">&nbsp;&nbsp;(必选性)</font>
							 </td>
						</tr>

						 

						<tr class="repCnd">
							<td class="repCndLb">菜单URL:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.menu_url" size="80"></s:textfield><font color="red">&nbsp;&nbsp;(可选性)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">菜单系统:</td>
							<td class="repCndEditRight"><s:select list="system" name="var.menu_system"></s:select><font color="red">&nbsp;&nbsp;(可选性，用于判断是否属于本系统菜单)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">菜单参数:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.menu_argument"  size="80" ></s:textfield><font color="red">&nbsp;&nbsp;(可选性)</font>
							</td>
						</tr>

 

						 <tr class="repCnd">
							<td class="repCndLb">菜单是否有效:</td>
							<td class="repCndEditRight">
							<s:select list="#{'Y':'是','N':'否'}" name="var.menu_isvalid"   ></s:select><font color="red">&nbsp;&nbsp;(必选性)</font><font color="red">&nbsp;&nbsp;(必选性)</font>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">是否菜单项:</td>
							<td class="repCndEditRight">
							<s:select list="#{'Y':'是','N':'否'}" name="var.menu_isleaf"   ></s:select><font color="red">&nbsp;&nbsp;(必选性，如果是目录将忽略菜单URL和参数)</font>
							</td>
						</tr>
						<%--
						<tr class="repCnd">
							<td class="repCndLb">菜单权限:</td>
							<td class="repCndEditRight">
							<s:textfield name="var.menu_privilege"  size="30"  readonly="true"></s:textfield><font color="red">&nbsp;&nbsp;(必选性，不可修改)</font>
							</td>
						</tr>
                        --%>
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
 
</body>
</html>
