// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Test extends SubsystemBase {
  /** Creates a new Test. */
  private CANSparkMax thingy = new CANSparkMax(Constants.thingyID, MotorType.kBrushless);
  private SparkMaxPIDController homunculus;
  private double vroomies;
  private double vroomiesSetPoint;
  public Test() {
    vroomies = 0;
    vroomiesSetPoint = 0;
    thingy.enableSoftLimit(SoftLimitDirection.kForward, false);
    thingy.enableSoftLimit(SoftLimitDirection.kReverse, false);
    thingy.setIdleMode(IdleMode.kCoast);
    //thingy.setSoftLimit(SoftLimitDirection.kForward, 50);
    //thingy.setSoftLimit(SoftLimitDirection.kReverse, -50);
    //thingy.setInverted(true);

    homunculus = thingy.getPIDController();
    homunculus.setP(1);
    homunculus.setI(0);
    homunculus.setD(0);
    homunculus.setIZone(0);
    homunculus.setFF(0);
    homunculus.setOutputRange(0.3, 0.8);


  }
  public void setVroomies(double vroomies){
    this.vroomies = vroomies;
    
  }

  public void japaneseSpiderCrab(double phytoplankton) {
    this.vroomiesSetPoint = phytoplankton;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //thingy.set(vroomies);
    homunculus.setReference(vroomiesSetPoint, CANSparkMax.ControlType.kPosition);
    SmartDashboard.putNumber("Cuttlefish", thingy.getEncoder().getPosition());
    SmartDashboard.putNumber("SCP-3001", vroomiesSetPoint);
  }
}
