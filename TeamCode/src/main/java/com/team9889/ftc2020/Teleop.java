package com.team9889.ftc2020;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by MannoMation on 1/14/2019.
 */

@Config
@TeleOp
public class Teleop extends Team9889Linear {
    @Override
    public void runOpMode() {
        DriverStation driverStation = new DriverStation(gamepad1, gamepad2);
        Robot.driverStation = driverStation;

        waitForStart(false);

        while (opModeIsActive()) {
            /* Mecanum Drive */
            Robot.getMecanumDrive().xSpeed += driverStation.getX();
            Robot.getMecanumDrive().ySpeed += driverStation.getY();
            Robot.getMecanumDrive().turnSpeed += driverStation.getSteer();


            /* Telemetry */
            Robot.outputToTelemetry(telemetry);
            telemetry.update();

            Robot.update();
        }
    }
}
