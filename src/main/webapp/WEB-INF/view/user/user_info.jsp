<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<%@ include file="../../include/taglib.jsp"%>
<script src="${ctx}/assets/js/user/user_info.js"
	type="text/javascript"></script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeIn">
		<div class="row">
			<div class="col-md-8">
				<div class="ibox float-e-margins">
					<div class="ibox-title">账户基本信息</div>
					<div class="ibox-content">
                        <p>
                        <i class="fa fa-send-o"></i>会员昵称：${userInfo.nickName}  <a href="javascript:;" onclick="modifyNickName()" id="modifyNickA">修改昵称</a>
	                        <form id="modifyNickNameForm">
	                        	<input type="text" value="${userInfo.nickName}" name="nickName"/>
	                        	<button class="btn btn-primary btn-xs" type="submit">保存</button>
	                        </form>
	                       
                        </p>
                        <p><i class="fa fa-envelope-o"></i> 登录邮箱：${userInfo.loginName}
                        </p>
                        <p><i class="fa fa-flag-o"></i>帐号安全： <a href="javascript:;" onclick="modifyPwd()">修改密码</a>
                        </p>
					</div>
					<div class="ibox-title">店铺基本信息</div>
					<div class="ibox-content">
                        <h4><strong>${shop.name }</strong></h4>
                            <p><i class="fa fa-map-marker"></i>${shop.provinceName}${shop.cityName}${shop.districtName} ${shop.address }</p>
                            <p> <fmt:formatDate value="${shop.createTime }" pattern="yyyy-MM-dd"/>加入</p>
                            <p>邮箱： ${shop.email }</p>
                            <p>电话： ${shop.contactInformation }</p>
                            <h5>简介</h5>
                            <p><c:if test="${shop.introduction==null }">暂无</c:if><c:if test="${shop.introduction!=null }">${shop.introduction }</c:if></p>
                            <h5 class="tag-title">特色</h5>
                            <ul class="tag-list" style="padding: 0">
                                <li><a href="file_manager.html">爱人</a>
                                </li>
                                <li><a href="file_manager.html">工作</a>
                                </li>
                                <li><a href="file_manager.html">家庭</a>
                                </li>
                                <li><a href="file_manager.html">孩子</a>
                                </li>
                                <li><a href="file_manager.html">假期</a>
                                </li>
                                <li><a href="file_manager.html">音乐</a>
                                </li>
                                <li><a href="file_manager.html">照片</a>
                                </li>
                                <li><a href="file_manager.html">电影</a>
                                </li>
                            </ul>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="ibox float-e-margins">
					<div class="ibox-title"></div>
					<div class="ibox-content"></div>
				</div>
			</div>

		</div>
	</div>
	<!-- 找回密码  start-->
	<div id="modifyPwd" style="display: none;overflow: hidden">
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
							<input name="newPwd" id="newPwd" class="form-control" placeholder="请输入新密码"
								type="password">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label"><i class="red">*</i>确认新密码：</label>
						<div class="col-sm-8">
							<input name="confirmPwd" class="form-control" placeholder="确认新密码"
								type="password" >
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