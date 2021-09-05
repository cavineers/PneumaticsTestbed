package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SingleSolenoid extends SubsystemBase {
  private Solenoid sol;

  public SingleSolenoid() {
    this.sol = new Solenoid(Constants.PCMChannelIds.PistonSolenoid1);
  }

  /**
   * Open the barrel.
   */
  public void open() {
    this.sol.set(true);
  }

  /**
   * Close the barrel.
   */
  public void close() {
    this.sol.set(false);
  }

  /**
   * Periodic.
   */
  @Override
  public void periodic() {}

}
