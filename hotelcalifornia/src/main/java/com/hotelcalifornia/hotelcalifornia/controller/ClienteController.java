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

import com.hotelcalifornia.hotelcalifornia.model.Cliente;
import com.hotelcalifornia.hotelcalifornia.repository.ClienteRepository;

//Controle das operações CRUD de cadastro e de consulta dos clientes dos hoteis 
@RestController
@RequestMapping({"/cliente"})
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	//Consultar uma lista de todos clientes cadastrados - http://localhost:8080/cliente
	@GetMapping
	public List findAll(){
		
		return clienteRepository.findAll();
		
	}
	
	//Consultar um determinado cliente cadastrado partir do CPF deste - http://localhost:8080/cliente/{cpf}
	@GetMapping(value = "{cpf}")
	public ResponseEntity findByCpf(@PathVariable String cpf){
		
		return clienteRepository.findById(cpf).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	//Criar um novo cadastro de um cliente - http://localhost:8080/cliente
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente){
		
		return clienteRepository.save(cliente);
		
	}
	
	//Atualizar os dados de um cliente cadastrado - http://localhost:8080/cliente/{cpf}
	@PutMapping(value = "{cpf}")
	public ResponseEntity update(@PathVariable String cpf, @RequestBody Cliente cliente){
		
		return clienteRepository.findById(cpf)
				.map(record -> {
					record.setCpf(cliente.getCpf());
					record.setNome(cliente.getNome());
					record.setIdade(cliente.getIdade());
					record.setFone(cliente.getFone());
					record.setEmail(cliente.getEmail());
					record.setHotel(cliente.getHotel());
					Cliente update = clienteRepository.save(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
		
	}
	
	//Deletar os dados do cliente cadastrado - http://localhost:8080/cliente/{cpf}
	@DeleteMapping(path = "{cpf}")
	public ResponseEntity delete(@PathVariable String cpf){
		
		return clienteRepository.findById(cpf)
				.map(record -> {
					clienteRepository.deleteById(cpf);
					return ResponseEntity.ok().body("Deletado com Sucesso");
				}).orElse(ResponseEntity.notFound().build());
		
	}
}
