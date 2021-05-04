package com.hotelcalifornia.hotelcalifornia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelcalifornia.hotelcalifornia.model.Hotel;
import com.hotelcalifornia.hotelcalifornia.repository.HotelRepository;

//Controle das operações CRUD de cadastro e de consulta dos hoteis 
@RestController
@RequestMapping({"/hotel"})
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	// Consultar todos os hoteis - http://localhost:8080/hotel
	@GetMapping
	public List findAll(){
		
		return hotelRepository.findAll();
		
	}
	
	// Consultar um determinado hotel pela matricula - http://localhost:8080/hotel/{matricula}
	@GetMapping(value = "{matricula}")
	public ResponseEntity findByMatricula(@PathVariable long matricula){
		
		return hotelRepository.findById(matricula).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	// Criar novo cadastro do hotel - http://localhost:8080/hotel
	@PostMapping
	public Hotel create(@RequestBody Hotel hotel){
		
		return hotelRepository.save(hotel);
		
	}
	
	// Atualiza o hotel cadastrado - http://localhost:8080/hotel/{matricula} 
	@PutMapping(value = "{matricula}")
	public ResponseEntity update(@PathVariable long matricula, @RequestBody Hotel hotel){
		
		return hotelRepository.findById(matricula)
				.map(record -> {
					record.setNome(hotel.getNome());
					record.setValdia(hotel.getValdia());
					record.setCidade(hotel.getCidade());
					record.setEstrelas(hotel.getEstrelas());
					Hotel update = hotelRepository.save(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
		
	}
	
	// Deletar o hotel cadastrado - http://localhost:8080/hotel/{matricula}   
	@DeleteMapping(path = "{matricula}")
	public ResponseEntity delete(@PathVariable long matricula){
		
		return hotelRepository.findById(matricula)
				.map(record -> {
					hotelRepository.deleteById(matricula);
					return ResponseEntity.ok().body("Deletado com Sucesso");
				}).orElse(ResponseEntity.notFound().build());
		
	}

}
