package xyz.froud.jvisa_example;

import xyz.froud.jvisa.JVisaException;
import xyz.froud.jvisa.JVisaInstrument;
import xyz.froud.jvisa.JVisaResourceManager;
import xyz.froud.jvisa.constants.FlowControl;
import xyz.froud.jvisa.constants.Parity;
import xyz.froud.jvisa.constants.StopBits;

/**
 * Shows how to set serial port parameters.
 * @author Peter Froud
 */
public class SerialPortExample {

    public static void main(String[] args) throws JVisaException {
        final String portName = "COM1";
        try (JVisaResourceManager resourceManager = new JVisaResourceManager()) {
            try (JVisaInstrument instrument = resourceManager.openInstrument(portName)) {
                instrument.setSerialBaudRate(9600);
                instrument.setSerialDataBits(8);
                instrument.setSerialStopBits(StopBits.ONE);
                instrument.setSerialParity(Parity.NONE);
                instrument.setSerialFlowControl(FlowControl.NONE);
                instrument.setReadTerminationCharacter('\n');
                instrument.setWriteTerminator("\n");
                System.out.println(instrument.queryString("*IDN?"));
            }
        }
    }
}
