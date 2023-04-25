// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Test extends SubsystemBase {
  /** Creates a new Test. */
  private CANSparkMax thingy = new CANSparkMax(Constants.thingyID, MotorType.kBrushless);
  private double vroomies;
  public Test() {
    vroomies = 0;
    thingy.enableSoftLimit(SoftLimitDirection.kForward, true);
    thingy.enableSoftLimit(SoftLimitDirection.kReverse, true);
    thingy.setSoftLimit(SoftLimitDirection.kForward, 50);
    thingy.setSoftLimit(SoftLimitDirection.kReverse, -50);
    thingy.setInverted(true);

  }
  public void setVroomies(double vroomies){
    this.vroomies = vroomies;
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    thingy.set(vroomies);
    SmartDashboard.putNumber("Cuttlefish", thingy.getEncoder().getPosition());
  }
}
