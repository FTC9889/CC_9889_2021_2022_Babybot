package com.team9889.ftc2020;

import android.graphics.Color;

import com.acmerobotics.roadrunner.geometry.Pose2d;

/**
 * Class to store constants
 * Created by joshua9889 on 4/10/2017.
 */

public class Constants {
    public final static String kRevHubMaster = "C";
    public final static String kRevHubSlave = "E";

    public static int side = Color.RED;
    public static Pose2d pose;

    /*---------------------
    |                     |
    |     Drivetrain!     |
    |                     |
    ---------------------*/

    //Settings for Drive class
    public static class DriveConstants {
        public final static String kLeftDriveMasterId = "lf";
        public final static String kRightDriveMasterId = "rf";
        public final static String kLeftDriveSlaveId = "lb";
        public final static String kRightDriveSlaveId = "rb";

        public final static double WheelbaseWidth = 14.5;
        public final static double WheelDiameter = 3.77953;
    }
}
