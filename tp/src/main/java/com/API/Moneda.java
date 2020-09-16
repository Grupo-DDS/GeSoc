package com.API;

import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Moneda {
	@Override
	public String toString() {
		return "Moneda [id=" + id + ", symbol=" + symbol + ", description=" + description + ", decimal_places="
				+ decimal_places + "]";
	}
	public Moneda() {}
	public Moneda(String id, String symbol, String description, int decimal_places) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.description = description;
		this.decimal_places = decimal_places;
	}
	
	
	@Id
	private String id;
	private String symbol;
	private String description;
	private int decimal_places;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDecimal_places() {
		return decimal_places;
	}
	public void setDecimal_places(int decimal_places) {
		this.decimal_places = decimal_places;
	}
	
	public List<Moneda> obtenerListaAPI() throws IOException{
		List<Moneda> list = null;
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet("https://api.mercadolibre.com/currencies/");
            HttpResponse responseGet = client.execute(get);
            HttpEntity responseEntity = responseGet.getEntity();
            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(responseEntity.getContent(),new TypeReference<List<Moneda>>(){});
          
		}
		 return list;
	}
	
	
	
}
