package com.team9889.ftc2020;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by MannoMation on 12/14/2018.
 */
public class DriverStation {
    boolean gamepad2Lift = false;

    private Gamepad gamepad1;
    private Gamepad gamepad2;

    public DriverStation(Gamepad gamepad1, Gamepad gamepad2){
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
    }

    double getX(){
        return gamepad1.left_stick_x;
    }

    double getY() {
        return -gamepad1.left_stick_y;
    }

    double getSteer(){
        return gamepad1.right_stick_x;
    }



/*          Toggle Code Example
    private boolean toggle = true;
    public boolean active = false;
    boolean getActive() {
        if (gamepad1.a && toggle) {
            active = !active;
            toggle = false;
        } else if (!gamepad1.a)
            toggle = true;

        return active;
    }
*/

}
