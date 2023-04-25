package com.example.publicblog.repositories;

import com.example.publicblog.entities.Blog;
import com.example.publicblog.entities.Comment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryBlogRepository implements BlogRepository{

    private static List<Blog> blogs = new CopyOnWriteArrayList<>();

    @Override
    public synchronized Blog addBlog(Blog blog) {
        Integer id = blogs.size();
        blog.setId(id);
        blog.setDate(LocalDate.now().getDayOfMonth() + "." + LocalDate.now().getMonthValue() + "." + LocalDate.now().getYear() + ".");
        blog.setComments(new ArrayList<>());
        blogs.add(Math.toIntExact(id), blog);
        return blog;
    }

    @Override
    public Comment addComment(Integer blogId, Comment comment) {
        blogs.get(blogId).addComment(comment);
        return comment;
    }

    @Override
    public List<Blog> allBlogs() {
        return new ArrayList<>(blogs);
    }

    @Override
    public List<Comment> allComments(Integer blogId) {
        return new ArrayList<>(blogs.get(blogId).getComments());
    }

    @Override
    public Blog findBlog(Integer id) {
        return blogs.get(id);
    }
}
