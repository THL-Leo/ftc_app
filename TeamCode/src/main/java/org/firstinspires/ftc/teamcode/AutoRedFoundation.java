package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedFoundation")
public class AutoRedFoundation extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);

        //1 second = 2 circumference;
        //time to travel = inches / 2 circumference;
        sleep(5000);
        drive(-1); //forward
        timer(1000);
        sleep(500);
        turn(-.8); //right turn
        timer(400);
        sleep(500);
        drive(1); //backup
        timer(800);
        sleep(2000);
        dragL.setPosition(.4);
        timer(750);
        dragR.setPosition(.61);
        timer(750);
        sleep(500);
        drive(-1); //go forward after hooking onto the foundation
        timer(1000);
        sleep(500);
        dragL.setPosition(.6);
        timer(750);
        dragR.setPosition(.39);
        timer(750);
        sleep(500);
        turn(.8); //left turn
        timer(1000);
        drive(1);
        timer(2000);
    }
}
