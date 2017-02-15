package com.mitocode.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mitocode.dao.UbigeoDAO;
import com.mitocode.dao.UbigeoDAOImpl;
import com.mitocode.model.Ubigeo;

@ManagedBean
@ViewScoped
public class EjemploBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<Ubigeo> listaPaises;
	private List<Ubigeo> listaRegiones;
	private List<Ubigeo> listaProvincias;

	private UbigeoDAO ubigeoDAO;

	private int codPais;
	private int codRegion;

	public EjemploBean() {
		listaPaises = new ArrayList<>();
		listaRegiones = new ArrayList<>();
		listaProvincias = new ArrayList<>();
		ubigeoDAO = new UbigeoDAOImpl();
		this.listarPaises();
	}

	public void listarPaises() {

		try {
			listaPaises = ubigeoDAO.listarPaises();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listarRegiones() {

		try {
			listaRegiones = ubigeoDAO.listarRegiones(codPais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listarProvincias() {
		try {
			listaProvincias = ubigeoDAO.listarProvincias(codPais, codRegion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ubigeo> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<Ubigeo> listaPaises) {
		this.listaPaises = listaPaises;
	}

	public List<Ubigeo> getListaRegiones() {
		return listaRegiones;
	}

	public void setListaRegiones(List<Ubigeo> listaRegiones) {
		this.listaRegiones = listaRegiones;
	}

	public List<Ubigeo> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Ubigeo> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public int getCodPais() {
		return codPais;
	}

	public void setCodPais(int codPais) {
		this.codPais = codPais;
	}

	public int getCodRegion() {
		return codRegion;
	}

	public void setCodRegion(int codRegion) {
		this.codRegion = codRegion;
	}

}
