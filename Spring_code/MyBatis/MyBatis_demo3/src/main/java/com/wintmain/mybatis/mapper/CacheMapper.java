package com.wintmain.mybatis.mapper;

import com.wintmain.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-04 9:23:08
 */
public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
