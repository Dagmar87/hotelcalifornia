package com.hotelcalifornia.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelcalifornia.hotelcalifornia.model.Hotel;

//Repositorio Jpa da classe Hotel
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
