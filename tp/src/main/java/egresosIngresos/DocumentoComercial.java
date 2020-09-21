package egresosIngresos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOCUMENTOS_COMERCIALES")
public class DocumentoComercial {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DOC_COMERCIAL")
	private Long id;
	@Column(name="NRO_DOC_COMERCIAL")
	private int nroComercial;
	@Column(name="TIPO_DOC_COMERCIAL")
	private char tipo;
	
	
	public DocumentoComercial(int nroComercial, char tipo) {
		super();
		this.nroComercial = nroComercial;
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "DocumentoComercial [id=" + id + ", nroComercial=" + nroComercial + ", tipo=" + tipo + "]";
	}


	public long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNroComercial() {
		return nroComercial;
	}


	public void setNroComercial(int nroComercial) {
		this.nroComercial = nroComercial;
	}


	public char getTipo() {
		return tipo;
	}


	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
}
