package com.wintmain.spring5.dao;

import com.wintmain.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-25 10:52:46
 */

@Component
public class BookImpl implements BookDao{
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加的方法
    @Override
    public void add(Book book) {
        //1 创建sql语句
        String sql = "insert into t_book values(?,?,?)";
        //2 调用方法实现
        Object[] args={book.getBookId(),book.getBookname(),book.getBookstatus()};

        // 记录行数
        int update = jdbcTemplate.update(sql,args);

        System.out.println(update);
    }

    // 修改的方法
    @Override
    public void update(Book book) {
        String sql = "update t_book set bookname=?,bookstatus=? where bookid=?";
        Object[] args = {book.getBookname(),book.getBookstatus(),book.getBookId()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    // 删除的方法
    @Override
    public void delete(String id) {
        String sql = "delete from t_book where bookid=?";
        int update = jdbcTemplate.update(sql,id);
    }

    // 查询返回某个值
    @Override
    public int selectCount() {
        String sql = "select count(*) from t_book";
        Integer count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from t_book where bookid=?";
        //调用方法
        Book book = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
        return book;
    }

    @Override
    public List<Book> findAllInfo() {
        String sql = "select * from t_book";

        List<Book> bookList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    // 批量添加的业务逻辑
    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql = "update t_book set bookname=?,bookstatus=? where bookid=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDel(List<Object[]> batchArgs) {
        String sql = "delete from t_book where bookid=?";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }


}
