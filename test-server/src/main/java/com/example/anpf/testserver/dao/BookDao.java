/**
 * 
 */
package com.example.anpf.testserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anpf.testserver.bean.Book;
import com.example.anpf.testserver.bean.Category;

/**
 * @author anpf
 * @date: 2020/08/11
 */
public interface BookDao extends JpaRepository<Book, Integer>{
	List<Book> findAllByCategory(Category category);
	
	List<Book> findAllByTitleLikeOrAuthorLike(String keyWord1, String keyWord2);

}
