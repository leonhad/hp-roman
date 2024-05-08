/*
 * Copyright (c) 2009 Leonardo Alves da Costa
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details. You should have received a copy of the GNU General Public License along with this
 * program. If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.leonhad.hproman;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The Roman8 charset.
 */
public class Roman8v2Charset extends AbstractCharset {

    // Source: https://en.wikipedia.org/wiki/HP_Roman
    private static final char[] TABLE = {
            '\u0000', '\u0001', '\u0002', '\u0003', '\u0004', '\u0005', '\u0006', '\u0007', '\u0008', '\t', '\n', '\u000B', '\u000C', '\r', '\u000E', '\u000F', // 0x00
            '\u0010', '\u0011', '\u0012', '\u0013', '\u0014', '\u0015', '\u0016', '\u0017', '\u0018', '\u0019', '\u001A', '\u001B', '\u001C', '\u001D', '\u001E', '\u001F', // 0x10
            0x20, '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', // 0x20
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', // 0x30
            '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', // 0x40
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', // 0x50
            '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', // 0x60
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', '▒', // 0x70
            '\u00A0', '÷', '×', '√', '∫', 'Σ', '▶', 'π', '∂', '≤', '≥', '≠', 'α', '→', '←', 'µ', // 0x80
            '\n', '°', '«', '»', '⊦', '₁', '₂', '²', '³', 'ᵢ', 'ⱼ', '‥', 'ⁱ', 'ʲ', 'ᵏ', 'ⁿ', //0x90
            '∡', 'À', 'Â', 'È', 'Ê', 'Ë', 'Î', 'Ï', '´', 'ˋ', 'ˆ', '¨', '˜', 'Ù', 'Û', '₤', // 0xA0
            '¯', 'Ý', 'ý', '°', 'Ç', 'ç', 'Ñ', 'ñ', '¡', '¿', '¤', '£', '¥', '§', 'ƒ', '¢', // 0xB0
            'â', 'ê', 'ô', 'û', 'á', 'é', 'ó', 'ú', 'à', 'è', 'ò', 'ù', 'ä', 'ë', 'ö', 'ü', // 0xC0
            'Å', 'î', 'Ø', 'Æ', 'å', 'í', 'ø', 'æ', 'Ä', 'ì', 'Ö', 'Ü', 'É', 'ï', 'ß', 'Ô', // 0xD0
            'Á', 'Ã', 'ã', 'Ð', 'ð', 'Í', 'Ì', 'Ó', 'Ò', 'Õ', 'õ', 'Š', 'š', 'Ú', 'Ÿ', 'ÿ', // 0xE0
            'Þ', 'þ', '·', 'µ', '¶', '¾', '—', '¼', '½', 'ª', 'º', '«', '■', '»', '±', '\u0000'  // 0xF0
    };

    private static final Map<Character, Byte> LOOKUP;

    static {
        Map<Character, Byte> map = new HashMap<>();
        for (int i = 0; i < TABLE.length; i++) {
            map.put(TABLE[i], (byte) i);
        }

        // Add special cases (problems with encoding definition by IBM and HP).
        map.put('\u007F', (byte) 0x7F);
        map.put('μ', (byte) 0x8F);
        map.put('˚', (byte) 0x91);
        map.put('∠', (byte) 0xA0);
        map.put('｀', (byte) 0xA9);

        LOOKUP = Collections.unmodifiableMap(map);
    }

    /**
     * Creates a new instance.
     */
    public Roman8v2Charset() {
        super("roman8-v2", new String[]{"hp-roman8-v2", "HP_ROMAN8_V2", "ROMAN8_V2"});
    }

    @Override
    protected char[] getTable() {
        return TABLE;
    }

    @Override
    protected Map<Character, Byte> getLookupTable() {
        return LOOKUP;
    }
}
