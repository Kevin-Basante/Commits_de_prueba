package observatory;

/**
 * Niveles de alerta volcánica usados por los analizadores.
 */
public enum AlertLevel {
    GREEN("Verde - Actividad normal"),
    YELLOW("Amarillo - Cambios en la actividad"),
    ORANGE("Naranja - Erupción probable en días o semanas"),
    RED("Rojo - Erupción inminente o en curso");

    private final String description;

    AlertLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Calcula el nivel de alerta a partir de una concentración de SO2 en ppm.
     */
    public static AlertLevel fromSo2Ppm(double ppm) {
        if (ppm < 5.0) {
            return GREEN;
        } else if (ppm < 20.0) {
            return YELLOW;
        } else if (ppm < 50.0) {
            return ORANGE;
        }
        return RED;
    }
}
