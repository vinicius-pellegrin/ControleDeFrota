package br.upf.ads.controleFrota.testes;

import javax.persistence.Persistence;

public class TesteCriarBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Persistence.createEntityManagerFactory("ControleFrota");
	}

}
