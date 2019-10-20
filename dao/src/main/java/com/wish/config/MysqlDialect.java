package com.wish.config;


import com.wish.common.model.PageInfo;

/**
 * Created by wish on 2018/7/11.
 */
public class MysqlDialect implements Dialect {
    public String getPageSql(String sql, PageInfo page) {
        if (null == page) {
            return sql;
        }
        sql = sql.trim();
        boolean isForUpdate = false;
        if (sql.toLowerCase().endsWith(" for update")) {
            sql = sql.substring(0, sql.length() - 11);
            isForUpdate = true;
        }
        StringBuffer pageSql = new StringBuffer();
        pageSql.append("select innerquery.* from (");
        pageSql.append(sql);
        pageSql.append(") innerquery limit ");
        pageSql.append((page.getPage() - 1) * page.getPageSize());
        pageSql.append(", ");
        pageSql.append(page.getPageSize());
        if (isForUpdate) {
            pageSql.append(" for update");
        }
        return pageSql.toString();
    }
}