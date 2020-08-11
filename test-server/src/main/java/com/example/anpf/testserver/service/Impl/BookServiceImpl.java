/**
 * 
 */
package com.example.anpf.testserver.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.anpf.testserver.bean.Book;
import com.example.anpf.testserver.bean.Category;
import com.example.anpf.testserver.dao.BookDao;
import com.example.anpf.testserver.service.BookService;
import com.example.anpf.testserver.service.CategoryService;

/**
 * @author anpf
 * @date: 2020/08/11
 */
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao dao;
	
	@Autowired
	CategoryService service;
	
	@Override
	public List<Book> list() {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return dao.findAll(sort);
	}

	@Override
	public void addOrUpdate(Book book) {
		dao.save(book);
		
	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

	@Override
	public List<Book> listByCategory(int cid) {
		Category category = service.get(cid);
		return dao.findAllByCategory(category);
	}

}
