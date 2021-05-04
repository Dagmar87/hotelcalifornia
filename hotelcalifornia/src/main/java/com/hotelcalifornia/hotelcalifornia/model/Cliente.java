package com.hotelcalifornia.hotelcalifornia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Criação de construtores padrões
@AllArgsConstructor
//Cria o construtor
@NoArgsConstructor
//Cria nossos gets e sets, assim como nossos hashcodes, etc 
@Data
//Definir quando uma classe é uma entidade espelho do banco de dados
@Entity
//Classe do tipo do model baseada na tabela Cliente
public class Cliente {
	
	//CPF do cliente
	@Id
	private String cpf;
	
	//Nome do Cliente
	private String nome;
	
	//Idade do Cliente
	private int idade;
	
	//Numero do telefone do Cliente
	private String fone;
	
	//E-mail do Cliente
	private String email;
	
	//O hotel em que o Cliente está hospedado (Numero de matricula do Hotel)
	@OneToOne
	@JoinColumn(name = "matricula")
	private Hotel hotel;

}
