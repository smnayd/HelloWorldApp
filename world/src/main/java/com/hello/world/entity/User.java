package com.hello.world.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 70)
    private String username;
    @Column(unique = true, nullable = false, length = 150)
    private String email;
    @Column(nullable = false, length = 150)
    private String password;
    private String bio;
    private byte[]  photo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @OneToMany(mappedBy = "followerUser", cascade = CascadeType.REMOVE)
    private List<Follow> followers;
    @OneToMany(mappedBy = "followingUser", cascade = CascadeType.REMOVE)
    private List<Follow> followings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Like> likes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Share> shares;

    public User(){

    }
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }
    public User(String username, String email, String password,String bio){
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.createdAt = LocalDateTime.now();
    }
    public User(String username, String email, String password,String bio,byte[] photo){
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.photo = photo;
        this.createdAt = LocalDateTime.now();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] isPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                ", photo=" + photo +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
