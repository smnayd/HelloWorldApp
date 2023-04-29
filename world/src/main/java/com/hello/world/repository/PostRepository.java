package com.hello.world.repository;

import com.hello.world.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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
    @Query("delete from Post p where p.id = :id")
    void deleteById(@Param("id")int id);

    @Query("select p From Post p where p.id = :id")
    Post getById(@Param("id")int id);
    boolean existsById(int id);
}
