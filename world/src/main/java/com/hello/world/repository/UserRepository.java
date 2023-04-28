package com.hello.world.repository;

import com.hello.world.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //Create a user
    public User save(User user);

    //Update a user
    @Modifying
    @Transactional
    @Query("update User u set u.username = :username where u.id = :id")
    public void updateUser(@Param("username") String username, @Param("id") int id);



    public List<User> findByUsername(String username);

}
