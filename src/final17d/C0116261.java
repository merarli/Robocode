/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final17d;

import com.sun.webkit.WebPage;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import robocode.AdvancedRobot;
import robocode.MoveCompleteCondition;
import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;
import robocode.util.Utils;

/**
 *
 * @author merarli
 */
public class C0116261 extends AdvancedRobot {

    public int count = 0;
    boolean peek; // Don't turn if there's a robot there
    double moveAmount; // How much to move
    double bgS = 0;
    double rbS = 0;
    double hMax = 0;
    double wMax = 0;
    boolean turn = false;

    @Override
    public void run() {

        System.out.println("ボーダーガードサイズは：　" + getSentryBorderSize());
        bgS = getSentryBorderSize();
        rbS = 18;
        hMax = getBattleFieldHeight() - bgS - rbS;
        wMax = getBattleFieldWidth() - bgS - rbS;

        System.out.println("hMax :" + hMax + ", wMax :" + wMax);

        while (true) {

            idou(wMax, hMax);
            idou(wMax, getBattleFieldHeight() - hMax);
            idou(getBattleFieldWidth() - wMax, getBattleFieldHeight() - hMax);
            idou(getBattleFieldWidth() - wMax, hMax);

        }

    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        //fireの距離レベル設定
        double distanceLevel1 = 100;
        double distanceLevel2 = 200;
        double distanceLevel3 = 300;
        double distanceLevel4 = 400;
        
        String name = event.getName();
        System.out.println(event.getName());

        if (name.contains("BorderGuard")) {
            System.out.println("やつはボーダー");
        } else {

            if (event.getDistance() <= distanceLevel1) {
                System.out.println("敵までの距離Level1");
                fire(4);
            } else if (event.getDistance() <= distanceLevel2) {
                System.out.println("敵までの距離Level2");
                fire(3);
            } else if (event.getDistance() <= distanceLevel3) {
                System.out.println("敵までの距離Level3");
                fire(2);
            } else if (event.getDistance() <= distanceLevel4) {
                System.out.println("敵までの距離Level4");
                fire(1);
            }

            setScanColor(Color.yellow);

        }

    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    public void idou(double x, double y) {

        if (turn == false) {
            turnLeft(getHeading());
            turn = true;
        }

        if (turn == true) {
            setAhead(y - getY());
            setTurnGunLeft(360 * 3);
            waitFor(new MoveCompleteCondition(this));
//            waitFor(new TurnCompleteCondition(this));
            turn = false;
        }

        if (turn == false) {
            turnLeft(90);
            turn = true;
        }

        if (turn == true) {
            setAhead(getX() - x);
            setTurnGunLeft(360 * 3);
            waitFor(new MoveCompleteCondition(this));
//            waitFor(new TurnCompleteCondition(this));
            turn = false;
        }

        execute();

    }

}
