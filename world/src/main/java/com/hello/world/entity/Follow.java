package com.hello.world.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "follows",uniqueConstraints = @UniqueConstraint(columnNames = { "follower_user_id", "following_user_id" }))
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private boolean isDeleted;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "follower_user_id",
            referencedColumnName = "id"
    )
    private User followerUser;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "following_user_id",
            referencedColumnName = "id"
    )
    private User followingUser;

    public Follow(){

    }
    public Follow(User followerUser, User followingUser){
        this.followerUser = followerUser;
        this.followingUser = followingUser;
        this.createdAt = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public User getFollowerUser() {
        return followerUser;
    }

    public void setFollowerUser(User followerUser) {
        this.followerUser = followerUser;
    }

    public User getFollowingUser() {
        return followingUser;
    }

    public void setFollowingUser(User followingUser) {
        this.followingUser = followingUser;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ",createdAt= " + createdAt +
                ",updatedAt= " + updatedAt +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
