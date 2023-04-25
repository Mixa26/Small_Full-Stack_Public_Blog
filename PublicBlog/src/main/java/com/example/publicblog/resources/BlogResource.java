package com.example.publicblog.resources;

import com.example.publicblog.entities.Blog;
import com.example.publicblog.entities.Comment;
import com.example.publicblog.services.BlogService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/blogs")
public class BlogResource {

    @Inject
    private BlogService blogService;

    public BlogResource(){}

    @GET
    @Produces({"application/json"})
    public Response allBlogs() {return Response.ok(blogService.allBlogs()).build();}

    @GET
    @Path("/comments/{id}")
    @Produces({"application/json"})
    public Response allComments(@PathParam("id") Integer id) {return Response.ok(blogService.allComments(id)).build();}

    @POST
    @Produces({"application/json"})
    public Blog create(@Valid Blog blog) {return blogService.addBlog(blog);}

    @POST
    @Path("/{id}")
    @Produces({"application/json"})
    public Comment addComment(@PathParam("id") Integer id, Comment comment) {return blogService.addComment(id, comment);}

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Blog find(@PathParam("id") Integer id) {return blogService.findBlog(id);}
}
