package org.firstinspires.ftc.teamcode.global;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorGroup;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SpindexerSubsystem;

public class Robot extends com.seattlesolvers.solverslib.command.Robot {
    private static final Robot instance = new Robot();

    private MotorEx liftLeft;
    private MotorEx liftRight;
    private MotorGroup liftMotorGroup;

    public static Robot getInstance() {
        return instance;
    }
    public MotorGroup shooterMotors;
    public DcMotor intakeMotor;
    public DcMotorEx spindexerMotor;

    //subsystems
    public ShooterSubsystem shooterSubsystem;
    public IntakeSubsystem intakeSubsystem;

    public SpindexerSubsystem spindexerSubsystem;

    public void init(HardwareMap hMap) {
        liftLeft = hMap.get(MotorEx.class, "liftLeft");
        liftRight = hMap.get(MotorEx.class, "liftRight");
        liftMotorGroup = new MotorGroup(liftLeft, liftRight);

        shooterMotors = new MotorGroup(
                new MotorEx(hMap, "shooter1").setInverted(true),
                new MotorEx(hMap, "shooter2").setInverted(false)
        );

        //shooter
        shooterMotors.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
        shooterMotors.setRunMode(Motor.RunMode.RawPower);
        shooterMotors.set(0);

        //intake
        intakeSubsystem.setIntake(IntakeSubsystem.IntakeState.INTAKE_STILL);

        //spindexer

    }
}
