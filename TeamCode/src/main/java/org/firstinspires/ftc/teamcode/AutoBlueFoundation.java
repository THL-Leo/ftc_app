package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BlueFoundation")
public class AutoBlueFoundation extends Hardware {

    public void runOpMode() throws InterruptedException {
        init(hardwareMap);
        waitForStart();



        //1 second = 2 circumference;
        //time to travel = inches / 2 circumference;
        sleep(5000);
        drive(-1); //forward
        timer(1000);
        sleep(500);
        turn(.8); //left turn
        timer(400);
        sleep(500);
        drive(1); //backup
        timer(800);
        sleep(2000);
        drive(0);
        dragL.setPosition(.4);
        dragR.setPosition(.61);
        timer(1200);
        dragL.setPosition(.5);
        dragR.setPosition(.5);
        sleep(500);
        drive(-1); //go forward after hooking onto the foundation
        timer(3000);
        sleep(500);
        drive(0);
        dragL.setPosition(.6);
        dragR.setPosition(.39);
        timer(750);
        dragR.setPosition(.5);
        dragL.setPosition(.5);
        sleep(500);
        turn(.8); //turn left
        timer(1000);
        drive(-1);
        timer(2000);
//        sleep(20000);
//        strafe(-.8);
//        timer(1000);
    }
}
