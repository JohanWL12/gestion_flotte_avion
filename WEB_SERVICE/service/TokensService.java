package com.example.gestion_flotte_avion_ws.service;

import com.example.gestion_flotte_avion_ws.models.Tokens;
import com.example.gestion_flotte_avion_ws.repository.TokensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

@Service
public class TokensService {

    @Autowired
    TokensRepository tokensRepository;
    private static final String ALGORITHM = "SHA-1";
    private static final String BYTE_ENCODE = "UTF-8";
    private static final String HEX_ENCODE = "%02x";

    private static String toHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format(HEX_ENCODE, b);
        }
        String hex = formatter.toString();
        formatter.close();
        return hex;
    }

    public static String sha1(String str) throws Exception {
        MessageDigest cryptage = MessageDigest.getInstance(ALGORITHM);
        cryptage.reset();
        cryptage.update(str.getBytes(BYTE_ENCODE));
        return toHex(cryptage.digest());
    }

    public static String generateToken(String id_user) throws Exception {
        LocalTime now = LocalTime.now();
        String token = sha1(id_user.concat(now.toString()));
        return token;
    }

    public List<Tokens> getAllTokens()
    {
        List<Tokens> tokens = new ArrayList<Tokens>();
        tokensRepository.findAll().forEach(books1 -> tokens.add(books1));
        return tokens;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Tokens getTokensById(int id)
    {
        return tokensRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Tokens tokens)
    {
        tokensRepository.save(tokens);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id)
    {
        tokensRepository.deleteById(id);
    }
    //updating a record
    public void update(Tokens tokens, int bookid)
    {
        tokensRepository.save(tokens);
    }

    public boolean isTokenValid(String token){
        return tokensRepository.isTokenValid(token);
    }


    public Tokens getTokensByToken(String token){
        return tokensRepository.getTokensByToken(token);
    }

    public void deconnexion(Tokens token){
        tokensRepository.deconnexion(token.getToken());
    }
}
