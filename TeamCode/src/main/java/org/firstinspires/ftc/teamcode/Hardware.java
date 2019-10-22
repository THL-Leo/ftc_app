package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

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

    DcMotor backRightMotor, backLeftMotor, frontRightMotor, frontLeftMotor/*, mainArm*/ /*, upMotor*/;

    CRServo pulley;
    Servo mainClaw;

    public void init(HardwareMap hardwareMap) {

        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        pulley = hardwareMap.crservo.get("pulley");
        pulley.setDirection(DcMotorSimple.Direction.FORWARD);

        mainClaw = hardwareMap.servo.get("mainClaw");
        mainClaw.setDirection(Servo.Direction.FORWARD);


        /*mainArm = hardwareMap.dcMotor.get("mainArmMotor");
        mainArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mainArm.setDirection(DcMotorSimple.Direction.FORWARD);*/

        /*upMotor = hardwareMap.dcMotor.get("mainUpMotor");
        upMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        upMotor.setDirection(DcMotorSimple.Direction.FORWARD);*/
    }

    public void drive(float power) {
        backLeftMotor.setPower(/*0.51**/power);
        backRightMotor.setPower(-power);
        frontLeftMotor.setPower(-/*0.51**/power);
        frontRightMotor.setPower(power);
    }

    public void turn(float power) {
        backRightMotor.setPower(-power);
        backLeftMotor.setPower(-power);
        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(power);
    }

    public void timer(long milis) {
        long time = new Date().getTime() + milis;
        while (time > new Date().getTime() && opModeIsActive()) ;
    }

    public void strafe(float power) {
        backLeftMotor.setPower(power);
        backRightMotor.setPower(power);
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(-power);
    }
    /*public void raiseArm(float power){
        mainArm.setPower(power);
    }*/

    public void pullUp(float power) {
        pulley.setPower(power);

    }

    public void stopDrivetrain() {
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
    }

    public void clawBois(float power) {
        mainClaw.setPosition(power);
    }

    public void encoderDrive(double distance) {
        backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        double circumference = 12.5664;
        final double counts_per_inch = (1680 * 60) / (4 * 3.1415);

        backLeftMotor.setTargetPosition((int) (distance * counts_per_inch));
        backRightMotor.setTargetPosition((int) (distance * counts_per_inch));
        frontLeftMotor.setTargetPosition((int) (distance * counts_per_inch));
        frontRightMotor.setTargetPosition((int) (distance * counts_per_inch));

        backLeftMotor.setPower(0.8);
        backRightMotor.setPower(0.8);
        frontRightMotor.setPower(0.8);
        frontLeftMotor.setPower(0.8);

    }
}
