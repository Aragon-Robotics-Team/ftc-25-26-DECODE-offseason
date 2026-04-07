package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.util.TelemetryData;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SpindexerSubsystem;

public class Robot extends com.seattlesolvers.solverslib.command.Robot {
    Telemetry telemetry;
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

    public void init(HardwareMap hMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        //shooter
        shooterSubsystem = new ShooterSubsystem();
        shooter = new MotorEx(hMap, "shooter");
        shooter.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
        shooter.setRunMode(Motor.RunMode.RawPower);

        //intake
        intakeSubsystem = new IntakeSubsystem();
        intakeMotor = hMap.get(DcMotor.class, "intake");
        intakeSubsystem.setIntake(IntakeSubsystem.IntakeState.INTAKE_STILL);

        //spindexer
        spindexerSubsystem = new SpindexerSubsystem(telemetry);
        spindexerMotor = hMap.get(DcMotorEx.class, "spindexer");

    }
}
