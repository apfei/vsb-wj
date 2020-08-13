/**
 * 
 */
package com.example.anpf.testserver.service;

import java.util.List;

import com.example.anpf.testserver.bean.Book;

/**
 * @author anpf
 * @date: 2020/08/11
 */
public interface BookService {

    List<Book> list();

    void addOrUpdate(Book book);

    void deleteById(int id);

    List<Book> listByCategory(int cid);
    
    List<Book> searchByKeywords(String keyWord1, String keyWord2);
}
