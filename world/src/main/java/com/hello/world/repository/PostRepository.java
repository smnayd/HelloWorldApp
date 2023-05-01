package com.hello.world.repository;

import com.hello.world.entity.Like;
import com.hello.world.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    //Create
    Post save(Post post);

    //Update
    @Modifying
    @Transactional
    @Query("update Post p set p.type = :type where p.id = :id")
    void updateById(@Param("type") String type, @Param("id") int id);

    //Delete
    @Modifying
    @Transactional
    @Query("update Post p set p.isDeleted=:isDeleted where p.id = :id")
    void deleteById(@Param("isDeleted")boolean isDeleted,@Param("id")int id);

    @Query("select p From Post p where p.id = :id")
    Post getById(@Param("id")int id);

    //Get the post with username which has most comments
    @Query("select p from Post p join p.comments c join c.user u group by p.id, u.username order by count(p.id) desc ")
    List<Post> getPostByCommentsAndUsername();
}
