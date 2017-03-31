package org.ftc.one_one_four_nine_six;

import android.graphics.Color;
import android.media.MediaPlayer;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.R;

@Autonomous(name = "Red Beacon")
public class AutoBeaconRed extends LinearOpMode {

    DcMotor left_drive;
    DcMotor right_drive;
    DcMotor Test_zip;
    Servo RGB_Move;
    ColorSensor RGB;
    DeviceInterfaceModule cdim;

    @Override
    public void runOpMode() throws InterruptedException {
        MediaPlayer mediaPlayer = MediaPlayer.create(hardwareMap.appContext, R.raw.nxtstartupsound);
        mediaPlayer.start();
        left_drive = hardwareMap.dcMotor.get("left");
        right_drive = hardwareMap.dcMotor.get("right");
        Test_zip = hardwareMap.dcMotor.get("Zip_tie");
        RGB_Move = hardwareMap.servo.get("SensorServo");
        RGB = hardwareMap.colorSensor.get("Color");
        cdim = hardwareMap.deviceInterfaceModule.get("dim");
        left_drive.setMaxSpeed(3992);
        right_drive.setMaxSpeed(3990);
        Test_zip.setMaxSpeed(4000);

        waitForStart();

        float HValues[] = {0F,0F,0F};
        final float values[] = HValues;
        Color.RGBToHSV((RGB.red() * 255) / 800, (RGB.green() * 255) / 800, (RGB.blue() * 255) / 800, HValues);
        //This part moves the robot to the first Sensor, just test code, so this likely won't work or be accurate.

        //From here is the if then loops to detect the beacon
        if (RGB.blue() > 400) {
            RGB_Move.setPosition(0.8);
            sleep(200);
        }else if (RGB.red() > 100) {
            RGB_Move.setPosition(0.8);
            left_drive.setPower(.5);
            right_drive.setPower(.5);
            sleep(400);
            left_drive.setPower(0);
            right_drive.setPower(0);
            sleep(500);
        } if (RGB.blue() > 400) {
            //Move Forward and push button
            sleep(4200);
            RGB_Move.setPosition(0.5); //The servo need to be centered so the button can be pushed
            left_drive.setPower(-0.1);//This code pushes the button
            right_drive.setPower(-0.1);
            sleep(500);
            left_drive.setPower(0);
            right_drive.setPower(0);
            left_drive.setPower(1.1);
            right_drive.setPower(1.1);
            sleep(500);
            left_drive.setPower(0);
            right_drive.setPower(0);
        }

        //Move to the next beacon
        RGB_Move.setPosition(0.25);
        left_drive.setPower(-1);
        right_drive.setPower(-1);
        sleep(500);
        left_drive.setPower(0);
        right_drive.setPower(0);
        left_drive.setPower(1);
        right_drive.setPower(-1);
        sleep(200);
        left_drive.setPower(0);
        right_drive.setPower(0);
        left_drive.setPower(1);
        right_drive.setPower(1);
        sleep(1500);
        left_drive.setPower(0);
        right_drive.setPower(0);
        //Repeat the if/then loop process
        if (RGB.blue() > 400) {
            RGB_Move.setPosition(0.8);
            sleep(200);
        }else if (RGB.red() > 100) {
            RGB_Move.setPosition(0.8);
            left_drive.setPower(.5);
            right_drive.setPower(.5);
            sleep(400);
            left_drive.setPower(0);
            right_drive.setPower(0);
            sleep(500);
        } if (RGB.blue() > 400) {
            //Move Forward and push button
            sleep(4200);
            RGB_Move.setPosition(0.5); //The servo need to be centered so the button can be pushed
            left_drive.setPower(-0.1);//This code pushes the button
            right_drive.setPower(-0.1);
            sleep(500);
            left_drive.setPower(0);
            right_drive.setPower(0);
            left_drive.setPower(1.1);
            right_drive.setPower(1.1);
            sleep(500);
            left_drive.setPower(0);
            right_drive.setPower(0);
        }

        //This line adds all the telemetry data for debugging the code, and seeing the values that the color sensor outputs.
        // telemetry.addData("IR Value", IR.signalDetected()); This line is commented out, since we don't have the ir sensor tested.
        telemetry.addData("Red  ", RGB.red());
        telemetry.addData("Green", RGB.green());
        telemetry.addData("Blue ", RGB.blue());
        // telemetry.addData("Hue", HValues[0]);
        telemetry.update();










    }
}
