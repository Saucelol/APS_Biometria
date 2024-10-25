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
@Table(name = "NIVEL2")
public class Nivel2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PK_ID_CIDADE;

	@Column(name = "NOME_CIDADE")
	@NotEmpty(message = "O campo 'Estado' não pode ser vazio!")
	@Size(min = 2, max = 255, message = "Minimo de 2 caracteres")
	private String NOME_CIDADE;

	// Casos de pesticiadas sendo utilizados na cidade
	@Column(name = "NUMERO_DE_CASOS_CD")
//	@NotEmpty(message = "O campo 'Numero de casos' não pode ser vazio!")
	@Positive(message = "O número de casos deve ser maior que 0")
	private int NUMERO_DE_CASOS_CD;

	public int getPK_ID_CIDADE() {
		return PK_ID_CIDADE;
	}

	public void setPK_ID_CIDADE(int pK_ID_CIDADE) {
		PK_ID_CIDADE = pK_ID_CIDADE;
	}

	public String getNOME_CIDADE() {
		return NOME_CIDADE;
	}

	public void setNOME_CIDADE(String nOME_CIDADE) {
		NOME_CIDADE = nOME_CIDADE;
	}

	public int getNUMERO_DE_CASOS_CD() {
		return NUMERO_DE_CASOS_CD;
	}

	public void setNUMERO_DE_CASOS_CD(int nUMERO_DE_CASOS_CD) {
		NUMERO_DE_CASOS_CD = nUMERO_DE_CASOS_CD;
	}

}
