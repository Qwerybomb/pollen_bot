package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Disabled
public class DriveTrain {
    DcMotor leftDrive, rightDrive;
    long start = System.nanoTime();
    private IMU imu = null;
    private ElapsedTime runtime;

    Telemetry telemetry;

    // variables for encoders and IMU
    static final double COUNTS_PER_MOTOR_REV = 537.6;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // No External Gearing.
    static final double WHEEL_DIAMETER_INCHES = 3.5;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);

    // All subsystems should have a hardware function that labels all of the hardware required of it.
    public DriveTrain(HardwareMap hwMap, Telemetry telemetry) {
        // Initializes motor names
        leftDrive = hwMap.get(DcMotor.class, "left");
        rightDrive = hwMap.get(DcMotor.class, "right");

        // Initializes motor directions:
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // float when motor has no power.
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        this.telemetry = telemetry;

        runtime = new ElapsedTime();
        runtime.reset();
    }

    public void dual_motor_drive(double axial, double yaw) {
        leftDrive.setPower(axial - yaw);
        rightDrive.setPower(axial + yaw);
    }
}