package com.xxl.job.admin.service;

import java.util.Map;

import com.xxl.job.admin.core.model.ReturnT;

/**
 * core job service for xxl-job
 * 
 * @author xuxueli 2016-5-28 15:30:33
 */
public interface IXxlJobService {
	/**
	 * 分页从数据库查询 job 列表并进行填充
	 * @param start 起始页码
	 * @param length 每页数量
	 * @param jobGroup 作业组
	 * @param jobName 作业名
	 * @param filterTime 暂时未用
	 * @return: 返回 job 列表
	 */
	public Map<String, Object> pageList(int start, int length, String jobGroup, String jobName, String filterTime);
	/**
	 * 新增 job
	 * @param jobGroup 作业组
	 * @param jobName 作业名
	 * @param jobCron 作业 Cron 表达式
	 * @param jobDesc 作业备注
	 * @param executorAddress 执行器地址
	 * @param executorHandler 执行器 handler
	 * @param executorParam 执行器参数
	 * @param author 负责人
	 * @param alarmEmail 报警邮件
	 * @param alarmThreshold 报警阙值
	 * @param glueSwitch GLUE模式开关：0-否，1-是
	 * @param glueSource GLUE源代码
	 * @param glueRemark GLUE备注
	 * @return: 成功或者报错信息
	 */
	public ReturnT<String> add(String jobGroup, String jobName, String jobCron, String jobDesc, 
			String executorAddress,	String executorHandler, String executorParam, 
			String author, String alarmEmail, int alarmThreshold,
			int glueSwitch, String glueSource, String glueRemark);
	
	public ReturnT<String> reschedule(String jobGroup, String jobName, String jobCron, String jobDesc,
			String handler_address, String handler_name, String handler_params, 
			String author, String alarmEmail, int alarmThreshold, int glueSwitch);
	/**
	 * 移除 job
	 * @param jobGroup 作业组
	 * @param jobName 作业名
	 * @return: 成功或报错信息
	 */
	public ReturnT<String> remove(String jobGroup, String jobName);
	/**
	 * 暂停 job
	 * @param jobGroup 作业组
	 * @param jobName 作业名
	 * @return:
	 */
	public ReturnT<String> pause(String jobGroup, String jobName);
	/**
	 * 唤醒 job
	 * @param jobGroup 作业组
	 * @param jobName 作业名
	 * @return:
	 */
	public ReturnT<String> resume(String jobGroup, String jobName);
	/**
	 * 触发 job
	 * @param jobGroup 作业组
	 * @param jobName 作业名
	 * @return:
	 */
	public ReturnT<String> triggerJob(String jobGroup, String jobName);
	
}
