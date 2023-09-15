package co.edu.uniquindio.clinica.modelo.entidades;

public enum Tipo_Sangre {

    A_POSITIVO("A+", "Tipo A Positivo"),
    A_NEGATIVO("A-", "Tipo A Negativo"),
    B_POSITIVO("B+", "Tipo B Positivo"),
    B_NEGATIVO("B-", "Tipo B Negativo"),
    O_POSITIVO("O+", "Tipo O Positivo"),
    O_NEGATIVO("O-", "Tipo O Negativo"),
    AB_POSITIVO("AB+", "Tipo AB Positivo"),
    AB_NEGATIVO("AB-", "Tipo AB Negativo");

    private String codigo;
    private String nombre;

    Tipo_Sangre(String codigo, String nombre) {
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
