package com.wintmain.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wintmain.mpdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-09 16:02:20
 */

@Repository//将类标志为持久层
@Mapper
public interface UserMapper extends BaseMapper<User> {


}
