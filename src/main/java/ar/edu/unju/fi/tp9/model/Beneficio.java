package ar.edu.unju.fi.tp9.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "BENEFICIO")
public class Beneficio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_beneficio;
	
	@Column(name = "cli_Beneficios")
	@ManyToMany(mappedBy ="beneficios" )//ES CON RELACION CLIENTE
	private List<Cliente>Clientes;
	
	@NotBlank(message="Debe seleccionar una opcion")
	@Column(name = "cli_tipoDocumento")
	private String ben_descripcion;
	
	/**
	 * 
	 */
	public Beneficio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id_beneficio
	 */
	public int getId_beneficio() {
		return id_beneficio;
	}

	/**
	 * @param id_beneficio the id_beneficio to set
	 */
	public void setId_beneficio(int id_beneficio) {
		this.id_beneficio = id_beneficio;
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return Clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		Clientes = clientes;
	}

	/**
	 * @return the ben_descripcion
	 */
	public String getBen_descripcion() {
		return ben_descripcion;
	}

	/**
	 * @param ben_descripcion the ben_descripcion to set
	 */
	public void setBen_descripcion(String ben_descripcion) {
		this.ben_descripcion = ben_descripcion;
	}

	@Override
	public String toString() {
		return "Beneficio [id_beneficio=" + id_beneficio + ", Clientes=" + Clientes + ", ben_descripcion="
				+ ben_descripcion + "]";
	}

	
}
