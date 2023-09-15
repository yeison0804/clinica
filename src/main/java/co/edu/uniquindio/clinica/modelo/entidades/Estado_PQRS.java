package co.edu.uniquindio.clinica.modelo.entidades;

public enum Estado_PQRS {

    ABIERTA("A", "Abierta"),
    CERRADA("C", "Cerrada"),
    EN_PROCESO("EP", "En Proceso");

    private String codigo;
    private String estado;

    Estado_PQRS(String codigo, String estado) {
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
