package com.hello.world.repository;

import com.hello.world.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //Create
    User save(User user);

    //checking user by id
    boolean existsById(int id);

    //checking user by username
    boolean existsByUsername(String username);

    //Update
    @Modifying
    @Transactional
    @Query("update User u set u.username = :username where u.id = :id")
    void updateById(@Param("username") String username, @Param("id") int id);

    //Delete
    @Modifying
    @Transactional
    @Query("delete from User u where u.id = :id")
    void deleteById(@Param("id") int id);

    //Get user by Id
    @Query("select u from User u where u.id = :id")
    User getUserById(@Param("id") int id);

    //Get user by username
    User findByUsername(String username);

}
