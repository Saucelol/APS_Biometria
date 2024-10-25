package aps.biometria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Entity
@Table(name = "NIVEL1")
public class Nivel1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PK_ID_ESTADO;

	@Column(name = "NOME_ESTADO")
	@NotEmpty(message = "O campo 'Estado' não pode ser vazio!")
	@Size(min = 2, max = 255, message = "Minimo de 2 caracteres")
	private String NOME_ESTADO;

	// Casos de pesticiadas sendo utilizados no estado
	@Column(name = "NUMERO_DE_CASOS_ES")
//	@NotEmpty(message = "O campo 'Numero de casos' não pode ser vazio!")
	@Positive(message = "O número de casos deve ser maior que 0")
	private int NUMERO_DE_CASOS_ES;

	public int getPK_ID_ESTADO() {
		return PK_ID_ESTADO;
	}

	public void setPK_ID_ESTADO(int pK_ID_ESTADO) {
		PK_ID_ESTADO = pK_ID_ESTADO;
	}

	public String getNOME_ESTADO() {
		return NOME_ESTADO;
	}

	public void setNOME_ESTADO(String nOME_ESTADO) {
		NOME_ESTADO = nOME_ESTADO;
	}

	public int getNUMERO_DE_CASOS_ES() {
		return NUMERO_DE_CASOS_ES;
	}

	public void setNUMERO_DE_CASOS_ES(int nUMERO_DE_CASOS_ES) {
		NUMERO_DE_CASOS_ES = nUMERO_DE_CASOS_ES;
	}

}
