/**
 * 
 */
package com.example.anpf.testserver.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author anpf
 * @date: 2020/08/11
 */
@Data
@Entity
@Table(name = "book")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	private String cover;
	private String title;
	private String author;
	private String date;
	private String press;
	private String abs;
	
	@ManyToOne
	@JoinColumn(name = "cid")
	private Category category; 
}
