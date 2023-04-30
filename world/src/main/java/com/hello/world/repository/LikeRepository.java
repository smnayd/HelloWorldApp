package com.hello.world.repository;

import com.hello.world.entity.Like;
import com.hello.world.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {
    //Create
    Like save(Like like);

    //Update
    @Modifying
    @Transactional
    @Query("update Like l set l.post.id = :postId where l.id = :id")
    void updateById(@Param("postId") int postId, @Param("id") int id);

    //Delete
    @Modifying
    @Transactional
    @Query("update Like l set l.isDeleted=:isDeleted where l.id = :id")
    void deleteById(@Param("isDeleted")boolean isDeleted,@Param("id") int id);

    //Get by post id
    @Query("select l from Like l where l.post.id = :id")
    List<Like> getByPostId(@Param("id") int id);

    //Get the post which has most likes within last 3 days.
    @Query("select l.post from Like l where l.createdAt >= :createdAt group by l.post.id order by count(l.id) desc")
    List<Object[]> getLikeByCreatedAt(@Param("createdAt")LocalDateTime time);
}
