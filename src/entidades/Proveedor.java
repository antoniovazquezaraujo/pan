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

/*** Entity implementation class for Entity: Proveedor * */


@Entity
@Table(name = "proveedor", schema = "panaderia")
public class Proveedor extends  Entidad {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "ID")
	
	@GeneratedValue
	private int id;
	
	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "CIF")
	private String cif;
	
	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "POBLACION")
	private String población;

	@Column(name = "CODIGO_POSTAL")
	private String cp;

	@Column(name = "PROVINCIA")
	private String provincia;

	@Column(name = "TELEFONO_FIJO")
	private int telefonoFijo;

	@Column(name = "TELEFONO_MOVIL")
	private int telefonoMovil;

	@Column(name = "FAX")
	private int fax;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "OBSERVACIONES")
	private String observaciones;

	@Column(name = "ACTIVO")
	private boolean activo;
	
	
	
	@OneToMany(targetEntity = Pedido.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<Pedido> pedidos;

	@OneToMany(targetEntity = Producto.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(schema = "panaderia")
	List<Producto> productos;

	
// MÉTODOS.
	
	public List<Pedido> getPedido(){
		return pedidos;
	}

	public void setPedido (List<Pedido> pedidos){
		this.pedidos = pedidos;
	}

	
	public List<Producto> getProducto(){
		return productos;
	}

	public void setProducto (List<Producto> productos){
		this.productos = productos;
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getPoblacion() {
		return población;
	}


	public void setPoblacion(String poblacion) {
		this.población = poblacion;
	}


	public String getCodigoPostal() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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


	public int getFax() {
		return fax;
	}


	public void setFax(int fax) {
		this.fax = fax;
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
	
	
	
	// CIF
	
	public String getCif() {
		return cif;
	}

	public void setCif(String cif){
		if (isCif(cif)==true){
			this.cif = cif;
		}else {
				error("El cif no es correcto",cif);
				this.cif =null;
			   }
	}
		
// Validar cif
	
public static Boolean isCif(String cif){
        int pares=0;
        int impares=0;
        String suma;
        String ultima;
        int unumero;
        String uletra="JABCDEFGHI";// uletra:Array=new Array("J","A","B","C","D","E","F","G","H","I");
        String xxx;
        String texto=cif.toUpperCase();
        Pattern pat = null; // RegExp regular= new RegExp("/^[ABCDEFGHJKLMNPQS]d{7}[0-9,A-J]$/g");    var regular:RegExp=new RegExp(/^[ABCDEFGHJKLMNPQS]\d{7}[0-9,A-J]$/g);
        Matcher mat = null;
        pat = Pattern.compile("/^[ABCDEFGHJKLMNPQS]d{7}[0-9,A-J]$/g");
        mat = pat.matcher(texto);
        if (!mat.find()){return false;}
                
		//if (!regular.exec(texto)) {return false;}
        ultima=texto.substring(8,1);
        int cont;
        for (cont=1; cont <7; cont ++) {
            xxx = (2 * Integer.parseInt(texto.substring(cont++,1))) + "0";
            impares += (Integer.parseInt(xxx.substring(0,1)))+(Integer.parseInt(xxx.substring(1,1)));
            pares += Integer.parseInt(texto.substring(cont,1));
        }
        
        xxx = Integer.toString(2 *(Integer.parseInt(texto.substring(cont,1)))) + "0";
        impares+=Integer.parseInt(xxx.substring(0,1))+Integer.parseInt(xxx.substring(1,1));
        suma = Integer.toString(pares + impares);
        unumero = Integer.parseInt(suma.substring((suma.length())-1,1));
        unumero = (10 - unumero);
        if (unumero == 10) {
            unumero = 0;
        }
        if ((ultima == Integer.toString(unumero)) || (ultima==Character.toString(uletra.charAt(unumero)))){
        	return true;
        	}else {return false;
        	}
        }
        
	
	
	// CORREO
	public String getEmail() {
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
		
	
	public boolean isEmail(String correo) {  //Validar email
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

	}
	
	

	
