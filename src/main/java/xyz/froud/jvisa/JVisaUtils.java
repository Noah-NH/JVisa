/**
 * @license Copyright 2014-2018 Günter (gfuchs@acousticmicroscopy.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @version 0.6
 * <p>
 * Modifications by Peter Froud, June 2018
 */
package xyz.froud.jvisa;


import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains static utility functions.
 *
 * @author Günter Fuchs (gfuchs@acousticmicroscopy.com)
 * @author Peter Froud
 *
 */
public class JVisaUtils {

    /**
     * Converts a Java String to a ByteBuffer with a zero terminator.
     *
     * @param source string to convert
     * @return Java string converted to C-type string (0 terminated)
     */
    protected static ByteBuffer stringToByteBuffer(String source) {
        final ByteBuffer rv = ByteBuffer.allocate(source.length() + 1);
        rv.put(source.getBytes());
        rv.position(0);
        return rv;
    }

    protected static String byteBufferToString(ByteBuffer buf){
        return new String(buf.array()).trim();
    }

    protected static int getIEEEDataOffset(ByteBuffer buf) {
        int begin = 0;

        for (int i = 0; i < buf.array().length; i++) {
            if (buf.array()[i] == '#') begin = i;
        }

        int headerLength = buf.array()[begin + 1] - '0';

        return begin + 2 + headerLength;
    }

    protected static int getIEEEDataLength(ByteBuffer buf) {
        int begin = 0;

        for (int i = 0; i < buf.array().length; i++) {
            if (buf.array()[i] == '#') begin = i;
        }

        int headerLength = buf.array()[begin + 1] - '0';

        int dataLength = 0;
        for (int i = 0; i < headerLength; i++) {
            dataLength += (buf.array()[begin + 2 + i] - '0') * Math.pow(10, i);
        }

        return dataLength;
    }

    protected static List<Float> getIEEEFloats(ByteBuffer buf) {
        List<Float> ret = new ArrayList<>();

        int length = getIEEEDataLength(buf);
        int offset = getIEEEDataOffset(buf);

        buf.position(offset);
        for (int i = 0; i < length; i += 4) {
            ret.add(buf.getFloat());
        }
        return ret;
    }
}
