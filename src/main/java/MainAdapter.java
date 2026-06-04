interface EuropeanDevice {
    void consume220V();
}

interface USPowerSource {
    int getVoltage();
}

class RealUSPlug implements USPowerSource {
    @Override
    public int getVoltage() {
        return 110;
    }
}

class PowerAdapter implements EuropeanDevice {
    private final USPowerSource usSource;

    public PowerAdapter(USPowerSource usSource) {
        this.usSource = usSource;
    }

    @Override
    public void consume220V() {
        int voltage = usSource.getVoltage();
        System.out.println("Adapter received: " + voltage + "V");
        System.out.println("Result: 220V supplied on device.");
    }
}

public class MainAdapter {
    public static void main(String[] args) {
        // У нас есть американская розетка
        USPowerSource wallSocket = new RealUSPlug();

        // Для европейского устройства используем адаптер
        EuropeanDevice laptop = new PowerAdapter(wallSocket);

        // Работаем через интерфейс
        laptop.consume220V();
    }
}