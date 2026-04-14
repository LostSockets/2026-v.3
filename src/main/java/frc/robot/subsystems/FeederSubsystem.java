package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeederSubsystem extends SubsystemBase {

    private final SparkMax feederMotor = new SparkMax(Constants.IntakeShooterConstants.kIntakeShooterMotorPort2, MotorType.kBrushless);
    private final RelativeEncoder feederEncoder = feederMotor.getEncoder();

    
    public double getEncoderMeters() {
        return (((RelativeEncoder) feederEncoder).getPosition());
      }
    

    public FeederSubsystem () {
    }

    @Override
    public void periodic() {
       // SmartDashboard.putNumber("ClimberEncoder Value",  getEncoderMeters());

    }

    public void setMotor(double speed) {
        //armPivotMotorFollow.follow(armPivotMotorLead);
        SmartDashboard.putNumber("Feeder speed", speed);
        feederMotor.set(-speed);
    }

}