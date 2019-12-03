package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BlueFar")
public class AutoBlueFar extends Hardware {

    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);

        strafe(0.8f);
        timer(750);
    }
}
