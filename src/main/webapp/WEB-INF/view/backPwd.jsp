<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<title>找回密码-云在线销售分析系统</title>
<link rel="shortcut icon" href="assets/img/favicon.ico">
<%@ include file="../include/taglib.jsp"%>
<link href="${ctx}/assets/css/plugins/steps/jquery.steps.css"
	rel="stylesheet">
<script src="${ctx}/assets/js/plugins/steps/jquery.steps.min.js"></script>
<script src="${ctx}/assets/js/backPwd.js"></script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
						<h2>找回密码</h2>
						<form id="form" class="wizard-big form-horizontal m-t">
							<h1>账户</h1>
							<fieldset>

								<div class="row">
									<div class="col-sm-4"></div>
									<div class="col-sm-4">
										<h2>账户信息</h2>
										<div class="form-group">
											<label class="col-sm-3 control-label"><i class="red">*
											</i>用户名:</label>
											<div class="col-sm-9">
												<input id="loginName" name="loginName" placeholder="请输入用户名"
													type="text" class="form-control required">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label"><i class="red">*
											</i>验证码:</label>
											<div class="col-sm-6">
												<input id="verifyCode" name='verifyCode' type="text"
													placeholder="请输入验证码 " class="form-control required">
											</div>
											<div class="col-sm-3">
												<img id="verifycode"
													style="width: 100%; height: 32px; backgroud-color: white; cursor: pointer;"
													onclick="loadCode()" />
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="text-center">
											<div style="margin-top: 100px">
												<i class="fa fa-sign-in"
													style="font-size: 180px; color: #e5e5e5"></i>
											</div>
										</div>
									</div>
								</div>

							</fieldset>
							<h1>身份验证</h1>
							<fieldset>

								<div class="row">
									<div class="col-sm-4"></div>
									<div class="col-sm-4">
										<h2>修改密码信息</h2>
										<div class="alert alert-info">
											我们向你的账户内发送了一封验证码邮件，请查收邮件并填写邮箱验证码！
											<button class="btn btn-default btn-sm" id="reSendMail"
												type="button" onclick="sendMail()">重发</button>
										</div>
										<div class="form-group">
											<label><i class="red">* </i>验证码 </label> <input id="mailCode"
												name="mailCode" placeholder="请输入邮箱验证码" type="text"
												class="form-control required">
										</div>
										<div class="form-group">
											<label><i class="red">* </i>新密码 </label> <input id="newPwd"
												name="newPwd" placeholder="请输入新密码" type="password"
												class="form-control required">
										</div>
										<div class="form-group">
											<label><i class="red">* </i>确认新密码 </label> <input
												id="confirmNewPwd" name="confirmNewPwd" placeholder="请确认新密码"
												type="password" class="form-control required">
										</div>
									</div>
									<div class="col-sm-4">
										<div class="text-center">
											<div style="margin-top: 100px">
												<i class="fa fa-sign-in"
													style="font-size: 180px; color: #e5e5e5"></i>
											</div>
										</div>
									</div>
								</div>
							</fieldset>
							<h1>完成</h1>
							<fieldset>
								<h2 id="finishedTitle">还差一步就成功了！</h2>
								<div class="alert alert-info">
										欢迎回来(*^__^*) ,点击完成到登录页面！
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>