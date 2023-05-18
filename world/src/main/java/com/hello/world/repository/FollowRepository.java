package com.hello.world.repository;

import com.hello.world.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Integer> {
    //Create
    Follow save(Follow follow);

    //Update
    @Modifying
    @Transactional
    @Query("update Follow f set f.followingUser.id = :followingUser where f.followerUser.id = :followerUser")
    void updateByFollowing(@Param("followingUser") int followingUser, @Param("followerUser") int followerUser);

    //Delete
    @Modifying
    @Transactional
    @Query("update Follow f set f.isDeleted=true where f.id = :id")
    void deleteById(@Param("id")int id);

    //Getting the follower count of a user by user id
    @Query("select count(f.id) from Follow f where f.followingUser.id =:followingId and f.followingUser.isDeleted=false")
    int getByFollowingUser(@Param("followingId") int followingId);
    @Query("select f from Follow f")
    List<Follow> getAll();
}
