package ar.edu.unju.fi.tp8.model;

import java.util.ArrayList;
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
@Table(name = "BENEFICIOS")
public class Beneficio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@ManyToMany(mappedBy="beneficios")
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@NotBlank(message="Debe seleccionar una opcion")
	@Column(name = "ben_descripcion")
	private String descripcion;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * 
	 */
	public Beneficio() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Beneficio [id=" + id + ", clientes=" + clientes + ", descripcion=" + descripcion + "]";
	}

	

	
}
