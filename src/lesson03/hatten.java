/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson03;

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
import robocode.*;

/**
 *
 * @author merarli
 */
public class hatten extends Robot {

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
//        this.setScanColor(Color.YELLOW);
//        System.out.println("敵の角度" + event.getBearing());
//        System.out.println("敵までの距離" + event.getDistance());
//        System.out.println("敵のエネルギー" + event.getEnergy());
//        System.out.println("敵の向き" + event.getHeading());
        System.out.println("敵の名前" + event.getName());
//        System.out.println("敵の速度" + event.getVelocity());
//        System.out.println("---");

          if(event.getName().equals("sample.SittingDuck")){
              fire(3);
          }
          
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
        System.out.println("たまの飛んできた方向"+event.getHeading());
        turnRight(event.getHeading()-getHeading()-180);
        turnRight(90);
        System.out.println("実機のボディ方向"+getHeading());
        System.out.println("---");

    }

    @Override
    public void onBulletMissed(BulletMissedEvent event) {

    }

    @Override
    public void onBulletHit(BulletHitEvent event) {
        System.out.println("敵にたまが命中しました！");
        System.out.println("敵の名前" + event.getName());
        System.out.println("敵のエネルギー" + event.getEnergy());
        System.out.println("---");
    }

    @Override
    public void run() {
//        this.setBodyColor(new Color(114, 160, 255));
//        this.setGunColor(new Color(254, 64, 216));
//        this.setBulletColor(new Color(220, 244, 255));
//        idou(100, 100);
//        while (true) {
//            this.setScanColor(new Color(105, (int)(Math.random()*255), (int)(Math.random()*255)));
//            turnGunRight(360);
            
//        }

    }

    @Override
    public void onWin(WinEvent event) {
        setGunColor(Color.WHITE);
        idou(500, 500);
    }

    public void idou(int x, int y) {
        turnLeft(getGunHeading());
        ahead(y - getY());
        turnLeft(90);
        ahead(getX() - x);
    }

}
