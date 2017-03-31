package org.ftc.one_one_four_nine_six;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;


@Disabled
@Autonomous(name="Dual Sensor Test Code//Blue")
public class TestDualColorSensorCode extends LinearOpMode
{
    ColorSensor ColorSensor1;
    ColorSensor ColorSensor2;
    DcMotor Drive;

    public void runOpMode() throws InterruptedException
    {
        ColorSensor1 = hardwareMap.colorSensor.get("leftColor");
        ColorSensor2 = hardwareMap.colorSensor.get("rightColor");
        Drive = hardwareMap.dcMotor.get("Drive");
       // ColorSensor1.setI2cAddress(I2cAddr.create8bit());
        waitForStart();
        if (ColorSensor1.blue() == ColorSensor2.red() || ColorSensor2.blue() == ColorSensor1.red()){
            Drive.setPower(100);
            sleep(100);
        } else if (ColorSensor1.blue() == ColorSensor2.blue()) {
            Drive.setPower(-100);
        } else if (ColorSensor1.red() == ColorSensor2.red()){
            Drive.setPower(100);
            sleep(100);
        }

    }
}
