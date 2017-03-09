package jp.techacademy.kousei.asayama.crossstamp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CrossStamp extends Game {
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		//オープニング画面を表示
		//現在は試験的にレコード画面へ遷移するように設定中
		//setScreen(new OpeningScreen(this));
		//setScreen(new RecordScreen());
	}
}
