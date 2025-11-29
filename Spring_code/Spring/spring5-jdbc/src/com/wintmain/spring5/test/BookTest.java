package com.wintmain.spring5.test;

import com.wintmain.spring5.entity.Book;
import com.wintmain.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-25 12:34:33
 */
public class BookTest {

    @Test
    public void testAdd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        Book book = new Book();
        book.setBookId("3");
        book.setBookname("Java");
        book.setBookstatus("借阅中");
        bookService.addBook(book);
    }

    @Test
    public void testUpdate(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        Book book = new Book();
        book.setBookId("3");
        book.setBookname("Python");
        book.setBookstatus("已归还");
        bookService.updateBook(book);
    }

    @Test
    public void testDel(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        bookService.deleteBook("1");
    }

    @Test
    public void testquery(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        bookService.selectCount();
    }

    @Test
    public void testObj(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        bookService.findBookInfo("2");
    }

    @Test
    public void testlist(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
        List<Book> all = bookService.findAll();
        System.out.println(all);
    }

    @Test
    public void testbatchadd(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
//        // 批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"4","java","a"};
//        Object[] o2 = {"5","java","a"};
//        Object[] o3 = {"6","java","a"};
//
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//
//        //调用批量添加
//        bookService.batchAddBook(batchArgs);

//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = { "java0909", "a3", "3"};
//        Object[] o2 = { "c++1010", "b4", "4"};
//        Object[] o3 = { "MySQL1111", "c5", "5"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        //调用方法实现批量修改
//        bookService.batchUpdateBook(batchArgs);

        // 批量删除
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        //调用方法实现批量删除
        bookService.batchDelBook(batchArgs);

    }
}
