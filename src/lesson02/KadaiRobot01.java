/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson02;

import robocode.Robot;
import robocode.ScannedRobotEvent;
import preset.pri;

/**
 *
 * @author merarli
 */
public class KadaiRobot01 extends Robot {

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
        ahead((getBattleFieldHeight()-18)/2-getY());
        turnLeft(90);
        ahead(getX()-(getBattleFieldWidth()-18)/2);
        
        preset.pri.idou(18, 18);
        

    }
    
//    public void idou(int x,int y){
//        turnLeft(getGunHeading());
//        ahead(y-getY());
//        turnLeft(90);
//        ahead(getX()-x);
//    }

}
