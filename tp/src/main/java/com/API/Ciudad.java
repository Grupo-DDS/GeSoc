package com.API;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ciudad {
	private String id;
	private String name;
	private Provincia state;
	private Pais country;
	private List<Ciudad> neighborhoods;
	private Coordenada geo_information;

	
	
	
	public Provincia getState() {
		return state;
	}
	public void setState(Provincia state) {
		this.state = state;
	}
	public Pais getCountry() {
		return country;
	}
	public void setCountry(Pais country) {
		this.country = country;
	}
	public List<Ciudad> getNeighborhoods() {
		return neighborhoods;
	}
	public void setNeighborhoods(List<Ciudad> neighborhoods) {
		this.neighborhoods = neighborhoods;
	}
	public Coordenada getGeo_information() {
		return geo_information;
	}
	public void setGeo_information(Coordenada geo_information) {
		this.geo_information = geo_information;
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
	
	public Ciudad obtenerCiudad(String id) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{
		Ciudad ciudad = null;
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpGet get = new HttpGet("https://api.mercadolibre.com/classified_locations/cities/"+id);
            HttpResponse responseGet = client.execute(get);
            HttpEntity responseEntity = responseGet.getEntity();
            ObjectMapper objectMapper = new ObjectMapper();
            ciudad = objectMapper.readValue(responseEntity.getContent(),Ciudad.class);
		}
		return ciudad;
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, UnsupportedOperationException, IOException{
		Pais p = new Pais();
		List<Pais> list = p.obtenerPaises(); 
		
			Pais pais = list.get(0);
			
//			System.out.println(pais.getId());
			System.out.println(pais.getName());
//			System.out.println(pais.getLocale());
//			System.out.println(pais.getCurrency_id());
			pais = pais.obtenerPais(pais.getId());
//			System.out.println(pais.getDecimal_separator());
//			System.out.println(pais.getThousands_separator());
//			System.out.println(pais.getTime_zone());
//			if(pais.getGeo_information() != null) {
//				System.out.println(pais.getGeo_information().getLocation().getLatitude());
//				System.out.println(pais.getGeo_information().getLocation().getLongitude());
//			}
			
			int j=0;
			while(j<pais.getStates().size()) {
				
				Provincia provincia = pais.getStates().get(j);
				Provincia provincia_mas_info = provincia.obtenerProvincia(provincia.getId());
				//System.out.println(provincia_mas_info.getId());
				System.out.println(provincia_mas_info.getName());
//				System.out.println(provincia_mas_info.getTime_zone());
//				System.out.println(provincia_mas_info.getCountry().getName());
//				System.out.println(provincia_mas_info.getGeo_information().getLocation().getLatitude());
				for(int k = 0;k<provincia_mas_info.getCities().size();k++) {
					Ciudad c = provincia_mas_info.getCities().get(k).obtenerCiudad(provincia_mas_info.getCities().get(k).getId());

					System.out.println(c.getId());
					System.out.println(c.getName());
					System.out.println(c.getName());
					System.out.println(c.getCountry().getName());
					if(c.getNeighborhoods().size() > 0)
						System.out.println(c.getNeighborhoods().get(0).getName());
					if(c.getGeo_information() != null) {
						System.out.println(pais.getGeo_information().getLocation().getLatitude());
						System.out.println(pais.getGeo_information().getLocation().getLongitude());
					}
				
				}
				j++;
			}
			
			
		
	}
}
