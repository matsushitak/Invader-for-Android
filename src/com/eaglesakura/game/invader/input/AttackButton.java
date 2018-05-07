package com.eaglesakura.game.invader.input;

import com.eaglesakura.game.invader.Define;
import com.eaglesakura.game.invader.GameSprite;
import com.eaglesakura.game.invader.R;
import com.eaglesakura.game.invader.scene.GameSceneBase;
import com.eaglesakura.lib.android.game.graphics.Sprite;
import com.eaglesakura.lib.android.game.input.MultiTouchInput.TouchPoint;

public class AttackButton extends GameSprite {
	/**
	 * 押していない時のボタン画像
	 */
	Sprite release = null;
	
	/**
	 * 押している時のボタン画像
	 */
	Sprite press = null;
	
	/**
	 * 攻撃する瞬間の場合、true
	 */
	boolean attack = false;

	public AttackButton(GameSceneBase scene) {
		super(scene);
		
		release = loadSprite(R.drawable.ui_shot);//離している時の画像
		press = loadSprite(R.drawable.ui_shot_p);//押している時の画像
		
		sprite = release; //まずは離している時の画像表示
		
		//適当な位置で表示する
		setPosition(Define.VIRTUAL_DISPLAY_WIDTH - 50, Define.VIRTUAL_DISPLAY_HEIGHT - 120);
		
	}
	
	@Override
	public void setPosition(float x, float y) { 
		super.setPosition(x, y);
		
		//release/pressのスプライト位置も更新する
		release.setSpritePosition((int) x, (int) y);
		press.setSpritePosition((int) x, (int) y);
	}
	
	/**
	 * 攻撃する場合、trueを返す
	 */
	public boolean isAttack() {
		return attack;
	}
	
	@Override
	public void update() {
		// 触れているか,話した瞬間のタッチ座標があるかどうかを確認する
		TouchPoint touchPoint = sprite.findIntersectTouchOrReleaseOnce(scene.getMultiTouchInput());
		
		if(touchPoint != null) {
			//該当ポイントがあったので、「話した瞬間」ならば攻撃タイミングとして認識する
			if (touchPoint.isReleaseOnce()) {
				sprite = release; //離している時の画像にする
				attack = true; //攻撃するタイミングとして認識する
			} else {
				sprite = press; //押している時の画像を表示する
				attack = false; //攻撃するタイミングではない
			}
		} else {
			//該当ポイントがないので、ボタンは押されていないし攻撃タイミングでもない
			sprite = release; //離している時の画像を表示する
			attack = false; //攻撃するタイミングではない
		}
	}

}
