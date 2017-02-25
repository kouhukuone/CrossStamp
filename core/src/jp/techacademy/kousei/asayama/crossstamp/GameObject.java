package jp.techacademy.kousei.asayama.crossstamp;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/*
ゲームオブジェクトクラス
ボタン画像、背景画像、スピング画像、その他画像の元情報
 */
public class GameObject extends Sprite {
    public final Vector2 velocity;

    //コンストラクタ
    public GameObject(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight){
        super(texture, srcX, srcY, srcWidth, srcHeight);

        //Vector2クラス。座標などxとyを持つ場合に利用
        velocity = new Vector2();
    }
}
