package com.example.gestion_flotte.repository;

import com.example.gestion_flotte.models.Tokens;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TokensRepository extends CrudRepository<Tokens,Integer> {
    @Query(value = "select isTokenValid(?1)",nativeQuery = true)
    public boolean isTokenValid(String token);

    @Query(value = "select * from Tokens where token=?1",nativeQuery = true)
    public Tokens getTokensByToken(String token);

    @Transactional
    @Modifying
    @Query(value = "update Tokens set date_expiration=now() where token=:token",nativeQuery = true)
    public void deconnexion(@Param("token")String token);
}
