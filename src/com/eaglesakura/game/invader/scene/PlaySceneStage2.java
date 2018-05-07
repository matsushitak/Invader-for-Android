package com.eaglesakura.game.invader.scene;

import com.eaglesakura.game.invader.Define;
import com.eaglesakura.game.invader.InvaderGame;
import com.eaglesakura.game.invader.fighter.enemy.EnemyFighterBase;
import com.eaglesakura.game.invader.fighter.enemy.Frisbee;
import com.eaglesakura.game.invader.fighter.enemy.Tongari;

public class PlaySceneStage2 extends PlaySceneBase {

    public PlaySceneStage2(InvaderGame game) {
        super(game);
    }

    /**
     * 敵の初期化を行う。
     */
    @Override
    protected void initializeEnemy() {
        // 敵の配置テーブルを作成する
        final EnemyFighterBase[][] enemyTable = {
            // 後列
            {
                    new Frisbee(this), new Tongari(this), new Frisbee(this),
            },
        };

        // プレイエリアの左右から幅を取得する
        final int PLAY_AREA_WIDTH = Define.PLAY_AREA_RIGHT - Define.PLAY_AREA_LEFT;
        int y = 100;

        // 全ラインをfor文で見る。
        for (int line = 0; line < enemyTable.length; ++line) {
            final int lineEnemyNum = enemyTable[line].length;

            // 1ラインの横方向をfor文で見る
            for (int index = 0; index < lineEnemyNum; ++index) {
                // 配置対象の敵をテーブルから取り出す
                EnemyFighterBase enemy = enemyTable[line][index];

                // 配置する敵が存在する場合、位置を設定する。
                if (enemy != null) {
                    // プレイエリアを等分して、現在のindexに割り当てる
                    int x = PLAY_AREA_WIDTH / lineEnemyNum * index;
                    x += PLAY_AREA_WIDTH / lineEnemyNum / 2;
                    enemy.setPosition(Define.PLAY_AREA_LEFT + x, y);

                    // 敵リストへ登録する
                    enemies.add(enemy);
                }
            }

            // Y位置を1ライン前線へ下げる
            y += 100;
        }
    }

}