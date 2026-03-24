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
    public static double SHOOTER_FAR_VELOCITY = 1500; // Ticks/second
    public static double SHOOTER_CLOSE_VELOCITY = 1200; // Ticks/second
    public static double SHOOTER_MAX_VELOCITY = 2000; // Ticks/second

    // Intake
    public final static double INTAKE_MOTOR_IN = 1.0;
    public final static double INTAKE_MOTOR_OUT = -1.0;
}
