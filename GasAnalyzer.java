package observatory;

/**
 * Nueva implementación del Bridge: analiza emisiones de dióxido de azufre (SO2).
 */
public class GasAnalyzer implements DataAnalyzer {
    private final double so2Ppm;

    public GasAnalyzer() {
        this(12.5);
    }

    public GasAnalyzer(double so2Ppm) {
        this.so2Ppm = so2Ppm;
    }

    @Override
    public String analyzeData(String region) {
        AlertLevel level = AlertLevel.fromSo2Ppm(so2Ppm);
        return "Gas Analyzer: SO2 concentration of " + so2Ppm + " ppm in " + region
                + "\nAlert Level: " + level + " (" + level.getDescription() + ")";
    }
}
