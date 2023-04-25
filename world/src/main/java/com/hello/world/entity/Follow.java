package com.hello.world.entity;

import javax.persistence.*;

@Entity
@Table(name = "follows", uniqueConstraints = @UniqueConstraint(
        columnNames = {"follower_user_id","following_user_id"}
))
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "follower_user_id")
    private int followerId;
    @Column(name = "following_user_id")
    private int followingId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollowerId() {
        return followerId;
    }

    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    public int getFollowingId() {
        return followingId;
    }

    public void setFollowingId(int followingId) {
        this.followingId = followingId;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", followerId=" + followerId +
                ", followingId=" + followingId +
                '}';
    }
}
