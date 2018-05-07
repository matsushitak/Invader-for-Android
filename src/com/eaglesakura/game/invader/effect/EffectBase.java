package com.eaglesakura.game.invader.effect;

import com.eaglesakura.game.invader.GameSprite;
import com.eaglesakura.game.invader.scene.GameSceneBase;

public class EffectBase extends GameSprite {

	public EffectBase(GameSceneBase scene) {
		super(scene);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	/**
	 * このエフェクトが有効ならtrueを返す
	 * falseを返した場合、このエフェクトはフィールドから取り除かれる
	 * @return
	 */
	public boolean isEnable() {
		return !sprite.isAnimationFinish();
	}

	@Override
	public void update() {
		// スプライトのアニメーションを更新する
		sprite.nextFrame();

	}

}
