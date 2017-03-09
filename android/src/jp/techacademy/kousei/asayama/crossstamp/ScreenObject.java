package jp.techacademy.kousei.asayama.crossstamp;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class ScreenObject extends ScreenAdapter {
    //カメラサイズを表す定数
    static final float CAMERA_WIDTH = 10;
    static final float CAMERA_HEIGHT = 15;

    CrossStamp mGame;
    SpriteBatch batch;

    Sprite mBg;
    OrthographicCamera mCamera; //カメラを表す
    FitViewport mViewPort; //ビューポート

    Vector3 mTouchPoint;

    public ScreenObject(CrossStamp game){
        mGame = game;
        batch = new SpriteBatch();

        //カメラ、ViewPortを生成、設定
        //定数を使って2つの大きさを同じにする
        mCamera = new OrthographicCamera();
        mCamera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
        mViewPort = new FitViewport(CAMERA_WIDTH, CAMERA_HEIGHT, mCamera);

        mTouchPoint = new Vector3();
    }
}
