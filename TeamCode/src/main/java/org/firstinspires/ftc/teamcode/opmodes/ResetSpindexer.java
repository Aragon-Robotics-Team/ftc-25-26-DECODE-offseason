package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.seattlesolvers.solverslib.command.CommandOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.global.Robot;

public class ResetSpindexer extends CommandOpMode {
    private final Robot robot = Robot.getInstance();
    Telemetry telemetry;

    @Override
    public void initialize() {
        super.reset();
        robot.init(hardwareMap, telemetry);
        robot.spindexerMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.spindexerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


}
