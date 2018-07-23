package com.example.demo.schedule;

import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CusSchedulerFactoryBean extends SchedulerFactoryBean{

	public CusSchedulerFactoryBean(JobFactory jobFactory) {
		super();
	}
}
