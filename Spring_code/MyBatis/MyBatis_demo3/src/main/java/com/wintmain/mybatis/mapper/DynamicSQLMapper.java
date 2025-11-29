package com.wintmain.mybatis.mapper;

import com.wintmain.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-03 14:58:56
 */
public interface DynamicSQLMapper {
    /**
     * 多条件查询
     */
    List<Emp> getEmpByCondition(Emp emp);


    /**
     * 测试choose、when、otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过列表批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
