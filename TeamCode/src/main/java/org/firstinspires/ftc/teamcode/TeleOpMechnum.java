package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import java.lang.*;

//11248 //Cougars Property >:D

@TeleOp(name = "TeleOpMechnum", group = "LinearOpMode")

public class TeleOpMechnum extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFront, rightFront, leftRear, rightRear, intakeMotor1, intakeMotor2;
    //right trigger up
    //left trigger down



    @Override
    public void runOpMode() {


        telemetry.addData("init","init");
        telemetry.update();

        //wheel motors hardware mapping
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftFront.setDirection(DcMotor.Direction.FORWARD);









        
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftRear = hardwareMap.get(DcMotor.class, "leftRear");
        rightRear = hardwareMap.get(DcMotor.class, "rightRear");
        leftRear.setDirection(DcMotor.Direction.FORWARD);
        rightRear.setDirection(DcMotor.Direction.REVERSE);

        //Intake hardware mapping
        intakeMotor1 = hardwareMap.get(DcMotor.class, "intakeMotor1");
        intakeMotor2 = hardwareMap.get(DcMotor.class, "intakeMotor2");
        intakeMotor1.setDirection(DcMotor.Direction.REVERSE);
        intakeMotor2.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        telemetry.addData("init","init");
        telemetry.update();

        while (opModeIsActive()){
            //turn using gamepad 1 bumpers.
            if (gamepad1.right_bumper) {
                leftFront.setPower(.8);
                rightFront.setPower(-.8);
                leftRear.setPower(.8);
                rightRear.setPower(-.8);
            } else if (gamepad1.left_bumper) {
                leftFront.setPower(-.8);
                rightFront.setPower(.8);
                leftRear.setPower(-.8);
                rightRear.setPower(.8);


                //strafe using gamepad 1 triggers.
            } else if (gamepad1.right_trigger != 0) {
                leftFront.setPower(1);
                rightFront.setPower(-1);
                leftRear.setPower(-1);
                rightRear.setPower(1);
            } else if (gamepad1.left_trigger != 0) {
                leftFront.setPower(-1);
                rightFront.setPower(1);
                leftRear.setPower(1);
                rightRear.setPower(-1);

            } else {
                //gamepad 1 lift joystick up and down = drive foward backward
                leftFront.setPower(gamepad1.left_stick_y);
                rightFront.setPower(gamepad1.left_stick_y);
                leftRear.setPower(gamepad1.left_stick_y);
                rightRear.setPower(gamepad1.left_stick_y);
                //gamepad 1 right joystick left and right = turn
                leftFront.setPower(-gamepad1.right_stick_x);
                leftRear.setPower(-gamepad1.right_stick_x);
                rightFront.setPower(-gamepad1.right_stick_x);
                rightRear.setPower(gamepad1.right_stick_x);

            //intake system is controlled here
                if(gamepad2.right_trigger !=0)
                {
                    intakeMotor1.setPower(1);
                    intakeMotor2.setPower(1);
                }


            }








        }
    }}

