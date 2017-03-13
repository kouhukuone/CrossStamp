package jp.techacademy.kousei.asayama.crossstamp;

import android.os.Handler;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

//オプション画面
public class OptionScreen implements ApplicationListener {
    Stage stage;
    Texture option_left_bgm,
            option_left_se,
            option_right_bgm,
            option_right_se,
            option_title,
            reset;

    Image mOption_left_bgm,
            mOption_left_se,
            mOption_right_bgm,
            mOption_right_se,
            mOption_title,
            mReset;

    @Override
    public void create(){
        option_left_bgm = new Texture("option_left.png");
        option_left_se = new Texture("option_left.png");
        option_right_bgm = new Texture("option_right.png");
        option_right_se = new Texture("option_right.png");
        option_title = new Texture("option_title.png");
        reset = new Texture("reset.png");

        mOption_left_bgm = new Image(option_left_bgm);
         mOption_left_se = new Image(option_left_se);
          mOption_right_bgm = new Image(option_right_bgm);
          mOption_right_se = new Image(option_right_se);
           mOption_title = new Image(option_title);
            mReset = new Image(reset);

    }

    //描画
    @Override
    public void render(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(22, 0, 0, 1);

    }

    //画面サイズ変更時
    @Override
    public void resize(int width, int height){
    }

    //スマホのホーム画面、着信時
    @Override
    public void pause(){

    }

    //ポーズから復帰時
    @Override
    public void resume(){

    }

    //破棄時
    @Override
    public void dispose(){

    }

}
