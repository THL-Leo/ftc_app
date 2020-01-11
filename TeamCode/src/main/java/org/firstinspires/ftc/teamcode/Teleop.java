package org.firstinspires.ftc.teamcode;

// 60 motor = 420 ticks per revolution

import com.qualcomm.robotcore.eventloop.opmode.*;

@TeleOp( name = "Driver Control", group = "Linear Opmode" )
public class Teleop extends Hardware
{

    //This op mode is the "driving" op mode in which people control the robot with controllers
    /*
    Controls:
    */
    boolean lowered = false, pressed = false;
    @Override
    public void runOpMode() throws InterruptedException {
        init(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.left_stick_y > .2 || gamepad1.left_stick_y < -.2){
                drive((gamepad1.left_stick_y > 0.8 ? 0.8 : gamepad1.left_stick_y));
            }
            else if (gamepad1.right_stick_x > .2)
                turn(-0.8);
            else if(gamepad1.right_stick_x < -.2)
                turn(0.8);
            else
                stopDrivetrain();

            if (gamepad1.dpad_right) {
                strafe(-.8);
            } else if (gamepad1.dpad_left) {
                strafe(.8);
            } else {
                strafe(0);
            }

            if(gamepad1.right_bumper){
                extendArm(0.6);
            } else if(gamepad1.left_bumper){
                extendArm(-0.6);
            } else{
                extendArm(0);
            }

            if(gamepad1.right_trigger > 0 && gamepad1.right_trigger < 1.1){
                moveClaw(0.6);
            }
            else if(gamepad1.left_trigger > 0 && gamepad1.left_trigger < 1.1){
                moveClaw(-0.6);
            }
            else
                moveClaw(0);

            if(gamepad1.b){
                dragL.setPosition(.4);
                dragR.setPosition(.61);
            } else if(gamepad1.x){
                dragL.setPosition(.6);
                dragR.setPosition(.39);
            }
            else{
                dragR.setPosition(.5);
                dragL.setPosition(.5);
            }

            if(gamepad1.y){
                pullUp(-.8);
            } else if(gamepad1.x){
                pullUp(.6);
            } else
                pullUp(0);

        }
    }
}
