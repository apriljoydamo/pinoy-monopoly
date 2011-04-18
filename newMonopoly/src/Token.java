
import javax.swing.JLabel;


public class Token extends JLabel{
        
        private static final long serialVersionUID = 1L;
        private int xLocation = 525;
        private int yLocation = 525;
        private int assignedToken;
        
        public Token(){
        }
         
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////GETTER AND SETTER/////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        public void setxLocation(int xLocation) {
                this.xLocation = xLocation;
        }
        
        public int getxLocation() {
                return xLocation;
        }
        
        public void setyLocation(int yLocation) {
                this.yLocation = yLocation;
        }
        
        public int getyLocation() {
                return yLocation;
        }


        public void setAssignedToken(int assignedToken) {
                this.assignedToken = assignedToken;
        }


        public int getAssignedToken() {
                return assignedToken;
        }
}