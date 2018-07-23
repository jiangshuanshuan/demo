package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ScheduleDao;
import com.example.demo.entity.ScheduleJob;
import com.example.demo.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {
	
	@Autowired
	private ScheduleDao scheduleDao;
	@Override
	public List<ScheduleJob> findLegalJobList() throws Exception {
		return scheduleDao.findLegalJobList();
	}

	@Override
	public List<ScheduleJob> findDelJobList() throws Exception {
		return scheduleDao.findDelJobList();
	}
	

}
