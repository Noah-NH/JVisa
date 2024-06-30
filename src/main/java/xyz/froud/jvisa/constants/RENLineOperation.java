package xyz.froud.jvisa.constants;

import xyz.froud.jvisa.JVisaLibrary;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Operation that can be performed on the REN line
 *
 * @see <a href="https://github.com/pyvisa/pyvisa/blob/d64180380b2f9b4afa69bed480f74ca34cec46fa/pyvisa/constants.py#L1151">Class <code>RENLineOperation</code> in PyVISA</a>
 */
public enum RENLineOperation {
    ADDRESS_GTL(JVisaLibrary.VI_GPIB_REN_ADDRESS_GTL),
    ASSERT(JVisaLibrary.VI_GPIB_REN_ASSERT),
    ASSERT_ADDRESS(JVisaLibrary.VI_GPIB_REN_ASSERT_ADDRESS),
    ASSERT_ADDRESS_LLO(JVisaLibrary.VI_GPIB_REN_ASSERT_ADDRESS_LLO),
    ASSERT_LLO(JVisaLibrary.VI_GPIB_REN_ASSERT_LLO),
    DEASSERT(JVisaLibrary.VI_GPIB_REN_DEASSERT),
    DEASSERT_GTL(JVisaLibrary.VI_GPIB_REN_DEASSERT_GTL);

    public final int VALUE;

    RENLineOperation(int value) {
        this.VALUE = (short) value;
    }

    private static final Map<Integer, RENLineOperation> VALUE_MAP
            = Stream.of(RENLineOperation.values())
            .collect(Collectors.toMap(e -> e.VALUE, e -> e));

    public static RENLineOperation parseInt(int value) {
        return VALUE_MAP.get(value);
    }
}
