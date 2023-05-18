// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Test;

public class Sloth extends CommandBase {
  /** Creates a new Sloth. */
  private Test thingy;
  private Timer tockTick = new Timer();
  public Sloth(Test thingy) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.thingy = thingy;
    addRequirements(thingy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    tockTick.reset();
    tockTick.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    thingy.setVroomies(-Constants.vroomiesSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    thingy.setVroomies(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(tockTick.get() > 5){
      return true;
  }
  else {
    return false;
  }
}
  }

