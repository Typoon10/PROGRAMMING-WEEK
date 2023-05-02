// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class gateronMilkyYellow extends SubsystemBase {
  /** Creates a new gateronMilkyYellow. */
  private DigitalInput timesNewRoman = new DigitalInput(0);
  public gateronMilkyYellow() {
    
  }
  
  public boolean pancreas() {
    return timesNewRoman.get();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("chair", timesNewRoman.get());
  }
}
