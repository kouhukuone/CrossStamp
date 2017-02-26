package jp.techacademy.kousei.asayama.crossstamp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

//オプション画面
//オープニング画面から遷移

public class OptionScreen extends ScreenObject {

    public OptionScreen(CrossStamp game){
        super(game);

        //背景を準備
        Texture bgTexture = new Texture("stage3button.png");
        //TextureRegionで切り出すときの原点は左上
        mBg = new Sprite(new TextureRegion(bgTexture, 0, 0, 540, 810));
        mBg.setSize(CAMERA_WIDTH,CAMERA_HEIGHT);
        mBg.setPosition(0, 0);
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
        mGame.batch.end();


    }

}
