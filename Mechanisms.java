package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //Imports the code for
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Mechanisms extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor flyWheelMotor;
        Servo clawMotor;

        flyWheelMotor = hardwareMap.get(DcMotor.class, "flyWheelMotor");
        clawMotor = hardwareMap.get(Servo.class, "clawMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                if (flyWheelMotor.getPower() == 0) {
                    flyWheelMotor.setPower(1);
                } else {
                    flyWheelMotor.setPower(0);
                }

                if (gamepad1.left_bumper) {
                    clawMotor.setPosition(360);
                } else if (gamepad1.right_bumper) {
                    clawMotor.setPosition(0);
                }

                telemetry.addData("Status", "Running");
                telemetry.addData("clawMotor", clawMotor.getPosition());
                telemetry.addData("flyWheelMotor", flyWheelMotor.getPower());
                telemetry.update();
            }
        }
    }
}
