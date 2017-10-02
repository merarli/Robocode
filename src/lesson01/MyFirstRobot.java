/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson01;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
/**
 *
 * @author merarli
 */
public class MyFirstRobot extends Robot{

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        super.onScannedRobot(event); //To change body of generated methods, choose Tools | Templates.
        fire(1);
        
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        super.onHitWall(event); //To change body of generated methods, choose Tools | Templates.
        back(20);
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        super.onHitByBullet(event); //To change body of generated methods, choose Tools | Templates.
        back(10);
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        ahead(100);
        turnGunRight(360);
        back(100);
        turnGunLeft(360);
    }
    
}
