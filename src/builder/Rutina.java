package builder;

public class Rutina {
    private final String nombre;
    private final String calentamiento;
    private final String bloquePrincipal;
    private final int series;
    private final int repeticiones;
    private final int tiempoDescansoMin;

    Rutina(Builder builder) {
        this.nombre = builder.nombre;
        this.calentamiento = builder.calentamiento;
        this.bloquePrincipal = builder.bloquePrincipal;
        this.series = builder.series;
        this.repeticiones = builder.repeticiones;
        this.tiempoDescansoMin = builder.tiempoDescansoMin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCalentamiento() {
        return calentamiento;
    }

    public String getBloquePrincipal() {
        return bloquePrincipal;
    }

    public int getSeries() {
        return series;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public int getTiempoDescansoMin() {
        return tiempoDescansoMin;
    }

    @Override
    public String toString() {
        return "Rutina: '" + nombre + "'\n" +
               "  - Calentamiento: " + calentamiento + "\n" +
               "  - Ejercicios Clave: " + bloquePrincipal + "\n" +
               "  - Series x Repeticiones: " + series + " x " + repeticiones + "\n" +
               "  - Descanso entre series: " + tiempoDescansoMin + " min";
    }

    public static class Builder {
        private final String nombre;
        private String calentamiento = "Movilidad articular general (5 min)";
        private String bloquePrincipal = "Circuito de acondicionamiento general";
        private int series = 3;
        private int repeticiones = 10;
        private int tiempoDescansoMin = 1;

        public Builder(String nombre) {
            this.nombre = nombre;
        }

        public Builder conCalentamiento(String calentamiento) {
            this.calentamiento = calentamiento;
            return this;
        }

        public Builder conBloquePrincipal(String bloquePrincipal) {
            this.bloquePrincipal = bloquePrincipal;
            return this;
        }

        public Builder conSeries(int series) {
            this.series = series;
            return this;
        }

        public Builder conRepeticiones(int repeticiones) {
            this.repeticiones = repeticiones;
            return this;
        }

        public Builder conDescanso(int minutos) {
            this.tiempoDescansoMin = minutos;
            return this;
        }

        public Rutina build() {
            return new Rutina(this);
        }
    }
}
