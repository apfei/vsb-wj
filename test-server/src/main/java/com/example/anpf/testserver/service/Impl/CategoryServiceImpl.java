/**
 * 
 */
package com.example.anpf.testserver.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.anpf.testserver.bean.Category;
import com.example.anpf.testserver.dao.CategoryDao;
import com.example.anpf.testserver.service.CategoryService;

/**
 * @author anpf
 * @date: 2020/08/11
 */
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao dao;
	
	@Override
	public List<Category> list() {
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return dao.findAll(sort);
	}

	@Override
	public Category get(int id) {		
		return dao.findById(id).orElse(null);
	}

}
