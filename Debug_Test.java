package org.ftc.one_one_four_nine_six;

import android.graphics.Color;
import android.media.MediaPlayer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.TouchSensor;
import org.firstinspires.ftc.teamcode.R;
import java.lang.*;

@TeleOp(name="Debug/Test Tank Drive")
public class Debug_Test extends OpMode
{
    DcMotor left_drive;
    DcMotor right_drive;
    DcMotor Test_zip;
    Servo   RGB_Move;
    ColorSensor RGB;
    DeviceInterfaceModule cdim;
    //TouchSensor Touch;
   // TouchSensor Touch2;
    //touch Sensors will be added later on


    public void init()
    {
        MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.nxtstartupsound);
        mediaPlayer.start();
        left_drive = hardwareMap.dcMotor.get("left");
        right_drive = hardwareMap.dcMotor.get("right");
        Test_zip = hardwareMap.dcMotor.get("Zip_tie");
        RGB_Move = hardwareMap.servo.get("SensorServo");
        RGB = hardwareMap.colorSensor.get("Color");
        cdim = hardwareMap.deviceInterfaceModule.get("dim");
      //  Touch = hardwareMap.touchSensor.get("Touch");
      //  Touch2 = hardwareMap.touchSensor.get("Touch2");
        left_drive.setMaxSpeed(3992);
        right_drive.setMaxSpeed(3990);
        Test_zip.setMaxSpeed(4000);
    }

    //Fix Trigger and Pivot to be proportional Done??
    //Reverse Drive so it is not backwards DONE

    @Override
    public void loop() {
        final float nJoyX = (gamepad1.right_stick_x);
        float nJoyY = (-gamepad1.right_trigger);
        float fPivYLimit = 1;
        int     nMotMixL;           // Motor (left)  mixed output           (-128..+127)
        int     nMotMixR;           // Motor (right) mixed output           (-128..+127)
        //float Forward = gamepad1.right_stick_x;
        //float Backward = -gamepad1.right_stick_x;
        float   nMotPremixL;
        float   nMotPremixR;
        float   fPivScale;      // Balance scale b/w drive and pivot    (   0..1   )

        if (nJoyY >= 0) {
            // Forward
            nMotPremixL = (nJoyX>=0)? 1 : (1 + nJoyX);
            nMotPremixR = (nJoyX>=0)? (1 - nJoyX) : 1;
        } else {
            // Reverse
            nMotPremixL = (nJoyX>=0)? (1 - nJoyX) : 1;
            nMotPremixR = (nJoyX>=0)? 1 : (1 + nJoyX);
        }


        nMotPremixL = nMotPremixL * nJoyY/1;
        nMotPremixR = nMotPremixR * nJoyY/1;
        final float nPivSpeed = nJoyX;
        fPivScale = (Math.abs(nJoyY)>fPivYLimit)? 0 : (1 - Math.abs(nJoyY)/fPivYLimit);

        final float Left = (1-fPivScale)*nMotPremixL + fPivScale*( nPivSpeed);
        final float Right = (1-fPivScale)*nMotPremixR + fPivScale*(-nPivSpeed);



        left_drive.setPower(Left);
        right_drive.setPower(Right);

















       // left_drive.setPower();










/*
        if(gamepad1.right_stick_x > 0.001){

            left_drive.setPower(Forward);
            right_drive.setPower(Backward);

        }
        if (gamepad1.right_stick_x  < 0){

            left_drive.setPower(Backward);
            right_drive.setPower(Forward);


        }



        if (gamepad1.right_trigger > 0) ;
            {
                left_drive.setPower(-gamepad1.right_trigger );
                right_drive.setPower(-gamepad1.right_trigger);
            }

        if (gamepad1.left_trigger > 0) ;
        {
            left_drive.setPower(gamepad1.left_trigger);
            right_drive.setPower(gamepad1.left_trigger);
        }

        if (gamepad1.right_stick_x < 0)
        {
            left_drive.setPower(gamepad1.right_stick_x);
            right_drive.setPower(-gamepad1.right_stick_x);
        }
*/
        if (gamepad1.dpad_right && gamepad1.a)
        {RGB_Move.setPosition(0.2);}
        if (gamepad1.dpad_left && gamepad1.a) {
            RGB_Move.setPosition(0.8);
        }
        if (gamepad1.dpad_up && gamepad1.a) {
            RGB_Move.setPosition(0.5);
        }





        float HValues[] = {0F,0F,0F};
        final float values[] = HValues;
        Color.RGBToHSV((RGB.red() * 255) / 800, (RGB.green() * 255) / 800, (RGB.blue() * 255) / 800, HValues);
        telemetry.addData("RightBumper Value", gamepad1.right_bumper);
        telemetry.addData("RightTrigger Value", gamepad1.right_trigger);
        telemetry.addData( "Joystick Value: ", -gamepad1.left_stick_y );
        telemetry.addData( "Joystick Value: ", -gamepad1.right_stick_y);
        telemetry.addData("Red  ", RGB.red());
        telemetry.addData("Green", RGB.green());
        telemetry.addData("Blue ", RGB.blue());
        telemetry.addData("Hue", HValues[0]);
        telemetry.addData("LeftDriveMax", left_drive.getMaxSpeed());
        telemetry.addData("RightDriveMax", right_drive.getMaxSpeed());
        telemetry.addData("TestZipMax", Test_zip.getMaxSpeed());
       // telemetry.addData("Touch Sensor Value", Touch.isPressed());
       // telemetry.addData("Touch Sensor 2 Value", Touch2.isPressed());
        telemetry.update();

    }
}
