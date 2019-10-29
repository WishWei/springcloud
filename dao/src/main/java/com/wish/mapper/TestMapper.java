package com.wish.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by wish on 2019/3/4.
 */
public interface TestMapper {
    void insert(String name);

    void update(@Param("id")Integer id, @Param("name") String name);
}
