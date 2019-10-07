package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="~Servo Test")
public class ServoTest extends Hardware{
    @Override
    public void runOpMode() throws InterruptedException{
        waitForStart();
        init(hardwareMap);
        while(opModeIsActive()){
            pulley.setPower(0.5f);
            timer(3000);
            pulley.setPower(-0.5f);
            timer(3000);
            pulley.setPower(0f);


        }
    }
}
