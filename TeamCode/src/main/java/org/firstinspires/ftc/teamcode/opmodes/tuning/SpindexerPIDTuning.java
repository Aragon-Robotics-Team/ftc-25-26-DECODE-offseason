package org.firstinspires.ftc.teamcode.opmodes.tuning;

import android.util.Log;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.util.TelemetryData;

import org.firstinspires.ftc.teamcode.global.Robot;
import org.firstinspires.ftc.teamcode.subsystems.SpindexerSubsystem;
@Config
@TeleOp
public class SpindexerPIDTuning extends CommandOpMode {
    public static double P = 0;
    public static double I = 0;
    public static double D = 0;
    public static double F = 0;

    private final PIDFController spindexerPIDF = new PIDFController(P,I,D,F);
    public GamepadEx driver;
    TelemetryData telemetryData = new TelemetryData(new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry()));
    public ElapsedTime timer;
    private final Robot robot = Robot.getInstance();
    public static int TARGET = 0;

    @Override
    public void initialize() {

        robot.init(hardwareMap);
        telemetryData = new TelemetryData(new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry()));

        super.reset();
    }

    @Override
    public void run() {
        if (timer == null) {
            robot.initHasMovement();
            timer = new ElapsedTime();
        }

        driver = new GamepadEx(gamepad1);

        spindexerPIDF.setPIDF(P,I,D,F);
        int spindexerPos = robot.spindexerMotor.getCurrentPosition();
        double pid = spindexerPIDF.calculate(spindexerPos, TARGET);

        robot.spindexerMotor.setPower(pid);

        telemetryData.addData("Loop time", timer.milliseconds());
        timer.reset();

        telemetryData.addData("target: ", TARGET);
        telemetryData.addData("spindexerPos: ", spindexerPos);

        telemetryData.update();

    }

    @Override
    public void end() {
        Log.v("P", String.valueOf(P));
        Log.v("I", String.valueOf(I));
        Log.v("D", String.valueOf(D));
        Log.v("F", String.valueOf(F));
    }
}