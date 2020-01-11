package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Date;

import static java.lang.Math.abs;

public abstract class
Hardware extends LinearOpMode {
    public static final byte LEFT = 1, CENTER = 2, RIGHT = 3;
    static final double COUNTS_PER_MOTOR_REV = 1680;
    static final double DRIVE_GEAR_REDUCTION = 60;
    static final double WHEEL_DIAMETER = 4;


    DcMotor backRightMotor, backLeftMotor, frontRightMotor, frontLeftMotor, mainArm;
    ModernRoboticsI2cGyro gyro;
    Servo dragL, dragR;
    CRServo claw;

    public void init(HardwareMap hardwareMap) {

        gyro =  hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");

        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        mainArm = hardwareMap.dcMotor.get("mainArm");
        mainArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mainArm.setDirection(DcMotorSimple.Direction.FORWARD);

        claw = hardwareMap.crservo.get("claw");
        claw.setDirection(CRServo.Direction.FORWARD);

        dragL = hardwareMap.servo.get("dragL");
        dragL.setDirection(Servo.Direction.FORWARD);

        dragR = hardwareMap.servo.get("dragR");
        dragR.setDirection(Servo.Direction.FORWARD);

    }

    public void drive(double power) {
        backLeftMotor.setPower(-power);
        backRightMotor.setPower(-power);
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(-power);
    }


    public void turn(double power) {
        backRightMotor.setPower(power);
        backLeftMotor.setPower(-power);
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(power);
    }

    public void turnLeft(double power){
        backRightMotor.setPower(-power);
        backLeftMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(-power);
    }

    public void turnRight(double power){
        backRightMotor.setPower(0);
        backLeftMotor.setPower(power);
        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(0);
    }

    public void timer(double milis) {
        double time = new Date().getTime() + milis;
        while (time > new Date().getTime() && opModeIsActive()) ;
    }

    public void strafe(double power) {
        backLeftMotor.setPower(power);
        backRightMotor.setPower(-power);
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(power);
    }
    /*public void raiseArm(float power){
        mainArm.setPower(power);
    }*/

//    public void pullUp(float power) {
//        pulley.setPower(power);
//
//    }

    public void driveStraight(int duration, double power) throws InterruptedException{
        double leftSpeed;
        double rightSpeed;

        double target = gyro.getIntegratedZValue();
        double startPosition = backLeftMotor.getCurrentPosition();

        while(backLeftMotor.getCurrentPosition() < duration + startPosition){
            int zAccu = gyro.getIntegratedZValue();

            leftSpeed = power + (zAccu - target)/100;
            rightSpeed = power - (zAccu - target)/100;

            leftSpeed = Range.clip(leftSpeed, -1, 1);
            rightSpeed = Range.clip(rightSpeed, -1, 1);

            backLeftMotor.setPower(leftSpeed);
            frontLeftMotor.setPower(leftSpeed);
            backRightMotor.setPower(rightSpeed);
            frontRightMotor.setPower(rightSpeed);

            telemetry.addData("1. Left", backLeftMotor.getPower());
            telemetry.addData("2. Right", backRightMotor.getPower());
            telemetry.addData("3. Distance to go", duration + startPosition - backLeftMotor.getCurrentPosition());
            waitOneFullHardwareCycle();
        }
        drive(0);
        waitOneFullHardwareCycle();
    }

    public void gyroTurn(int target) throws InterruptedException{
        int zAccu = gyro.getIntegratedZValue();

        while(Math.abs(zAccu - target) > 3){
            if(zAccu > 0){
                backLeftMotor.setPower(0.2);
                frontLeftMotor.setPower(0.2);
                backRightMotor.setPower(-.2);
                frontRightMotor.setPower(-.2);
            }

            if(zAccu < 0){
                backLeftMotor.setPower(-0.2);
                frontLeftMotor.setPower(-0.2);
                backRightMotor.setPower(0.2);
                frontRightMotor.setPower(0.2);
            }

            waitOneFullHardwareCycle();

            zAccu = gyro.getIntegratedZValue();
            telemetry.addData("1. accu", String.format("%03d", zAccu));
        }
        drive(0);
        telemetry.addData("1. accu", String.format("%03d", zAccu));
        waitOneFullHardwareCycle();
    }


    public void stopDrivetrain() {
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
    }

    public void extendArm(double power){
        mainArm.setPower(power);
    }

    public void moveClaw(double power){
        claw.setPower(power);
    }


//    public void encoderDrive(double distanceLeft, double distanceRight) {
//
//            backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//            frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//            backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//            frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//
//            double circumference = 12.5664;
//            final double counts_per_inch = (1680 * 1) / (circumference);
//
////        backLeftMotor.setTargetPosition(0);
////        backRightMotor.setTargetPosition(0);
////        frontLeftMotor.setTargetPosition(0);
////        frontRightMotor.setTargetPosition(0);
//
//            backLeftMotor.setTargetPosition((int) ((distanceLeft-0.5) * counts_per_inch));
//            backRightMotor.setTargetPosition(-(int) (distanceRight * counts_per_inch));
//            frontLeftMotor.setTargetPosition(-(int) ((distanceLeft-0.5) * counts_per_inch));
//            frontRightMotor.setTargetPosition((int) (distanceRight * counts_per_inch));
//
//            backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//
//            backLeftMotor.setPower(-1);
//            backRightMotor.setPower(1);
//            frontLeftMotor.setPower(1);
//            frontRightMotor.setPower(-1);
//
//
//
////            backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
////            backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
////            frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
////            frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//    }
}
