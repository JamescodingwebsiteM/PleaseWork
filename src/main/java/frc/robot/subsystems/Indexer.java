/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.motor.single.SingleMotorMechanism;
import com.nerdherd.lib.sensor.VexUltrasonic;
import com.playingwithfusion.TimeOfFlight;

import frc.robot.RobotMap;
import frc.robot.constants.IndexerConstants;

public class Indexer extends SingleMotorMechanism {
  public TimeOfFlight timeOfFlight1, timeOfFlight2, timeOfFlight3;
  public VexUltrasonic ultrasonic;
  
  /**
   * Creates a new Indexer.
   */
  public Indexer() {
    super(RobotMap.kIndex, "Indexer", false, false);
    timeOfFlight1 = new TimeOfFlight(RobotMap.kTimeOFFlightSensorID1);
    timeOfFlight2 = new TimeOfFlight(RobotMap.kTimeOFFlightSensorID2);
    timeOfFlight3 = new TimeOfFlight(RobotMap.kTimeOFFlightSensorID3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public boolean hopperBallDetected(){
    return timeOfFlight1.getRange() < IndexerConstants.kTimeOfFlightNoBall;
  }

  public boolean indexerLowBallDetected() {
    return timeOfFlight2.getRange() < IndexerConstants.kTimeOfFlightNoBall;
  }

  public boolean indexerHighBallDetected()
{
  return timeOfFlight3.getRange() < IndexerConstants.kTimeOfFlightNoBall;
}
}
