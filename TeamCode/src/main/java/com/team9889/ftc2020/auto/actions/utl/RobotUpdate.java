package com.team9889.ftc2020.auto.actions.utl;

import com.team9889.ftc2020.auto.actions.Action;
import com.team9889.ftc2020.subsystems.Robot;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Eric on 12/13/2019.
 */
public class RobotUpdate extends Action {
    Telemetry telemetry;

    public RobotUpdate(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {
        Robot.getInstance().update();
        Robot.getInstance().outputToTelemetry(telemetry);
        telemetry.update();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void done() {}
}
