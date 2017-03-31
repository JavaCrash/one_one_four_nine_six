package org.ftc.one_one_four_nine_six;

import android.media.MediaPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.R;

/**
 * 11496 Red Ball Ramp Code
 */
@Autonomous(name = "Red Ball Push & Ramp Park")
public class Red_Ball_ramp extends LinearOpMode{
    DcMotor left_drive;
    DcMotor right_drive;
    @Override
    public void runOpMode() throws InterruptedException {
        left_drive = hardwareMap.dcMotor.get("left");
        right_drive = hardwareMap.dcMotor.get("right");

        MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.nxtstartupsound);
        mediaPlayer.start();
        waitForStart();
        left_drive.setPower(-1);
        right_drive.setPower(-1);
        sleep(1500);
        left_drive.setPower(0);
        right_drive.setPower(0);
        left_drive.setPower(0.5);
        right_drive.setPower(-0.5);
        sleep(650);
        left_drive.setPower(0);
        right_drive.setPower(0);
        left_drive.setPower(-1);
        right_drive.setPower(-1);
        sleep(1670);
        left_drive.setPower(0);
        right_drive.setPower(0);
    }
}
