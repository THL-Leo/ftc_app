package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name = "Servo")
public class gyroTest extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);
        while (opModeIsActive()) {
            dragL.setPosition(.4);
            dragR.setPosition(.61);

        }
    }
}
