package aut.groupsync;

public class Alarm {
	private boolean enabled;
	
	public Alarm(boolean enabled) {
		this.enabled = enabled;
	}

	public Alarm() {
		// Enable alarm by default
		this(true);
	}

	public void enable() {
		this.enabled = true;
	}

	public void disable() {
		this.enabled = false;
	}

	public boolean isEnabled() {
		return this.enabled;
	}
}
