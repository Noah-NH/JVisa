package xyz.froud.jvisa.constants;

import xyz.froud.jvisa.JVisaLibrary;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Whether and how to lock a resource
 *
 * @see <a href="https://pyvisa.readthedocs.io/en/latest/api/constants.html#pyvisa.constants.AccessModes">Class <code>AccessModes</code> in PyVISA</a>
 */
public enum AccessMode {
    NO_LOCK(JVisaLibrary.VI_NO_LOCK),
    EXCLUSIVE_LOCK(JVisaLibrary.VI_EXCLUSIVE_LOCK),
    SHARED_LOCK(JVisaLibrary.VI_SHARED_LOCK);

    public final int VALUE;

    AccessMode(int value) {
        this.VALUE = value;
    }

    private static final Map<Integer, AccessMode> VALUE_MAP
            = Stream.of(AccessMode.values())
            .collect(Collectors.toMap(e -> e.VALUE, e -> e));

    public static AccessMode parseInt(int value) {
        return VALUE_MAP.get(value);
    }
}
