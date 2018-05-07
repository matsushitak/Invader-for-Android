package com.eaglesakura.game.invader.bullet;

import com.eaglesakura.game.invader.R;
import com.eaglesakura.game.invader.fighter.FighterBase;
import com.eaglesakura.game.invader.scene.GameSceneBase;
import com.eaglesakura.game.invader.scene.PlaySceneBase;

public class FrisbeeBullet extends BulletBase {

	public FrisbeeBullet(GameSceneBase scene, FighterBase shooter) {
		super(scene, shooter);
		
		sprite = loadSprite(R.drawable.bullet_enemy); //弾の画像を保持する
		setPosition(shooter.getPositionX(), shooter.getPositionY()); //位置を発射した戦闘機に合わせる
		
		// サウンドを鳴らす
		scene.playSE(R.raw.enemy_bullet);
		}
	
	@Override
	public void update() {
		offsetPosition(0, 10); //下へ向かって移動させる
		
		FighterBase player = ((PlaySceneBase) scene).getPlayer();
		//プレイヤーと弾が衝突したらダメージ処理を行う
		if (player.isIntersect(this)) {
			enable = false;
			player.onDamage(this);
		}
	}

}
