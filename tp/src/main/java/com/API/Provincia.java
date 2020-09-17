package com.API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Entity
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_provincia;
	
	private String id;
	private String name;
	@ManyToOne
	
	private Pais country;
	@OneToOne(cascade = CascadeType.ALL)
	private Coordenada geo_information;
	private String time_zone;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "state_id_provincia")
	private List<Ciudad> cities;
	
	public Pais getCountry() {
		return country;
	}
	public void setCountry(Pais country) {
		this.country = country;
	}
	public Long getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(Long id_provincia) {
		this.id_provincia = id_provincia;
	}
	public Coordenada getGeo_information() {
		return geo_information;
	}
	public void setGeo_information(Coordenada geo_information) {
		this.geo_information = geo_information;
	}
	public String getTime_zone() {
		return time_zone;
	}
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}
	public List<Ciudad> getCities() {
		return cities;
	}
	public void setCities(List<Ciudad> cities) {
		this.cities = cities;
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
	
	public Provincia obtenerProvincia(String id) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{
		Provincia provincia = null;
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet("https://api.mercadolibre.com/classified_locations/states/"+id);
            HttpResponse responseGet = client.execute(get);
            HttpEntity responseEntity = responseGet.getEntity();
            ObjectMapper objectMapper = new ObjectMapper();
            provincia = objectMapper.readValue(responseEntity.getContent(),Provincia.class);
		}
		
		
		return provincia;
	}
	
	public List<Provincia> obtenerProvinciasDetalladas(List<Provincia> provincias) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{
		if(provincias != null) {
			List<Provincia> provinciasDetalladas = new ArrayList<Provincia>();
			int index = 0;
			int size = provincias.size();
			
			while(index<size) {
				Provincia provinciaDetallada = obtenerProvincia(provincias.get(index).getId());
				provinciasDetalladas.add(provinciaDetallada);
				index++;
			}
			return provinciasDetalladas;
		}
		else
			return provincias;
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{
		Pais p = new Pais();
		List<Pais> list = p.obtenerPaises(); 
		
			Pais pais = list.get(0);
			
			System.out.println(pais.getId());
			System.out.println(pais.getName());
			System.out.println(pais.getLocale());
			System.out.println(pais.getCurrency_id());
			pais = pais.obtenerPais(pais.getId());
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
				Provincia provincia_mas_info = provincia.obtenerProvincia(provincia.getId());
				System.out.println(provincia_mas_info.getId());
				System.out.println(provincia_mas_info.getName());
				System.out.println(provincia_mas_info.getTime_zone());
				System.out.println(provincia_mas_info.getCountry().getName());
				System.out.println(provincia_mas_info.getGeo_information().getLocation().getLatitude());
				System.out.println(provincia_mas_info.getCities().get(0).getName());
				j++;
			}
			
			
		
	}
}
