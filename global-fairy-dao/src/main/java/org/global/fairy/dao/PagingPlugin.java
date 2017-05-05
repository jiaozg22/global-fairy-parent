package org.global.fairy.dao;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.global.fairy.modules.PageParams;

import com.mysql.jdbc.Connection;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PagingPlugin implements Interceptor {
	private Integer defaultPage;// 当前页码数
	private Integer defaultPageSize;// 每页条数
	private Boolean defaultUseFlag;// 是否启用插件
	private Boolean defaultCheckFlag;// 是否检测当前页码的有效性

	@Override
	public Object plugin(Object statementHandler) {
		return Plugin.wrap(statementHandler, this);
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		StatementHandler stmtHandler = getUnProxyObject(invocation);
		MetaObject metaStatementHandler = SystemMetaObject
				.forObject(stmtHandler);
		String sql = (String) metaStatementHandler
				.getValue("delegate.boundSql.sql");
		// 不是select 语句
		if (!checkSelect(sql)) {
			return invocation.proceed();
		}
		BoundSql boundSql = (BoundSql) metaStatementHandler
				.getValue("delegate.boundSql");
		Object parameterObject = boundSql.getParameterObject();
		PageParams pageParams = getPageParams(parameterObject);
		// 没有分页参数，不启用插件
		if (pageParams == null) {
			return invocation.proceed();
		}

		// 获取分页参数，获取不到时候使用默认值
		Integer pageNum = pageParams.getPage() == null ? this.defaultPage
				: pageParams.getPage();
		Integer pageSize = pageParams.getPageSize() == null ? this.defaultPageSize
				: pageParams.getPageSize();
		Boolean useFlag = pageParams.getUseFlag() == null ? this.defaultUseFlag
				: pageParams.getUseFlag();
		Boolean checkFlag = pageParams.getCheckFlag() == null ? this.defaultCheckFlag
				: pageParams.getCheckFlag();

		if (!useFlag) {
			// 不使用分页插件
			return invocation.proceed();
		}
		int total = getTotal(invocation, metaStatementHandler, boundSql);
		// 回填总数到分页参数里
		setTotalToPageParams(pageParams, total, pageSize);
		// 检查当前页码的有效性
		checkPage(checkFlag, pageNum, pageParams.getTotalPage());
		// 修改SQL
		return changeSQL(invocation, metaStatementHandler, boundSql, pageNum,
				pageSize);
	}

	private Object changeSQL(Invocation invocation,
			MetaObject metaStatementHandler, BoundSql boundSql,
			Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	private void checkPage(Boolean checkFlag, Integer pageNum, Integer totalPage) {
		// TODO Auto-generated method stub

	}

	private void setTotalToPageParams(PageParams pageParams, int total,
			Integer pageSize) {
		// TODO Auto-generated method stub

	}

	private int getTotal(Invocation invocation,
			MetaObject metaStatementHandler, BoundSql boundSql) {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean checkSelect(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

	private PageParams getPageParams(Object parameterObject) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 从代理对象中分离出真实对象
	 * 
	 * @param invocation
	 * @return 非代理StatementHandler
	 */
	private StatementHandler getUnProxyObject(Invocation invocation) {
		StatementHandler statementHandler = (StatementHandler) invocation
				.getTarget();

		MetaObject metaStatementHandler = SystemMetaObject
				.forObject(statementHandler);

		// 分离代理对象链（由于目标类可能被多个拦截器拦截，从而形成多次代理，通过循环可以分离出最原始的目标类）
		Object object = null;
		while (metaStatementHandler.hasGetter("h")) {
			object = metaStatementHandler.getValue("h");
		}
		if (object == null) {
			return statementHandler;
		}
		return (StatementHandler) object;
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
