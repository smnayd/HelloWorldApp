package com.hello.world.repository;

import com.hello.world.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    //Create
    Comment save(Comment comment);

    //Update
    @Modifying
    @Transactional
    @Query("update Comment c set c.comment = :comment where c.id = :id")
    Comment updateById(@Param("comment")String comment, @Param("id") int id);

    //Delete
   /* @Modifying
    @Transactional
    @Query("update Comment c set c.isDeleted=:isDeleted where c.id = :id ")
    void deleteById(@Param("isDeleted") boolean isDeleted, @Param("id")int id);*/

    //Get by post id
    @Query("select c from Comment c where c.post.id = :id")
    List<Comment> getByPostId(@Param("id") int id);
}
