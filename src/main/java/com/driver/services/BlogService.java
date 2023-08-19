package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    UserRepository userRepository1;
    @Autowired
    BlogRepository blogRepository;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
       User user = userRepository1.findById(userId).get();

        Blog blog = new Blog(user,title,content);

        blog.setPubDate(new Date());
        userRepository1.save(user);
        user.getBlogList().add(blog);
        return blog;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images


        blogRepository.deleteById(blogId);
    }
}
