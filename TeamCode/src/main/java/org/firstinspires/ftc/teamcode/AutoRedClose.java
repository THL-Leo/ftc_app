package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedClose")

public class AutoRedClose extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);

        encoderDrive(3,3);
        while(backRightMotor.isBusy() || backLeftMotor.isBusy() || frontLeftMotor.isBusy() || frontRightMotor.isBusy()){
        }
        strafe(1);
        timer(9000);


    }
}
