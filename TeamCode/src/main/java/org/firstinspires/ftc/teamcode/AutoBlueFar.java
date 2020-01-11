package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BlueFar")
public class AutoBlueFar extends Hardware {

    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);


        double circumference = 12.56;

        //1 second = 2 circumference;
        //time to travel = inches / 2 circumference;

        drive(-1);
        timer(1000);
        turn(.8);
        timer(1000);
        drive(1);
        timer(700);
        {
            dragL.setPosition(.4);
            dragR.setPosition(.61);
        }timer(1200);
        drive(-1);
        timer(1300);
        {
            dragL.setPosition(.6);
            dragR.setPosition(.39);
        }timer(1200);
        strafe(-.8);
        timer(1000);
    }
}
