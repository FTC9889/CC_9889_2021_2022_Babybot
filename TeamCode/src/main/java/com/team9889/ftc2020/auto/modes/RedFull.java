package com.team9889.ftc2020.auto.modes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.team9889.ftc2020.auto.AutoModeBase;
import com.team9889.ftc2020.auto.actions.utl.RobotUpdate;

/**
 * Created by Eric on 11/23/2021.
 */

@Autonomous
public class RedFull extends AutoModeBase {
    Trajectory traj;

    @Override
    public void run(StartPosition startPosition, Boxes box) {
        Robot.rr.getLocalizer().setPoseEstimate(new Pose2d(-33, -65, Math.toRadians(90)));

        ThreadAction(new RobotUpdate(telemetry));
    }

    @Override
    public StartPosition side() {
        return null;
    }
}
