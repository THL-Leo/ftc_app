package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import android.media.MediaPlayer;

@Autonomous(name = "Color/Distance Test")

public class ColorTest extends Hardware {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        init(hardwareMap);
        timer(200);
        MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.star_wars);

        while (opModeIsActive()){
            mediaPlayer.start();

            telemetry.addData("Blue",colorSensor.blue());
            telemetry.addData("Green",colorSensor.green());
            telemetry.addData("Red",colorSensor.red());
            telemetry.addData("Deteced1", detectedSensor1());
            telemetry.update();
        }
        mediaPlayer.pause();
    }

}