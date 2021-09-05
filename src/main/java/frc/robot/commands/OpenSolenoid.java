package frc.robot.commands;

import frc.robot.subsystems.SingleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;

public class OpenSolenoid extends CommandBase {
    private final SingleSolenoid m_subsystem;

    private double startTime;

    private RobotContainer rc;

    public OpenSolenoid(SingleSolenoid subsystem, RobotContainer rc) {
      this.m_subsystem = subsystem;
      this.rc = rc;

      addRequirements(subsystem);
    }

    @Override
  public void initialize() {
    if (this.rc.controllerMode == RobotContainer.SafetyMode.SAFETY_OFF) {
        this.m_subsystem.open();
        this.rc.controllerMode = RobotContainer.SafetyMode.SAFETY_ON;
    }

    // Start the timer
    this.startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    // Close when finished
    this.m_subsystem.close();
  }

  @Override
  public boolean isFinished() {
    // Finished after .3 seconds
    return Timer.getFPGATimestamp() - this.startTime >= 0.3;
  }
}
