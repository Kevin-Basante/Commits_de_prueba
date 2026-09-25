package observatory;

public class GeigerAdapter implements DataAnalyzer {
    private LegacyGeigerMuller legacyDevice;

    public GeigerAdapter(LegacyGeigerMuller legacyDevice) {
        this.legacyDevice = legacyDevice;
    }

    @Override
    public String analyzeData(String region) {
        return "Digitized Output -> " + legacyDevice.readRadiationLevels(region);
    }
}
