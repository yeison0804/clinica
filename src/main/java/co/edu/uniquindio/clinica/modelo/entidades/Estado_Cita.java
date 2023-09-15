package co.edu.uniquindio.clinica.modelo.entidades;

public enum Estado_Cita {

    PENDIENTE("P", "Pendiente"),
    CONFIRMADA("C", "Confirmada"),
    CANCELADA("CA", "Cancelada");

    private String codigo;
    private String estado;

    Estado_Cita(String codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }
}



