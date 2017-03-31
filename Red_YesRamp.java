package org.ftc.one_one_four_nine_six;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by 120449 on 10/26/16.
 */
@TeleOp(name ="Red color & ramp", group ="Auto")
@Disabled
public class Red_YesRamp extends LinearOpMode{
    DcMotor left_drive;
    DcMotor right_drive;

    public void runOpMode() throws InterruptedException
    {
        left_drive = hardwareMap.dcMotor.get("left");
        right_drive = hardwareMap.dcMotor.get("right");

        waitForStart();
        left_drive.setPower(1);
        right_drive.setPower(1);
        sleep(1000);
        left_drive.setPower(0);
        right_drive.setPower(0);



    }


}
