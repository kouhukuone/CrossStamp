package jp.techacademy.kousei.asayama.crossstamp;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class OpeningScreen extends ScreenAdapter {
    //カメラサイズを表す定数
    static final float CAMERA_WIDTH = 10;
    static final float CAMERA_HEIGHT = 15;

    private CrossStamp mGame;

    TapButton mTitleButton;


    Sprite mBg;
    OrthographicCamera mCamera; //カメラを表す
    FitViewport mViewPort; //ビューポート

    Vector3 mTouchPoint;

    //コンストラクタ？
    public OpeningScreen(CrossStamp game) {
        mGame = game;

        //背景を準備
        Texture bgTexture = new Texture("badlogic.jpg");
        //TextureRegionで切り出すときの原点は左上
        mBg = new Sprite(new TextureRegion(bgTexture, 0, 0, 540, 810));
        mBg.setSize(CAMERA_WIDTH,CAMERA_HEIGHT);
        mBg.setPosition(0, 0);

        //カメラ、ViewPortを生成、設定
        //定数を使って2つの大きさを同じにする
        mCamera = new OrthographicCamera();
        mCamera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
        mViewPort = new FitViewport(CAMERA_WIDTH, CAMERA_HEIGHT, mCamera);

        mTouchPoint = new Vector3();

        createButton();
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

        //原点は左下
        mBg.setPosition(mCamera.position.x - CAMERA_WIDTH / 2, mCamera.position.y - CAMERA_HEIGHT / 2);
        mBg.draw(mGame.batch);

        mGame.batch.end();
    }

    @Override
    //物理的な画面のサイズが変更された時に呼び出される
    public void resize(int width, int height){
        mViewPort.update(width, height);
    }

    private void createButton(){
        Texture titleButtonTexture = new Texture("option_title.png");
        mTitleButton = new TapButton(titleButtonTexture, 0, 0, 72, 30);
        mTitleButton.setPosition(0, 0);
    }
}

