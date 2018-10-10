public class jobScheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scheduleJob(new Runnable() {
		    public void run() {
		        System.out.println("Hello World");
		    }
		}, 1000);
	}
	
	public static void scheduleJob(Runnable funcToRun, long time) {
		JobSchedule job = new JobSchedule(time, funcToRun);
		job.start();
	}

}

class JobSchedule implements Runnable {
	Thread temp;
	long time;
	Runnable funcToRun;
	
	JobSchedule(long timeToSleep, Runnable inputFunction){
		time = timeToSleep;
		funcToRun = inputFunction;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(time);
			funcToRun.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void start () {
	      if (temp == null) {
	         temp = new Thread (this, "Thread");
	         temp.start ();
	      }
	   }
	
}
