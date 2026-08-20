package org.firstinspires.ftc.teamcode.Modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SpinnyThing {
    // motor
    DcMotor motor;

    // spin flag
    private boolean spin_flag = false;

    SpinnyThing(HardwareMap hwMap, Telemetry telemetry) {
        motor = hwMap.get(DcMotor.class, "blades");
    }

   public void toggle_spin() {
        spin_flag = !spin_flag;
        if (spin_flag) {
            motor.setPower(1);
       } else {
            motor.setPower(0);
        }
    }

   public boolean get_toggle() {
        return spin_flag;
   }
}
