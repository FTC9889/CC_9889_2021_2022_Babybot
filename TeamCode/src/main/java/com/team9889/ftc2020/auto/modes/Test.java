package com.team9889.ftc2020.auto.modes;

import android.util.Log;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.team9889.ftc2020.auto.AutoModeBase;
import com.team9889.ftc2020.auto.actions.utl.RobotUpdate;
import com.team9889.ftc2020.auto.actions.utl.Wait;

/**
 * Created by Eric on 11/13/2021.
 */

@Autonomous
public class Test extends AutoModeBase {
    @Override
    public void run(StartPosition startPosition, Boxes box) {
        ThreadAction(new RobotUpdate(telemetry));

        Robot.rr.followTrajectory(
                Robot.rr.trajectoryBuilder(new Pose2d())
                        .splineTo(new Vector2d(36, 36), Math.toRadians(0))

                        .addDisplacementMarker(20, () -> {
                            Log.i("Hello", "");
                        })

                        .addDisplacementMarker(55, () -> {
                        })
                        .splineTo(new Vector2d(72, 0), Math.toRadians(0))
                        .build()
        );

        runAction(new Wait(2000));
    }

    @Override
    public StartPosition side() {
        return null;
    }
}
