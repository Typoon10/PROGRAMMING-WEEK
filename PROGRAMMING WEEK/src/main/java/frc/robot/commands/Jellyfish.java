// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Test;

public class Jellyfish extends CommandBase {
  /** Creates a new Jellyfish. */
  private Test thingy;
  private XboxController m_OperatorController;
  //private double PortugeseManOWar;
  public Jellyfish(Test thingy, XboxController m_OperatorController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.thingy = thingy;
    this.m_OperatorController = m_OperatorController;
    addRequirements(this.thingy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    thingy.setVroomies(m_OperatorController.getRawAxis(3));
    SmartDashboard.putNumber("Sea Cucumber", m_OperatorController.getRawAxis(3));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
