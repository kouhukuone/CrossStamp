package jp.techacademy.kousei.asayama.crossstamp;

import android.app.Application;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.deploygate.sdk.DeployGate;

public class CrossStamp extends Application {
	public void create () {
		super.onCreate();
		DeployGate.install(this);
	}
}
