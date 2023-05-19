package com.hello.world.repository;

import com.hello.world.entity.Like;
import com.hello.world.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
    @Query("update Like l set l.isDeleted=true where l.id = :id")
    void deleteById(@Param("id") int id);

    //Get by post id
    @Query("select l from Like l where l.post.id = :id")
    List<Like> getByPostId(@Param("id") int id);

    //Get the post which has most likes within last 3 days.
    @Query("select p from Like l join l.post p join p.user u where l.createdAt >= :createdAt group by p.id, u.id order by count(l.id) desc")
    List<Post> getLikeByCreatedAt(@Param("createdAt") LocalDate time);
}
