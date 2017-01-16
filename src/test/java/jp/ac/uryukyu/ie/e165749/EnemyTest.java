package jp.ac.uryukyu.ie.e165749;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tnal on 2016/11/13.
 */
public class EnemyTest {
    /**
     * 「死んでる状態では攻撃できない」ことを確認。
     * @throws Exception
     */
    @Test
    public void attack() throws Exception {
        int heroHP = 10;
        Hero hero = new Hero("テスト勇者", heroHP, 5);
        Enemy enemy = new Enemy("テストスライム", 6, 3);
        enemy.dead = true;
        for(int i=0; i<10; i++) {
            if(enemy.dead == false) {
                enemy.attack(hero); //乱数で0ダメージとなることもあるため、複数回実行してみる。
            }
        }
        assertEquals(heroHP, hero.hitPoint);
    }

}