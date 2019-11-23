package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedClose")

public class AutoRedClose extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);

//        encoderDrive(3,3);
//        while(backRightMotor.isBusy() || backLeftMotor.isBusy() || frontLeftMotor.isBusy() || frontRightMotor.isBusy()){
//        }
//        strafe(1);
//        timer(9000);

        double circumference = 12.56;
        //1 second = 2 circumference;
        //time to travel = inches / 2 circumference;

        drive(-1); //-1 is forward for some reason
        timer(24/circumference * 1000);
        drive(0);
        timer(500);
        clawBois(-0.6f);
        timer(2000);
        clawBois(0);
        timer(500);
        extendArm(1);
        timer(1000);
        extendArm(0);

        clawBois(0.6f);
        timer(1500);
        clawBois(0);

//        extendArm(-1);
//        timer(1000);
//        extendArm(0);

        pullUp(1);
        timer(500);
        pullUp(0);

        drive(1);
        timer(24/circumference*1000);
        drive(0);

        strafe(.8f); // to the right
        timer(10000);
        strafe(0);

        drive(-1);
        timer(24/circumference*1000);
        drive(0);

        clawBois(-0.6f);
        timer(1500);
        clawBois(0);

        drive(1);
        timer(24/circumference*1000);
        drive(0);

        strafe(-.8f);
        timer(7000);
        strafe(0);
    }
}
