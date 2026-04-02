package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    private final SparkMax shooterMotor = new SparkMax(Constants.IntakeShooterConstants.kIntakeShooterMotorPort2, MotorType.kBrushless);
    private final RelativeEncoder shooterEncoder = shooterMotor.getEncoder();

    
    public double getEncoderMeters() {
        return (((RelativeEncoder) shooterEncoder).getPosition());
      }
    

    public ShooterSubsystem () {
    }

    @Override
    public void periodic() {
       // SmartDashboard.putNumber("ClimberEncoder Value",  getEncoderMeters());

    }

    public void setMotor(double speed) {
        //armPivotMotorFollow.follow(armPivotMotorLead);
        SmartDashboard.putNumber("Shooter speed", speed);
        shooterMotor.set(-speed);
    }

}