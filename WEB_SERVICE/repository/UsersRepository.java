package com.example.gestion_flotte_avion_ws.repository;

import com.example.gestion_flotte_avion_ws.models.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends CrudRepository<Users, Integer> {

    @Query(value = "select * from users where email= :email and password=:pswd",nativeQuery = true)
    public Users findUserByEmailAndAndPassword(@Param("email") String email,@Param("pswd") String password);
}
