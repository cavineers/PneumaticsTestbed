// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TogglePiston;
import frc.robot.subsystems.Piston;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Piston m_subsystem = new Piston();

  private final TogglePiston m_autoCommand = new TogglePiston(m_subsystem);
public Joystick m_joy = new Joystick(0);
    public JoystickButton m_aButton = new JoystickButton(m_joy, 1);
    public JoystickButton m_bButton = new JoystickButton(m_joy, 2);
    public JoystickButton m_xButton = new JoystickButton(m_joy, 3);
    // public JoystickButton m_yButton = new JoystickButton(m_joy, 4);
    // public JoystickButton m_lBump = new JoystickButton(m_joy, 5);
    // public JoystickButton m_rBump = new JoystickButton(m_joy, 6);
    // public JoystickButton m_leftMenu = new JoystickButton(m_joy, 7);
    // public JoystickButton m_rightMenu = new JoystickButton(m_joy, 8);
    // public JoystickButton m_leftStick = new JoystickButton(m_joy, 9);
    // public JoystickButton m_rightStick = new JoystickButton(m_joy, 10);
    // public POVButton m_povUp = new POVButton(m_joy, 0, 0);
    // public POVButton m_povRight = new POVButton(m_joy, 90, 0);
    // public POVButton m_povDown = new POVButton(m_joy, 180, 0);
    // public POVButton m_povLeft = new POVButton(m_joy, 270, 0);

  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }
     

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
       this.m_xButton.whenPressed(this.m_autoCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
