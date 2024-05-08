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
package com.github.leonhad.hproman;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * The HP Roman charset provider.
 */
public class RomanCharsetProvider extends CharsetProvider {

    private static final List<Charset> CHARSET_LIST = Arrays.asList(new Roman8Charset(), new Roman8v1Charset(), new Roman8v2Charset(), new Roman9Charset());

    /**
     * Creates a new instance.
     */
    public RomanCharsetProvider() {
        super();
    }

    @Override
    public Iterator<Charset> charsets() {
        return CHARSET_LIST.iterator();
    }

    @Override
    public Charset charsetForName(String charsetName) {
        return CHARSET_LIST.stream().filter(c -> charsetName.equals(c.name()) || c.aliases().contains(charsetName)).findAny().orElse(null);
    }
}
