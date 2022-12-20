package com.example.gestion_flotte_avion_ws.service;

import com.example.gestion_flotte_avion_ws.models.Tokens;
import com.example.gestion_flotte_avion_ws.models.Users;
import com.example.gestion_flotte_avion_ws.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    //getting all users record by using the method findaAll() of CrudRepository
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Users getUsersById(int id) {
        return usersRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Users users) {
        users.setPassword(DigestUtils.md5DigestAsHex(users.getPassword().getBytes()));
        usersRepository.save(users);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        usersRepository.deleteById(id);
    }

    //updating a record
    public void update(Users users, int userid) {
        usersRepository.save(users);
    }

//    public Users login(String email, String password) {
//        return usersRepository.findUserByEmailAndAndPassword(email, DigestUtils.md5DigestAsHex(password.getBytes()));
//    }

    public Tokens login(String email,String password)throws Exception{
        Users user=usersRepository.findUserByEmailAndAndPassword(email, DigestUtils.md5DigestAsHex(password.getBytes()));
        if (user!=null){
            Tokens token=new Tokens();
            token.setToken(TokensService.generateToken(user.getIdUser().toString()));
            token.setUser(user);
            return token;
        }
        return null;
    }

    public void deconnexion(){

    }
}
