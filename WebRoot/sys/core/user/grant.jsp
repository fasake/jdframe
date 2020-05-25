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
<title>用户基本信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<link rel="StyleSheet" href="/css/tree/dtree.css" type="text/css" />
<script type="text/javascript" src="/css/tree/dtree.js"></script>
<link rel="stylesheet" type="text/css" href="/css/sys/main.css">
<script type="text/javascript" src="/js/sys/progress.js"></script>
</head>
<body onload="init();">
  


	<div class="topBar">
		<table  height="98%" width="98%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp;系统管理&gt;&gt;用户管理&gt;&gt;授权 </td>
				<td>
	              <div style="width:100%;font-size:10pt;padding:2px" align="right">
		               <a href="javascript:history.back();">[back]&nbsp;&nbsp;</a>
	              </div>
              </td>
			</tr>
		</table>
	</div>
	<s:form   action="grant"  namespace="/com/jdframe/sys/core/user" onsubmit="doprogress()">
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
							    <s:hidden name="var.user_zzjg_dm"></s:hidden>
								<s:textfield name="var.user_id" size="40"  readonly="true"></s:textfield><font color="red">&nbsp;&nbsp;(必选性，不可修改)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">用户代码:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.user_dm" size="40"  readonly="true"></s:textfield><font color="red">&nbsp;&nbsp;(必选性，不可修改)</font>
							 </td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">用户名称:</td>
							<td class="repCndEditRight"><s:textfield
									name="var.user_name" size="40"  readonly="true"></s:textfield><font color="red">&nbsp;&nbsp;(必选性，不可修改)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">系统岗位树:</td>
							<td style="border:1px solid #999; padding:1px 3px;white-space:nowrap;width:100% " valign="top">
							<s:hidden name="var.user_station_id"></s:hidden>
							<div style="width:100%;height:300px;overflow:auto;">
							<!--checkbox.name =  dtree_ckbox  id=_chkxxxx -->
							  <script type="text/javascript">
							    <s:property value="stationTree"/>
							  </script>
							</div>
							</td>
						</tr>

						

						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont"><s:submit
									 accesskey="S" value="保存(S)" onclick="return save();"> </s:submit> &nbsp;&nbsp;&nbsp;&nbsp; <s:reset
									value="重置(C)" accesskey="C"></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>
					
				</td>
			</tr>
		</table>
	</s:form>
	<msg:checker/>
</body>
<script type="text/javascript">
function init(){
	//初始化菜单树值
	var stationids = document.getElementsByName("var.user_station_id")[0].value.split(",");
	for(var n=0;n<stationids.length;n++){
		if(document.getElementById("_chk"+stationids[n])){
	    	document.getElementById("_chk"+stationids[n]).checked = true;
		}
	}
}
function save(){
	var stationids = "";
	var stations = document.getElementsByName("dtree_ckbox");
	for(var n=0;n<stations.length;n++){
		if(stations[n].checked == true){
				stationids = stationids+stations[n].value+",";
		}
	}
	if(stationids.lastIndexOf(",")==stationids.length-1){
		stationids = stationids.substr(0,stationids.length-1);
	}
	document.getElementsByName("var.user_station_id")[0].value = stationids;
	return true;
}
</script>
</html>