package ar.edu.unju.fi.tp8.model;



import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

	@Component
	@Entity
	@Table(name = "CLIENTES")
	public class Cliente {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@ManyToMany//ES DE BENEFICIO
		@JoinTable(name="CLIENTES_BENEFICIOS",joinColumns=@JoinColumn(name="cli_id"),inverseJoinColumns=@JoinColumn(name="ben_id") )
		private List<Beneficio> beneficios = new ArrayList<Beneficio>();

		@Valid
		@Autowired
		@OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "cue_id")
		private Cuenta cuenta;
		
		@NotBlank(message="Debe seleccionar una opcion")
		@Column(name = "cli_tipoDocumento")
		private String tipoDocumento;
		
		@Min(value = 1000000,message = "El DNI debe ser mayor o igual a 1000000 digitos")
		@Max(value = 999999999,message = "El DNI debe ser menor o igual a 999999999 digitos")
		@Column(name = "cli_nroDocumento")
		private int nroDocumento;
		
		@NotBlank(message="Debe ingresar su Nombre y Apellido")
		@Size(min=8,max=50,message = "Debe ingresar de 8 a 50 caracteres")
		@Column(name = "cli_nombreApellido")
		private String nombreApellido;
		
		@NotBlank(message = "Debe ingresar un E-mail")
		@Email(message = "Ingrese un E-mail valido")
		@Column(name="cli_email")
		private String email;
		
		@NotBlank(message="Debe ingresar una contraseña")
		@Size(min=8,max=20,message = "Debe ingresar de 8 a 20 caracteres")
		@Column(name = "cli_password")
		private String password;
		
		@NotNull(message = "Debe ingresar una fecha valida")
		@Past
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name = "cli_fechaNacimiento") 
		private LocalDate fechaNacimiento;
		
		@Min(value = 100,message = "El Codigo de Area debe ser mayor o igual a 3 digitos")
		@Max(value = 99999,message = "El Codigo de Area debe ser menor o igual a 5 digitos")
		@Column(name="cli_codigoAreaTelefono")
		private int codigoAreaTelefono;
		
		@Min(value = 100000,message = "El numero de telefono debe ser mayor o igual a 100000 digitos")
		@Max(value = 999999999,message = "El numero de telefono debe ser menor o igual a 999999999 digitos")
		@Column(name="cli_nroTelefono")
		private int nroTelefono;
		
		@PastOrPresent
		@NotNull(message = "Debe ingresar una fecha valida")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name="cli_fechaUltimaCompra")
		private LocalDate fechaUltimaCompra;

		/**
		 * 
		 */
		public Cliente() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @param id
		 * @param beneficios
		 * @param cuenta
		 * @param tipoDocumento
		 * @param nroDocumento
		 * @param nombreApellido
		 * @param email
		 * @param password
		 * @param fechaNacimiento
		 * @param codigoAreaTelefono
		 * @param nroTelefono
		 * @param fechaUltimaCompra
		 */
		public Cliente(Long id, List<Beneficio> beneficios, @Valid Cuenta cuenta,
				@NotBlank(message = "Debe seleccionar una opcion") String tipoDocumento,
				@Min(value = 1000000, message = "El DNI debe ser mayor o igual a 1000000 digitos") @Max(value = 999999999, message = "El DNI debe ser menor o igual a 999999999 digitos") int nroDocumento,
				@NotBlank(message = "Debe ingresar su Nombre y Apellido") @Size(min = 8, max = 50, message = "Debe ingresar de 8 a 50 caracteres") String nombreApellido,
				@NotBlank(message = "Debe ingresar un E-mail") @Email(message = "Ingrese un E-mail valido") String email,
				@NotBlank(message = "Debe ingresar una contraseña") @Size(min = 8, max = 20, message = "Debe ingresar de 8 a 20 caracteres") String password,
				@NotNull(message = "Debe ingresar una fecha valida") @Past LocalDate fechaNacimiento,
				@Min(value = 100, message = "El Codigo de Area debe ser mayor o igual a 3 digitos") @Max(value = 99999, message = "El Codigo de Area debe ser menor o igual a 5 digitos") int codigoAreaTelefono,
				@Min(value = 100000, message = "El numero de telefono debe ser mayor o igual a 100000 digitos") @Max(value = 999999999, message = "El numero de telefono debe ser menor o igual a 999999999 digitos") int nroTelefono,
				@PastOrPresent @NotNull(message = "Debe ingresar una fecha valida") LocalDate fechaUltimaCompra) {
			super();
			this.id = id;
			this.beneficios = beneficios;
			this.cuenta = cuenta;
			this.tipoDocumento = tipoDocumento;
			this.nroDocumento = nroDocumento;
			this.nombreApellido = nombreApellido;
			this.email = email;
			this.password = password;
			this.fechaNacimiento = fechaNacimiento;
			this.codigoAreaTelefono = codigoAreaTelefono;
			this.nroTelefono = nroTelefono;
			this.fechaUltimaCompra = fechaUltimaCompra;
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the beneficios
		 */
		public List<Beneficio> getBeneficios() {
			return beneficios;
		}

		/**
		 * @param beneficios the beneficios to set
		 */
		public void setBeneficios(List<Beneficio> beneficios) {
			this.beneficios = beneficios;
		}

		/**
		 * @return the cuenta
		 */
		public Cuenta getCuenta() {
			return cuenta;
		}

		/**
		 * @param cuenta the cuenta to set
		 */
		public void setCuenta(Cuenta cuenta) {
			this.cuenta = cuenta;
		}

		/**
		 * @return the tipoDocumento
		 */
		public String getTipoDocumento() {
			return tipoDocumento;
		}

		/**
		 * @param tipoDocumento the tipoDocumento to set
		 */
		public void setTipoDocumento(String tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
		}

		/**
		 * @return the nroDocumento
		 */
		public int getNroDocumento() {
			return nroDocumento;
		}

		/**
		 * @param nroDocumento the nroDocumento to set
		 */
		public void setNroDocumento(int nroDocumento) {
			this.nroDocumento = nroDocumento;
		}

		/**
		 * @return the nombreApellido
		 */
		public String getNombreApellido() {
			return nombreApellido;
		}

		/**
		 * @param nombreApellido the nombreApellido to set
		 */
		public void setNombreApellido(String nombreApellido) {
			this.nombreApellido = nombreApellido;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * @return the fechaNacimiento
		 */
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}

		/**
		 * @param fechaNacimiento the fechaNacimiento to set
		 */
		public void setFechaNacimiento(LocalDate fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		/**
		 * @return the codigoAreaTelefono
		 */
		public int getCodigoAreaTelefono() {
			return codigoAreaTelefono;
		}

		/**
		 * @param codigoAreaTelefono the codigoAreaTelefono to set
		 */
		public void setCodigoAreaTelefono(int codigoAreaTelefono) {
			this.codigoAreaTelefono = codigoAreaTelefono;
		}

		/**
		 * @return the nroTelefono
		 */
		public int getNroTelefono() {
			return nroTelefono;
		}

		/**
		 * @param nroTelefono the nroTelefono to set
		 */
		public void setNroTelefono(int nroTelefono) {
			this.nroTelefono = nroTelefono;
		}

		/**
		 * @return the fechaUltimaCompra
		 */
		public LocalDate getFechaUltimaCompra() {
			return fechaUltimaCompra;
		}

		/**
		 * @param fechaUltimaCompra the fechaUltimaCompra to set
		 */
		public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
			this.fechaUltimaCompra = fechaUltimaCompra;
		}

		@Override
		public String toString() {
			return "Cliente [id=" + id + ", beneficios=" + beneficios + ", cuenta=" + cuenta + ", tipoDocumento="
					+ tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido=" + nombreApellido
					+ ", email=" + email + ", password=" + password + ", fechaNacimiento=" + fechaNacimiento
					+ ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono=" + nroTelefono
					+ ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
		}



		public int getEdad() {
			int edad = 0;
			LocalDate hoy = LocalDate.now();
			Period periodo = Period.between(this.fechaNacimiento, hoy);
			edad = periodo.getYears();
			return edad;
		}
		
		//Método para obtener el tiempo entre la fecha de la última compra y la fecha actual
		
		public String getTiempoUltimaCompraHoy() {
			String texto = ""; 
			LocalDate hoy = LocalDate.now();
			Period periodo = Period.between( this.fechaUltimaCompra, hoy);
			texto = "Año/s: " + periodo.getYears() + " - Mes/es: " + periodo.getMonths() + " - Dia/s: " + periodo.getDays();
			return texto;
		}
		
		//Método para obtener el tiempo expresado en días desde la fecha de nacimiento hasta la fecha actual 
		
		public String getTiempoNacimientoAhoraDias() {
			String texto = ""; 
			LocalDate hoy = LocalDate.now();
			int dias = (int) ChronoUnit.DAYS.between(this.fechaNacimiento, hoy);
			texto = dias + " dias"; 
			return texto;
		}
		
		//Método para obtener el tiempo hasta el cumpleaños
		
		public String getTiempoHastaCumple() {
			String texto ="";
			LocalDate hoy = LocalDate.now();
			int varanio;
			if(hoy.getMonthValue() < this.fechaNacimiento.getMonthValue()) {
				varanio = hoy.getYear();
			}else {
				varanio = hoy.getYear()+1;
			}
			
			LocalDate fechaProximoCumple = LocalDate.of(varanio,this.fechaNacimiento.getMonth(),this.fechaNacimiento.getDayOfMonth() );
	        Period periodo = Period.between(hoy,fechaProximoCumple );

	        texto = "Dias :"+ periodo.getDays() + " - Meses: "+periodo.getMonths() + " - Año: "+ periodo.getYears();

	        LocalDateTime ahora = LocalDateTime.now();
	        LocalDateTime fechaHoraProxCumple = LocalDateTime.of(varanio,this.fechaNacimiento.getMonth(),this.fechaNacimiento.getDayOfMonth(),0,0,0);

	        Duration duracion = Duration.between(ahora,fechaHoraProxCumple);
	        texto = texto + " - Horas: "+duracion.toHoursPart() + " - Min: "+duracion.toMinutesPart() + " - Seg: "+duracion.toSecondsPart();
	        return texto;
			
		}


}
