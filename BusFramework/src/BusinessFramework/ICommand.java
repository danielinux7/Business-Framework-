package BusinessFramework;

import java.awt.event.ActionEvent;

public interface ICommand {
	public void executeLogic();

	public void setEvent(ActionEvent event);

	public void execute();
}
