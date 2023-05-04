// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.time.chrono.ThaiBuddhistChronology;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Test;
import frc.robot.subsystems.gateronMilkyYellow;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Worm extends InstantCommand {
  private gateronMilkyYellow timesNewRoman;
  private Test thingy;
  public Worm(gateronMilkyYellow timesNewRoman, Test thingy) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.timesNewRoman = timesNewRoman;
    this.thingy = thingy;
    addRequirements(timesNewRoman);
    addRequirements(thingy);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    thingy.setVroomies(Constants.vroomiesSpeed);
    
    
  }
}
