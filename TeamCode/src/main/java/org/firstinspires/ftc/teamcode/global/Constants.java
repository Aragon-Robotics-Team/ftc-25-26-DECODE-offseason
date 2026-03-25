package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class Constants {

    // Shooter
    public static PIDFCoefficients FLYWHEEL_PIDF_COEFFICIENTS = new PIDFCoefficients(-0.0070,0,0,-0.00052);
    public static double SHOOTER_FAR_VELOCITY = 1500; // Ticks/second
    public static double SHOOTER_CLOSE_VELOCITY = 1200; // Ticks/second

    // Intake
    public final static double INTAKE_MOTOR_IN = 1.0;
    public final static double INTAKE_MOTOR_OUT = -1.0;

    // Spindexer
    public static PIDFCoefficients SPINDEXER_PID_COEFFICIENTS = new PIDFCoefficients(0, 0, 0, 0); //tune
    public final static double TICKS_IN_DEGREE_SPINDEXER = 8192.0 / 360;

}
