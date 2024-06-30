package xyz.froud.jvisa.constants;

import xyz.froud.jvisa.JVisaLibrary;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * All I/O session types
 *
 * @see <a href="https://www.ni.com/docs/en-US/bundle/ni-visa-api-ref/page/ni-visa-api-ref/vi_attr_intf_type.html">VI_ATTR_INTF_TYPE</a>
 * @see <a href="https://pyvisa.readthedocs.io/en/latest/api/constants.html#pyvisa.constants.InterfaceType">Class <code>InterfaceType</code> in PyVISA</a>
 */
public enum InterfaceType {
    UNKONWN(-1),
    GPIB(JVisaLibrary.VI_INTF_GPIB),
    VXI(JVisaLibrary.VI_INTF_VXI),
    GPIB_VXI(JVisaLibrary.VI_INTF_GPIB_VXI),
    ASRL(JVisaLibrary.VI_INTF_ASRL),
    PXI(JVisaLibrary.VI_INTF_PXI),
    TCPIP(JVisaLibrary.VI_INTF_TCPIP),
    USB(JVisaLibrary.VI_INTF_USB),
    RIO(8),
    FIREWIRE(9),
    VICP(36000);

    public final int VALUE;

    InterfaceType(int value) {
        this.VALUE = (short) value;
    }

    private static final Map<Integer, InterfaceType> VALUE_MAP
            = Stream.of(InterfaceType.values())
            .collect(Collectors.toMap(e -> e.VALUE, e -> e));

    public static InterfaceType parseInt(int value) {
        return VALUE_MAP.get(value);
    }
}
