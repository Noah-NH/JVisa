package xyz.froud.jvisa;

import java.nio.ByteBuffer;

/**
 * Provides an abstraction of the {@link JVisaInstrument} class, to be able to address other instruments, e.g. via the Prologix Adapter.
 *
 * @author Noah Heinzel
 */

public interface Instrument {

    /**
     * Sends a command and receives its response. It receives as many bytes as the instrument is sending. (That is probably wrong, it can receive maximum DEFAULT_BUFFER_SIZE bytes)
     *
     * @param command string to send
     * @return response from instrument as a String
     * @throws Exception, either {@link java.io.IOException} or {@link JVisaException}
     */
    String queryString(String command) throws Exception;

    /**
     * Sends a command and receives its response. No write terminator is added. It receives as many
     * bytes as the instrument is sending. (That is probably wrong, it can receive maximum DEFAULT_BUFFER_SIZE bytes)
     *
     * @param command bytes to send to the instrument
     * @return response from instrument as a String
     * @throws JVisaException if the write operation fails or the read operation fails
     */
    String queryString(byte[] command) throws Exception;

    /**
     * Sends a command and receives its response. If setWriteTerminator() was called with a non-null
     * string, the terminator will be appended to the string before sending it to the instrument.
     * It receives as many bytes as the instrument is sending.
     *
     * @param command string to send to the instrument
     * @return response from instrument as a ByteBuffer
     * @throws JVisaException if the write operation fails or the read operation fails
     */
    ByteBuffer queryBytes(String command) throws Exception;

    /**
     * Sends a command and receives its response. No write terminator is added. It receives as many
     * bytes as the instrument is sending.
     *
     * @param command bytes to send to the instrument
     * @return response from instrument as a ByteBuffer
     * @throws JVisaException if the write operation fails or the read operation fails
     */
    ByteBuffer queryBytes(byte[] command) throws Exception;

    /**
     * Sends a command to the instrument.
     *
     * @param command the command to send
     * @throws Exception, either {@link java.io.IOException} or {@link JVisaException}
     */
    void write(String command) throws Exception;

    /**
     * Sends a command to the instrument. No write terminator is added.
     *
     * @param bytes the command to send to the instrument
     *
     * @throws JVisaException if the write operation fails
     * @see <a href="https://www.ni.com/docs/en-US/bundle/ni-visa/page/ni-visa/viwrite.html">viWrite</a>
     */
    void write(byte[] bytes) throws Exception;

    String getManufacturerName() throws Exception;

    String getModelName() throws Exception;
}
