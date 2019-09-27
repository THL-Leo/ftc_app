package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp( name = "Driver Control", group = "Linear Opmode" )
public class Teleop extends Hardware
{

    //This op mode is the "driving" op mode in which people control the robot with controllers
    /*
    Controls:
       TODO: Write in all of the new controls
    */
    boolean lowered = false, pressed = false;
    @Override
    public void runOpMode() throws InterruptedException {
        init(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.left_stick_y > .2 || gamepad1.left_stick_y < -.2)
                drive(-gamepad1.left_stick_y);
            else if (gamepad1.right_stick_x > .2 || gamepad1.right_stick_x < -.2)
                turn(gamepad1.right_stick_x);
            else
                stopDrivetrain();

            if (gamepad1.dpad_right) {
                strafe(.6f);
            } else if (gamepad1.dpad_left) {
                strafe(-.6f);
            } else {
                strafe(0f);
            }

        }
    }
}
