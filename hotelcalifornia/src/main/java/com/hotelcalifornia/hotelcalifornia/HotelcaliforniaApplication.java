package com.hotelcalifornia.hotelcalifornia;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hotelcalifornia.hotelcalifornia.model.Hotel;
import com.hotelcalifornia.hotelcalifornia.repository.HotelRepository;

@SpringBootApplication
public class HotelcaliforniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelcaliforniaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(HotelRepository hotelrepository){
		
		return args -> {
			
			LongStream.range(1, 5)
			.mapToObj(i -> {
				Hotel hotel = new Hotel();
				hotel.setNome("Hotel name" + i);
				hotel.setValdia(0.00);
				hotel.setCidade("City" + i);
				hotel.setEstrelas(0.00);
				return hotel;		
			}).map(m -> hotelrepository.save(m))
			.forEach(System.out::println);			
		};
		
	}

}
