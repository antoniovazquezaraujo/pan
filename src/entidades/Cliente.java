package entidades;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/** Entity implementation class for Entity: Cliente * */


@Entity
@Table(name = "cliente", schema = "panaderia")

public class Cliente extends Entidad{

	private static final long serialVersionUID = 1L;
	public static final String LETRAS_DNI="TRWAGMYFPDXBNJZSQVHLCKE";
	
	@Id
	@Column(name = "ID")
	
	@GeneratedValue
	private int id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO1")
	private String apellido1;
	
	@Column(name = "APELLIDO2")
	private String apellido2;

	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "POBLACION")
	private String poblacion;
	
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@Column(name = "CP")
	private String cp;
	
	@Column(name = "TELEFONO_FIJO")
	private int telefonoFijo;
	
	@Column(name = "TELEFONO_MOVIL")
	private int telefonoMovil;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@Column(name = "ACTIVO")
	private boolean activo;
	
	
	@OneToMany(targetEntity = Encargo.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<Encargo> encargos;

	@OneToMany(targetEntity = Factura.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<Factura> facturas;

	
	
	@OneToMany(targetEntity = Albaran.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<Albaran> albaranes;
	
	// MÉTODOS
	
	public List<Encargo> getEncargos() {
		return encargos;
	}

	public void setEncargos(List<Encargo> encargos) {
		this.encargos = encargos;
	}
		
	
	
	 public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
		
	
	public List<Albaran> getAlbaran() {
		return albaranes;
	}

	public void setAlbaranes(List<Albaran> albaranes) {
		this.albaranes = albaranes;
	}
		
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
			this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
			this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public int getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(int telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public int getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(int telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}


	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		if (email.isEmpty()){
			this.email="@";
		}
		else { if (isEmail(email)==true){
						this.email = email;
				}
				else {
					error("El email no es correcto",email);
					this.email =null;
						}
				}
		}
		
	
	public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }
    }
	

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	
	
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		if (!dni.isEmpty()){
			String dniSinEspacios = dni.toUpperCase().trim() ;           //obtenemos el String en máyúsculas y sin espacios.
			if(dniSinEspacios.length() == 9){
				String dniSinLetra = dniSinEspacios.substring(0, 8);    //obtenemos el dni sin letra
				int i = 0;
				try {
					i = Integer.parseInt(dniSinLetra);
				} catch (NumberFormatException e) {
					error("dni", "El valor del DNI es incorrecto");
					this.dni = "";
					return;
				}
				char l = dniSinEspacios.charAt(8);              //cogemos sólo la letra del dni
				char letra = LETRAS_DNI.charAt(i%23);     //calculamos la letra que le correspondería
				if((l == letra)){
					correct("dni");
					this.dni = dni;				
				}else{
					error("dni", "El valor del DNI es incorrecto");
					this.dni = "";
				}	
			}else{
				error("dni", "El número de caracteres del DNI no es válido");
				this.dni = "";
			}
		}
	}

}
