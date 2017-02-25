package jp.techacademy.kousei.asayama.crossstamp;

import com.badlogic.gdx.graphics.Texture;


public class TapButton extends GameObject {
    public static final float BUTTON_WIDTH = 1.0f;
    public static final float BUTTON_HEIGHT = 1.0f;

    public TapButton(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    }
}
