package jp.techacademy.kousei.asayama.crossstamp;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

//レコード画面
public class RecordScreen extends Game implements ApplicationListener {

    Stage stage;
    Texture option_title;
    Image mOptionTitle;

    @Override
    public void create(){
        stage = new Stage();
        {
            option_title = new Texture("option_title.png");
            mOptionTitle = new Image(option_title);
            mOptionTitle.setPosition(2,2);
            stage.addActor(mOptionTitle);
        }

    }

    //描画
    @Override
    public void render(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(22, 0, 0, 1);

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
