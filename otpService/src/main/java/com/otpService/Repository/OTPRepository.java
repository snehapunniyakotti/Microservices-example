package com.otpService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otpService.Entity.OTPLog;

public interface OTPRepository extends JpaRepository<OTPLog, Integer> {

}
