package com.mailService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mailService.Entity.MailLog;

public interface MailRepository extends JpaRepository<MailLog,Integer>{

}
