package observatory;

public class SeismicAnalyzer implements DataAnalyzer {
    @Override
    public String analyzeData(String region) {
        return "Seismic Analyzer: Detecting tectonic shifts in " + region;
    }
}
