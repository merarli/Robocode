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
import robocode.WinEvent;
import robocode.util.Utils;

/**
 *
 * @author merarli
 */
public class C0116261 extends AdvancedRobot {

    public int count = 0;
    double bgS = 0;
    double rbS = 0;
    double hMax = 0;
    double wMax = 0;
    boolean turn = false;

    @Override
    public void run() {

        this.setRadarColor(Color.GRAY);
        this.setBodyColor(new Color(114, 160, 255));
        this.setGunColor(new Color(254, 64, 216));
        this.setBulletColor(new Color(220, 244, 255));

//        nanoru();

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
            
            //もしロボットの残り数が１になったら名乗るモードにはいる
            if(getOthers()==1){
                break;
            }

        }
        
        nanoru();
        
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
            setTurnGunLeft(getBattleFieldWidth() * 1.7);
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
            setTurnGunLeft(getBattleFieldHeight() * 1.7);
            waitFor(new MoveCompleteCondition(this));
//            waitFor(new TurnCompleteCondition(this));
            turn = false;
        }

        execute();

    }

    @Override
    public void onWin(WinEvent event) {
        setGunColor(Color.WHITE);
        idou(100, 500);
    }

    public void nanoru() {
        //mを描く
        idou(getBattleFieldWidth() / 4, getBattleFieldHeight() / 2);
        idou(getBattleFieldWidth() / 4, getBattleFieldHeight() / 2 + 100);
        idou(getBattleFieldWidth() / 4 + 25, getBattleFieldHeight() / 2 + 100);
        idou(getBattleFieldWidth() / 4 + 25, getBattleFieldHeight() / 2 + 0);
        idou(getBattleFieldWidth() / 4 + 50, getBattleFieldHeight() / 2 + 0);
        idou(getBattleFieldWidth() / 4 + 50, getBattleFieldHeight() / 2 + 100);
        idou(getBattleFieldWidth() / 4 + 75, getBattleFieldHeight() / 2 + 100);
        idou(getBattleFieldWidth() / 4 + 75, getBattleFieldHeight() / 2 + 0);
        //mを描く

        //eを描く
        idou(getBattleFieldWidth() / 4 + 100, getBattleFieldHeight() / 2 + 0);
        idou(getBattleFieldWidth() / 4 + 100, getBattleFieldHeight() / 2 + 50);
        idou(getBattleFieldWidth() / 4 + 75, getBattleFieldHeight() / 2 + 50);
        idou(getBattleFieldWidth() / 4 + 75, getBattleFieldHeight() / 2 - 100);
        idou(getBattleFieldWidth() / 4 + 125, getBattleFieldHeight() / 2 + -100);
        //eを描く
        
        //rを描く
        idou(getBattleFieldWidth() / 4 + 125, getBattleFieldHeight() / 2 + 100);
        idou(getBattleFieldWidth() / 4 + 175, getBattleFieldHeight() / 2 + 100);
        //rを描く
        
        //aを描く
        idou(getBattleFieldWidth() / 4 + 175, getBattleFieldHeight() / 2 + -100);
        idou(getBattleFieldWidth() / 4 + 225, getBattleFieldHeight() / 2 + -100);
        idou(getBattleFieldWidth() / 4 + 225, getBattleFieldHeight() / 2 + 50);
        idou(getBattleFieldWidth() / 4 + 175, getBattleFieldHeight() / 2 + 50);
        idou(getBattleFieldWidth() / 4 + 175, getBattleFieldHeight() / 2 - 100);
        idou(getBattleFieldWidth() / 4 + 250, getBattleFieldHeight() / 2 + -100);
        //aを描く
    }

}
