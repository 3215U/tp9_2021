package ar.edu.unju.fi.tp9.service;

import java.util.List;

import ar.edu.unju.fi.tp9.model.Cuenta;

public interface ICuentaService {

	public void guardarCuenta(Cuenta cuenta);

	public List<Cuenta> getAllCuentas();

	public void generarTablaCuenta();
}
