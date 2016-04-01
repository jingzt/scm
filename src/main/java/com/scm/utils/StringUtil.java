package com.scm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * 用户字符串操作
 * 
 * @author kcy
 * 
 */
public class StringUtil {
	private static final char[] codeSequenceRandom = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9' };

	private static final char[] codeSequenceNumRandom = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public static String ascii2native(String ascii) {
		int n = ascii.length() / 6;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0, j = 2; i < n; i++, j += 6) {
			String code = ascii.substring(j, j + 4);
			char ch = (char) Integer.parseInt(code, 16);
			sb.append(ch);
		}
		return sb.toString();
	}

	public static String Sha1(String str) throws NoSuchAlgorithmException {
		StringBuffer sb = new StringBuffer();
		MessageDigest digest = MessageDigest.getInstance("sha1");
		byte[] digest2 = digest.digest(str.getBytes());
		for (byte b : digest2) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	public static String getAddressByIP(String strIP) {
		try {
			URL url = new URL("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=" + strIP);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
			String line = null;
			StringBuffer result = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
			JSONObject json = (JSONObject) JSONObject.parse(result.toString());
			String s = "" + json.get("country") + json.get("province") + json.get("city");
			return s;

		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 
	 * 功能描述:生成随机数
	 * 
	 * @return String
	 * @version 1.0.0
	 * @author 孔垂云
	 */
	public static String createSerialNum() {
		String serialNum = "";
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			String strRand = String.valueOf(codeSequenceRandom[random.nextInt(codeSequenceRandom.length)]);
			serialNum += strRand;
		}
		return  serialNum;
	}

	/**
	 * 生成字母+数字随机数
	 * 
	 * @param length
	 * @return
	 */
	public static String createRandowmLetter(int length) {
		String serialNum = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String strRand = String.valueOf(codeSequenceRandom[random.nextInt(codeSequenceRandom.length)]);
			serialNum += strRand;
		}
		return serialNum;
	}

	/**
	 * 生成数字随机数
	 * 
	 * @param length
	 * @return
	 */
	public static String createRandowmNum(int length) {
		String serialNum = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String strRand = String.valueOf(codeSequenceNumRandom[random.nextInt(codeSequenceNumRandom.length)]);
			serialNum += strRand;
		}
		return serialNum;
	}

	/**
	 * 判断是否是整数
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isInteger(String integer) {
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher(integer);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否是正整数
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isInteger2(String integer) {
		Pattern p = Pattern.compile("^[0-9]*[1-9][0-9]*$");
		Matcher m = p.matcher(integer);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 把前台传过来的含中文的url字符串转换成标准中文，比如%25E5%258C%2597%25E4%25BA%25AC转换成北京
	 */
	public static String decodeUrl(String url) {
		String str = "";
		try {
			str = URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 取字符除最后一位的子串，比如 aaa,bbb, 返回aaa,bbb
	 * 
	 * @param str
	 * @return
	 */
	public static String subTract(String str) {
		if (str.length() == 0)
			return "";
		else
			return str.substring(0, str.length() - 1);
	}

	/**
	 * 判断字符串是null或空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.equals(""))
			return true;
		else
			return false;
	}

	/**
	 * 判断字符串是null或空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNullOrEmpty(String str) {
		if (str != null && !str.equals(""))
			return true;
		else
			return false;
	}

	/**
	 * 如果为null不trim
	 * 
	 * @param str
	 * @return
	 */
	public static String isNullNoTrim(String str) {
		if (!(str == null)) {

			return str.trim();
		} else {
			return str;
		}
	}

	/**
	 * 把字符串里面的\r\n替换掉，json处理
	 * 
	 * @param str
	 * @return
	 */
	public static String dealJsonFormat(String str) {
		str = str.replace("\r", "");
		str = str.replace("\n", "");
		return str;
	}

	public static boolean checkFileExist(String path) {
		File file = new File(path);
		if (file.isFile() && file.exists()) {
			return true;
		} else
			return false;
	}

	/**
	 * 格式化小数
	 * 
	 * @param val
	 * @param point小数位
	 * @return
	 */
	public static String formatDouble(String val, int point) {
		String str = "";
		DecimalFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(point);
		str = nf.format(Double.parseDouble(val));
		return str.replace(",", "");
	}

	/**
	 * 格式化小数
	 * 
	 * @param val
	 * @param point小数位
	 * @return
	 */
	public static double formatDouble(double val, int point) {
		String str = "";
		DecimalFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(point);
		str = nf.format(val);
		return Double.parseDouble(str.replace(",", ""));
	}

	/**
	 * 格式化两位小数
	 * 
	 * @param val
	 * @param point
	 * @return
	 */
	public static String formatDouble(String val) {
		String str = "";
		DecimalFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(2);
		str = nf.format(Double.parseDouble(val));
		return str.replace(",", "");
	}

	/**
	 * 格式化两位小数
	 * 
	 * @param val
	 * @param point
	 * @return
	 */
	public static double formatDouble(double val) {
		String str = "";
		DecimalFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(2);
		str = nf.format(val);
		return Double.parseDouble(str.replace(",", ""));
	}

	/**
	 * 格式化金钱
	 * 
	 * @param val
	 * @param point
	 * @return
	 */
	public static String formatAmount(double val) {
		NumberFormat nf = new DecimalFormat("#,###.##");
		String str = nf.format(val);
		return str;
	}

	/**
	 * 判断是否是ajax请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean checkAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			return true;
		} else
			return false;
	}

	/**
	 * 获取ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		String szClientIP = request.getHeader("x-forwarded-for");
		if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
			szClientIP = request.getHeader("Proxy-Client-IP");
		if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
			szClientIP = request.getHeader("WL-Proxy-Client-IP");
		if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
			szClientIP = request.getRemoteAddr();
		return szClientIP;
	}

	/**
	 * 
	 * @Title: processFileName
	 * 
	 * @Description: ie,chrom,firfox下处理文件名显示乱码
	 */
	public static String processFileName(HttpServletRequest request, String fileNames) {
		String codedfilename = null;
		try {
			String agent = request.getHeader("USER-AGENT");
			if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
				String name = java.net.URLEncoder.encode(fileNames, "UTF8");
				codedfilename = name;
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
				codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codedfilename;
	}

	public static String text2Html(String str) {
		if (str == null) {
			return "";
		} else if (str.length() == 0) {
			return "";
		}
		str = str.replaceAll("\n", "<br />");
		str = str.replaceAll("\r", "<br />");
		return str;
	}

	/**
	 * 变大写
	 * 
	 * @param str
	 * @return
	 */
	public static String toUpperCase(String str) {
		if (isNullOrEmpty(str))
			return "";
		else
			return str.toUpperCase();
	}

	/**
	 * 获取所有操作参数
	 * 
	 * @param request
	 * @return
	 */
	public static String getOperaParams(HttpServletRequest request) {
		String parameters = "";// 定义所有参数值
		Map<String, String[]> map = request.getParameterMap();
		// /取得所有参数值，用&号组装起来
		Object[] obj = null;
		obj = map.keySet().toArray();
		for (int i = 0; i < obj.length; i++) {
			parameters += obj[i].toString() + "=" + request.getParameter(obj[i].toString()) + "&";
		}
		return parameters;
	}

	// URL编码
	public static String URLEncodeUTF8(String in) {
		try {
			return URLEncoder.encode(in, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
