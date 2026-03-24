package org.firstinspires.ftc.teamcode.opmodes.tuning;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.util.TelemetryData;

import static org.firstinspires.ftc.teamcode.global.Constants.*;

import android.util.Log;

import org.firstinspires.ftc.teamcode.global.Robot;

public class ShooterPIDTuning extends CommandOpMode {
    public static double P = 0;
    public static double I = 0;
    public static double D = 0;
    public static double F = 0;

    public static double TARGET_VELO = 0;
    public static double TOLERANCE = 0;

    private double motorVel = 0;
    private double MOTOR_POWER = 0;

    private final PIDFController shooterPIDF = new PIDFController(P,I,D,F);
    TelemetryData telemetryData = new TelemetryData(new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry()));
    public ElapsedTime timer;
    private final Robot robot = Robot.getInstance();

    private MotorEx motor;

    @Override
    public void initialize() {
        motor = hardwareMap.get(MotorEx.class, "shooter1");

        super.reset();
        robot.init(hardwareMap);
    }

    @Override
    public void run() {
        if (timer == null) {
            robot.initHasMovement();
            timer = new ElapsedTime();
        }

        double newVel = robot.shooter.encoder.getCorrectedVelocity();
        if (Math.abs(newVel) < SHOOTER_MAX_VELOCITY) {
            motorVel = newVel;
        }

        shooterPIDF.setPIDF(P,I,D,F);

        shooterPIDF.setSetPoint(TARGET_VELO);
        double power = shooterPIDF.calculate(motorVel,TARGET_VELO);

        if (MOTOR_POWER != 0) {
            motor.set(MOTOR_POWER);
        }
        else {
            robot.shooter.set(power);
        }

        telemetryData.addData("Loop time", timer.milliseconds());
        timer.reset();

        telemetryData.addData("power", power);
        telemetryData.addData("target velocity", TARGET_VELO);
        telemetryData.addData("actual velocity", motorVel);
        telemetryData.addData("motor velocity", motor.getVelocity());
        telemetryData.addData("encoder position", motor.encoder.getPosition());

        robot.updateLoop(telemetryData);
    }

    @Override
    public void end() {
        Log.v("P", String.valueOf(P));
        Log.v("I", String.valueOf(I));
        Log.v("D", String.valueOf(D));
        Log.v("F", String.valueOf(F));
    }
}
