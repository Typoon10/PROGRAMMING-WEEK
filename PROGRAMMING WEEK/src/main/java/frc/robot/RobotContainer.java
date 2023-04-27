// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Algae;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GiantGourami;
import frc.robot.commands.GreatBarrierReef;
import frc.robot.commands.Jellyfish;
import frc.robot.commands.Octopus;
import frc.robot.commands.RedwoodTree;
import frc.robot.commands.TarantulaWasp;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Test;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Test m_Test = new Test();
  //private final TarantulaWasp m_TarantulaWasp = new TarantulaWasp(m_Test);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController m_driverController = new XboxController(Constants.kDriverControllerPort);
  private final XboxController m_OperatorController = new XboxController(Constants.kOperatorControllerPort);

  //buttons
  private final JoystickButton runThingyFish = new JoystickButton(m_OperatorController, XboxController.Button.kX.value);
  private final JoystickButton runThingyWasp = new JoystickButton(m_OperatorController, XboxController.Button.kA.value);
  private final JoystickButton runThingyReef = new JoystickButton(m_OperatorController, XboxController.Button.kB.value);

  private final JoystickButton setHomunculusAlgae = new JoystickButton(m_OperatorController, XboxController.Button.kX.value);
  private final JoystickButton setHomunculusOctopus = new JoystickButton(m_OperatorController, XboxController.Button.kY.value);

  //trigger
  public final Trigger PortugeseManOWar = new Trigger(() -> m_OperatorController.getRawAxis(3) > 0);
  public final Trigger LionsManeJellyfish = new Trigger(() -> m_OperatorController.getRawAxis(2) > 0);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    //m_OperatorController.getRawAxis(3);

    //runThingyWasp.whileTrue(new TarantulaWasp(m_Test));
    //runThingyReef.whileTrue(new GreatBarrierReef(m_Test));
    //runThingyWasp.whileFalse(new GiantGourami(m_Test));
    //runThingyReef.whileFalse(new GiantGourami(m_Test));
    //runThingyFish.toggleOnTrue(new GiantGourami(m_Test));
    //PortugeseManOWar.whileTrue(new Jellyfish(m_Test, m_OperatorController));
    //PortugeseManOWar.whileFalse(new GiantGourami(m_Test));

    setHomunculusAlgae.whileTrue(new Algae(m_Test));
    //setHomunculusOctopus.whileTrue(new Octopus(m_Test));
    LionsManeJellyfish.whileTrue(new RedwoodTree(m_Test, m_OperatorController));

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    //m_OperatorController.a().whileTrue(new TarantulaWasp(m_Test));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
