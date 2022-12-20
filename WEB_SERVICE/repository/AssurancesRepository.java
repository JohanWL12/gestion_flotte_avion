package com.example.gestion_flotte.repository;

import com.example.gestion_flotte.models.Assurances;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssurancesRepository extends CrudRepository<Assurances,Integer> {
    @Query(value = "select * from v_assurance where dateexpiration<to_timestamp(?1,'YYYY-MM-dd hh24:mi:ss')",nativeQuery = true)
    public List<Assurances> getAssurancesPreExpiration(String nbmois);
}
