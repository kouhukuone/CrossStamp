package jp.techacademy.kousei.asayama.crossstamp;


import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
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
    Image[][] sMasnuri;

    Image[] masIndex;
    Image[] masnuriIndex;
    ClickListener listener2;

    int tateIndex = 0;
    int yokoIndex = 0;
    int actIndex = 0;

    //最初に呼び出される
    @Override
    public void create() {

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        //マスのアクター
        {
            stage_masempty = new Texture("stage_masempty.png");
            mas = new Image(stage_masempty);

            mas.setPosition(50, 50);
            //タップイベント
            ClickListener listener1 = new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){
                    sMas[2][2].setScale(1.3f);
                }
            };
            mas.addListener(listener1);
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

        {
            //空白マス
            masIndex = new Image[]{
                    new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty),
                    new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty),
                    new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty),new Image(stage_masempty)
            };
            sMas = new Image[][]{
                    {masIndex[0], masIndex[1], masIndex[2]},
                    {masIndex[3], masIndex[4],masIndex[5]},
                    {masIndex[6], masIndex[7],masIndex[8]},
                    {masIndex[9], masIndex[10],masIndex[11]},
                    {masIndex[12], masIndex[13],masIndex[14]}
            };

            //塗りつぶしたマス
            masnuriIndex = new Image[]{
                    new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri),
                    new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri),
                    new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri),new Image(stage_masnuri)
            };

            sMasnuri = new Image[][]{
                    {masnuriIndex[0],masnuriIndex[1],masnuriIndex[2]},
            {masnuriIndex[3],masnuriIndex[4],masnuriIndex[5]},
            {masnuriIndex[6],masnuriIndex[7],masnuriIndex[8]},
            {masnuriIndex[9],masnuriIndex[10],masnuriIndex[11]},
            {masnuriIndex[12],masnuriIndex[13],masnuriIndex[14]}
            };

            //マスをActorに追加
            // i = 縦　k = 横
            for (int i = 0; i < 5; i++) {
                tateIndex = i;
                for (int k = 0; k < 3; k++) {
                    yokoIndex = k;
                    sMas[i][k].setPosition(250 + (64 * i), (500 + (64 * k)));
                    //タップイベント登録
                    sMas[i][k].addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y){
                            //sMas[0][0].setPosition(20, 20);
                            sMas[tateIndex][yokoIndex] = sMasnuri[tateIndex][yokoIndex];
                        }
                    });
                    stage.addActor(sMas[i][k]);
                    actIndex++;
                }
            }
        }
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
