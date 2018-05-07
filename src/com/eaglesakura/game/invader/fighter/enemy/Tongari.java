package com.eaglesakura.game.invader.fighter.enemy;

import com.eaglesakura.game.invader.R;
import com.eaglesakura.game.invader.bullet.DirectionBullet;
import com.eaglesakura.game.invader.scene.GameSceneBase;
import com.eaglesakura.game.invader.scene.PlaySceneBase;

public class Tongari extends EnemyFighterBase {

    public Tongari(GameSceneBase scene) {
        super(scene);
        sprite = loadSprite(R.drawable.enemy_01); // 敵の画像を読み込む
        hp = 50; // HP50のボスキャラにする。
    }

    /**
     * 弾を発射する
     */
    void fire() {
        // 方向弾を生成する
        DirectionBullet bullet = new DirectionBullet(scene, this);

        // 現在のフレーム数の角度へ10の速度で打ち込む
        bullet.setup(120 + (frameCount % 120), 10);

        // シーンに弾を追加する
        ((PlaySceneBase) scene).addBullet(bullet);
    }

    @Override
    public void update() {
        // スーパークラスの処理を行わせる
        super.update();
        // 指定したフレームで処理を行わせる
        if (frameCount % 10 == 0) {
            // 10フレームごとに、弾を撃たせる
            fire();
        }
    }
}