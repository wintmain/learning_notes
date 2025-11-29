package com.wintmain.mpdemo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-09 15:52:34
 */

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@EqualsAndHashCode
@Data
@TableName("user")
public class User {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;
}
