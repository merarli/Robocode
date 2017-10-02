/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson02;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 *
 * @author merarli
 */
public class KadaiRobot02 extends Robot {

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
//        super.onScannedRobot(event); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void run() {
//        super.run(); //To change body of generated methods, choose Tools | Templates.
//        while (true) {
        System.out.println("X座標:" + getX());
        System.out.println("Y座標:" + getY());
        System.out.println("ロボットの方向:" + getHeading());
        System.out.println("速度:" + getVelocity());
        System.out.println("ロボットの高さ:" + getHeight());
        System.out.println("ロボットの幅:" + getWidth());
        System.out.println("Gunの向き:" + getGunHeading());
        System.out.println("Readerの向き:" + getRadarHeading());
        System.out.println("ロボットのエネルギー量:" + getEnergy());
        System.out.println("フィールドの大きさ:" + getBattleFieldHeight() + "*" + getBattleFieldWidth());
        System.out.println("敵のロボット人数:" + getOthers());

        turnLeft(getGunHeading());
        ahead((getBattleFieldHeight())*0.75-getY());
        turnLeft(90);
        ahead(getX()-(getBattleFieldWidth()*0.75));

        while (true) {
            ahead(getBattleFieldWidth() * 0.50);
            turnLeft(90);
            ahead(getBattleFieldHeight() * 0.50);
            turnLeft(90);
        }
//        ahead(getBattleFieldHeight() * 0.25);
//        turnRight(90);
//        ahead(getBattleFieldHeight() * 0.25);
//        turnRight(90);
//        }
    }

}
