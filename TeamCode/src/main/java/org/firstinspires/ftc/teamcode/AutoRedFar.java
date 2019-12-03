package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedFar")
public class AutoRedFar extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);

        double circumference = 12.56;

        //1 second = 2 circumference;
        //time to travel = inches / 2 circumference;

        drive(-1); //-1 is forward for some reason
        timer(1000);
        drive(0);

        pullUp(-0.8f);
        timer(250);
        pullUp(0);

        clawBois(-0.6f);
        timer(4000);
        clawBois(0);

        drive(-1);
        timer(200);
        drive(0);

        clawBois(0.6f);
        timer(6000);
        clawBois(0);

        pullUp(-0.8f);
        timer(250);
        pullUp(0);

        drive(-1);
        timer(200);
        drive(0);

        drive(1);
        timer(1000);
        drive(0);

        strafe(0.8f);
        timer(5000);
        strafe(0);

        clawBois(-0.6f);
        timer(2000);
        clawBois(0);

        strafe(-0.8f);
        timer(2700);
        strafe(0);

}}
