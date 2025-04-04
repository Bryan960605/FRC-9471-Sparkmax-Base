// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class EndEffectorSubsystem extends SubsystemBase {
  /** Creates a new EndEffectorSubsystem. */
  private final SparkMax endEffectorMotor;
  private final SparkMaxConfig endEffectorMotorConfig;
  public EndEffectorSubsystem() {
    endEffectorMotor = new SparkMax(5, MotorType.kBrushless);
    endEffectorMotorConfig = new SparkMaxConfig();

    endEffectorMotorConfig.idleMode(IdleMode.kBrake);
    endEffectorMotorConfig.inverted(false);

    endEffectorMotor.configure(endEffectorMotorConfig, com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }

  public void turnOut(){
    endEffectorMotor.set(0.1);
  }

  public void stopMotor(){
    endEffectorMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
