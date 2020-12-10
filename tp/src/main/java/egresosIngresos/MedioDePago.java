package egresosIngresos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import persistencia.MedioDePagoMapperBD;

@Entity
public class MedioDePago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_medioDePago;
	private String id;
	private String medio;
	private String paymentTypeId;

	public Long getId_medioDePago() {
		return id_medioDePago;
	}


	public String getPaymentTypeId() {
		return paymentTypeId;
	}



	public String getMedio() {
		return medio;
	}

	public boolean datosDelSistema(String medio) {
		switch (medio) {
		case "Visa":
			paymentTypeId = "credit_card";
			id = "visa";
			return true;
		case "Mastercard":
			paymentTypeId = "credit_card";
			id = "master";
			return true;
		case "American Express":
			paymentTypeId = "credit_card";
			id = "amex";
			return true;
		case "Diners Club International":
			paymentTypeId = "credit_card";
			id = "diners";
			return true;
		case "Tarjeta Naranja":
			paymentTypeId = "credit_card";
			id = "naranja";
			return true;
		case "Tarjeta Nativa":
			paymentTypeId = "credit_card";
			id = "nativa";
			return true;
		case "Tarjeta Shopping":
			paymentTypeId = "credit_card";
			id = "shopping";
			break;
		case "Tarjeta Cencosud":
			paymentTypeId = "credit_card";
			id = "cencosud";
			break;
		case "Tarjeta CMR MasterCard":
			paymentTypeId = "credit_card";
			id = "cmr_master";
			break;
		case "Argencard":
			paymentTypeId = "credit_card";
			id = "argencard";
			break;
		case "Cordial":
			paymentTypeId = "credit_card";
			id = "cordial";
			break;
		case "Cordobesa":
			paymentTypeId = "credit_card";
			id = "cordobesa";
			break;
		case "Cabal":
			paymentTypeId = "credit_card";
			id = "cabal";
			return true;
		case "Visa Débito":
			paymentTypeId = "debit_card";
			id = "debvisa";
			return true;
		case "Mastercard Débito":
			paymentTypeId = "debit_card";
			id = "debmaster";
			return true;
		case "Maestro":
			paymentTypeId = "debit_card";
			id = "maestro";
			break;
		case "Cabal D�bito":
			paymentTypeId = "debit_card";
			id = "debcabal";
			break;
		case "Pago Fácil":
			paymentTypeId = "ticket";
			id = "pagofacil";
			break;
		case "RapiPago":
			paymentTypeId = "ticket";
			id = "rapipago";
			break;
		case "Provincia Pagos":
			paymentTypeId = "ticket";
			id = "bapropagos";
			break;
		case "Carga Virtual":
			paymentTypeId = "ticket";
			id = "cargavirtual";
			break;
		case "Cobro Express":
			paymentTypeId = "ticket";
			id = "cobroexpress";
			break;
		case "Red Link":
			paymentTypeId = "atm";
			id = "redlink";
			return true;
		case "Dinero en cuenta":
			paymentTypeId = "account_money";
			id = "account_money";
			return true;
		default:
			return false;
		}
		return false;
	}

	public void setMedio(String _medio) {
		medio = _medio;
	}
	
	public static void insertarNuevoMedioDePagoEnBD(MedioDePago mp) {
		MedioDePagoMapperBD.getInstance().insert(mp);
	}

}