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

        sleep(1000);
        driveStraight(3000, 1);
        sleep(1000);

        gyro.resetZAxisIntegrator();

        while (opModeIsActive())
        {
            telemetry.addData("gyro heading", gyro.getHeading());
            telemetry.update();

            // Use gyro to drive in a straight line.
            correction = checkDirection();

            // set power levels.
            backLeftMotor.setPower(power - correction);
            frontLeftMotor.setPower(power - correction);
            backRightMotor.setPower(power + correction);
            frontRightMotor.setPower(power + correction);

            // We record the sensor values because we will test them in more than
            // one place with time passing between those places. See the lesson on
            // Timing Considerations to know why.
            aButton = gamepad1.a;
            bButton = gamepad1.b;

            if ( aButton || bButton)
            {
                // backup.
                backLeftMotor.setPower(power);
                frontLeftMotor.setPower(power);
                backRightMotor.setPower(power);
                frontRightMotor.setPower(power);

                sleep(500);

                // stop.
                backRightMotor.setPower(0);
                backLeftMotor.setPower(0);
                frontRightMotor.setPower(0);
                frontLeftMotor.setPower(0);

                // turn 90 degrees right.
                if (touched || aButton) rotate(-90, power);

                // turn 90 degrees left.
                if (bButton) rotate(90, power);
            }
        }

        // turn the motors off.
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
    }
    private double checkDirection()
    {
        // The gain value determines how sensitive the correction is to direction changes.
        // You will have to experiment with your robot to get small smooth direction changes
        // to stay on a straight line.
        double correction, heading, gain = .10;

        heading = gyro.getHeading();

        if (heading == 0)
            correction = 0;             // no adjustment.
        else if (heading > 180)
            correction = 360 - heading; // adjust left.
        else
            correction = -heading;      // adjust right.

        correction = correction * gain;

        return correction;
    }

    private void rotate(int degrees, double power)
    {
        double  leftPower, rightPower;
        int     targetAngle;

        // reset gyro to zero.
        gyro.resetZAxisIntegrator();

        // Gyro returns 0->359 when rotating counter clockwise (left) and 359->0 when rotating
        // clockwise (right).

        if (degrees < 0)
        {   // turn right.
            leftPower = power;
            rightPower = -power;
            targetAngle = 360 + degrees;    // degrees is - for right turn.
        }
        else if (degrees > 0)
        {   // turn left.
            leftPower = -power;
            rightPower = power;
            targetAngle = degrees;
        }
        else return;

        // set power to rotate.
        backLeftMotor.setPower(leftPower);
        frontLeftMotor.setPower(leftPower);
        backRightMotor.setPower(rightPower);
        frontRightMotor.setPower(rightPower);
        // rotate until turn is completed.
        if (degrees < 0)
        {
            // On right turn we have to get off zero first.
            while (opModeIsActive() && gyro.getHeading() == 0)
            {
                telemetry.addData("gyro heading", gyro.getHeading());
                telemetry.update();
                idle();
            }

            while (opModeIsActive() && gyro.getHeading() > targetAngle)
            {
                telemetry.addData("gyro heading", gyro.getHeading());
                telemetry.update();
                idle();
            }
        }
        else
            while (opModeIsActive() && gyro.getHeading() < targetAngle)
            {
                telemetry.addData("gyro heading", gyro.getHeading());
                telemetry.update();
                idle();
            }

        // turn the motors off.
        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
        // Reset gyro heading to zero on new direction we are now pointing.
        gyro.resetZAxisIntegrator();
    }
}
