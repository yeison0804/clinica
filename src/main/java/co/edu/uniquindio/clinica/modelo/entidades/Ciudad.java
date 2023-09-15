package co.edu.uniquindio.clinica.modelo.entidades;

public enum Ciudad {

    BOGOTA("BOG", "Bogotá"),
    MEDELLIN("MED", "Medellín"),
    CALI("CAL", "Cali"),
    BARRANQUILLA("BAR", "Barranquilla"),
    CARTAGENA("CAR", "Cartagena"),
    BUCARAMANGA("BUC", "Bucaramanga"),
    CUCUTA("CUC", "Cúcuta");

    private String codigo;
    private String nombre;

    Ciudad(String codigo, String nombre) {
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
