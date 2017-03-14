package jp.techacademy.kousei.asayama.crossstamp;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

//ステージ画面。実際に遊ぶ画面
public class StageScreen implements ApplicationListener {
    Stage stage;
    Texture stage_masempty;
    Texture stage_masnuri;
    Image mas;
    Image masnuri;
    Image[][] sMas;

    Image[] masIndex;


    //最初に呼び出される
    @Override
    public void create() {

        stage = new Stage();
        //マスのアクター
        {
            stage_masempty = new Texture("stage_masempty.png");
            mas = new Image(stage_masempty);

            mas.setPosition(50, 50);
            ClickListener listener = new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    //クリック時のイベントを記述
                }
            };
            mas.addListener(listener);
            stage.addActor(mas);
        }

        //マスのアクター
        {
            stage_masnuri = new Texture("stage_masnuri.png");
            masnuri = new Image(stage_masnuri);

            masnuri.setPosition(100, 100);
            stage.addActor(masnuri);
        }

        //ステージマスのアクター
        //最後にaddActorしたものだけが表示されるためコメント化
        /*
        {
            masIndex = new Image[]{
                    mas,mas,mas,mas,mas,
                    mas,mas,mas,mas,mas,
                    mas,mas,mas,mas,mas
            };
            sMas = new Image[][]{
                    {masIndex[0], masIndex[1], masIndex[2], masIndex[3], masIndex[4]},
                    {masIndex[5], masIndex[6], masIndex[7], masIndex[8], masIndex[9]},
                    {masIndex[10], masIndex[11], masIndex[12], masIndex[13], masIndex[14]}
            };

            int actIndex = 0;
            // i = 縦　k = 横
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 5; k++) {
                    sMas[i][k].setPosition(500 + (50 * i), (500 + (50 * k)));
                    stage.addActor(sMas[i][k]);
                }
            }
        }
        */

    }

    //描画
    @Override
    public void render(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(9, 0, 0, 1);

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
