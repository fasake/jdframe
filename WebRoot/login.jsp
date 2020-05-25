<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="msg" uri="msgTag"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<HTML>

<style>
body {
	TEXT-ALIGN: center;
}
</style>

<HEAD>
<TITLE>JDFrame(J2EE Develop Frame)</TITLE>

<LINK rel=stylesheet type=text/css href="css/window.css">
<LINK rel=stylesheet type=text/css href="css/login.css">
<BODY>
	<DIV id=outer>
		<DIV id=content>
			<DIV id=logo>
				<IMG id=console-title
					alt="JDFrame"
					src="/images/sys/loginTitle2_v2.gif">
			</DIV>
			<DIV id=login>
				<DIV class=jdframe-frame>
 
								<DIV class=c2 style="BORDER-LEFT: #ccc 1px solid;">
									<DIV class=jdframe-titlebar>
										<DIV class=float-container>
											<DIV class=jdframe-titlebar-title-panel>Welcome</DIV>
											<DIV class=jdframe-titlebar-button-panel>&nbsp;</DIV>
										</DIV>
									</DIV>
									<DIV class=jdframe-window-content>
										<FORM id=loginData method=post name=loginData
											action="loginAction">
											<DIV class=message-row>
												<P>Welcome to log in to the workspace </P>
											</DIV>
											<DIV class=input-row>
												<LABEL for=j_username>Username:</LABEL> <SPAN class=ctrl>
													<s:textfield name="user.user_dm" size="21" maxlength="20"></s:textfield>
												</SPAN>
											</DIV>

											<DIV class=input-row>
												<LABEL for=j_password>Password:</LABEL> <SPAN class=ctrl>
													<s:password name="user.user_pwd" size="21" maxlength="20"></s:password>
												</SPAN>
											</DIV>

											<DIV class=input-row>
												<LABEL for=j_password>Checkcode:</LABEL> 
												<SPAN class=ctrl style="display: inline-block;"  align="left"> 
												   <tr align="left"><td nowrap="nowrap" align="left"> 
													<s:textfield name="veriCode" size="5" maxlength="4" cssStyle="vertical-align:middle"></s:textfield>
													<img id="im_vericode" src="/servlet/VeriCodeGen" style="vertical-align:middle" onclick="javascript:document.all.im_vericode.src='/servlet/VeriCodeGen?'+Math.random();" />
													</td></tr>
												</SPAN>
											</DIV>


											<DIV class=button-row>
												<SPAN class=ctrl> <INPUT class=formButton
													onclick="form.submit();this.disabled=true;document.body.style.cursor = 'wait'; this.className='formButton-disabled';"
													value="Login" type=submit>
												</SPAN>

											</DIV>
										</FORM>
									</DIV>

									<DIV class=notice-row>
										<P>It is recommended that users log out when finished with
											the Administration System or when visiting an untrusted
											site.</P>
									</DIV>
								</DIV>
 
				</DIV>
				<DIV class=login-footer>
					<DIV class=info>
						<P id=footerVersion>jdframe: 2.0.3.0</P>
						<P id=copyright>MINAE and/or its affiliates. All rights reserved.</P>
						<P id=trademark></P>
					</DIV>
				</DIV>
			</DIV>
		</DIV>
	</DIV>
	<msg:checker />
	<script type="text/javascript">
		if (self != top)
			window.top.location.replace(self.location);
	</script>
</BODY>
</HTML>
