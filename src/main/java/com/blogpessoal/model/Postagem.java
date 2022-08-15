package com.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // declaro a classe como uma entidade, podendo se transformar em uma tabela
@Table(name="tb_postagem") // crio a tabela e defino o nome dela
public class Postagem { // A classe se refere a coluna que será criada no MYSQL
	
	
	@Id // definindo o elemento abaixo como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id; // long == BIGINT
	
	
	@NotBlank // define como preenchimento obrigatório, ou seja, NOT NULL
	@Size(min = 3, max = 255) // define o minimo e o maximo de caracteres a serem inseridos
	private String titulo; // String == varchar
	
	
	@NotBlank
	@Size(min = 5, max = 1000)
	private String texto;
	
	
	@UpdateTimestamp
	private LocalDateTime data; // usado para pegar a data e hora
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne 
	@JsonIgnoreProperties("postagem") 
	private Usuario usuario;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
}
