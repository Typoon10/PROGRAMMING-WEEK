// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Test;

public class Koala extends CommandBase {
  /** Creates a new Koala. */
  private Test thingy;
  private Timer tickTock = new Timer();
 
  public Koala(Test thingy) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.thingy = thingy;
    addRequirements(thingy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    tickTock.reset();
    tickTock.start();
    System.out.println("real");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    thingy.setVroomies(Constants.vroomiesSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    thingy.setVroomies(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      if(tickTock.get() > 5){
        return true;
    }
    else {
      return false;
    }
  }
}
