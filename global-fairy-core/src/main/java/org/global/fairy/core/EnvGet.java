package org.global.fairy.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class EnvGet {

	public static String getEnvByKey(String key) {
		Map map = System.getenv();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			if (entry.getKey().equals(key)) {
				System.out.print(entry.getKey() + "=");
				System.out.println(entry.getValue());
				return entry.getValue().toString();
			}
		}
		return "没有配置环境变量：" + key;
	}

}
