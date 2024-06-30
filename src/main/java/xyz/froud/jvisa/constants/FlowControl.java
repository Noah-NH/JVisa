package xyz.froud.jvisa.constants;

import xyz.froud.jvisa.JVisaLibrary;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Flow control for a serial port.
 *
 * @author Peter Froud
 * @see <a href="https://www.ni.com/docs/en-US/bundle/ni-visa/page/ni-visa/vi_attr_asrl_flow_cntrl.html">VI_ATTR_ASRL_FLOW_CNTRL</a>
 */
public enum FlowControl {

    NONE(JVisaLibrary.VI_ASRL_FLOW_NONE),
    XON_XOFF(JVisaLibrary.VI_ASRL_FLOW_XON_XOFF),
    RTS_CTS(JVisaLibrary.VI_ASRL_FLOW_RTS_CTS),
    DTR_DSR(JVisaLibrary.VI_ASRL_FLOW_DTR_DSR);

    public final int VALUE;

    FlowControl(int value) {
        this.VALUE = value;
    }

    private static final Map<Integer, FlowControl> VALUE_MAP
            = Stream.of(FlowControl.values())
                    .collect(Collectors.toMap(e -> e.VALUE, e -> e));

    public static FlowControl parseInt(int value) {
        return VALUE_MAP.get(value);
    }

}
