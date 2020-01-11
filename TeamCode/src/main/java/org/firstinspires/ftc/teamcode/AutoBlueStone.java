package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BlueStone")
public class AutoBlueStone extends Hardware {

    public void runOpMode() throws InterruptedException {
        waitForStart();

        init(hardwareMap);

        sleep(250);
        strafe(.8);//strafe left
        timer(500);
        sleep(250);
        drive(-1);
        timer(1000);
        sleep(250);
        moveClaw(0.6);
        timer(2000);
        sleep(250);
        strafe(-.8);
        timer(500);
        sleep(250);
        moveClaw(-0.6);
        timer(1750);
        sleep(250);
        drive(1);
        timer(1200);
        sleep(250);
        turn(-.8);
        timer(1000);
        sleep(250);
        drive(-1);
        timer(4000);
        sleep(250);
        turn(.8);
        timer(1000);



    }
}
