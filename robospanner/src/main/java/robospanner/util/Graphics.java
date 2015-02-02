package robospanner.util;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Graphics {

    /**
     * Tint the drawable to the specified color. Optionally at an alpha level.<code>
     *     tint(drawable,rgbColor,alphaLevel); // alphaLevel = 0(no color)..255(full color)
     * </code>
     * @param drawable
     * @param colorAlpha
     * @return
     */
    public static Drawable tint(Drawable drawable, int... colorAlpha) {
        int color;
        int alpha=0xff;
        if (colorAlpha.length==0){
            throw new IllegalArgumentException("Must give at least color");
        }
        color = colorAlpha[0];
        if (colorAlpha.length>1)
            alpha = colorAlpha[1];

        drawable = drawable.mutate();

        float[] matrix = {
            0, 0, 0, 0, (color & 0xFF0000) >> 16,   // red
            0, 0, 0, 0, (color & 0xFF00) >> 8,      // green
            0, 0, 0, 0, (color & 0xFF),             // blue
            0, 0, 0, ((float)(alpha&0xff))/255F, 0  // alpha
        };
        ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);
        drawable.setColorFilter(colorFilter);
        return drawable;
    }

    public static void tint(ImageView view, int... colorAlpha) {
        Drawable drawable = view.getDrawable();
        tint(drawable, colorAlpha);
    }
}