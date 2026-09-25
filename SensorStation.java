package observatory;

public abstract class SensorStation {
    protected DataAnalyzer analyzer;

    public SensorStation(DataAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public abstract String monitorRegion(String region);
}
