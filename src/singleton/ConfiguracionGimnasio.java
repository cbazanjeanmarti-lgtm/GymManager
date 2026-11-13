package singleton;

public class ConfiguracionGimnasio {
    private static ConfiguracionGimnasio instancia;
    private String nombreGimnasio;
    private int aforoMaximo;
    private String horarioAtencion;

    private ConfiguracionGimnasio() {
        this.nombreGimnasio = "Iron Gym Fitness Center";
        this.aforoMaximo = 150;
        this.horarioAtencion = "Lunes a Sábado: 06:00 - 22:00";
    }

    public static synchronized ConfiguracionGimnasio getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionGimnasio();
        }
        return instancia;
    }

    public String getNombreGimnasio() {
        return nombreGimnasio;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setNombreGimnasio(String nombreGimnasio) {
        this.nombreGimnasio = nombreGimnasio;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }
}
