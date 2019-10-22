package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="~Servo Test")
public class ServoTest extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);
        while (opModeIsActive()) {
            telemetry.addData("Main Servo Position", mainClaw.getPosition());
            telemetry.update();

            mainClaw.setPosition(0.8);
            timer(3000);
            mainClaw.setPosition(0.2);
            timer(3000);
        }
    }
}
