package com.wish.config;


import com.wish.common.model.PageInfo;

/**
 * Created by wish on 2018/7/11.
 */
public interface Dialect {

    enum Type {
        MYSQL {
            public String getValue() {
                return "mysql";
            }
        },
        ORACLE {
            public String getValue() {
                return "oracle";
            }
        }
    }

    String getPageSql(String sql, PageInfo page);
}
