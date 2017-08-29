package hu.swing.workers;

import hu.swing.workers.WorkersConfig;

public interface WorkersInterface {
	// hozzá add
	public void add(WorkersConfig workersConfig);

	// listáz
	public Object[][] getAllworkers();

}
