package com.example.gestion_flotte_avion_ws.controller;

import com.example.gestion_flotte_avion_ws.format.Data;
import com.example.gestion_flotte_avion_ws.models.Tokens;
import com.example.gestion_flotte_avion_ws.models.Users;
import com.example.gestion_flotte_avion_ws.service.TokensService;
import com.example.gestion_flotte_avion_ws.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;
    @Autowired
    TokensService tokensService;

    @PostMapping("/login")
    private Data login(@RequestBody Users user) throws Exception {
        Tokens token = usersService.login(user.getEmail(), user.getPassword());
        if (token != null) {
            tokensService.saveOrUpdate(token);
            return new Data(tokensService.getTokensByToken(token.getToken()));
        }
        return new Data(null);
    }

    @GetMapping
    private List<Users> getAllusers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{userid}")
    private Users getUsers(@PathVariable("userid") int userid) {
        return usersService.getUsersById(userid);
    }

    @DeleteMapping("/{userid}")
    private void deleteUser(@PathVariable("userid") int userid) {
        usersService.delete(userid);
    }

    @PostMapping
    private int saveUser(@RequestBody Users users) {
        usersService.saveOrUpdate(users);
        return users.getIdUser();
    }

    @PutMapping
    private Users update(@RequestBody Users users) {
        usersService.saveOrUpdate(users);
        return users;
    }

    @PostMapping("/check")
    private Data checkConnexion(@RequestBody Tokens token) {
        return new Data(tokensService.isTokenValid(token.getToken()));
    }

    @PostMapping("/disconnect")
    private void deconnexion(@RequestBody Tokens token) {
        tokensService.deconnexion(tokensService.getTokensByToken(token.getToken()));
    }

}
