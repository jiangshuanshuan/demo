package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ScheduleJob;

public interface ConfigService {
	List<ScheduleJob> findLegalJobList() throws Exception;

	List<ScheduleJob> findDelJobList() throws Exception;

}
