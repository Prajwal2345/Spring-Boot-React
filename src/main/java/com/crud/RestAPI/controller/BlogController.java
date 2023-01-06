package com.crud.RestAPI.controller;

import com.crud.RestAPI.exception.BlogNotFoundException;
import com.crud.RestAPI.model.Blog;
import com.crud.RestAPI.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("/new")
    Blog newBlog(@RequestBody Blog blog){
        return blogRepository.save(blog);
    }

    @GetMapping("/blogs")
    List<Blog> getBlog(){
        return blogRepository.findAll();
    }

    @GetMapping("/blogs/{id}")
    Blog getBlogById(@PathVariable String id){
        return blogRepository.findById(id).orElseThrow(() -> new BlogNotFoundException(id));
    }

    @PutMapping("/update/{id}")
    Blog updateBlog(@RequestBody Blog blog, @PathVariable String id){
        return blogRepository.findById(id)
                .map(blg -> {
                    blg.setTitle(blog.getTitle());
                    blg.setDescription(blog.getDescription());

                    return blogRepository.save(blg);
                }).orElseThrow(() -> new BlogNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteById(@PathVariable String id){
        if(!blogRepository.existsById(id)){
            throw new BlogNotFoundException(id);
        }
        blogRepository.deleteById(id);
        return "Blog deleted successfully!!";
    }

}
