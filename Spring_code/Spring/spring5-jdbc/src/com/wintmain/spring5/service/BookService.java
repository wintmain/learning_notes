package com.wintmain.spring5.service;

import com.wintmain.spring5.dao.BookDao;
import com.wintmain.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-25 10:51:43
 */

@Service
public class BookService {
    // 注入dao
    @Autowired
    private BookDao bookDao;

    // 添加的方法
    public void addBook(Book book) {
        bookDao.add(book);
    }

    // 修改的方法
    public void updateBook(Book book){
        bookDao.update(book);
    }

    // 删除的方法
    public void deleteBook(String id){
        bookDao.delete(id);
    }

    //查询返回某个值
    public void selectCount(){
        int count = bookDao.selectCount();
        System.out.println(count);
    }

    // 查询返回的对象
    public void findBookInfo(String id){
        Object obj = bookDao.findBookInfo(id);
        System.out.println(obj);
        System.out.println(obj.getClass());
    }

    // 查询返回的集合
    public List<Book> findAll(){
        return bookDao.findAllInfo();
    }


    // 批量添加
    public void batchAddBook(List<Object[]> batchArgs){
        bookDao.batchAdd(batchArgs);
    }

    // 批量修改
    public void batchUpdateBook(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }

    // 批量修改
    public void batchDelBook(List<Object[]> batchArgs){
        bookDao.batchDel(batchArgs);
    }
}
