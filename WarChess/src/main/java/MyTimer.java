public class MyTimer {
	private OnTimerListener onTimerListener;
	private long pTime, lastTime, nowTime;
	private boolean isRunning = false;

	private MyTimer(OnTimerListener onTimerListener) {
		this.onTimerListener = onTimerListener;
	}

	private MyTimer(long pTime, OnTimerListener onTimerListener) {
		this.pTime = pTime;
		this.onTimerListener = onTimerListener;
	}

	public static MyTimer createWTimer(long pTime, OnTimerListener onTimerListener) {
		MyTimer wTimer = new MyTimer(pTime, onTimerListener);
		return wTimer;
	}

	public void start() {
		isRunning = true;
		lastTime = System.currentTimeMillis();
	}

	public void update() {
		if (isRunning) {
			nowTime = System.currentTimeMillis();

			if (nowTime - lastTime >= pTime) {
				if (onTimerListener != null) {
					onTimerListener.onTimerRunning(this);
				}
				lastTime = nowTime;
			}
		}
	}

	public void stop() {
		isRunning = false;
	}

	public interface OnTimerListener {
		void onTimerRunning(MyTimer mTimer);
	}
}
