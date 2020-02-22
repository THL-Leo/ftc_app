package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Date;

@Autonomous(name="~Back wheels Test")
public class ServoTest extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        init(hardwareMap);
        waitForStart();
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        double time = new Date().getTime() + 12000;
        while(detectedSensor1() == false && new Date().getTime() < time) {
            strafe(0.2);
            timer(1700);
            strafe(0);
            timer(300);
            if (detectedSensor1()) {
                telemetry.addData("stop", detectedSensor1());
                telemetry.update();
                break;
            }

        }
        pullUp(-.8);
        timer(500);
        pullUp(0);



    }
}
