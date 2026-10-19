# Sistema de Control Vulcanológico

Aplicación de escritorio en Java (Swing) que simula un observatorio vulcanológico y sismológico.
Se usa para practicar los patrones de diseño **Adapter** y **Bridge**.

## Patrones aplicados

| Patrón  | Rol                         | Clases                                                        |
|---------|-----------------------------|---------------------------------------------------------------|
| Bridge  | Abstracción                 | `SensorStation`, `RemoteVolcanoStation`, `DeepTrenchStation`  |
| Bridge  | Implementación              | `DataAnalyzer`, `SeismicAnalyzer`, `ThermalAnalyzer`, `GasAnalyzer` |
| Adapter | Adaptador de equipo antiguo | `GeigerAdapter` → `LegacyGeigerMuller`                        |

## Funcionalidades nuevas

- **AlertLevel**: enum con los niveles de alerta (Verde, Amarillo, Naranja, Rojo).
- **GasAnalyzer**: analizador de SO2 que calcula el nivel de alerta.
- **ScanHistory**: historial de escaneos con fecha y hora, visible con el botón *View Scan History*.

## Cómo ejecutar

```bash
javac -d out *.java
java -cp out observatory.MainGUI
```

## Autores

- Kevin Basante
- Arley Riascos
