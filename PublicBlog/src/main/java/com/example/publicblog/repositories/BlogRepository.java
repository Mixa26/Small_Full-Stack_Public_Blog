package com.example.publicblog.repositories;

import com.example.publicblog.entities.Blog;
import com.example.publicblog.entities.Comment;

import java.util.ArrayList;
import java.util.List;

public interface BlogRepository {

    Blog addBlog(Blog blog);

    Comment addComment(Integer blogId, Comment comment);

    List<Blog> allBlogs();

    List<Comment> allComments(Integer blogId);

    Blog findBlog(Integer id);
}
