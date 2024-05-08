package io.github.leonhad.hproman;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Map;

/**
 * Abstract charset support.
 *
 * @since 1.0.0
 */
public abstract class AbstractCharset extends Charset {

    /**
     * Creates a new instance.
     *
     * @param canonicalName the charset canonical name.
     * @param aliases       the charset alias list.
     */
    protected AbstractCharset(String canonicalName, String[] aliases) {
        super(canonicalName, aliases);
    }

    protected abstract char[] getTable();

    protected abstract Map<Character, Byte> getLookupTable();

    @Override
    public boolean contains(Charset cs) {
        return cs.name().equals("roman8");
    }

    @Override
    public CharsetDecoder newDecoder() {
        final char[] table = getTable();
        return new CharsetDecoder(this, 1.0F, 1.0F) {
            @Override
            protected CoderResult decodeLoop(ByteBuffer from, CharBuffer to) {

                while (from.hasRemaining()) {
                    if (!to.hasRemaining()) {
                        return CoderResult.OVERFLOW;
                    }

                    byte c = from.get();
                    char d = table[c & 0xFF];
                    to.put(d);
                }

                return CoderResult.UNDERFLOW;
            }
        };
    }

    @Override
    public CharsetEncoder newEncoder() {
        final Map<Character, Byte> lookup = getLookupTable();

        return new CharsetEncoder(this, 1F, 1F) {
            @Override
            protected CoderResult encodeLoop(final CharBuffer from, final ByteBuffer to) {
                while (from.hasRemaining()) {
                    if (!to.hasRemaining()) return CoderResult.OVERFLOW;

                    final Byte v = lookup.get(from.get());
                    if (v == null) {
                        // unconsume the character we consumed
                        from.position(from.position() - 1);
                        return CoderResult.unmappableForLength(1);
                    }

                    to.put(v);
                }

                return CoderResult.UNDERFLOW;
            }
        };
    }
}
