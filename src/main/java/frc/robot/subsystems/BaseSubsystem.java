// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class BaseSubsystem extends SubsystemBase {
  /** Creates a new BaseSubsystem. */
  private final SparkMax rightFrontMotor;
  private final SparkMax rightBackMotor;
  private final SparkMax leftFrontMotor;
  private final SparkMax leftBackMotor;

  private final SparkMaxConfig rightFrontConfig;
  private final SparkMaxConfig rightBackConfig;
  private final SparkMaxConfig leftFrontConfig;
  private final SparkMaxConfig leftBackConfig;

  private final DifferentialDrive drive;
  public BaseSubsystem() {
    rightFrontMotor = new SparkMax(1, MotorType.kBrushed);
    rightBackMotor = new SparkMax(2, MotorType.kBrushed);
    leftFrontMotor = new SparkMax(3, MotorType.kBrushed);
    leftBackMotor = new SparkMax(4, MotorType.kBrushed);

    rightFrontConfig = new SparkMaxConfig();
    rightBackConfig = new SparkMaxConfig();
    leftFrontConfig = new SparkMaxConfig();
    leftBackConfig = new SparkMaxConfig();

    drive = new DifferentialDrive(leftFrontMotor, rightFrontMotor);

    rightFrontConfig.inverted(false);
    rightBackConfig.inverted(false);
    leftFrontConfig.inverted(true);
    leftBackConfig.inverted(true);

    rightBackConfig.follow(rightFrontMotor.getDeviceId());
    leftBackConfig.follow(leftFrontMotor.getDeviceId());

    rightFrontMotor.configure(rightFrontConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    rightBackMotor.configure(rightBackConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    leftFrontMotor.configure(leftFrontConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    leftBackMotor.configure(leftBackConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
  }

  public void manualDrive(double xSpeed, double ySpeed){
    drive.arcadeDrive(xSpeed, ySpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
