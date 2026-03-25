package org.firstinspires.ftc.teamcode.opmodes.tuning;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.util.TelemetryData;

import static org.firstinspires.ftc.teamcode.global.Constants.*;

import android.util.Log;

import org.firstinspires.ftc.teamcode.global.Robot;

@Config
@TeleOp
public class ShooterPIDTuning extends CommandOpMode {
    public static double P = 0;
    public static double I = 0;
    public static double D = 0;
    public static double F = 0;

    public static double TARGET_VELO = 0;

    private double motorVel = 0;

    private final PIDFController shooterPIDF = new PIDFController(P,I,D,F);
    public ElapsedTime timer;
    private final Robot robot = Robot.getInstance();


    @Override
    public void initialize() {
        super.reset();

        robot.init(hardwareMap);
    }

    @Override
    public void run() {
        if (timer == null) {
            timer = new ElapsedTime();
        }

        motorVel = robot.shooter.encoder.getCorrectedVelocity();

        shooterPIDF.setPIDF(P,I,D,F);

        shooterPIDF.setSetPoint(TARGET_VELO);
        double power = shooterPIDF.calculate(motorVel,TARGET_VELO);

        robot.shooter.set(power);

        telemetry.addData("Loop time", timer.milliseconds());
        timer.reset();

        telemetry.addData("power", power);
        telemetry.addData("target velocity", TARGET_VELO);
        telemetry.addData("actual velocity", motorVel);
        telemetry.addData("motor velocity", robot.shooter.getVelocity());
        telemetry.addData("encoder position", robot.shooter.encoder.getPosition());

        telemetry.update();
    }

}
