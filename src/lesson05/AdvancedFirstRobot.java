/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson05;

import robocode.AdvancedRobot;
import robocode.MoveCompleteCondition;
import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;
import robocode.util.Utils;

/**
 *
 * @author merarli
 */
public class AdvancedFirstRobot extends AdvancedRobot {

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        fire(3);
    }

    @Override
    public void run() {
        //90度の方向を向くために、現在の時期方向から右方向に何度か移転するか
        double turnRightAmount = 90 - getHeading();

        //90度の方向を向く
        turnRight(Utils.normalRelativeAngleDegrees(turnRightAmount));

        //フィールド幅の中心までの横方向に進む
        ahead(getBattleFieldWidth() / 2.0 - getX());

        //90度左回転する(0度を向く)
        turnLeft(90);

        //フィールドの高さの中心まで縦方向に進む
        ahead(getBattleFieldHeight() / 2.0 - getY());

        //以降でノンブロッキングメソッドを実行する
//        setAhead(1250);
//        setTurnRight(90);
//        waitFor(new TurnCompleteCondition(this));
//        setTurnGunRight(720);
//        setTurnRight(90);
//        execute();

//            setAhead(200);
//            setTurnGunRight(90);
//            waitFor(new MoveCompleteCondition(this));
//            setBack(200);
//            setTurnGunRight(360);
//            waitFor(new MoveCompleteCondition(this));
//            execute();

//        setAdjustGunForRobotTurn(true);
//        while(true){
//            setAhead(2000);
//            setTurnRight(360);
//            setMaxVelocity((int)(Math.random()*5));
//            waitFor(new TurnCompleteCondition(this));
//            
//        }
        while (true) {
            
            setTurnGunLeft(2000);
            setMaxVelocity(8);
            setAhead(200);
            waitFor(new MoveCompleteCondition(this));
            setMaxVelocity(1);
            setBack(200);
            waitFor(new MoveCompleteCondition(this));
            execute();
            

        }
    }

}
