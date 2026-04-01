// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.PIDController;

import frc.robot.Constants.ClimberConstants;


/** An example command that uses an example subsystem. */
public class ClimberPIDCommand extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
  private final ClimberSubsystem climberSubsystem;
  private final PIDController pidController;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   * @param setpoint  The setpoint for the PID controller.
   */
  public ClimberPIDCommand(ClimberSubsystem climberSubsystem, double setpoint) {
    this.climberSubsystem = climberSubsystem;
    this.pidController = new PIDController(ClimberConstants.kP, ClimberConstants.kI, ClimberConstants.kD);
    pidController.setSetpoint(setpoint);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climberSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pidController.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = pidController.calculate(climberSubsystem.getEncoderMeters());
    climberSubsystem.setMotor(speed);
    System.out.println("Climber speed = " + speed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climberSubsystem.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
