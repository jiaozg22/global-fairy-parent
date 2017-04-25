package org.global.fairy.dao;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.mysql.jdbc.Connection;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PagingPlugin implements Interceptor {
	private Integer defaultPage;// 当前页码数
	private Integer defaultPageSize;// 每页条数
	private Boolean defaultUseFlag;// 是否启用插件
	private Boolean defaultCheckFlag;// 是否检测当前页码的有效性

	@Override
	public Object plugin(Object statementHandler){
		return Plugin.wrap(statementHandler, this);
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void setProperties(Properties properties) {
		String strDefaultPage = properties.getProperty("default.page", "1");

		String strDefaultPageSize = properties.getProperty("default.pageSize",
				"50");
		String strDefaultUseFlag = properties.getProperty("default.useFlag",
				"false");
		String strDefaultCheckFlag = properties.getProperty(
				"default.checkFlag", "false");

		this.defaultPage = Integer.parseInt(strDefaultPage);
		this.defaultPageSize = Integer.parseInt(strDefaultPageSize);
		this.defaultUseFlag = Boolean.parseBoolean(strDefaultUseFlag);
		this.defaultCheckFlag = Boolean.parseBoolean(strDefaultCheckFlag);

	}
}
