package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class Constants {

    // Shooter
    public static PIDFCoefficients FLYWHEEL_PIDF_COEFFICIENTS = new PIDFCoefficients(-0.000001,0,0,0.0011);
    public static double SHOOTER_FAR_VELOCITY = 1500; // Ticks/second
    public static double SHOOTER_CLOSE_VELOCITY = 1200; // Ticks/second

    // Intake
    public final static double INTAKE_MOTOR_IN = 1.0;
    public final static double INTAKE_MOTOR_OUT = -1.0;

    // Spindexer
    public static PIDFCoefficients SPINDEXER_PID_COEFFICIENTS = new PIDFCoefficients(0, 0, 0, 0); //tune this
    public final static double TICKS_IN_DEGREE_SPINDEXER = 8192.0 / 360;
    public final static int SPINDEXER_FORWARD_ONE = 120; //tune this

}
