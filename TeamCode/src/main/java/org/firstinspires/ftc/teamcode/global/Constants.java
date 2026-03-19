package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class Constants {
    // Climb
    public static double LEFT_CLIMB_UP = 0.11;
    public static double RIGHT_CLIMB_UP = 0.9;
    public static double LEFT_CLIMB_DOWN = 0.57;
    public static double RIGHT_CLIMB_DOWN = 0.42;

    // Shooter
    public static PIDFCoefficients FLYWHEEL_PIDF_COEFFICIENTS = new PIDFCoefficients(-0.0070,0,0,-0.00052);
    public static double SHOOTER_VERY_FAR_VELOCITY = 7.0;
    public static double SHOOTER_FAR_VELOCITY = 5.8; // Meters/second
    public static double SHOOTER_CLOSE_VELOCITY = 4.51; // Meters/second
    public static double SHOOTER_MAX_VELOCITY = 2000; // Ticks/second

    // Hood
    public static double MIN_HOOD_ANGLE = 20; //degrees
    public static double MIN_HOOD_SERVO_POS = 0.28; //match with value above
    public static double MAX_HOOD_ANGLE = 45; //degrees
    public static double MAX_HOOD_SERVO_POS = 0.82; //match with value above


    // Intake
    public final static double INTAKE_MOTOR_IN = 1.0;
    public final static double INTAKE_MOTOR_OUT = -1.0;
}
