package com.wintmain.spring5.dao;

import com.wintmain.spring5.entity.Book;

import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-25 10:52:03
 */
public interface BookDao {

    // 添加方法
    void add(Book book);

    //修改的方法
    void update(Book book);

    //删除的方法
    void delete(String id);

    int selectCount();

    Book findBookInfo(String id);

    List<Book> findAllInfo();

    void batchAdd(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDel(List<Object[]> batchArgs);
}
