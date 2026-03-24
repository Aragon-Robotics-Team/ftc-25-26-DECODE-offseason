package org.firstinspires.ftc.teamcode.subsystems;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

import static org.firstinspires.ftc.teamcode.global.Constants.*;
import org.firstinspires.ftc.teamcode.global.Robot;

public class SpindexerSubsystem extends SubsystemBase {
    private final Robot robot = Robot.getInstance();

    double ticks = 8192.0;
    private final double ticks_in_degree = 8192.0 / 360;

    /*public static double p = 0, i = 0, d = 0;
    public static double f = 0;*/
    public static int target = 0; //double?

    private final PIDFController spindexerController = new PIDFController(SPINDEXER_PID_COEFFICIENTS);

    public void setPIDF(double p, double i, double d, double f) {
        this.spindexerController.setPIDF(p,i,d,f);
    }

    public void setSpindexerTarget(int newTarget) {
        target = newTarget;

        int spindexerPos = robot.spindexerMotor.getCurrentPosition();
        double pid = spindexerController.calculate(spindexerPos, target);
        double ff = Math.cos(Math.toRadians(target / ticks_in_degree)) * SPINDEXER_PID_COEFFICIENTS.f; //feedforward

        double power = pid + ff;

        robot.spindexerMotor.setPower(power);
    }

    

}