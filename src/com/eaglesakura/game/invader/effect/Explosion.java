package com.eaglesakura.game.invader.effect;

import com.eaglesakura.game.invader.GameSprite;
import com.eaglesakura.game.invader.R;
import com.eaglesakura.game.invader.scene.GameSceneBase;

public class Explosion extends EffectBase {

    public Explosion(GameSceneBase scene, GameSprite parent) {
        super(scene);
        // 64x64サイズで12コマのスプライトを生成する
        sprite = loadAnimatedSprite(R.drawable.explosion, 64, 64, 12);
        // 爆発を発生させた親の位置に合わせる
        if (parent != null) {
            setPosition(parent.getPositionX(), parent.getPositionY());
        }
    }

}