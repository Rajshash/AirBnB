package com.airbnb.repository;

import com.airbnb.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

//    @Query("select p from Property p JOIN City c on p.city=c.id where c.name=:name ")
//    List<Property> searchProperty(@Param("name") String cityName);

    @Query("select p from Property p JOIN p.city c JOIN p.country co where c.name=:name or co.name=:name")
    List<Property> searchProperty(@Param("name") String cityName);
}