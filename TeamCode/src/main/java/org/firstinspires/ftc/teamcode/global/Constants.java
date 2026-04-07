package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.PIDCoefficients;
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
    public static double spindexer_p = -0.00065;
    public static double spindexer_i = 0;
    public static double spindexer_d = 0;
    public final static int TICKS_IN_DEGREE_SPINDEXER = 8192 / 360;
    public final static int SPINDEXER_FORWARD_ONE = TICKS_IN_DEGREE_SPINDEXER * 120; //tune this
    public final static double STALL_CURRENT = 6.5;

}
