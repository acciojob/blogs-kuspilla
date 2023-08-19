package com.driver.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String userId;
     private String password;
     private String firstName = "test";
     private String lastName = "test";

     @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
     @JoinColumn
     private List<Blog> blogList = new ArrayList<>();

     public User() {
     }

     User(String userId, String password){
          this.userId = userId;
          this.password = password;
     }
     User(String userId, String password,String firstName, String lastName){
          this.userId = userId;
          this.password = password;
          this.firstName = firstName;
          this.lastName = lastName;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getUserId() {
          return userId;
     }

     public void setUserId(String userId) {
          this.userId = userId;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }

     public List<Blog> getBlogList() {
          return blogList;
     }

     public void setBlogList(List<Blog> blogList) {
          this.blogList = blogList;
     }
}