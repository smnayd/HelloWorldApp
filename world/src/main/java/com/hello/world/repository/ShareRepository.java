package com.hello.world.repository;

import com.hello.world.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ShareRepository extends JpaRepository<Share,Integer> {

    //Create
    Share save(Share share);

    //Delete
    @Modifying
    @Transactional
    @Query("update Share s set s.isDeleted = :isDeleted where s.id = :id")
    void deleteById(@Param("isDeleted")boolean isDeleted, @Param("id")int id);
}
