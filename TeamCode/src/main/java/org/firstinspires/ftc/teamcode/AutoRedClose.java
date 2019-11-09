package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedClose")

public class AutoRedClose extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);

        encoderDrive(17,17);
        while(backRightMotor.isBusy() || backLeftMotor.isBusy() || frontLeftMotor.isBusy() || frontRightMotor.isBusy()){
        }
        turn(0.8f);
        timer(2000);
        encoderDrive(45,45);
        while(backRightMotor.isBusy() || backLeftMotor.isBusy() || frontLeftMotor.isBusy() || frontRightMotor.isBusy()){
        }
        
    }
}
