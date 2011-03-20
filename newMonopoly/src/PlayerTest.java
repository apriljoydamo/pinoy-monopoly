import junit.framework.TestCase;


public class PlayerTest extends TestCase {

	public void testSetName() {
		Player player = new Player();
		player.setName("april");
		assertEquals("april", player.getName());
	}

	public void testGetName() {
		Player player = new Player();
		player.setName("lhaine");
		assertEquals("april", player.getName());
	}

	public void testSetToken() {
		Player player = new Player();
		player.setName("april");
		assertEquals("april", player.getName());
	}

	public void testGetToken() {
		fail("Not yet implemented");
	}

	public void testSetMoney() {
		fail("Not yet implemented");
	}

	public void testGetMoney() {
		fail("Not yet implemented");
	}

}
