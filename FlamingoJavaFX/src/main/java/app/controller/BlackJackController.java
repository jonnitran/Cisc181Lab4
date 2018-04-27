package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Flamingo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pkgCore.Action;
import pkgCore.GamePlay;
import pkgCore.Hand;
import pkgCore.HandPoker;
import pkgCore.HandScorePoker;
import pkgCore.Player;
import pkgCore.Table;
import pkgEnum.eAction;
import pkgCore.Deck;
import javafx.scene.control.Button;


public class BlackJackController implements Initializable {
	private Flamingo FlamingoGame;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	public void setMainApp(Flamingo FlamingoGame)
	{
		this.FlamingoGame = FlamingoGame;
	}

	@FXML private Label lblTopName;
	@FXML private Label lblBottomName;
	@FXML private Button btnTop;
	@FXML private Button btnBottom;
	@FXML private Button leaveTop;
	@FXML private Button leaveBottom;
	
	@FXML
	public void btnSitLeave_Click(ActionEvent event)
	{
		Button btn = (Button)event.getSource();
		
		Action act = new Action();
		HandPoker hand = new HandPoker();
		
		act.setAction(btn.getText().equals("Sit") ? eAction.Sit : eAction.Leave);
		
		Player p = FlamingoGame.getAppPlayer();
		
		if (btn.getId().equals("btnTop")) {
			p.setiPlayerPosition(2);
				
		}
		else if (btn.getId().equals("btnButtom")) {
			p.setiPlayerPosition(0);
		} 
		act.setPlayer(FlamingoGame.getAppPlayer());
		
	}

	public void HandleTableState(Table t) {

		for (Player p: t.GetTable()) {
			switch (p.getiPlayerPosition()) {
				case 0:
					lblTopName.setText(p.getPlayerName());
					btnTop.setText("Leave");
					btnTop.setVisible(false);
					break;
					
				case 2:
					lblBottomName.setText(p.getPlayerName());
					btnBottom.setText("Leave");
					btnBottom.setVisible(false);
					break;
					
			}
		}
		
	}

	public void HandleGameState(GamePlay gp) {

		//		Coming Soon....!
	}

}
