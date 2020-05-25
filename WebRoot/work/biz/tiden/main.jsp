<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="codeTag" %>
<%@ taglib prefix="p" uri="pageTag" %>
<%@ taglib prefix="msg" uri="msgTag" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Auto Generate Function</title>

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
				<td class="topTitle">&nbsp;&nbsp; Business&gt;&gt;Auto Generate Function&gt;&gt;</td>
			</tr>
		</table>
	</div>
	<s:form   action="query"  namespace="/work/biz/tiden"  enctype="multipart/form-data" method="post" onsubmit="doprogress()">
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
								colspan="4">&nbsp; Query Condition:
							</td>
						</tr>
						
						<!-- // TODO Auto-generated  -->
						<tr class="repCnd">
							<td class="repCndLb">LINENUMBER:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.linenumber" id="linenumber" size="22" maxlength="23"></s:textfield>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">TPAYER:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.tpayer" id="tpayer" size="20" maxlength="21"></s:textfield>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">OPERATEDATE:</td>
							<td class="repCndEditRight">
								<sx:datetimepicker displayFormat="yyyy-MM-dd" name="var.operatedate"    cssStyle="width:200px" ></sx:datetimepicker>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">TAXES:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.taxes" id="taxes" size="22" maxlength="23"></s:textfield>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">STRATDATE:</td>
							<td class="repCndEditRight">
								<sx:datetimepicker displayFormat="yyyy-MM-dd" name="var.stratdate"    cssStyle="width:200px" ></sx:datetimepicker>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">ENDDATE:</td>
							<td class="repCndEditRight">
								<sx:datetimepicker displayFormat="yyyy-MM-dd" name="var.enddate"    cssStyle="width:200px" ></sx:datetimepicker>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">TCLASS:</td>
							<td class="repCndEditRight">
								<s:textfield name="var.tclass" id="tclass" size="2" maxlength="3"></s:textfield>
							</td>
						</tr>

						
						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
								<s:submit  accesskey="S" value="Query(S)" > </s:submit> &nbsp;&nbsp;&nbsp;&nbsp;
								<s:reset value="Reset(C)" accesskey="C" ></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
								<s:submit  accesskey="N"  value="New(N)" name="init" action="new"  method="init"></s:submit  > &nbsp;&nbsp;&nbsp;&nbsp;
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
							&nbsp; Query Result:
						</td>
					 </tr>
					 
					 <tr>
						<td width="5">&nbsp;  </td>
						<td width="100%" id="tagsContainer">
							<div>
								<table id="sortTbl" class="editGrid" width="100%">
								   <!-- query result title -->
									<tr class="editGridHd">
										 <!-- // TODO Auto-generated  -->
													<td class="editGridHd" nowrap="nowrap" >
														linenumber
													</td>
													<td class="editGridHd" nowrap="nowrap" >
														tpayer
													</td>
													<td class="editGridHd" nowrap="nowrap" >
														operatedate
													</td>
													<td class="editGridHd" nowrap="nowrap" >
														taxes
													</td>
													<td class="editGridHd" nowrap="nowrap" >
														stratdate
													</td>
													<td class="editGridHd" nowrap="nowrap" >
														enddate
													</td>
													<td class="editGridHd" nowrap="nowrap" >
														tclass
													</td>
													<td class="editGridHd" nowrap="nowrap" >
														Operation
													</td>

					                </tr>
					                
					                <!-- query result data, pagenationList-->
					                 <s:iterator value="pagenationList"  var="list">
					                      <tr class="editGrid" type="data">
											<!-- // TODO Auto-generated  -->
													<td class="editGrid"  align="left">
														<s:property value="#list.linenumber"  />
													</td>
													<td class="editGrid"  align="left">
														<s:property value="#list.tpayer"  />
													</td>
													<td class="editGrid"  align="left">
														<s:property value="#list.operatedate"   format="yyyy-MM-dd HH:mm:ss" />
													</td>
													<td class="editGrid"  align="left">
														<s:property value="#list.taxes"  />
													</td>
													<td class="editGrid"  align="left">
														<s:property value="#list.stratdate"   format="yyyy-MM-dd HH:mm:ss" />
													</td>
													<td class="editGrid"  align="left">
														<s:property value="#list.enddate"   format="yyyy-MM-dd HH:mm:ss" />
													</td>
													<td class="editGrid"  align="left">
														<s:property value="#list.tclass"  />
													</td>

											
											<td class="editGrid" nowrap="nowrap">
											 <s:url id="lnk_update" action="update!init"  namespace="/work/biz/tiden">
											    							<s:param name="var.linenumber" value="#list.linenumber"  > </s:param>
							<s:param name="var.tpayer" value="#list.tpayer"  > </s:param>

											 </s:url>
											 
											 <s:url id="lnk_delete" action="delete"  namespace="/work/biz/tiden">
																			<s:param name="var.linenumber" value="#list.linenumber"  > </s:param>
							<s:param name="var.tpayer" value="#list.tpayer"  > </s:param>

											 </s:url>
											 
											 <s:a href="%{lnk_update}" onclick="doprogress()">Update</s:a>&nbsp;&nbsp;
											 <s:a href="%{lnk_delete}"  onclick="javascript:return doconfirmDel();" >Delete</s:a>
											</td>
									   </tr>
					                 </s:iterator>
					                <!-- page turning-->
					                 <tr class="editGridHd">
										<td class="editGridHd" nowrap="nowrap" align="center" width="100%" colspan="7">
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
	 <!-- msg tag -->
	<msg:checker/>
</body>
</html>