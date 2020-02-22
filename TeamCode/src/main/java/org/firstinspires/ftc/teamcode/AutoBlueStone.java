package org.firstinspires.ftc.teamcode;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.Date;

@Autonomous(name = "BlueStone")
public class AutoBlueStone extends Hardware {

    public void runOpMode() throws InterruptedException {
        init(hardwareMap);
        waitForStart();
        MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.star_wars);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        double time = new Date().getTime() + 15000;

//        strafe(-.8);//strafe
//        timer(500);
//        strafe(0);
        mediaPlayer.start();

        drive(-0.6);
        timer(725);
        drive(0);

        drive(0);
        timer(2000);
        drive(0);

        while(detectedSensor1() == false && new Date().getTime() < time) {
            strafe(-0.2);
            timer(1500);
            strafe(0);
            timer(300);
            if (detectedSensor1()) {
                telemetry.addData("stop", detectedSensor1());
                telemetry.update();
                break;
            }

        }

        strafe(0.2);
        timer(500);
        strafe(0);

        pullUp(-0.6);
        timer(1000);
        pullUp(0);

        moveClaw(0.6);
        timer(2500);
        moveClaw(0);

        extendArm(-0.6);
        timer(500);
        extendArm(0);

        pullUp(0.6);
        timer(500);
        pullUp(0);


        moveClaw(-0.6);
        timer(2500);
        moveClaw(0);



        drive(1); //backup
        timer(500);
        drive(0);

        turn(-.2);
        timer(100);
        turn(0);

        strafe(.8); //left
        timer(2250);
        strafe(0);

        drive(-1);
        timer(500);
        drive(0);

        pullUp(-0.6);
        timer(500);
        pullUp(0);

        moveClaw(0.6);
        timer(1500);
        moveClaw(0);

        moveClaw(-0.6);
        timer(1500);
        moveClaw(0);

        pullUp(0.6);
        timer(400);
        pullUp(0);

        drive(1);
        timer(300);
        drive(0);

        strafe(-.8);
        timer(500);
        strafe(0);

        mediaPlayer.pause();

    }
}
