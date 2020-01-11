package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "gyroTest")
public class gyroTest extends Hardware {



    double                  power = .90, correction;
    boolean                 aButton, bButton, touched;
    public void runOpMode() throws InterruptedException {
        init(hardwareMap);

        telemetry.addData("Mode", "starting gyro calibration...please wait");
        telemetry.update();

        gyro.calibrate();

        while (!isStopRequested() && gyro.isCalibrating())
        {
            sleep(50);
            idle();
        }
        telemetry.addData("Mode", "gyro calibrated...waiting for start");
        telemetry.update();

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        gyroTurn(90);

        // Reset gyro heading to zero on new direction we are now pointing.
        gyro.resetZAxisIntegrator();
    }
}
