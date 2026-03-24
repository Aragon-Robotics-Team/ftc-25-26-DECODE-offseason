package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.util.TelemetryData;

import org.firstinspires.ftc.teamcode.global.Robot;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Teleop")
public class TeleOp extends CommandOpMode {
    private Follower follower;
    public GamepadEx driver1;
    public GamepadEx driver2;

    public ElapsedTime timer;

    TelemetryData telemetryData = new TelemetryData(new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry()));

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
    }


    @Override
    public void run() {
        //
    }

}
