/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preset;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 *
 * @author merarli
 */
public class pri extends Robot {

    public static void idou(int x, int y) {
        System.out.println("aaa");
        
        idou_(x,y);
    }
    
      public static void main(int x,int y){

    }
    }
void idou_(int x,int y){
        turnLeft(getGunHeading());
        ahead(y-getY());
        turnLeft(90);
        ahead(getX()-x);
    }
    
}
