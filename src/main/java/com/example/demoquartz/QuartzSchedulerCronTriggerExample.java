package com.example.demoquartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;



public class QuartzSchedulerCronTriggerExample {


    private static QuartzSchedulerCronTriggerExample instance = new QuartzSchedulerCronTriggerExample();
	public static QuartzSchedulerCronTriggerExample getInstance() {
		return instance;
	}
	private Scheduler scheduler;

	private QuartzSchedulerCronTriggerExample(){

	}
	
	public void iniciar() throws SchedulerException {
		scheduler = new StdSchedulerFactory().getScheduler();
		JobDetail job = JobBuilder.newJob(JobImpl.class)
		.withIdentity("ValidadorComprasJob", "Grupo6")
		 .build();
		Trigger trigger = TriggerBuilder
		.newTrigger()
		.withIdentity("Trigger", "Grupo6")
		.withSchedule(CronScheduleBuilder.cronSchedule("0 0/5 * * * ?")) // Ejecuta cada 5 minutos.
		.build();
		scheduler.start();
		scheduler.scheduleJob(job,trigger);
		}

		public void stop() throws SchedulerException {
		scheduler.shutdown();
		}
  

}
