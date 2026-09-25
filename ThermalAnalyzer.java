package observatory;

public class ThermalAnalyzer implements DataAnalyzer {
    @Override
    public String analyzeData(String region) {
        return "Thermal Analyzer: Measuring magma heat signatures in " + region;
    }
}
