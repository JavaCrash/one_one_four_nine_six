package org.ftc.one_one_four_nine_six;

import android.media.MediaPlayer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.R;

@TeleOp(name="Tank Drive")
public class TankDrive extends OpMode
{
    DcMotor left_drive;
    DcMotor right_drive;
    DcMotor Test_zip;
    Servo   RGB_Move;

    public void init()
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.nxtstartupsound);
        mediaPlayer.start();
        left_drive = hardwareMap.dcMotor.get("left");
        right_drive = hardwareMap.dcMotor.get("right");
        Test_zip = hardwareMap.dcMotor.get("Zip_tie");
        RGB_Move = hardwareMap.servo.get("SensorServo");

        left_drive.setMaxSpeed(3992);
        right_drive.setMaxSpeed(3990);
        Test_zip.setMaxSpeed(4000);
    }
    @Override
    public void loop()
    {
        left_drive.setPower(gamepad1.left_stick_y);
        right_drive.setPower(gamepad1.right_stick_y);
        Test_zip.setPower(gamepad1.right_trigger);
        Test_zip.setPower(-gamepad1.left_trigger);
     if (gamepad1.dpad_right && gamepad1.a){
         RGB_Move.setPosition(0.2);
     }
       if(gamepad1.dpad_left && gamepad1.a){
            RGB_Move.setPosition(0.8);
        }
            if (gamepad1.dpad_up && gamepad1.a){
                RGB_Move.setPosition(0.5);
            }

        telemetry.addData( "Joystick Value: ", -gamepad1.left_stick_y );
        telemetry.addData( "Joystick Value: ", -gamepad1.right_stick_y);
        telemetry.addData("LeftDriveMax", left_drive.getMaxSpeed());
        telemetry.addData("RightDriveMax", right_drive.getMaxSpeed());
        telemetry.addData("TestZipMax", Test_zip.getMaxSpeed());
        telemetry.update();

    }
}
