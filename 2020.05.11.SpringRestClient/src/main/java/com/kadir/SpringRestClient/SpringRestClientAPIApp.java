package com.kadir.SpringRestClient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.kadir.SpringRestClient.domain.Ogrenci;

public class SpringRestClientAPIApp {

	static final String serverUrl = "http://localhost:8099/SpringRestController/students/";
	static RestTemplate restTemplete = new RestTemplate();

	private static Ogrenci getOgrenci(int ogrenciId) {
		return restTemplete.getForObject(serverUrl + "/" + ogrenciId, Ogrenci.class);

	}
	
	public static List<Ogrenci> getOgrenciler() {
		ResponseEntity<List<Ogrenci>> respEntity = restTemplete.exchange(serverUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Ogrenci>>() {
				});
		return respEntity.getBody();
	}

	private static ResponseEntity<Ogrenci> insertOgrenci(Ogrenci ogrenci) {

		return restTemplete.postForEntity(serverUrl, ogrenci, Ogrenci.class);
	}

	private static void updateOgrenci(Ogrenci ogrenci) {

		restTemplete.put(serverUrl, ogrenci);
	}

	private static void deleteOgrenci(int id) {
		restTemplete.delete(serverUrl, id);

	}

	public static void main(String[] args) {
		// Get ogrenci
		/*
		 * Ogrenci ogr = getOgrenci(1); System.out.println(ogr);
		 */

		// insert ogrenci
		/*
		 * Ogrenci ogrInserting = new Ogrenci("Satý", "Sat", 344, null);
		 * insertOgrenci(ogrInserting); System.out.println(ogrInserting);
		 */

		// update ogrenci
		/*
		 * Ogrenci ogrUpdating = getOgrenci(62); ogrUpdating.setOgrenciNo(255);
		 * System.out.println(ogrUpdating); updateOgrenci(ogrUpdating);
		 */

		/*Ogrenci deleteOgrenci = getOgrenci(62);
		deleteOgrenci(deleteOgrenci.getId());*/
		
		List<Ogrenci> ogrenciler = getOgrenciler();
		for (Ogrenci ogrenci : ogrenciler) {
			System.out.println(ogrenci);
		}
	}

}
