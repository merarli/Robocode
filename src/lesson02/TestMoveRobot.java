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
public class TestMoveRobot extends Robot {

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
//        super.onScannedRobot(event); //To change body of generated methods, choose Tools | Templates.
        System.out.println("FOUND ENEMY!");
        fire(1);
    }

    @Override
    public void run() {
//        super.run(); //To change body of generated methods, choose Tools | Templates.

        while (true) {
            turnGunRight(360);
        }

    }

}
