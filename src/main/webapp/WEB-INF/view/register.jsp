<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<title>注册账户-云在线销售分析系统</title>
<link rel="shortcut icon" href="assets/img/favicon.ico">
<%@ include file="../include/taglib.jsp"%>
<link href="${ctx}/assets/css/plugins/steps/jquery.steps.css"
	rel="stylesheet">
<script src="${ctx}/assets/js/plugins/steps/jquery.steps.min.js"></script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
						<h2>注册向导</h2>
						<p>欢迎注册，请您按照提示填写相关信息</p>

						<form id="form" class="wizard-big">
							<h1>账户</h1>
							<fieldset>
								<div class="row">
									<div class="col-sm-4"></div>
									<div class="col-sm-4">
										<h2>账户信息</h2>
										<div class="form-group">
											<label><i class="red">* </i>用户名 </label> <input
												id="loginName" name="userInfo.loginName"
												placeholder="请输入可用邮箱" type="text" class="form-control">

										</div>
										<div class="form-group">
											<label><i class="red">* </i>密码 </label> <input id="loginPwd"
												name="userInfo.loginPwd" type="password" placeholder="请输入密码"
												class="form-control required">
										</div>
										<div class="form-group">
											<label><i class="red">* </i>确认密码 </label> <input id="confirm"
												name="confirm" type="password" placeholder="请输入确认密码"
												class="form-control required">
										</div>
										<div class="form-group">
											<label>推荐码 </label> <input id="recommendCode"
												name="userInfo.recommendCode" type="text"
												placeholder="如果有，请输入推荐码" class="form-control">
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
										<h2>验证码信息</h2>
										<div class="alert alert-info" id="prompt">
											我们向你的申请注册邮箱内<span id="sendEmailAddress"></span>发送了一封验证邮件，请查收邮件并填写邮箱验证码！<a
												href="#" id="sendEmailUrl" target='blank'>跳转邮箱</a>
											<button class="btn btn-default btn-sm" id="reSendMail"
												type="button" onclick="sendMail()">重发</button>
										</div>

										<div class="form-group">
											<label><i class="red">* </i>验证码 </label> <input
												id="verifyCode" name="verifyCode" placeholder="请输入验证码"
												type="text" class="form-control">
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

							<h1>店铺信息</h1>
							<fieldset>
								<div class="row">
									<div class="col-sm-4"></div>
									<div class="col-sm-4">
										<div class="form-group">
											<label><i class="red">* </i>店铺名称 </label> <input
												id="shopName" name="shopInfo.name" placeholder="请输入店铺名称"
												type="text" class="form-control required">
										</div>
										<div class="form-group">
											<label><i class="red">* </i>法人 </label> <input
												id="legalPersonName" name="shopInfo.legalPersonName"
												type="text" placeholder="请输入法人姓名"
												class="form-control required">
										</div>
										<div class="form-group">
											<input type="hidden" name="shopInfo.provinceName" /> <input
												type="hidden" name="shopInfo.cityName" /> <input
												type="hidden" name="shopInfo.districtName" /> <label><i
												class="red">*</i>地址：</label> <select class="form-control col-sm-4"
												name="shopInfo.provinceId">
												<option value="">选择省</option>
												<c:forEach items="${allProvince }" var="province">
													<option value="${province.id }">${province.name }</option>
												</c:forEach>
											</select> <select class="form-control col-sm-4" name="shopInfo.cityId"">
												<option value=''>选择市</option>
												<c:forEach items="${allCity }" var="city">
													<option value="${city.id }">${city.name }</option>
												</c:forEach>
											</select> <select class="form-control col-sm-4"
												name="shopInfo.districtId">
												<option value=''>选择区</option>
												<c:forEach items="${allDistrict }" var="district">
													<option value="${district.id }">${district.name }</option>
												</c:forEach>
											</select>

										</div>
										<div class="form-group">
											<label><i class="red">* </i>联系方式 </label> <input
												id="contactInformation" name="shopInfo.contactInformation"
												type="text" placeholder="请输入联系方式"
												class="form-control required">
										</div>
									</div>
									<div class="col-sm-4"></div>
								</div>
							</fieldset>
							<h1>完成</h1>
							<fieldset>
								<h3>免责声明与责任限制</h3>
								<p>您使用本站不构成您与本站所有者的合同，本站也没有任何担保（包括但不限于针对特定目的的适用性和不侵犯知识产权等方面）。
									在任何情况下，无论是根据合同或侵权行为抑或其它任何法律理论，也无论本站是否被告知有此类损害的可能性，本站及其与本站有合作的任何其它第三方均不对由于本站、链接到本站点的任何其他站点或者包含在任何或所有此类站点中的信息或服务的使用、无法使用或使用结果而造成的任何损害负责，包括但不限于直接的和/或间接的利润损失、数据损毁、精神损害等。
								</p>
								<h3>使用条款</h3>
								<p>以下为使用本网站(下称「本网站」)的有关条款(下称「本条款」)。若不接受本条款，请不要使用本网站提供的服务。</p>
								<p>当您使用本网站提供的服务时，即表明已详细阅读及了解本条款，并同意受本条款约束。本网站可能随时以更新网页方式单方面修改本条款，而不会作另行通知。您应定期浏览此网页，以了解对您具有约束力的条款是否有所修改。若您违反任何条款，或本网站怀疑您违反任何条款，或本网站相信您的行为违反适用法律或损害本网站或其用户的利益，本网站可在您获知或不获知的情况下终止您进入本网站及使用各项服务，并采取法律行动。
								</p>
								<p>本网站系统的内容没有义务针对个人进行修改(定制功能用户除外)。本网站可能不定时更新内容功能而不会作另行通知，为了保证用户体验会尽量避开工作时间进行更新。针对功能定制用户，我们会只把该功能针对定制账户开放，并根据协议进行持续维护。若该定制功能有向大众公开的必要，会征得定制用户的同意。
								</p>
								<br /> <input id="acceptTerms" name="acceptTerms"
									type="checkbox" class="required"> <label
									for="acceptTerms">我同意注册条款</label>
							</fieldset>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="assets/js/register.js"></script>
</body>

</html>