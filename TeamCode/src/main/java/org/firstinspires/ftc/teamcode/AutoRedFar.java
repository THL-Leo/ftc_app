package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "RedFar")
public class AutoRedFar extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);

        double circumference = 12.56;

        //1 second = 2 circumference;
        //time to travel = inches / 2 circumference;


    }
}
