package com.team9889.ftc2020.subsystems;

import android.util.Log;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.RobotLog;
import com.team9889.ftc2020.Constants;
import com.team9889.ftc2020.DriverStation;
import com.team9889.ftc2020.auto.actions.ActionVariables;
import com.team9889.lib.hardware.Motor;
import com.team9889.lib.hardware.RevIMU;
import com.team9889.lib.roadrunner.drive.SampleMecanumDrive;
import com.team9889.lib.roadrunner.drive.StandardTrackingWheelLocalizer;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.openftc.revextensions2.ExpansionHubEx;
import org.openftc.revextensions2.RevBulkData;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by Eric on 7/26/2019.
 */

public class Robot {
    public Motor fLDrive, fRDrive, bLDrive, bRDrive;
    public RevIMU imu = null;

    public RevBulkData bulkDataMaster, bulkDataSlave;
    public ExpansionHubEx revHubMaster, revHubSlave;

    public HardwareMap hardwareMap;

    public ActionVariables actionVariables = new ActionVariables();

    public boolean isRed = true;

    ElapsedTime robotTimer = new ElapsedTime();

    private static Robot mInstance = null;

    public static Robot getInstance() {
        if (mInstance == null)
            mInstance = new Robot();

        return mInstance;
    }

    private MecanumDrive mMecanumDrive = new MecanumDrive();

    public SampleMecanumDrive rr;
    public StandardTrackingWheelLocalizer localizer;

    public DriverStation driverStation = new DriverStation(null, null);

    public boolean blue = false;

    // List of subsystems
    private List<Subsystem> subsystems = Arrays.asList(mMecanumDrive);

    public void init(HardwareMap hardwareMap, boolean auto){
        this.hardwareMap = hardwareMap;

        Date currentData = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.M.yyyy hh:mm:ss");

        RobotLog.a("Robot Init Started at " + format.format(currentData));

        //Rev Hubs
        revHubMaster = hardwareMap.get(ExpansionHubEx.class, Constants.kRevHubMaster);
        revHubSlave = hardwareMap.get(ExpansionHubEx.class, Constants.kRevHubSlave);

        //Drive
        fLDrive = new Motor(hardwareMap, Constants.DriveConstants.kLeftDriveMasterId, 1,
                DcMotorSimple.Direction.FORWARD, true, false, true);
        bLDrive = new Motor(hardwareMap, Constants.DriveConstants.kLeftDriveSlaveId, 1,
                DcMotorSimple.Direction.FORWARD, true, false, true);
        fRDrive = new Motor(hardwareMap, Constants.DriveConstants.kRightDriveMasterId, 1,
                DcMotorSimple.Direction.REVERSE, true, false, true);
        bRDrive = new Motor(hardwareMap, Constants.DriveConstants.kRightDriveSlaveId, 1,
                DcMotorSimple.Direction.REVERSE, true, false, true);

        imu = new RevIMU("imu", hardwareMap);

        // Init all subsystems
        for (Subsystem subsystem : subsystems) {
            subsystem.init(auto);
        }

        rr = new SampleMecanumDrive(hardwareMap);

        robotTimer.reset();
    }

    // Update data from Hubs and Apply new data
    public void update() {
        Log.i("Update", "");

        // Update Bulk Data
        try {
            bulkDataMaster = revHubMaster.getBulkInputData();
            bulkDataSlave = revHubSlave.getBulkInputData();

            // Update Motors
            fRDrive.update(bulkDataMaster);
            fLDrive.update(bulkDataMaster);
            bRDrive.update(bulkDataMaster);
            bLDrive.update(bulkDataMaster);

            // Update Subsystems
            for (Subsystem subsystem : subsystems)
                subsystem.update();
        } catch (Exception e){
            Log.v("Exception@robot.update", "" + e);
        }

    }

    // Output Telemetry for all subsystems
    public void outputToTelemetry(Telemetry telemetry) {
        for (Subsystem subsystem : subsystems)
            subsystem.outputToTelemetry(telemetry);
    }

    // Stop all subsystems
    public void stop(){
        for (Subsystem subsystem : subsystems)
            subsystem.stop();
    }

    public MecanumDrive getMecanumDrive(){
        return mMecanumDrive;
    }
}
