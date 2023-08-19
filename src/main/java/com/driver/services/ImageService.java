package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {


    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Blog blog = blogRepository2.findById(blogId).get();
        Image image = new Image(blog,description,dimensions);
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;

    }

    public void deleteImage(Integer id) throws Exception{

        Optional<Image> optionalImage = imageRepository2.findById(id);
        if(!optionalImage.isPresent()){
            throw new Exception("Id not valid");
        }
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) throws Exception{
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        Optional<Image> optionalImage = imageRepository2.findById(id);
        if(!optionalImage.isPresent()) {
            throw new Exception("Id is invalid");
        }
        Image image =optionalImage.get();
        String imageDirection = image.getDimensions();
        String[] imagerr = imageDirection.split("x");
        String[] imagescreen = screenDimensions.split("x");
        int imagewidth = Integer.parseInt( imagerr[0]);
        int imageheight = Integer.parseInt(imagerr[1]);
        int imagescreenwidth = Integer.parseInt(imagescreen[0]);
        int imagescreenheight = Integer.parseInt(imagescreen[1]);

        int width = imagescreenwidth / imagewidth;
        int height = imagescreenheight / imageheight;
        int ans = height * width;
    return ans;
    }
}
