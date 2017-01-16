package jp.ac.uryukyu.ie.e165749;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by south on 2016/11/13.
 */
public class Enemy extends LivingThing {

    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
        super.name = name;
        super.attack = attack;
        hitPoint = maximumHP;
        dead = false;
    }

    @Override
    public void attack(LivingThing opponent){
        int damage = (int) (Math.random() * attack);
        if(hitPoint > 0) {
            if(damage != 0) {
                double critical = Math.random();
                if(critical < 0.2){
                    damage = damage * 2;
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
                }else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
                }
            }else{
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", name, opponent.getName());
            }

        }
        opponent.wounded(damage);
    }
}