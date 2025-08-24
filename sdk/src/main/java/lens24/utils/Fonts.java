package lens24.utils;

import android.content.Context;
import android.graphics.Typeface;

public final class Fonts {

    private static volatile Typeface sCardFont;

    private Fonts(Context context) { }

    public static Typeface getCardFont(Context context) {
        if (sCardFont == null) {
            synchronized (Fonts.class) {
                if (sCardFont == null) sCardFont = Typeface.DEFAULT;
            }
        }
        return sCardFont;
    }
}
