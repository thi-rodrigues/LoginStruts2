package br.com.soc.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NM_LOGIN")	
	private String nome;
	
	@Column(name="DS_SENHA")
	private String senha;
	
	@Column(name="QT_TEMPO_INATIVIDADE")
	private Long tempoInativividade;
	
	@Column(name="AUTENTICADO")
	private LocalDateTime autenticado;
}
