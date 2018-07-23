package com.example.demo.task;

import java.io.Serializable;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Task1 implements  Job,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("-------------task1------------");
		
	}
}
