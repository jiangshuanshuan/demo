package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.ScheduleJob;

public interface ScheduleDao extends JpaRepository<ScheduleJob, Long> {
	@Query(value = "select * from schedule_job where jobstatus = 1 and auditstatus = 1",nativeQuery = true)
	public List<ScheduleJob> findLegalJobList();

	@Query(value = "select * from schedule_job where jobstatus = 0",nativeQuery = true)
	public List<ScheduleJob> findDelJobList();
}
