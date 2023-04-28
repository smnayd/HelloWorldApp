package com.hello.world.entity;

import javax.persistence.*;

@Entity
@Table(name = "follows",uniqueConstraints = @UniqueConstraint(columnNames = { "follower_user_id", "following_user_id" }))
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                '}';
    }
}
