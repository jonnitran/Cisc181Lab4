package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableTest {
	Table t = new Table();
	Player P1 = new Player("zhaoyuan",7);
	Player P2 = new Player("jonni",8);
	Player P3 = new Player("yao",9);
	@Test
	public void test() {
		
		t.AddPlayerToTable(P1);
		t.AddPlayerToTable(P2);
		t.AddPlayerToTable(P3);
		
		assertEquals(P1.getPlayerID(),t.GetPlayerFromTable(P1).getPlayerID());
		
		t.RemovePlayerFromTable(P3);
		
		assertEquals(null,t.GetPlayerFromTable(P3));
		
	}

}
