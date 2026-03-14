package com.sparrowwallet.sparrow.glyphfont;

import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;
import org.controlsfx.glyphfont.INamedCharacter;

import java.io.InputStream;
import java.util.Arrays;

public class CryptoFont extends GlyphFont {
    public static String FONT_NAME = "cryptofont";

    /**
     * The individual glyphs offered by the CryptoFont font.
     */
    public static enum Glyph implements INamedCharacter {
        LTC('\ueb84');

        private final char ch;

        /**
         * Creates a named Glyph mapped to the given character
         * @param ch
         */
        Glyph( char ch ) {
            this.ch = ch;
        }

        @Override
        public char getChar() {
            return ch;
        }
    }

    /**
     * Do not call this constructor directly - instead access the
     * {@link CryptoFont.Glyph} public static enumeration method to create the glyph nodes), or
     * use the {@link GlyphFontRegistry} class to get access.
     *
     * Note: Do not remove this public constructor since it is used by the service loader!
     */
    public CryptoFont() {
        this(CryptoFont.class.getResourceAsStream("/font/cryptofont.ttf"));
    }

    /**
     * Creates a new CryptoFont instance which uses the provided font source.
     * @param is
     */
    public CryptoFont(InputStream is){
        super(FONT_NAME, 14, is, true);
        registerAll(Arrays.asList(CryptoFont.Glyph.values()));
    }
}
