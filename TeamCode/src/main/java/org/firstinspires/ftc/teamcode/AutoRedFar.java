package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedFar")
public class AutoRedFar extends Hardware {
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
        turn(-.8); //left turn
        timer(1000);
        sleep(500);
        drive(1); //backup
        timer(700);
        {
            dragL.setPosition(.4);
            dragR.setPosition(.61);
        }timer(1200);
        sleep(500);
        drive(-1); //go forward after hooking onto the foundation
        timer(1300);
        sleep(500);
        {
            dragL.setPosition(.6);
            dragR.setPosition(.39);
        }timer(1200);
        sleep(500);
        strafe(-.8); //strafe right
        timer(1000);
    }
}
