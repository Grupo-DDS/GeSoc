package com.API;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Pais {
	private String id;
	private String name;
	private String locale;
	private String currency_id;
	private String decimal_separator;
	private String thousands_separator;
	private String time_zone;
	private Coordenada geo_information;
	private List<Provincia> states;

	
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
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getCurrency_id() {
		return currency_id;
	}
	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}
	public String getDecimal_separator() {
		return decimal_separator;
	}
	public void setDecimal_separator(String decimal_separeator) {
		this.decimal_separator = decimal_separeator;
	}
	public String getThousands_separator() {
		return thousands_separator;
	}
	public void setThousands_separator(String thousands_separator) {
		this.thousands_separator = thousands_separator;
	}
	public String getTime_zone() {
		return time_zone;
	}
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}
	public Coordenada getGeo_information() {
		return geo_information;
	}
	public void setGeo_information(Coordenada geo_information) {
		this.geo_information = geo_information;
	}
	public List<Provincia> getStates() {
		return states;
	}
	public void setStates(List<Provincia> states) {
		this.states = states;
	}
	
	public static Pais obtenerPais(String id) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{
		Pais pais = null;
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet("https://api.mercadolibre.com/classified_locations/countries/"+id);
            HttpResponse responseGet = client.execute(get);
            HttpEntity responseEntity = responseGet.getEntity();
            ObjectMapper objectMapper = new ObjectMapper();
            pais = objectMapper.readValue(responseEntity.getContent(),Pais.class);
		}
		
		
		return pais;
	}
	
	public static List<Pais> obtenerPaises() throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{
		List<Pais> list = null;
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet("https://api.mercadolibre.com/classified_locations/countries");
            HttpResponse responseGet = client.execute(get);
            HttpEntity responseEntity = responseGet.getEntity();
            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(responseEntity.getContent(),new TypeReference<List<Pais>>(){});
		}
		return list;
	}
	public static void main(String[] args) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{
		List<Pais> list = obtenerPaises(); 
		int i=0;
		while(i<list.size()){
			Pais pais = list.get(i);
			
			System.out.println(pais.getId());
			System.out.println(pais.getName());
			System.out.println(pais.getLocale());
			System.out.println(pais.getCurrency_id());
			pais = obtenerPais(pais.getId());
			System.out.println(pais.getDecimal_separator());
			System.out.println(pais.getThousands_separator());
			System.out.println(pais.getTime_zone());
			if(pais.getGeo_information() != null) {
				System.out.println(pais.getGeo_information().getLocation().getLatitude());
				System.out.println(pais.getGeo_information().getLocation().getLongitude());
			}
			
			int j=0;
			while(j<pais.getStates().size()) {
				Provincia provincia = pais.getStates().get(j);
				System.out.println(provincia.getId());
				System.out.println(provincia.getName());
				j++;
			}
			i++;
			
		}
	}
	
	
	
}
