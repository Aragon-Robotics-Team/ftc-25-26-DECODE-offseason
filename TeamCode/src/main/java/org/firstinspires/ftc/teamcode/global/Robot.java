package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.util.TelemetryData;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SpindexerSubsystem;

public class Robot extends com.seattlesolvers.solverslib.command.Robot {
    private static final Robot instance = new Robot();
    public static Robot getInstance() {
        return instance;
    }

    //motors
    public MotorEx shooter;
    public DcMotor intakeMotor;
    public DcMotorEx spindexerMotor;

    //subsystems
    public ShooterSubsystem shooterSubsystem;
    public IntakeSubsystem intakeSubsystem;
    public SpindexerSubsystem spindexerSubsystem;

    public void init(HardwareMap hMap) {

        //shooter
        shooter = hMap.get(MotorEx.class, "shooter1");
        shooter.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
        shooter.setRunMode(Motor.RunMode.RawPower);
        shooterSubsystem = new ShooterSubsystem();

        //intake
        intakeSubsystem = new IntakeSubsystem();
        intakeSubsystem.setIntake(IntakeSubsystem.IntakeState.INTAKE_STILL);

        //spindexer

    }

    public void initHasMovement() {
        intakeSubsystem.init();
        shooterSubsystem.init();
    }

    public void updateLoop(TelemetryData telemetryData) {
        CommandScheduler.getInstance().run();

        if (telemetryData != null) {
            telemetryData.update();
        }
    }
}
