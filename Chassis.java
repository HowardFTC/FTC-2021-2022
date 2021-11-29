/**
 * Controls
 * ----------------------------------------------------------
 * Tank drive with joy sticks
 * Triggers for side movement
 * D pad for diagonal movement (rotate 45 degrees clockwise
 * ----------------------------------------------------------
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode; //imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp; //Imports the code for
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Chassis extends LinearOpMode {
    //creates a var for the motors
    private DcMotor dcMotorTL; //top left
    private DcMotor dcMotorBL; //top right
    private DcMotor dcMotorTR; //bottom left
    private DcMotor dcMotorBR; //bottom right

    @Override
    public void runOpMode() {
        // mapping for expansion hub (names port for what will be inputted)
        dcMotorTL = hardwareMap.get(DcMotor.class, "dcMotorTL");
        dcMotorBL = hardwareMap.get(DcMotor.class, "dcMotorBL");
        dcMotorTR = hardwareMap.get(DcMotor.class, "dcMotorTR");
        dcMotorBR = hardwareMap.get(DcMotor.class, "dcMotorBR");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // runs until driver hits stop
        while (opModeIsActive()) {

            // checks if pressure greater than 0, returns double corresponding to pressure on trigger (value between 0 and 1)
            if (this.gamepad1.right_trigger > 0) {
                dcMotorTL.setPower(-this.gamepad1.right_trigger);
                dcMotorBL.setPower(this.gamepad1.right_trigger);
                dcMotorTR.setPower(-this.gamepad1.right_trigger);
                dcMotorBR.setPower(this.gamepad1.right_trigger);
            }

            if (this.gamepad1.left_trigger > 0) {
                dcMotorTL.setPower(-this.gamepad1.left_trigger);
                dcMotorBL.setPower(this.gamepad1.left_trigger);
                dcMotorTR.setPower(-this.gamepad1.left_trigger);
                dcMotorBR.setPower(this.gamepad1.left_trigger);
            }

            //DIAGONAL MOVEMENT (D-PAD) controls (unfinished)
            //Make sure to check which numbers are supposed to be negative or positive.

            if (gamepad1.dpad_up) { //diagonal TR
                dcMotorTL.setPower(1);
                dcMotorBR.setPower(1);
                dcMotorTR.setPower(0);
                dcMotorBL.setPower(0);

            }
            if (gamepad1.dpad_right) { //diagonal BR
                dcMotorTR.setPower(1);
                dcMotorBL.setPower(1);
                dcMotorTL.setPower(0);
                dcMotorBR.setPower(0);

            }
            if (gamepad1.dpad_down) { //diagonal BL
                dcMotorTL.setPower(-1);
                dcMotorBR.setPower(-1);
                dcMotorTR.setPower(0);
                dcMotorBL.setPower(0);

            }
            if (gamepad1.dpad_left) { //diagonal TL
                dcMotorTR.setPower(-1);
                dcMotorBL.setPower(-1);
                dcMotorTL.setPower(0);
                dcMotorBR.setPower(0);

            }

            dcMotorTL.setPower(-this.gamepad1.left_stick_y); //-1 to 1 //chassis top left
            dcMotorBL.setPower(-this.gamepad1.left_stick_y); // chassis bottom left
            dcMotorTR.setPower(-this.gamepad1.right_stick_y);  // chassis top right
            dcMotorBR.setPower(-this.gamepad1.right_stick_y); // chassis bottom right

            dcMotorTL.setPower(-this.gamepad1.left_stick_x);
            dcMotorBL.setPower(this.gamepad1.left_stick_x);
            dcMotorTR.setPower(this.gamepad1.left_stick_x);
            dcMotorBR.setPower(-this.gamepad1.left_stick_x);

            //telemetry update the variable values
            telemetry.addData("Status", "Running");
            telemetry.addData("dcMotorTL", dcMotorTL.getPower());
            telemetry.addData("dcMotorBL", dcMotorBL.getPower());
            telemetry.addData("dcMotorTR", dcMotorTR.getPower());
            telemetry.addData("dcMotorBR", dcMotorBR.getPower());
            telemetry.update();
        }
    }
}
