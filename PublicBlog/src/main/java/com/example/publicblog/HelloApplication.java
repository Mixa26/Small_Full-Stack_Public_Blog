package com.example.publicblog;

import com.example.publicblog.repositories.BlogRepository;
import com.example.publicblog.repositories.InMemoryBlogRepository;
import org.glassfish.jersey.server.ResourceConfig;
import com.example.publicblog.services.BlogService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {

    public HelloApplication() {
        this.property("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", true);
        AbstractBinder binder = new AbstractBinder() {
            protected void configure() {
                this.bind(InMemoryBlogRepository.class).to(BlogRepository.class).in(Singleton.class);
                this.bindAsContract(BlogService.class);
            }
        };
        this.register(binder);
        this.packages(new String[]{"com.example.publicblog.resources"});
    }
}