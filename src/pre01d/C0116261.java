/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pre01d;

import lesson03.*;
import lesson02.*;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import java.awt.Color;
import java.beans.Introspector;
import jdk.nashorn.internal.ir.BreakNode;
import robocode.*;

/**
 *
 * @author merarli
 */
public class C0116261 extends Robot {

    public int turnCount = 0;
    public String tmpName = "";

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        double battleDiaonal = Math.sqrt(Math.pow
        (getBattleFieldHeight(), 2) + Math.pow(getBattleFieldWidth(), 2));
        double distanceLevel1 = 100;
        double distanceLevel2 = 200;
        double distanceLevel3 = 300;
        double distanceLevel4 = 400;

        System.out.println(distanceLevel4);
        System.out.println(distanceLevel3);
        System.out.println(distanceLevel2);
        System.out.println(distanceLevel1);

        if (event.getDistance() <= distanceLevel1) {
            System.out.println("敵までの距離Level1");
            fire(1);
        } else if (event.getDistance() <= distanceLevel2) {
            System.out.println("敵までの距離Level2");
            fire(2);
        } else if (event.getDistance() <= distanceLevel3) {
            System.out.println("敵までの距離Level3");
            fire(3);
        } else if (event.getDistance() <= distanceLevel4) {
            System.out.println("敵までの距離Level4");
            fire(4);
        }

        setScanColor(Color.yellow);
    }

    @Override
    public void onHitWall(HitWallEvent event) {

    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        System.out.println("ロボットに衝突しました！");
        System.out.println("敵の角度" + event.getBearing());
        System.out.println("敵のエネルギー" + event.getEnergy());
        System.out.println("---");
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {

        System.out.println("敵のたまが命中しました！");
        System.out.println("敵の角度" + event.getBearing());
        System.out.println("敵の名前" + event.getName());
        System.out.println("敵の弾のパワー" + event.getBullet());
        System.out.println("---");

    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {

    }

    @Override
    public void onBulletHit(BulletHitEvent event) {

    }

    @Override
    public void run() {

        this.setRadarColor(Color.GRAY);
        this.setBodyColor(new Color(114, 160, 255));
        this.setGunColor(new Color(254, 64, 216));
        this.setBulletColor(new Color(220, 244, 255));
        //角に移動する
        turnLeft(getGunHeading());
        ahead((getBattleFieldHeight() - 18) - getY());
        turnLeft(90);
        ahead(getX() - (getBattleFieldWidth() - 18));
        turnGunLeft(90);

        while (true) {
            System.out.println((int) (getY()));
            System.out.println((int) ((getBattleFieldHeight() - 18)));
            ahead(getBattleFieldWidth() - 18);
            back(getBattleFieldWidth() - 18);

            //端へ行けなかった場合もう一度
            if ((int) (getY()) < (int) ((getBattleFieldHeight() - 18))) {

                System.out.println("端へ行けなかった");
                idou((int)getBattleFieldHeight()/2, (int)getBattleFieldWidth()/2);
                turnLeft(getGunHeading());
                ahead((getBattleFieldHeight() - 18) - getY());
                ahead(getX() - (getBattleFieldWidth() - 18));
                turnGunRight(180);

            }
        }

    }

    @Override
    public void onWin(WinEvent event) {
        setGunColor(Color.WHITE);
        idou(100, 500);
    }

    public void idou(int x, int y) {
        turnLeft(getGunHeading());
        ahead(y - getY());
        turnLeft(90);
        ahead(getX() - x);

    }

}
