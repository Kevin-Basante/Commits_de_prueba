package observatory;

public class RemoteVolcanoStation extends SensorStation {
    public RemoteVolcanoStation(DataAnalyzer analyzer) {
        super(analyzer);
    }

    @Override
    public String monitorRegion(String region) {
        return "Remote Volcano Station initiating scan...\n" + analyzer.analyzeData(region);
    }
}
