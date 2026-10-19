package observatory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JComboBox<String> stationSelector;
    private JComboBox<String> analyzerSelector;
    private JTextArea displayArea;
    private JButton scanButton;
    private JTextField regionInput;
    private JButton historyButton;
    private final ScanHistory scanHistory = new ScanHistory();

    public MainGUI() {
        setTitle("Volcanological and Seismological Observatory");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildUI();
    }

    private void buildUI() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel controlPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        controlPanel.add(new JLabel("Target Region:"));
        regionInput = new JTextField("Galeras Volcano Sector 7");
        controlPanel.add(regionInput);

        controlPanel.add(new JLabel("Select Station (Bridge Abstraction):"));
        String[] stations = {"Remote Volcano Station", "Deep Trench Station"};
        stationSelector = new JComboBox<>(stations);
        controlPanel.add(stationSelector);

        controlPanel.add(new JLabel("Select Analyzer (Bridge Implementation):"));
        String[] analyzers = {"Seismic Analyzer", "Thermal Analyzer", "Gas Analyzer (SO2)", "Legacy Geiger Counter (Adapter)"};
        analyzerSelector = new JComboBox<>(analyzers);
        controlPanel.add(analyzerSelector);

        scanButton = new JButton("Execute Scan");
        controlPanel.add(new JLabel("")); 
        controlPanel.add(scanButton);

        historyButton = new JButton("View Scan History");
        controlPanel.add(new JLabel(""));
        controlPanel.add(historyButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        displayArea.setBackground(new Color(30, 30, 30));
        displayArea.setForeground(new Color(0, 255, 0));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        scanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeSystemScan();
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(scanHistory.getFormattedHistory());
            }
        });
    }

    private void executeSystemScan() {
        String region = regionInput.getText();
        String selectedAnalyzer = (String) analyzerSelector.getSelectedItem();
        String selectedStation = (String) stationSelector.getSelectedItem();

        DataAnalyzer analyzer = null;

        if (selectedAnalyzer.equals("Seismic Analyzer")) {
            analyzer = new SeismicAnalyzer();
        } else if (selectedAnalyzer.equals("Thermal Analyzer")) {
            analyzer = new ThermalAnalyzer();
        } else if (selectedAnalyzer.equals("Gas Analyzer (SO2)")) {
            analyzer = new GasAnalyzer();
        } else if (selectedAnalyzer.equals("Legacy Geiger Counter (Adapter)")) {
            analyzer = new GeigerAdapter(new LegacyGeigerMuller());
        }

        SensorStation station = null;

        if (selectedStation.equals("Remote Volcano Station")) {
            station = new RemoteVolcanoStation(analyzer);
        } else if (selectedStation.equals("Deep Trench Station")) {
            station = new DeepTrenchStation(analyzer);
        }

        if (station != null) {
            String result = station.monitorRegion(region);
            scanHistory.record(selectedStation, selectedAnalyzer, region);
            displayArea.setText(result + "\n\n--- Scan Completed (#" + scanHistory.size() + ") ---");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
}
