package com.API;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.quartz.SchedulerException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import egresosIngresos.Consola;
import persistencia.MedioDePagoMapperBD;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class MedioDePago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_medioDePago;
	private String id;
	private String name;
	
	public MedioDePago() {}
	public MedioDePago(String id, String name, String payment_type_id) {
		super();
		this.id = id;
		this.name = name;
		this.payment_type_id = payment_type_id;
	}

	@Override
	public String toString() {
		return "MedioDePago [id=" + id + ", name=" + name + ", payment_type_id=" + payment_type_id + "]";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayment_type_id() {
		return payment_type_id;
	}

	public void setPayment_type_id(String payment_type_id) {
		this.payment_type_id = payment_type_id;
	}

	private String payment_type_id;

	public Long getId_medioDePago() {
		return id_medioDePago;
	}

	public static void insertarNuevoMedioDePagoEnBD(MedioDePago mp) {
		MedioDePagoMapperBD.getInstance().insert(mp);
	}

}