package general;

public class MedioDePago {
static String medio;
String paymentTypeId;
String id;

public void datosDelSistema(String medio) {
	switch(medio) {
	case "Visa":
		paymentTypeId = "credit_card";
		id = "visa";
		break;
	case "Mastercard":
		paymentTypeId = "credit_card";
		id = "master";
		break;
	case "American Express":
		paymentTypeId = "credit_card";
		id = "amex";
		break;
	case "Diners Club International":
		paymentTypeId = "credit_card";
		id = "diners";
		break;
	case "Tarjeta Naranja":
		paymentTypeId = "credit_card";
		id = "naranja";
		break;
	case "Tarjeta Nativa":
		paymentTypeId = "credit_card";
		id = "nativa";
		break;
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
		break;
	case "Visa D�bito":
		paymentTypeId = "debit_card";
		id = "debvisa";
		break;
	case "Mastercard D�bito":
		paymentTypeId = "debit_card";
		id = "debmaster";
		break;
	case "Maestro":
		paymentTypeId = "debit_card";
		id = "maestro";
		break;
	case "Cabal D�bito":
		paymentTypeId = "debit_card";
		id = "debcabal";
		break;
	case "Pago F�cil":
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
		break;
	case "Dinero en cuenta":
		paymentTypeId = "account_money";
		id = "account_money";
		break;
	default:
		System.out.println("Ingrese el medio nuevamente");
		}
	System.out.println(paymentTypeId);
	System.out.println(id);
}

public void setMedio(String medio) {
	MedioDePago.medio = medio;
}

public static void main(String[] args) {
	MedioDePago medioPago = new MedioDePago();
	medioPago.setMedio("Red Link");
	medioPago.datosDelSistema(medio);
}
}