package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Modules.Robot;

@TeleOp(name="testDrive", group="Linear OpMode")
public class testDrive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        Robot robot = new Robot(hardwareMap, telemetry);

        while(opModeIsActive()) {
            robot.driveTrain.dual_motor_drive(gamepad1.left_stick_y, gamepad1.right_stick_x);

            if (gamepad1.xWasPressed()) {
                robot.spinnyThing.toggle_spin();
            }
        }
    }
}
