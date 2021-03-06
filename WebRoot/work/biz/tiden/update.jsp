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
<title>Auto Generate Function</title>

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
<link rel="stylesheet" type="text/css" href="/css/sys/main.css">
<script type="text/javascript" src="/js/sys/progress.js"></script>	
<sx:head/>

</head>
<body>
	<div class="topBar">
		<table  height="98%" width="98%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="topTitle">&nbsp;&nbsp; Business&gt;&gt;Auto Generate Function&gt;&gt;</td>
			</tr>
			<td>
	            <div style="width:100%;font-size:10pt;padding:2px" align="right">
		           <a href="javascript:history.back();">[back]&nbsp;&nbsp;</a>
	            </div>
            </td>
		</table>
	</div>
	<s:form action="update" namespace="/work/biz/tiden" enctype="multipart/form-data" method="post" onsubmit="doprogress()">
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
							<td class="highLightNormal" width="15%" nowrap="nowrap" colspan="4">&nbsp; Update Form:</td>
						</tr>
						<!-- // TODO Auto-generated  -->
						<tr class="repCnd">
							<td class="repCndLb">LINENUMBER:</td>
							<td class="repCndEditRight">
								<s:hidden name="var.linenumber" ></s:hidden><s:property value="var.linenumber" />
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">TPAYER:</td>
							<td class="repCndEditRight">
								<s:hidden name="var.tpayer" ></s:hidden><s:property value="var.tpayer" />
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">OPERATEDATE:</td>
							<td class="repCndEditRight">
								<sx:datetimepicker    displayFormat="yyyy-MM-dd" name="var.operatedate"    cssStyle="width:200px" ></sx:datetimepicker>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">TAXES:</td>
							<td class="repCndEditRight">
								<s:textfield  name="var.taxes" size="taxes" size="22" maxlength="22"></s:textfield>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">STRATDATE:</td>
							<td class="repCndEditRight">
								<sx:datetimepicker    displayFormat="yyyy-MM-dd" name="var.stratdate"    cssStyle="width:200px" ></sx:datetimepicker>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">ENDDATE:</td>
							<td class="repCndEditRight">
								<sx:datetimepicker    displayFormat="yyyy-MM-dd" name="var.enddate"    cssStyle="width:200px" ></sx:datetimepicker>
							</td>
						</tr>
						<tr class="repCnd">
							<td class="repCndLb">TCLASS:</td>
							<td class="repCndEditRight">
								<s:textfield  name="var.tclass" size="tclass" size="2" maxlength="2"></s:textfield>
							</td>
						</tr>

						<tr class="bgLight" height="30">
							<td colspan="4" align="right" class="normalFont">
								<s:submit  accesskey="S" value="Submit(S)"> </s:submit> &nbsp;&nbsp;&nbsp;&nbsp; 
								<s:reset value="Reset(C)" accesskey="C"></s:reset> &nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						
					</table>
					
				</td>
				<td>
				
				</td>
				
			</tr>
			
		</table>
	</s:form>
	<!-- msg tag -->
	<msg:checker/>
</body>
</html>
