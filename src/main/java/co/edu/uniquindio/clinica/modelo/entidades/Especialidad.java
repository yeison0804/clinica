package co.edu.uniquindio.clinica.modelo.entidades;


import lombok.Setter;

public enum Especialidad {



    ESPECIALIDAD_1("001", "Especialidad 1"),
    ESPECIALIDAD_2("002", "Especialidad 2"),
    ESPECIALIDAD_3("003", "Especialidad 3");

    private String codigo;
    private String nombre;

    Especialidad(String codigo, String nombre) {
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





