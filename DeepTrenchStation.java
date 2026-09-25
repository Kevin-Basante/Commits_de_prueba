package observatory;

public class DeepTrenchStation extends SensorStation {
    public DeepTrenchStation(DataAnalyzer analyzer) {
        super(analyzer);
    }

    @Override
    public String monitorRegion(String region) {
        return "Deep Trench Station initiating scan...\n" + analyzer.analyzeData(region);
    }
}
