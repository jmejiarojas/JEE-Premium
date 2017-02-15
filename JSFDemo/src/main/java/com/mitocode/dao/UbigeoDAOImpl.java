package com.mitocode.dao;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.model.Ubigeo;

public class UbigeoDAOImpl implements UbigeoDAO {

	@Override
	public List<Ubigeo> listarPaises() throws Exception {
		List<Ubigeo> lista = new ArrayList<>(); // Set Hashset
		lista.add(new Ubigeo(1, "Peru"));
		lista.add(new Ubigeo(2, "Colombia"));
		lista.add(new Ubigeo(3, "Ecuador"));
		return lista;
	}

	@Override
	public List<Ubigeo> listarRegiones(int codPais) throws Exception {
		List<Ubigeo> lista = new ArrayList<>(); // Set Hashset

		switch (codPais) {
		case 1:
			lista.add(new Ubigeo(11, "Lima"));
			lista.add(new Ubigeo(12, "La Libertad"));
			lista.add(new Ubigeo(13, "Lambayeque"));
			break;
		case 2:
			lista.add(new Ubigeo(21, "Bogotá"));
			lista.add(new Ubigeo(22, "Cali"));
			lista.add(new Ubigeo(23, "Medellín"));
			break;
		default:
			lista.add(new Ubigeo(31, "Quito"));
			lista.add(new Ubigeo(32, "Atahualpa"));
			lista.add(new Ubigeo(33, "Ecuadorcito"));
			break;
		}

		return lista;
	}

	@Override
	public List<Ubigeo> listarProvincias(int codPais, int codRegion) throws Exception {
		List<Ubigeo> lista = new ArrayList<>(); // Set Hashset

		switch (codPais) {
		case 1:
			switch (codRegion) {
			case 11:
				lista.add(new Ubigeo(111, "Lima Metropolitana"));
				lista.add(new Ubigeo(121, "Huaral"));
				lista.add(new Ubigeo(131, "Canta"));
				break;
			case 12:
				lista.add(new Ubigeo(141, "Lib-01"));
				lista.add(new Ubigeo(151, "Lib-02"));
				lista.add(new Ubigeo(161, "Lib-03"));
				break;
			case 13:
				lista.add(new Ubigeo(171, "Lamb-01"));
				lista.add(new Ubigeo(181, "Lamb-02"));
				lista.add(new Ubigeo(191, "Lamb-03"));
				break;
			default:
				break;
			}
		default:
			break;
		}

		return lista;
	}

}
