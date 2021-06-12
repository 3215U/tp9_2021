package ar.edu.unju.fi.tp8.service;

import java.util.List;

import ar.edu.unju.fi.tp8.model.Beneficio;

public interface IBeneficioService {
	
	public void generarBeneficios();
	
	public List<Beneficio> obtenerBeneficios();
	
	public Beneficio encontrarBeneficio(long id);

}
