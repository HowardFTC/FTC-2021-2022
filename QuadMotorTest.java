//Make a single motor run
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //Imports the code for
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class QuadMotorTest extends LinearOpMode {
    private DcMotor dcMotor1; //creates a var for the motors
    private DcMotor dcMotor2;
    private DcMotor dcMotor3;
    private DcMotor dcMotor4;

    @Override
    public void runOpMode(){
        dcMotor1 = hardwareMap.get(DcMotor.class, "dcMotor1");
        dcMotor2 = hardwareMap.get(DcMotor.class, "dcMotor2");
        dcMotor3 = hardwareMap.get(DcMotor.class, "dcMotor3");
        dcMotor4 = hardwareMap.get(DcMotor.class, "dcMotor4");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            dcMotor1.setPower(-this.gamepad1.right_stick_y);
            dcMotor2.setPower(-this.gamepad1.left_stick_y);
            dcMotor3.setPower(-this.gamepad1.right_stick_x);
            dcMotor4.setPower(-this.gamepad1.left_stick_x);

            //telemetry update the variable values
            telemetry.addData("Status", "Running");
            telemetry.addData("dcMotor1", dcMotor1.getPower());
            telemetry.addData("dcMotor2", dcMotor2.getPower());
            telemetry.addData("dcMotor3", dcMotor3.getPower());
            telemetry.addData("dcMotor4", dcMotor4.getPower());
            telemetry.update();
        }
    }
}