package co.edu.uniquindio.clinica.modelo.entidades;

public enum EPS {

    EPS_1("001", "EPS Nombre 1"),
    EPS_2("002", "EPS Nombre 2"),
    EPS_3("003", "EPS Nombre 3");

    private String codigo;
    private String nombre;

    EPS(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

}
