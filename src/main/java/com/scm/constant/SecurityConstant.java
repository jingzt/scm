package com.scm.constant;

public class SecurityConstant {
	public static String SCM_ERP_USER_COOKIE_KEY = "SCM_ERP_USER_COOKIE_KEY"; // 当前登录用户
	public static String SCM_ERP_SHOP_COOKIE_KEY = "SCM_ERP_SHOP_COOKIE_KEY"; // 当前登录用户对应商铺
	public static String USER_LOGIN_VERIFY_CODE_KEY = "USER_LOGIN_VERIFY_CODE_KEY"; // 登录用
	public static String USER_REGISTER_VERIFY_CODE_KEY = "USER_REGISTER_VERIFY_CODE_KEY"; // 注册用
	public static String USER_BACKPWD_VERIFY_CODE_KEY = "USER_BACKPWD_VERIFY_CODE_KEY"; // 找回密码用
	public static String USER_BACKPWD_EMAIL_CODE_KEY = "USER_BACKPWD_EMAIL_CODE_KEY";

	public static String START_LEVEL = "START_LEVEL"; // 评价星级
	public static String MATERIAL_TYPE = "MATERIAL_TYPE"; // 材料类别
	public static String SHOP_TYPE = "SHOP_TYPE"; // 经营类别
	public static String BUSINESS_TYPE = "BUSINESS_TYPE";// 经营方式
	public static String MEASUREMENT_UNIT = "MEASUREMENT_UNIT";// 计量单位
	public static String CONSUMPTION_STYLE = "CONSUMPTION_STYLE";// 消费方式

	// --------------------------------微信----------------------
	public static final String token = "jingzt";

	public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static String APPID = "wxab9ea11aae6cd4a4";
	public static String APPSECRET = "f5e34d63be0dbc7f554925b802ac712a";

	public static String ACCESS_TOKE = "";

	public enum State { // 不要编辑状态代表的值
		ok("正常", 1), stop("冻结", 2), del("删除", -1);
		private String name;
		private int index;

		// 构造方法
		private State(String name, int index) {
			this.name = name;
			this.index = index;
		}

		// 普通方法
		public static String getName(int index) {
			for (State c : State.values()) {
				if (c.getIndex() == index) {
					return c.name;
				}
			}
			return null;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}
	}
}
