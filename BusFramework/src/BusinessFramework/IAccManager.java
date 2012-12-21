package BusinessFramework;

import java.awt.event.ActionListener;

public interface IAccManager {
	public ActionListener getActionListener();

	public void setCommand(ICommand cmd);

}
