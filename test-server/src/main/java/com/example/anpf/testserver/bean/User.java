/**
 * 
 */
package com.example.anpf.testserver.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author anpf
 * @date: 2020/08/07
 */
@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String name;
	private String password;

}
