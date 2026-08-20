package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.opencv.core.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration names <br>
 * pollen_bot -> current configuration
 */
public class Robot {
    Telemetry telemetry;
    public DriveTrain driveTrain;
    public SpinnyThing spinnyThing;

    public Robot(HardwareMap hwMap, Telemetry telemetry) {
        driveTrain = new DriveTrain(hwMap, telemetry);
        spinnyThing = new SpinnyThing(hwMap, telemetry);
        this.telemetry = telemetry;
    }

}