package jp.ac.uryukyu.ie.e165749;


/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by south on 2016/11/13.
 */
public class Hero extends LivingThing {

    public Hero(String name, int maximumHP, int attack) {
       super(name, maximumHP, attack);
        super.name = name;
        hitPoint = maximumHP;
        //super.attack = attack;


        dead = false;
    }

    @Override
    public void attack(LivingThing opponent){
        int damage = (int) (Math.random() * attack);
        if(hitPoint > 0) {
            if(damage != 0) {
                double critical = Math.random();
                if(critical < 0.3){
                    damage = damage * 2;
                    System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
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