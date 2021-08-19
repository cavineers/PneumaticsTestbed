// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Piston extends SubsystemBase {
  /** Creates a new Piston. */
  public enum PistonState {
    EXTENDED,
    RETRACTED
  }

  private DoubleSolenoid sol = 
    new DoubleSolenoid(0, 1);

  public Piston() {
    this.setPistonState(PistonState.RETRACTED);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPistonState(PistonState state) {
    if (state == PistonState.EXTENDED) {
      this.sol.set(DoubleSolenoid.Value.kForward);
    } else {
      this.sol.set(DoubleSolenoid.Value.kReverse);
    }
  }

  /**
   * get the current piston state.
   * @return current state
   */
  public PistonState getPistonState() {
    if (sol.get() == DoubleSolenoid.Value.kForward) {
      return PistonState.EXTENDED;
    } else {
      return PistonState.RETRACTED;
    }
  }
}
