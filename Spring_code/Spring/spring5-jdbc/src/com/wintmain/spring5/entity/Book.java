package com.wintmain.spring5.entity;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-25 12:05:50
 */
public class Book {
    private String Bookid;
    private String Bookname;
    private String bookstatus;

    @Override
    public String toString() {
        return "Book{" +
                "Bookid='" + Bookid + '\'' +
                ", Bookname='" + Bookname + '\'' +
                ", bookstatus='" + bookstatus + '\'' +
                '}';
    }

    public String getBookId() {
        return Bookid;
    }

    public void setBookId(String bookId) {
        this.Bookid = bookId;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        this.Bookname = bookname;
    }

    public String getBookstatus() {
        return bookstatus;
    }

    public void setBookstatus(String bookstatus) {
        this.bookstatus = bookstatus;
    }


}
