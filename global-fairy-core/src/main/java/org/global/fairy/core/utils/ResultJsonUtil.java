package org.global.fairy.core.utils;

import com.alibaba.fastjson.JSON;

public class ResultJsonUtil {

	public static String toJson(Object obj) {
		String jsonString = JSON.toJSONString(obj);
		return jsonString;
	}

	public static String success(Object obj) {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(success());
		strBuf.append(JSON.toJSONString(obj));
		return strBuf.toString();
	}

	public static String success() {
		String success = "{'succss': 'true','errCode': '0000','data': ''}";
		return success.toString();
	}

	public static String fail(String errorCode) {
		String success = "{'succss': 'false','errCode': '" + errorCode
				+ "','data': ''}";
		return success.toString();
	}

}
