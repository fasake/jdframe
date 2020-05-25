<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%@ taglib prefix="p" uri="pageTag" %>
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
<title>用户信息查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/sys/progress.js"></script>

</head>
<body>
  


	<div class="topBar">
		<table height="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp;系统管理&gt;&gt;用户管理
                      &nbsp;&nbsp;<font color="red"> 当前机构:<c:conversion codeType="DM_ZZJG" codeNo="var.user_zzjg_dm"/>(<s:property value="var.user_zzjg_dm"/>)</font>
              </td>
              
			</tr>
		</table>
	</div>
	<s:form   action="query" namespace="/com/jdframe/sys/core/user" onsubmit="doprogress()">
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
								colspan="4">&nbsp; 用户查询 :
								<s:hidden name="var.user_zzjg_dm"></s:hidden>
							</td>
						</tr>
						
						<tr class="repCnd">
							<td class="repCndLb">用户代码:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.user_dm" size="20" maxlength="18"></s:textfield><font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">用户名称:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.user_name" size="80" maxlength="78"></s:textfield><font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">用户办公电话:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.user_tel" size="80" maxlength="78"></s:textfield><font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">用户移动电话:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.user_mobile" size="80" maxlength="78"></s:textfield><font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">用户邮箱地址:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.user_email" size="80" maxlength="78"></s:textfield><font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>
						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
							<s:submit  accesskey="S" value="查询(S)"   > </s:submit> &nbsp;&nbsp;&nbsp;&nbsp;
							<s:reset value="重置(C)" accesskey="C" ></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
							<s:submit  accesskey="N"  value="创建用户(N)" name="init" action="new"  method="init" ></s:submit  > &nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td></td>
				<td >
				   <table  class="editGrid" cellspacing="0" cellpadding="0" border="0" width="100%">
				      <tr height="30">
						<td class="highLightNormal" colspan="3" nowrap="nowrap">
							&nbsp; 用户列表
						</td>
					 </tr>
					 
					 <tr>
						<td width="5">&nbsp;  </td>
						<td width="100%" id="tagsContainer">
							<div>
								<table id="sortTbl" class="editGrid" width="100%">
								   <!-- 翻页表头 固定写法-->
									<tr class="editGridHd">
										<td class="editGridHd" nowrap="nowrap" width="10%">
											用户ID(内码)
										</td>
										<td class="editGridHd" nowrap="nowrap" width="15%">
											用户代码
										</td>
										<td class="editGridHd" nowrap="nowrap" width="15%">
											用户名称
										</td>
										<td class="editGridHd" nowrap="nowrap" width="40%">
											用户机构
										</td>
										<td class="editGridHd" nowrap="nowrap" width="20%">
											操作
										</td>
					                </tr>
					                
					                <!-- 翻页数据 ,固定写法，变量必须是pagenationList-->
					                 <s:iterator value="pagenationList"  var="lst">
					                   <tr class="editGrid" type="data">
											<td class="editGrid"  align="right">
												<s:property value="#lst.user_id"/>
											</td>
											<td class="editGrid" align="left">
												<s:property value="#lst.user_dm"/>
											</td>
											<td class="editGrid" align="left">
												<s:property value="#lst.user_name"/>
											</td>
											<td class="editGrid">
											    <c:conversion codeType="DM_ZZJG" codeNo="#lst.user_zzjg_dm"/>
												
											</td>
											<td class="editGrid">
											<s:url id="lnk_update" action="update!init"  namespace="/com/jdframe/sys/core/user">
												<s:param name="var.user_id" value="#lst.user_id"> </s:param>
											 </s:url>
											 
											 <s:url id="lnk_delete" action="delete"  namespace="/com/jdframe/sys/core/user">
												<s:param name="var.user_id" value="#lst.user_id"> </s:param>
											 </s:url>
											 
											 <s:url id="lnk_grant" action="grant!init"  namespace="/com/jdframe/sys/core/user">
												<s:param name="var.user_id" value="#lst.user_id"> </s:param>
											 </s:url>
											 
											 <s:a href="%{lnk_update}" onclick="doprogress()">修改</s:a>&nbsp;&nbsp;
											 <s:a href="%{lnk_delete}" onclick="javascript:return doconfirmDel();" >删除</s:a>
											 <s:a href="%{lnk_grant}" onclick="doprogress()">用户授权</s:a>
											</td>
									   </tr>
					                 </s:iterator>
					                <!-- 翻页标签 ,固定写法-->
					                <tr class="editGridHd">
										<td class="editGridHd" nowrap="nowrap" align="center" width="100%" colspan="5">
											<p:pages pageSize="10"/>
										</td>
										 
					                </tr>
										
										
										
							</table>
					   </div>
					 </td>
					 <td width="5">&nbsp;  </td>
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