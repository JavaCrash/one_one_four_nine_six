# one_one_four_nine_six
This is the code for the FTC MacArthur Generals team. Currently (March 31st) we are using the 2.62 beta SDK. 
This is the first version of the code I have added to Github, so v1.0

Note: This is simply my /TeamCode/src/java/org/one_one_four_nine_six folder. This is NOT the full SDK.


V1.0 - Uploaded all the files
AutoBeacon - Autonomous program using encoder drive, (not complete) and the ADAFruit color sensor on a servo.

AutoBeaconRed - Same as AutoBeacon, except for the Red Side. Does not have Driving, just the Color Sensor logic.
Ball_Ramp - A basic autonomous to go and hit the ball off the Center Vortex then go park on the ramp for blue.
Blue_NoRamp - same as Ball_Ramp, except it doesnt go for the ramp and parks on the Center Vortex. (Or attempts to)
Blue_YesRamp - I don't remember why I created this. I should probably delete it.
Debug_Test - This little gem is basically our Driving program, except this is the one we mess with if we need to test a sensor, or a new method of driving
Debug_Test - Cont.. We used another algorithm to drive better, which the original can be found here: (It is in C) http://www.impulseadventure.com/elec/robot-differential-steering.html
GyroConcept - A blank file. WIP
I2C_Change_Button - The code found in the examples for changing an I2C address
Notes - This is my notes. Forever a WIP
Red_Ball_Ramp - Same as Ball_Ramp but for red
Red_NoRamp - Red ball with no ramp
Red_YesRamp - this one just moves the robot forward for 1000ms. Then stops. Nothing else. Nothing more.
SensorAdaFruitRGB2 - The example code that I used when figuring out how to work the adafruit color sensor before realizing I connected it wrong. Whoops.
TankDrive - A basic TankDrive program we used for a while before we changed recently to using the triggers as a forward and backward movement because it is easier to control one thing then try and get two joysticks exactly aligned with each other.
Test.C - Code from http://www.impulseadventure.com/elec/robot-differential-steering.html
TestDualColorSensorCode - Messing with the logic of the color sensor on a servo.
TouchSensorTesting - Converting the time based Color Sensor code to use Encoder Drive. Never finished it. GG me.
