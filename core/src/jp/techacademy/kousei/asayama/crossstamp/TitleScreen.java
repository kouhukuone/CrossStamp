package jp.techacademy.kousei.asayama.crossstamp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

//タイトル画面
//オープニングから遷移。
//タイトルボタンタップで遷移

public class TitleScreen extends ScreenObject {
    Sprite tapButton;
    Sprite mRecordButton;
    Vector3 mTouchPoint;

    //コンストラクタ
    public TitleScreen(CrossStamp game){
        super(game);

        //背景を準備
        Texture bgTexture = new Texture("stage2button.png");

        //TextureRegionで切り出すときの原点は左上
        mBg = new Sprite(new TextureRegion(bgTexture, 0, 0, 540, 810));
        mBg.setSize(CAMERA_WIDTH,CAMERA_HEIGHT);
        mBg.setPosition(0, 0);

        //ボタンを準備
        Texture optionButton = new Texture("title_option.png");
        tapButton = new Sprite(optionButton);
        tapButton.setSize(2.0f, 1.0f);
        tapButton.setPosition(0,0);

        Texture recordButton = new Texture("title_record.png");
       mRecordButton = new Sprite(recordButton);
        mRecordButton.setSize(2.0f, 1.0f);
        mRecordButton.setPosition(3, 0);

        mTouchPoint = new Vector3();

    }

    //描画
    @Override
    public void render (float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //カメラの座標をアップデート（計算）し、スプライトの表示に反映させる
        mCamera.update();
        mGame.batch.setProjectionMatrix(mCamera.combined);

        mGame.batch.begin();
         mBg.draw(mGame.batch);
        tapButton.draw(mGame.batch);
        mRecordButton.draw(mGame.batch);
        mGame.batch.end();

        //オプションボタン、レコードボタンタップ時に画面遷移
        //現在動かない
        if (Gdx.input.justTouched()) {
            if (mTouchPoint.equals(tapButton)){
                mGame.setScreen(new OptionScreen(mGame));
                this.dispose();
            }
        }
    }



}
