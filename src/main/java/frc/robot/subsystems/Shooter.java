/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.nerdherd.lib.motor.motorcontrollers.NerdyFalcon;
import com.nerdherd.lib.motor.single.SingleMotorMechanism;

import org.opencv.features2d.FlannBasedMatcher;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Shooter extends SingleMotorMechanism {
  /**
   * Creates a new Shooter.
   */
  private double m_desiredVel;
  private NerdyFalcon follower;

  public Shooter() {
    super(new NerdyFalcon(RobotMap.kshooterID1), "shooter", false, true);
    super.motor.setCoastMode();
    follower = new NerdyFalcon(RobotMap.kshooterID2);
    follower.setCoastMode();
    super.configPIDF(ShooterConstants.kP, ShooterConstants.kI, ShooterConstants.kD, ShooterConstants.kF);
    super.configDeadband(ShooterConstants.kDeadband);
    follower.follow((TalonFX) super.motor);
    super.configCurrentLimit(80, 60);
    m_desiredVel = 0;.
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setVelocity(double vel){
    super.setVelocity(vel);
    Robot.limelight.setOn();
  }

  public void setVelocityarbFF(double vel, double arbFF){
    super.setVelocity(vel, arbFF);
    Robot.limelight.setOn();

  }
}
