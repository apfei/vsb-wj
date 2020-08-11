/**
 * 
 */
package com.example.anpf.testserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anpf.testserver.bean.Category;

/**
 * @author anpf
 * @date: 2020/08/11
 */
public interface CategoryDao extends JpaRepository<Category, Integer>{

}
