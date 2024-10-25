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
@Table(name = "NIVEL3")
public class Nivel3 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PK_ID_FAZENDA;

	@Column(name = "NOME")
	@NotEmpty(message = "O campo 'Nome' não pode ser vazio!")
	@Size(min = 2, max = 255, message = "Minimo de 2 caracteres")
	private String NOME;

	@Column(name = "CPF")
	@NotEmpty(message = "O campo 'CPF' não pode ser vazio!")
	@Size(min = 2, max = 255, message = "Minimo de 2 caracteres")
	private String CPF;

	@Column(name = "CEP")
	@NotEmpty(message = "O campo 'CEP' não pode ser vazio!")
	@Size(min = 2, max = 255, message = "Minimo de 2 caracteres")
	private String CEP;

	// Casos de pesticiadas sendo utilizados numa fazenda
	@Column(name = "NUMERO_DE_CASOS_FZ")
//	@NotEmpty(message = "O campo 'Numero de casos' não pode ser vazio!")
	@Positive(message = "O número de casos deve ser maior que 0")
	private int NUMERO_DE_CASOS_FZ;

	public int getPK_ID_FAZENDA() {
		return PK_ID_FAZENDA;
	}

	public void setPK_ID_FAZENDA(int pK_ID_FAZENDA) {
		PK_ID_FAZENDA = pK_ID_FAZENDA;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public int getNUMERO_DE_CASOS_FZ() {
		return NUMERO_DE_CASOS_FZ;
	}

	public void setNUMERO_DE_CASOS_FZ(int nUMERO_DE_CASOS_FZ) {
		NUMERO_DE_CASOS_FZ = nUMERO_DE_CASOS_FZ;
	}

}
