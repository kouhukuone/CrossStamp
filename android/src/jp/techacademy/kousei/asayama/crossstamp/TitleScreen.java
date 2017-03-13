package jp.techacademy.kousei.asayama.crossstamp;

import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

//タイトル画面
public class TitleScreen extends Game implements ApplicationListener {
    Stage stage;
    Texture title_option;
    Texture title_play;
    Texture title_record;
    Image  mTitle_option;
    Image mTitle_play;
    Image mTitle_record;


    //最初に呼び出される
    @Override
    public void create(){

    title_option = new Texture("title_option.png");
    title_play = new Texture("title_play.png");
    title_record = new Texture("title_record.png");

    mTitle_option = new Image(title_option);
    mTitle_play = new Image(title_play);
    mTitle_record = new Image(title_record);



        Gdx.input.setInputProcessor(stage);

        stage = new Stage();
        //プレイボタン
        {
            mTitle_play.setPosition(0,0);
            stage.addActor(mTitle_play);
            ClickListener listener = new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                 //クリック時のイベントを記述
                }
            };
            mTitle_play.addListener(listener);
            stage.addActor(mTitle_play);
        }

        //オプションボタン
        {
            mTitle_option.setPosition(100,0);
            ClickListener listener = new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //クリック時のイベントを記述
                }
            };
            mTitle_option.addListener(listener);
            stage.addActor(mTitle_option);
        }

        //レコードボタン
        {
            mTitle_record.setPosition(200,0);
            ClickListener listener = new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //クリック時のイベントを記述

                }
            };
            mTitle_record.addListener(listener);
            stage.addActor(mTitle_record);
        }
    }

    //描画
    @Override
    public void render(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 0, 1);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

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
