package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "EncoderTest")

public class EncoderTest extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);

//        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

//        encoderDrive(17, 17);
//        while(backLeftMotor.isBusy() && frontRightMotor.isBusy() && backRightMotor.isBusy() && frontLeftMotor.isBusy()){
//        }
//        idle();

        drive(-1);
        timer(1000);
        drive(0);


    }
}