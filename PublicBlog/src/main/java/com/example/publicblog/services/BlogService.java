package com.example.publicblog.services;

import com.example.publicblog.entities.Blog;
import com.example.publicblog.entities.Comment;
import com.example.publicblog.repositories.BlogRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class BlogService {

    @Inject
    private BlogRepository blogRepository;

    public BlogService(){}

    public Blog addBlog(Blog blog) {return blogRepository.addBlog(blog);}

    public Comment addComment(Integer blogId, Comment comment) {return blogRepository.addComment(blogId, comment);}

    public List<Comment> allComments(Integer blogId) {
        return blogRepository.allComments(blogId);
    }


    public List<Blog> allBlogs() {
        return blogRepository.allBlogs();
    }

    public Blog findBlog(Integer id) {return blogRepository.findBlog(id);}
}
