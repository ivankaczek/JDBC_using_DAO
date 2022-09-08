package dominio;
public class Persona {

    private int idPersona;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;

    // es clave tener el constructor vacío
    public Persona() {
    }
    
    // para poder usar el 'where' puede ser útil construir un objeto sólo con el id

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }
    
    // para insertar un nuevo registro, no especificamos el campo id que es la llave primaria
    // (primary key) y también autoincrementable (AI)

    public Persona(String nombre, String apellido, String mail, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
    }
    
    // posiblemente para modificar un registro me sirve tener un constructor con todos los atributos
    
    public Persona(int idPersona, String nombre, String apellido, String mail, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
    }

    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", telefono=" + telefono + '}';
    }
    
    






    
}
