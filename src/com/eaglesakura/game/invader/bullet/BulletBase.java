package com.eaglesakura.game.invader.bullet;

import com.eaglesakura.game.invader.GameSprite;
import com.eaglesakura.game.invader.fighter.FighterBase;
import com.eaglesakura.game.invader.scene.GameSceneBase;

public class BulletBase extends GameSprite {
	/**
	 * この弾を撃った期待を保持しておく
	 */
	FighterBase shooter = null;
	
	/**
	 * 弾が有効な場合true
	 */
	protected boolean enable = true;

	public BulletBase(GameSceneBase scene, FighterBase shooter) {
		super(scene);
		this.shooter = shooter;
	}
	
	/**
	 * 弾が有効ならtrue
	 * @return
	 */
	public boolean isEnable() {
		return enable;
	}

	@Override
	public void draw() {
		// 弾が有効でないなら描画しない
		if (!isEnable()) {
			return;
		}
		super.draw();
	}

	@Override
	public void update() {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
