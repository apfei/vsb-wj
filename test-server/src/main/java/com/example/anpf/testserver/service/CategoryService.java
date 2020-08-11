/**
 * 
 */
package com.example.anpf.testserver.service;

import java.util.List;

import com.example.anpf.testserver.bean.Category;

/**
 * @author anpf
 * @date: 2020/08/11
 */
public interface CategoryService {

	List<Category> list();
	
	Category get(int id);
}
