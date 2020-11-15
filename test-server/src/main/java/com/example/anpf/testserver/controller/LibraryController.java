/**
 * 
 */
package com.example.anpf.testserver.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.anpf.testserver.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.anpf.testserver.bean.Book;
import com.example.anpf.testserver.service.BookService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author anpf
 * @date: 2020/08/11
 */
@RestController
public class LibraryController {
    public static final String imgPath = "H:/JavaData/testServer/img";

    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @CrossOrigin
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }
    

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }
    
    @CrossOrigin
    @GetMapping("/api/search")
    public List<Book> searchByKeyword(@RequestParam("keywords") String keywords){
    	System.out.println(keywords);
    	if("" == keywords) {
    		return bookService.list();
    	} else {
    		return bookService.searchByKeywords(keywords, keywords);
    	}
    }

    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/api/covers")
    public String coversUpload(MultipartFile file) throws Exception{
        System.out.println(file.getOriginalFilename().toString());
        File imgFolder = new File(imgPath);
        File f = new File(imgFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
