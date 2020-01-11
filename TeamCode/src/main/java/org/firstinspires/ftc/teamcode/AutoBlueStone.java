package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BlueStone")
public class AutoBlueStone extends Hardware {

    public void runOpMode() throws InterruptedException {
        waitForStart();

        init(hardwareMap);

        timer(200000);
        strafe(0.8f);
        timer(750);
    }
}
