<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%@ taglib prefix="p" uri="pageTag" %>
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
<title>系统公告信息查询</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="/css/sys/public.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/grid.css" rel="stylesheet" type="text/css" />
<link href="/css/sys/report.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/sys/progress.js"></script>
<sx:head/>
</head>
<body>
	<div class="topBar">
		<table height="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp;系统管理&gt;&gt;系统公告管理&gt;&gt;</td>
			</tr>
		</table>
	</div>
	<s:form   action="query"  namespace="/com/jdframe/sys/core/notice"  onsubmit="doprogress()">
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
								colspan="4">&nbsp; 系统公告查询 :
							</td>
						</tr>
						
						<tr class="repCnd">
							<td class="repCndLb">公告标题:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.notice_title" size="80" maxlength="78"></s:textfield><font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>

						<tr class="repCnd">
							<td class="repCndLb">公告发布日期起:</td>
							<td class="repCndEditRight">
							    <sx:datetimepicker type="date" displayFormat="yyyy-MM-dd" name="var.notice_create_date_start"  cssStyle="width:200px" ></sx:datetimepicker>
								<font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">公告发布日期止:</td>
							<td class="repCndEditRight">
							    <sx:datetimepicker type="date" displayFormat="yyyy-MM-dd" name="var.notice_create_date_end"  cssStyle="width:200px" ></sx:datetimepicker>
								<font color="red">&nbsp;&nbsp;(可选性，支持模糊查询)</font>
							</td>
						</tr>
						
						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
							<s:submit  accesskey="S" value="查询(S)"  > </s:submit> &nbsp;&nbsp;&nbsp;&nbsp;
							<s:reset value="重置(C)" accesskey="C" ></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
							<s:submit  accesskey="N"  value="新建(N)"  name="init" action="new"  method="init"></s:submit  > &nbsp;&nbsp;&nbsp;&nbsp;
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
							&nbsp; 系统公告列表
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
											公告ID
										</td>
										<td class="editGridHd" nowrap="nowrap" width="40%">
											公告标题
										</td>
										<td class="editGridHd" nowrap="nowrap" width="10%">
											公告发布人
										</td>
										<td class="editGridHd" nowrap="nowrap" width="20%">
											公告发布日期
										</td>
										<td class="editGridHd" nowrap="nowrap" width="20%">
											操作
										</td>
					                </tr>
					                
					                <!-- 翻页数据 ,固定写法，变量必须是pagenationList-->
					                 <s:iterator value="pagenationList"  var="lst">
					                   <tr class="editGrid" type="data">
											<td class="editGrid"  align="right">
												<s:property value="#lst.notice_id"/>
											</td>
											<td class="editGrid" align="left">
												<s:property value="#lst.notice_title"/>
											</td>
											<td class="editGrid" align="left">
											    <c:conversion codeType="DM_CZRY" codeNo="#lst.notice_creater"/>
											</td>
											<td class="editGrid">
											   <s:property value="#lst.notice_create_date"/>
											</td>
											
											<td class="editGrid">
											 <s:url id="lnk_update" action="update!init"  namespace="/com/jdframe/sys/core/notice">
												<s:param name="var.notice_id" value="#lst.notice_id"> </s:param>
											 </s:url>
											 
											 <s:url id="lnk_delete" action="delete"  namespace="/com/jdframe/sys/core/notice">
												<s:param name="var.notice_id" value="#lst.notice_id"> </s:param>
											 </s:url>
											 
											 <s:a href="%{lnk_update}"  onclick="doprogress()">修改</s:a>&nbsp;&nbsp;
											 <s:a href="%{lnk_delete}"  onclick="javascript:return doconfirmDel();"  >删除</s:a>
											</td>
									   </tr>
					                 </s:iterator>
					                <!-- 翻页标签 ,固定写法-->
					                <tr class="editGridHd">
										<td class="editGridHd" nowrap="nowrap" align="center" width="100%" colspan="6">
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
			</tr>
		</table>
	</s:form>
	<!-- 消息检测器 -->
	<msg:checker/>
    
</body>
</html>