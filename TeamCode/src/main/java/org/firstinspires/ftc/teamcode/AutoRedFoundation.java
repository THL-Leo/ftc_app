package org.firstinspires.ftc.teamcode;
import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "RedFoundation")
public class AutoRedFoundation extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);
        waitForStart();
        MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.star_wars);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //1 second = 2 circumference;
        //time to travel = inches / 2 circumference;
//        sleep(5000);
//        drive(-1); //forward
//        timer(1000);
//        sleep(500);
//        turn(-.8); //right turn
//        timer(400);
//        sleep(500);

        mediaPlayer.start();

        strafe(-0.8); //left
        timer(600);
        strafe(0);

        drive(.3); //backup
        timer(1700);
        drive(0);

        dragL.setPosition(.4);
        dragR.setPosition(.61);
        timer(1200);
        dragL.setPosition(.5);
        dragR.setPosition(.5);


        drive(-.6); //go forward after hooking onto the foundation
        timer(1400);
        drive(0);

        dragL.setPosition(.6);
        dragR.setPosition(.39);
        timer(1000);
        dragR.setPosition(.5);
        dragL.setPosition(.5);


        strafe(.8);
        timer(1250); //1500 will get the robot under the bridge
        strafe(0);

        drive(.6);
        timer(1200);
        drive(0);

        strafe(-.8);
        timer(1500);
        strafe(0);

        drive(-.2);
        timer(4000);
        drive(0);

        strafe(.8);
        timer(1375);
        strafe(0);

        mediaPlayer.pause();
    }
}
