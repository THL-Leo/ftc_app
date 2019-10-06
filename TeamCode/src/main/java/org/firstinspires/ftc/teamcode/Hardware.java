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
Hardware extends LinearOpMode{
    public static final byte LEFT = 1, CENTER = 2, RIGHT = 3;

    DcMotor backRightMotor, backLeftMotor, frontRightMotor, frontLeftMotor/*, mainArm*/ /*, upMotor*/;
    CRServo pulley;

    public void init(HardwareMap hardwareMap)
    {

        backRightMotor = hardwareMap.dcMotor.get("backRightMotor");
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        pulley = hardwareMap.crservo.get("pulley");
        pulley.setDirection(DcMotorSimple.Direction.FORWARD);

        /*mainArm = hardwareMap.dcMotor.get("mainArmMotor");
        mainArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mainArm.setDirection(DcMotorSimple.Direction.FORWARD);*/

        /*upMotor = hardwareMap.dcMotor.get("mainUpMotor");
        upMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        upMotor.setDirection(DcMotorSimple.Direction.FORWARD);*/
    }
    public void drive(float power)
    {
        backLeftMotor.setPower(/*0.51**/power);
        backRightMotor.setPower(-power);
        frontLeftMotor.setPower(-/*0.51**/power);
        frontRightMotor.setPower(power);
    }
    public void turn(float power){
        backRightMotor.setPower(-power);
        backLeftMotor.setPower(-power);
        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(power);
    }
    public void Timer(long milis){
        long time = new Date().getTime() + milis;
        while (time > new Date().getTime() && opModeIsActive());
    }
    public void strafe(float power){
        backLeftMotor.setPower(power);
        backRightMotor.setPower(power);
        frontLeftMotor.setPower(-power);
        frontRightMotor.setPower(-power);
    }
    /*public void raiseArm(float power){
        mainArm.setPower(power);
    }*/

    public void pullUp(float power){
        pulley.setPower(power);

    }

    public void stopDrivetrain(){
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        frontRightMotor.setPower(0);
        frontLeftMotor.setPower(0);
    }

    /*public void goUp(float power){
        upMotor.setPower(-power);
    }*/
    //@TODO measure spped of robot once we get wheels
    //@TODO program autonomous method lol
    //@TODO once we get mecanum wheels we need left and right
    //@TODO grabber method/ method that moves up the linear actuator
}
