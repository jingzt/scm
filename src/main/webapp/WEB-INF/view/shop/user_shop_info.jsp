<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<script src="${ctx}/assets/js/user/user_info.js" type="text/javascript"></script>

</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="row">
			<div class="col-md-8">
				<div class="ibox float-e-margins">
					<div class="ibox-content">
						<h3>账户基本信息</h3>
						<br />
						<p>
							<i class="fa fa-send-o"></i>会员昵称：${user.nickName} <a
								href="javascript:;" onclick="modifyNickName()" id="modifyNickA">修改昵称</a>
						<form id="modifyNickNameForm">
							<input type="text" value="${user.nickName}" name="nickName" />
							<button class="btn btn-primary btn-xs" type="submit">保存</button>
						</form>

						</p>
						<p>
							<i class="fa fa-envelope-o"></i> 登录邮箱：${user.loginName}
						</p>
						<p>
							<i class="fa fa-flag-o"></i>帐号安全： <a href="javascript:;"
								onclick="modifyPwd()">修改密码</a>
						</p>

						<div class="hr-line-dashed"></div>
						<h3>
							店铺基本信息 <a href="toEditShopInfo.htm"><i class="fa fa-edit"></i></a>
						</h3>
						<br />
						<h4>
							<strong>${shop.name }</strong>
							<h5>
								<i class="fa fa-map-marker"></i><fmt:formatDate value="${shop.createTime}" pattern="yyyy-MM-dd" />
								加入
							</h5>
						</h4>
						<p>
							<i class="fa fa-map-pin"></i>${shop.provinceName}${shop.cityName}${shop.districtName}
							${shop.address }
						</p>

						<p><i class="fa fa-envelope-o"></i>邮箱：${shop.email }</p>
						<p><i class="fa fa-phone"></i>电话：${shop.contactInformation }</p>
						<p><i class="fa fa-paper-plane-o"></i>简介：</p>
						<p>
							<c:if test="${empty shop.introduction}">太懒,还未留下足迹...</c:if>
							<c:if test="${!empty shop.introduction}">${shop.introduction }</c:if>
						</p>
						<p><i class="fa fa-star-o"></i>特色：</p>
						<p>
							<c:if test="${empty shop.features}">太懒,还未留下足迹...</c:if>
							<c:if test="${!empty shop.features}">${shop.features }</c:if>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title">最近登录记录</div>
					<div class="ibox-content timeline">
						<c:forEach items="${userLogList }" var="userLog">
							<div class="timeline-item">
								<div class="row">
									<div class="col-xs-3 date">
										<i class="fa fa-user-md"></i>
										
										<br>
										<small class="text-navy">${userLog.loginAddress}</small>
									</div>
									<div class="col-xs-7 content">
										<p class="m-b-xs">
											<strong>
												<fmt:formatDate value="${userLog.loginTime}" type="both" />
											</strong>
										</p>
										<p>登录IP：【<c:if test="${empty userLog.loginIp}">可能从火星来的...</c:if>
												<c:if test="${!empty userLog.loginIp}">${userLog.loginIp}</c:if>】</p>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- 找回密码  start-->
	<div id="modifyPwd" style="display: none; overflow: hidden">
		<div class="row">
			<div class="col-sm-11">
				<form class="form-horizontal m-t" id="modifyPwdForm">
					<div class="form-group">
						<label class="col-sm-4 control-label"><i class="red">*</i>原密码：</label>
						<div class="col-sm-8">
							<input name="oldPwd" class="form-control" placeholder="请输入原密码"
								type="password">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"><i class="red">*</i>新密码：</label>
						<div class="col-sm-8">
							<input name="newPwd" id="newPwd" class="form-control"
								placeholder="请输入新密码" type="password">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"><i class="red">*</i>确认新密码：</label>
						<div class="col-sm-8">
							<input name="confirmPwd" class="form-control" placeholder="确认新密码"
								type="password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-sm-offset-8">
							<button class="btn btn-primary" type="submit">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 找回密码 end -->
</body>
</html>