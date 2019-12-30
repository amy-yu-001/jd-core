/*
 * Copyright (c) 2008-2019 Emmanuel Dupuy.
 * This project is distributed under the GPLv3 license.
 * This is a Copyleft license that gives the user the right to use,
 * copy and modify the code freely for non-commercial purposes.
 */

package org.jd.core.v1.service.fragmenter.javasyntaxtojavafragment.util;


public class CharacterUtil {

    public static String escapeChar(int c) {
        switch (c) {
            case '\\':
                return "\\\\";
            case '\b':
                return "\\b";
            case '\f':
                return "\\f";
            case '\n':
                return "\\n";
            case '\r':
                return "\\r";
            case '\t':
                return "\\t";
            case '\'':
                return "\\'";
            default:
                if (c < ' ') {
                    return "\\0" + ((char) ('0' + (c >> 3))) + ((char) ('0' + (c & 7)));
                } else if (c > 127) {
                    char[] buffer = new char[6];

                    buffer[0] = '\\';
                    buffer[1] = 'u';

                    int h = (c >> 12);

                    buffer[2] = (char)((h <= 9) ? (h + '0') : (h + ('A' - 10)));
                    h = (c >> 8) & 15;
                    buffer[3] = (char)((h <= 9) ? (h + '0') : (h + ('A' - 10)));
                    h = (c >> 4) & 15;
                    buffer[4] = (char)((h <= 9) ? (h + '0') : (h + ('A' - 10)));
                    h = (c) & 15;
                    buffer[5] = (char)((h <= 9) ? (h + '0') : (h + ('A' - 10)));

                    return new String(buffer);
                } else {
                    return String.valueOf((char)c);
                }
        }
    }
}
