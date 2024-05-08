package io.github.leonhad.hproman;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Roman8CharsetTest {

    @Test
    void testRoman() {
        Charset charset = new Roman8Charset();
        byte[] converted = "β".getBytes(charset);
        assertEquals(1, converted.length);
        assertEquals((byte) 0xDE, converted[0]);

        converted = "ß".getBytes(charset);
        assertEquals(1, converted.length);
        assertEquals((byte) 0xDE, converted[0]);
    }
}
