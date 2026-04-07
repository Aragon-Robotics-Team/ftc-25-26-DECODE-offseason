package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDController;
import com.seattlesolvers.solverslib.controller.PIDFController;

import static org.firstinspires.ftc.teamcode.global.Constants.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.global.Robot;

public class SpindexerSubsystem extends SubsystemBase {
    private final Robot robot = Robot.getInstance();
    private ElapsedTime timer = new ElapsedTime();
    Telemetry telemetry;

    double ticks = 8192.0;

    /*public static double p = 0, i = 0, d = 0;
    public static double f = 0;*/
    public static int TARGET = 0;
    private int stallNum = 0;
    private final PIDController spindexerController = new PIDController(spindexer_p, spindexer_i, spindexer_d);

    public SpindexerSubsystem(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void setPIDF(double p, double i, double d, double f) {
        this.spindexerController.setPIDF(p,i,d,f);
    }

    public double getSetPoint() {
        return spindexerController.getSetPoint();
    }

    public void setSpindexerTarget(int newTarget) {
        TARGET = newTarget;
    }

    public void advanceSpindexer(int rotations) {
        int advance = TARGET + SPINDEXER_FORWARD_ONE * rotations;
        setSpindexerTarget(advance);
    }

    public boolean isSpindexerStalled(ElapsedTime timer, double targetPosition) {
        if (robot.spindexerMotor.getCurrent(CurrentUnit.AMPS) > STALL_CURRENT) return true;
        else return false;
    }

    @Override
    public void periodic() {
        int spindexerPos = robot.spindexerMotor.getCurrentPosition();
        double pid = spindexerController.calculate(spindexerPos, TARGET);
        //double ff = Math.cos(Math.toRadians(target / ticks_in_degree)) * SPINDEXER_PID_COEFFICIENTS.f; //gravity

        //double power = pid + ff;

        robot.spindexerMotor.setPower(pid);

        if (isSpindexerStalled(timer, spindexerController.getSetPoint())) {
            stallNum += 1;
            setSpindexerTarget(-SPINDEXER_FORWARD_ONE);
        }
        telemetry.addData("Stall Detection", stallNum);
    }


}