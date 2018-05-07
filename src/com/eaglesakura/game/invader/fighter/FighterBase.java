package com.eaglesakura.game.invader.fighter;

import android.graphics.Rect;

import com.eaglesakura.game.invader.GameSprite;
import com.eaglesakura.game.invader.bullet.BulletBase;
import com.eaglesakura.game.invader.scene.GameSceneBase;

public abstract class FighterBase extends GameSprite {
	/**
	 * 戦闘機のヒットポイント
	 * デフォルトは１にしておく
	 */
	protected int hp = 1;

	public FighterBase(GameSceneBase scene) {
		super(scene);
	}
	
	/**
	 * 2つのスプライトが衝突している場合trueを返す
	 * @param other
	 * @return
	 */
	public boolean isIntersect(GameSprite other) {
		if (isDead()) {
			// 撃墜済みの戦闘機に当たり判定を処理しない
			return false;
		}
		Rect mySpriteArea = getSprite() .getDstRect();
		Rect otherSpriteArea = other.getSprite() .getDstRect();
		return Rect.intersects(mySpriteArea, otherSpriteArea);
	}
	
	/**
	 * 弾が当たったらこのメソッドに通知される
	 * @param bullet
	 */
	public void onDamage(BulletBase bullet) {
		--hp;
	}
	
	/**
	 * この機体が撃墜されていたらtrueを返す
	 * @return
	 */
	public boolean isDead() {
		return hp <= 0;
	}

}
