package org.ftc.one_one_four_nine_six;

import android.graphics.Color;
import android.media.MediaPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.R;


@Autonomous(name = "Blue Beacon")
public class AutoBeacon extends LinearOpMode {

    DcMotor left_drive;
    DcMotor right_drive;
    DcMotor Test_zip;
    Servo RGB_Move;
    ColorSensor RGB;
    DeviceInterfaceModule cdim;

    private ElapsedTime runtime = new ElapsedTime();
    static final double COUNTS_PER_MOTOR_REV = 1440;
    static final double DRIVE_GEAR_REDUCTION = 2.0;
    static final double WHEEL_DIAMETER_INCHES = 3.8;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.5;
    static final double TURN_SPEED = 0.3;
    static final double ACCELL = 0.3;

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
        telemetry.addData("Status", "Resetting Encoders");
        telemetry.update();

        left_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();

        left_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();

        float HValues[] = {0F, 0F, 0F};
        //final float values[] = HValues;
        Color.RGBToHSV((RGB.red() * 255) / 800, (RGB.green() * 255) / 800, (RGB.blue() * 255) / 800, HValues);


        encoderDrive(ACCELL, 5, 5, 3);
        encoderDrive(DRIVE_SPEED, 25, 25, 6);
        left_drive.setPower(0);
        right_drive.setPower(0);
        encoderDrive(TURN_SPEED, -4, 4, 1);
        left_drive.setPower(0);
        right_drive.setPower(0);

 /*From here is the if then loops to detect the beacon
 if (RGB.red() > 100) {
 RGB_Move.setPosition(0.8);
 sleep(200);
 }else if (RGB.blue() > 400) {
 RGB_Move.setPosition(0.8);
 left_drive.setPower(.5);
 right_drive.setPower(.5);
 sleep(400);
 left_drive.setPower(0);
 right_drive.setPower(0);
 sleep(500);
 } if (RGB.red() > 100) {
            //Move Forward and push button
            sleep(4200);
            RGB_Move.setPosition(0.5); //The servo need to be centered so the button can be pushed
            left_drive.setPower(-0.1);//This code pushes the button
            right_drive.setPower(-0.1);
            sleep(500);
            left_drive.setPower(0);
            right_drive.setPower(0);
        }

 //Move to the next beacon


 if (RGB.red() > 100) {
 RGB_Move.setPosition(0.8);
 sleep(200);
 }else if (RGB.blue() > 400) {
 RGB_Move.setPosition(0.8);
 left_drive.setPower(.5);
 right_drive.setPower(.5);
 sleep(400);
 left_drive.setPower(0);
 right_drive.setPower(0);
 sleep(500);
 } if (RGB.red() > 100) {
 //Move Forward and push button
 sleep(4200);
 RGB_Move.setPosition(0.5);
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
 //Reset Servo to 0.2 so we can check it again in the next code
 }
 */

 }

    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) throws InterruptedException {
        int newLeftTarget;
        int newRightTarget;
        if (opModeIsActive()) {
            newLeftTarget = left_drive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newRightTarget = right_drive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            left_drive.setTargetPosition(newLeftTarget);
            right_drive.setTargetPosition(newRightTarget);
            left_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            right_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            runtime.reset();
            left_drive.setPower(Math.abs(speed));
            right_drive.setPower(Math.abs(speed));
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (left_drive.isBusy() && right_drive.isBusy())) {
                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        left_drive.getCurrentPosition(),
                        right_drive.getCurrentPosition());
                telemetry.update();
                idle();}
            left_drive.setPower(0);
            right_drive.setPower(0);
            left_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            right_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);}}
}
