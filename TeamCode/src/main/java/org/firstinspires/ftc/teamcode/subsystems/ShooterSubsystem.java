package org.firstinspires.ftc.teamcode.subsystems;
import static org.firstinspires.ftc.teamcode.global.Constants.*;

import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.controller.PIDFController;
import com.seattlesolvers.solverslib.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.global.Robot;


public class ShooterSubsystem extends SubsystemBase {
     private final Robot robot = Robot.getInstance();
     private final PIDFController flywheelController = new PIDFController(FLYWHEEL_PIDF_COEFFICIENTS);
     private double targetHoodAngle = MIN_HOOD_ANGLE;
     private double targetShooterVelo = 0.0;

     public ShooterSubsystem() {
          flywheelController.setTolerance(FLYWHEEL_VEL_TOLERANCE);
     }

     public void init() {
          setFlywheel(0);
     }

     /**
      * @param targetVelo target linear speed
      * set shooter setpoint to target linear speed if less than shooter max speed
      *                   if greater than shooter max speed, set to shooter max speed
      *                   set shooter target velocity to target ticks
      */
     public void setFlywheel(double targetVelo) {
          flywheelController.setSetPoint(Math.min(targetVelo, SHOOTER_MAX_VELOCITY));
          targetShooterVelo = targetVelo;
     }
}
