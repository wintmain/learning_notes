package com.wintmain.mybatis.mapper;

import com.wintmain.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-01 22:04:24
 */
public interface EmpMapper {
    /**
      解决字段名和属性名不一致的情况：
     * a>为字段起别名，保持和属性名的一致
     *      select eid,emp_name empName,age,sex from t_emp
     * b>设置全局配置，将_自动映射为驼峰
     *      首先在mybatis-config.xml里设置全局配置
     *      <setting name="mapUnderscoreToCamelCase" value="true"/>
     *      select * from t_emp
     * c>通过resultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Emp">
     *     <id property="eid" column="eid"></id>
     *     <result property="empName" column="emp_name"></result>
     *     <result property="age" column="age"></result>
     *     <result property="sex" column="sex"></result>
     *     <result property="email" column="email"></result>
     * </resultMap>
     *
     *     <select id="getAllEmp" resultMap="empResultType">
     *         select * from t_emp
     *     </select>
     * /

    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);


//    *********
    /**
     * 通过分步查询查询部门以及部门中所有的员工信息
     * 分步查询第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);

}
