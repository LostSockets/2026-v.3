package frc.robot.subsystems;

//import java.util.Set;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.InvertType;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeShooterSubsystem extends SubsystemBase {

    private final SparkMax intakeShooterMotor1 = new SparkMax(Constants.IntakeShooterConstants.kIntakeShooterMotorPort1, MotorType.kBrushless);
    private final SparkMax intakeShooterMotor2 = new SparkMax(Constants.IntakeShooterConstants.kIntakeShooterMotorPort2, MotorType.kBrushless);
    //private final RelativeEncoder elevatorEncoder = climberMotor1.getEncoder();

    
    /*public double getEncoderMeters() {
        return (((RelativeEncoder) elevatorEncoder).getPosition());
      }
    */

    public IntakeShooterSubsystem () {
    }

    @Override
    public void periodic() {

    }

    public void setMotor1(double speed) {
        SmartDashboard.putNumber("Intake Shooter speed 1", speed);
        intakeShooterMotor1.set(speed);
    }

    public void setMotor2(double speed) {
        SmartDashboard.putNumber("Intake Shooter speed 2", speed);
        intakeShooterMotor2.set(speed);
    }
}