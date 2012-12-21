package BusinessFramework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccManager implements IAccManager {
	private static IAccManager accmanager = new AccManager();
	private static ICommand cmd;

	private AccManager() {
	};

	public static IAccManager getInstance() {
		return accmanager;
	}

	@Override
	public void setCommand(ICommand cmd) {
		AccManager.cmd = cmd;
	}

	@Override
	public ActionListener getActionListener() {
		return new Window_Action();
	}

	private class Window_Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			cmd.setEvent(event);
			cmd.executeLogic();
		}

	}

}
