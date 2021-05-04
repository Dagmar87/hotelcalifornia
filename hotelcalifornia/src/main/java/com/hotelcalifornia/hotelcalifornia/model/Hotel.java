package com.hotelcalifornia.hotelcalifornia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
//Classe do tipo do model baseada na tabela Hotel
public class Hotel {
	
	//Matricula(codigo/id) do hotel 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricula;
	
	//Nome do hotel
	private String nome;
	
	//Valor diario de uma estadia no hotel
	@Column(name = "valorDiario")
	private double valdia;
	
	//Cidade onde fica localizada o hotel
	private String cidade;
	
	//Nota de avaliação dada ao hotel
	private double estrelas;

}
