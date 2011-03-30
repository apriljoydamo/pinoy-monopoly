
public class BoardBlock {
	private Block[] block = new Block[40];
	
	public BoardBlock(){												/////RETURNS THE FF:
		block[0] = new Block("Go", 0);									//go
		block[1] = new Block(new Estate("Ayala Ave.", 1, 60, false, new TitleDeed(2, 10, 30, 90, 160, 250, 30, 50)));			//brown
		block[2] = new Block("Community Chest", 2);	//chest
		block[3] = new Block(new Estate("Makati Ave.", 3, 60, false, new TitleDeed(4, 20, 60, 180, 420, 450, 30, 50)));			//brown
		block[4] = new Block("Income Tax", 4);					//tax
		block[5] = new Block(new Station("Ayala Ave. Station", 5, 200, false, new TitleDeed(25, 50, 100, 200, 100)));//station	
		block[6] = new Block(new Estate("PureGold", 6, 100, false, new TitleDeed(6, 30, 90, 270, 400, 550, 50, 50)));			//blue
		block[7] = new Block("Chance", 7);					//chance
		block[8] = new Block(new Estate("Rizal Park", 8, 130, false, new TitleDeed(6, 30, 90, 270, 400, 550, 50, 50)));			//blue
		block[9] = new Block(new Estate("Dela Rosa St.", 9, 120, false, new TitleDeed(8, 40, 100, 300, 450, 600, 60, 50)));		//blue
		block[10] = new Block("Jail", 10);								//jail
		
		block[11] = new Block(new Estate("Shopwise", 11, 140, false, new TitleDeed(10, 50, 150, 450, 625, 750, 70, 100)));			//pink
		//block[12] = new Block(new Utilities("Meralco", 12, 150, false, new TitleDeed()));		//utility
		block[13] = new Block(new Estate("SLEX", 13, 140, false, new TitleDeed(10, 50, 150, 450, 625, 750, 70, 100)));				//pink
		block[14] = new Block(new Estate("Walter Mart", 14, 160, false, new TitleDeed(10, 60, 180, 500, 700, 900, 80, 100)));		//pink
		block[15] = new Block(new Station("Buendia Station", 15, 200, false, new TitleDeed(25, 50, 100, 200, 100)));	//station
		block[16] = new Block(new Estate("Intramuros", 16, 160, false, new TitleDeed(14, 70, 200, 550, 750, 950, 90, 100)));		//orange
		block[17] = new Block("Community Chest", 17);//chest	
		block[18] = new Block(new Estate("C-5 Road", 18, 180, false, new TitleDeed(14, 70, 200, 550, 750, 950, 90, 100)));			//orange
		block[19] = new Block(new Estate("China Town", 19, 200, false, new TitleDeed(16, 80, 220, 600, 800, 1000, 100, 100)));		//orange		
		block[20] = new Block("Free Parking", 20);
		
		block[21] = new Block(new Estate("NLEX", 21, 220, false, new TitleDeed(18, 90, 250, 700, 875, 1050, 110, 150)));				//red
		block[22] = new Block("Chance", 22);				//chance
		block[23] = new Block(new Estate("National Bookstore", 23, 220, false, new TitleDeed(18, 90, 250, 700, 875, 1050, 110, 150)));//red
		block[24] = new Block(new Estate("Trinoma", 24, 240, false, new TitleDeed(20, 100, 300, 750, 925, 1100, 120, 150)));			//red
		block[25] = new Block(new Station("Taft Ave. Station", 25, 200, false, new TitleDeed(25, 50, 100, 200, 100)));//station
		block[26] = new Block(new Estate("EDSA", 26, 250, false, new TitleDeed(22, 110, 330, 800, 975, 1150, 130, 150)));				//yellow
		block[27] = new Block(new Estate("Magsaysay Bridge", 27, 250, false, new TitleDeed(22, 110, 330, 800, 975, 1150, 130, 150)));	//yellow
		block[28] = new //Block(new Utilities("Maynilad", 28, 150, false, new TitleDeed()));		//utility
		block[29] = new Block(new Estate("Star City", 29, 260, false, new TitleDeed(24, 120, 360, 850, 1025, 1200, 140, 150)));		//yellow
		block[30] = new Block("Go to Jail", 30);						//go to jail
		
		block[31] = new Block(new Estate("Landmark", 31, 300, false, new TitleDeed(26, 130, 390, 900, 1100, 1275, 150, 200)));			//green
		block[32] = new Block(new Estate("Glorietta", 32, 300, false, new TitleDeed(26, 130, 390, 900, 1100, 1275, 150, 200)));		//green
		block[33] = new Block("Community Chest", 33);//chest
		block[34] = new Block(new Estate("Greenbelt", 34, 320, false, new TitleDeed(28, 150, 450, 1000, 1200, 1400, 160, 200)));		//green
		block[35] = new Block(new Station("North Edsa Station", 35, 200, false, new TitleDeed(25, 50, 100, 200, 100)));//station
		block[36] = new Block("Chance", 36);				//chance
		block[37] = new Block(new Estate("Boracay Island", 37, 350, false, new TitleDeed(35, 175, 500, 1100, 1300, 1500, 200, 200)));	//dark blue
		block[38] = new Block("Super Tax", 38);				//tax
		block[39] = new Block(new Estate("SM Mall of Asia", 39, 400, false, new TitleDeed(50, 200, 600, 1400, 1700, 2000, 200, 200)));	//dark blue
	}

///////////////////////////////////GETTERS AND SETTERS///////////////////////////////
	public void setBlock(Block[] block) {
		this.block = block;
	}

	public Block[] getBlock() {
		return block;
	}

}
