package com.wintmain.restfulcrud.exception;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-05-05 14:49:55
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }

}
