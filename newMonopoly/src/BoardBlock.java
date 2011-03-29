
public class BoardBlock {
	private Block[] block = new Block[40];
	
	public BoardBlock(){												/////RETURNS THE FF:
		block[0] = new Block("Go", 0);									//go
		block[1] = new Block(new Estate("Ayala Ave.", 1, 60));			//brown
		//block[2] = new Block(new CommunityChest("Community Chest", 2));	//chest
		block[3] = new Block(new Estate("Makati Ave.", 3, 60));			//brown
		//block[4] = new Block(new Tax("Income Tax", 4));					//tax
		block[5] = new Block(new Station("Ayala Ave. Station", 5, 200));//station	
		block[6] = new Block(new Estate("PureGold", 6, 100));			//blue
		//block[7] = new Block(new Chance("Chance", 7));					//chance
		block[8] = new Block(new Estate("Rizal Park", 8, 130));			//blue
		block[9] = new Block(new Estate("Dela Rosa St.", 9, 120));		//blue
		block[10] = new Block("Jail", 10);								//jail
		
		block[11] = new Block(new Estate("Shopwise", 11, 140));			//pink
		block[12] = new Block(new Utilities("Meralco", 12, 150));		//utility
		block[13] = new Block(new Estate("SLEX", 13, 140));				//pink
		block[14] = new Block(new Estate("Walter Mart", 14, 160));		//pink
		block[15] = new Block(new Station("Buendia Station", 15, 200));	//station
		block[16] = new Block(new Estate("Intramuros", 16, 160));		//orange
		//block[17] = new Block(new CommunityChest("Community Chest", 17));//chest	
		block[18] = new Block(new Estate("C-5 Road", 18, 180));			//orange
		block[19] = new Block(new Estate("China Town", 19, 200));		//orange		
		block[20] = new Block("Free Parking", 20);
		
		block[21] = new Block(new Estate("NLEX", 21, 220));				//red
		//block[22] = new Block(new Chance("Chance", 22));				//chance
		block[23] = new Block(new Estate("National Bookstore", 23, 220));//red
		block[24] = new Block(new Estate("Trinoma", 24, 240));			//red
		block[25] = new Block(new Station("Taft Ave. Station", 25, 200));//station
		block[26] = new Block(new Estate("EDSA", 26, 250));				//yellow
		block[27] = new Block(new Estate("Magsaysay Bridge", 27, 250));	//yellow
		block[28] = new Block(new Utilities("Maynilad", 28, 150));		//utility
		block[29] = new Block(new Estate("Star City", 29, 260));		//yellow
		block[30] = new Block("Go to Jail", 30);						//go to jail
		
		block[31] = new Block(new Estate("Landmark", 31, 300));			//green
		block[32] = new Block(new Estate("Glorietta", 32, 300));		//green
		//block[33] = new Block(new CommunityChest("Community Chest", 33));//chest
		block[34] = new Block(new Estate("Greenbelt", 34, 320));		//green
		block[35] = new Block(new Station("North Edsa Station", 35, 200));//station
		//block[36] = new Block(new Chance("Chance", 36));				//chance
		block[37] = new Block(new Estate("Boracay Island", 37, 350));	//dark blue
		//block[38] = new Block(new Tax("Super Tax", 38));				//tax
		block[39] = new Block(new Estate("SM Mall of Asia", 39, 400));	//dark blue
	}

///////////////////////////////////GETTERS AND SETTERS///////////////////////////////
	public void setBlock(Block[] block) {
		this.block = block;
	}

	public Block[] getBlock() {
		return block;
	}

}
