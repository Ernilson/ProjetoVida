package br.com.vida.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "cadastro")
public class Cadastro {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_c;
    @Column(length = 200, nullable = false)
    private String nome;
   // @Column(length = 200, nullable = false)
    private String ender;
    @Column(length = 20)
    private String fone;
    @Column(length = 40)
    private String email;    
    private Date data;
    @Column(length = 20)
    private String status;
    
    public Cadastro() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cadastro [id_c=" + id_c + ", nome=" + nome + ", ender=" + ender + ", fone=" + fone + ", email=" + email
				+ ", data=" + data + ", status=" + status + "]";
	} 
    
    
}
