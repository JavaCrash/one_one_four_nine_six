package org.ftc.one_one_four_nine_six;

import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.R;


@Disabled
@TeleOp(name ="Red color & rNoamp", group ="Auto")
public class Red_NoRamp extends LinearOpMode{



    DcMotor left_drive;
    DcMotor right_drive;
    //  ColorSensor color;
//Add Servo here for button push
    @Override
    public void runOpMode() throws InterruptedException {
                    //  color = hardwareMap.colorSensor.get("color");
                    // color.enableLed(true);
                    left_drive = hardwareMap.dcMotor.get("left");
                    right_drive = hardwareMap.dcMotor.get("right");

                    MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.nxtstartupsound);
                    mediaPlayer.start();
                    waitForStart();
                     /**
                     *This code is ran after the start button is pressed
                     */
                    left_drive.setPower(-1);
                    right_drive.setPower(-1);
                    sleep(500);
                    left_drive.setPower(0);
                    right_drive.setPower(0);
                    left_drive.setPower(-0.5);
                    right_drive.setPower(0.5);
                    sleep(750);
                    left_drive.setPower(0);
                    right_drive.setPower(0);
                    left_drive.setPower(-1);
                    right_drive.setPower(-1);
                    sleep(1050);
                    left_drive.setPower(0);
                    right_drive.setPower(0);
                    left_drive.setPower(0.5);
                    right_drive.setPower(-0.5);
                    sleep(500);
                    left_drive.setPower(0);
                    right_drive.setPower(0);
                    left_drive.setPower(0.5);
                    right_drive.setPower(-0.5);
                    sleep(200);
                    left_drive.setPower(0);
                    right_drive.setPower(0);

                    //Go to ramp
                    //telemetry.addData ("Blue",color.blue());
        /*if (color.blue() < 20){
            left_drive.setPower(0);
            right_drive.setPower(0);
        } else {
            left_drive.setPower(0.5);
            right_drive.setPower(0.5);}*/
    }

}
