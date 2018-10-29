package br.com.ebix.desafio.service;

import javax.xml.ws.Endpoint;

public class DesafioServiceMain {
	public static void main(String[] args) {
		try {
			Endpoint.publish("http://localhost:4790/ws/desafio", new DesafioWSImpl());
			System.out.println("DesafioWS");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("End");
	}
}
