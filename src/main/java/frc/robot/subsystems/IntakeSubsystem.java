package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private final SparkMax intakeMotor = new SparkMax(Constants.IntakeShooterConstants.kIntakeShooterMotorPort1, MotorType.kBrushless);
    private final RelativeEncoder intakeEncoder = intakeMotor.getEncoder();

    
    public double getEncoderMeters() {
        return (((RelativeEncoder) intakeEncoder).getPosition());
      }
    

    public IntakeSubsystem () {
    }

    @Override
    public void periodic() {
       // SmartDashboard.putNumber("ClimberEncoder Value",  getEncoderMeters());

    }

    public void setMotor(double speed) {
        //armPivotMotorFollow.follow(armPivotMotorLead);
        SmartDashboard.putNumber("Intake speed", speed);
        intakeMotor.set(-speed);
    }

}