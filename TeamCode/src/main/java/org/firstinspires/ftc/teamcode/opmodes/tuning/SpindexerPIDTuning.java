package org.firstinspires.ftc.teamcode.opmodes.tuning;

import android.util.Log;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.controller.PIDController;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.global.Robot;

@Config
@TeleOp
public class SpindexerPIDTuning extends CommandOpMode {
    public static double P = 0;
    public static double I = 0;
    public static double D = 0;

    private final PIDController spindexerPID = new PIDController(P,I,D);
    public GamepadEx driver;
    public ElapsedTime timer;
    private final Robot robot = Robot.getInstance();
    public static int TARGET = 0;

    int spindexerPos;
    double spindexerPIDoutput;

    @Override
    public void initialize() {
        robot.init(hardwareMap);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        
        super.reset();
    }

    @Override
    public void run() {
        if (timer == null) {
            timer = new ElapsedTime();
        }

        driver = new GamepadEx(gamepad1);

        spindexerPID.setPID(P,I,D);
        spindexerPos = robot.spindexerMotor.getCurrentPosition();
        spindexerPIDoutput = spindexerPID.calculate(spindexerPos, TARGET);

        robot.spindexerMotor.setPower(spindexerPIDoutput);

        telemetry.addData("Loop time", timer.milliseconds());
        timer.reset();

        telemetry.addData("target: ", TARGET);
        telemetry.addData("spindexerPos: ", spindexerPos);

        telemetry.update();

    }

    @Override
    public void end() {
        Log.v("P", String.valueOf(P));
        Log.v("I", String.valueOf(I));
        Log.v("D", String.valueOf(D));
    }
}