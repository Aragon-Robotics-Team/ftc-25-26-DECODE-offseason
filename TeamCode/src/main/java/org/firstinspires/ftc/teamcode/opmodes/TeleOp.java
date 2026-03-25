package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;
import com.seattlesolvers.solverslib.util.TelemetryData;
import static org.firstinspires.ftc.teamcode.global.Constants.*;

import org.firstinspires.ftc.teamcode.global.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Teleop")
public class TeleOp extends CommandOpMode {
    private Follower follower;
    public GamepadEx driver1;
    public GamepadEx driver2;

    public ElapsedTime timer;
    private final Robot robot = Robot.getInstance();

    @Override
    public void initialize() {
        //reset command scheduler
        super.reset();

        //init robot which does most hardware initalizations I think
        robot.init(hardwareMap);

        follower = Constants.createFollower(hardwareMap);
        follower.startTeleOpDrive();
        follower.update();

        driver1 = new GamepadEx(gamepad1);
        driver2 = new GamepadEx(gamepad2);
        handleBinds();
    }

    public void handleBinds() {
        //intake
        driver1.getGamepadButton(GamepadKeys.Button.TRIANGLE).whenPressed(
                new InstantCommand(() -> {
                    if (robot.intakeSubsystem.currentState == IntakeSubsystem.IntakeState.INTAKE_IN) robot.intakeSubsystem.setIntake(IntakeSubsystem.IntakeState.INTAKE_STILL);
                    else robot.intakeSubsystem.setIntake(IntakeSubsystem.IntakeState.INTAKE_IN);
                })
        );
        driver1.getGamepadButton(GamepadKeys.Button.CROSS).whenPressed(
                new InstantCommand(() -> {
                    if (robot.intakeSubsystem.currentState == IntakeSubsystem.IntakeState.INTAKE_OUT) robot.intakeSubsystem.setIntake(IntakeSubsystem.IntakeState.INTAKE_STILL);
                    else robot.intakeSubsystem.setIntake(IntakeSubsystem.IntakeState.INTAKE_OUT);
                })
        );

        //spindexer

        //shooter
        driver1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(
                new InstantCommand(() -> {
                    robot.shooterSubsystem.setTargetTicks(SHOOTER_CLOSE_VELOCITY);
                })
        );
        driver1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(
                new InstantCommand(() -> {
                    robot.shooterSubsystem.setTargetTicks(SHOOTER_FAR_VELOCITY);
                })
        );
    }

    @Override
    public void run() {
        telemetry.addData("Loop time", timer.milliseconds());
        timer.reset();

        telemetry.update();
    }

}
