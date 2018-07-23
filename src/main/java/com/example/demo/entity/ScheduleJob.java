package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ScheduleJob {
	/** 任务id */
	@Id
    @GeneratedValue
    @Column(name="jobid")
	private long jobId;
	/** 任务名称 */
	@Column(name="jobname")
	private String jobName;
	/** 任务分组 */
	@Column(name="jobgroup")
	private String jobGroup;
	/** 任务状态 0禁用 1启用 2删除 */
	@Column(name="jobstatus")
	private String jobStatus;
	@Column(name="auditstatus")
	private String auditstatus;
	/** 任务运行时间表达式 */
	@Column(name="cronexpression")
	private String cronExpression;
	/** 定时任务处理类（全路径） */
	@Column(name="quartzclass")
	private String quartzClass;
	/** 任务描述 */
	private String description;
	/** 接收人 */
	private String receiver;

}
