package com.driver.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @CreationTimestamp
    private Date publicationDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "Blog", cascade = CascadeType.ALL)
    @JoinColumn
    private List<Image> imageList;

    public Blog(){

    }
    public Blog(Integer id, String title, String content, Date date,User user, List<Image> imageList){
        this.id = id;
        this.title = title;
        this.content = content;
        this.publicationDate =date;
        this.imageList = imageList;
        this.user = user;
    }

    public Blog(User user,String title,String content){
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}