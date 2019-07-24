package changepaneshape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 * 
 * The class below changes the size of the tabs from rectangle to trapezoid and also lets the user to change the color of the test used within the tabs.
 * @author Java Swing Tips 
 * This code was taken form https://java-swing-tips.blogspot.com/2017/01/change-tab-shape-of-jtabbedpane-to.html
 */
public class IsoscelesTrapezoidTabbedPaneUI  extends BasicTabbedPaneUI {
	private final Insets borderInsets = new Insets(3,3,3,3);
	private static final int ADJ2 = 3;
	  private final Color selectedTabColor = Color.RED;
	  private final Color tabBackgroundColor = Color.BLACK;
	  private final Color tabBorderColor = Color.RED;

	  @Override protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) { //NOPMD
	    int tabCount = tabPane.getTabCount();

	    Rectangle iconRect = new Rectangle(),
	    textRect = new Rectangle();
	    Rectangle clipRect = g.getClipBounds();

	    for (int i = runCount - 1; i >= 0; i--) {
	      int start = tabRuns[i];
	      int next = tabRuns[(i == runCount - 1) ? 0 : i + 1];
	      int end = next != 0 ? next - 1 : tabCount - 1; //NOPMD
	      for (int j = end; j >= start; j--) {
	        if (j != selectedIndex && rects[j].intersects(clipRect)) {
	          paintTab(g, tabPlacement, rects, j, iconRect, textRect);
	        }
	      }
	    }
	    if (selectedIndex >= 0 && rects[selectedIndex].intersects(clipRect)) {
	      paintTab(g, tabPlacement, rects, selectedIndex, iconRect, textRect);
	    }
	  }
	  @Override protected void paintTabBorder(
	      Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
	     

	  }
	  @Override protected void paintFocusIndicator(
	      Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
	      Rectangle iconRect, Rectangle textRect, boolean isSelected) {
	   
	  }
	  @Override protected void paintContentBorderTopEdge(
	      Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
	    super.paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
	    Rectangle selRect = getTabBounds(selectedIndex, calcRect);
	    Graphics2D g2 = (Graphics2D) g.create();
	    g2.setColor(selectedTabColor);
	    g2.drawLine(selRect.x - ADJ2 + 1, y, selRect.x + selRect.width + ADJ2 - 1, y);
	    g2.dispose();
	  }
	  @Override protected void paintTabBackground(
	      Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
	    Graphics2D g2 = (Graphics2D) g.create();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    int textShiftOffset = isSelected ? 0 : 1;

	    Rectangle clipRect = g2.getClipBounds();
	    clipRect.grow(ADJ2 + 1, 0);
	    g2.setClip(clipRect);

	    GeneralPath trapezoid = new GeneralPath();
	    trapezoid.moveTo(x - ADJ2,     y + h);
	    trapezoid.lineTo(x + ADJ2,     y + textShiftOffset);
	    trapezoid.lineTo(x + w - ADJ2, y + textShiftOffset);
	    trapezoid.lineTo(x + w + ADJ2, y + h);
	    //trapezoid.closePath();

	    g2.setColor(isSelected ? selectedTabColor : tabBackgroundColor);
	    g2.fill(trapezoid);

	    g2.setColor(tabBorderColor);
	    g2.draw(trapezoid);

	    g2.dispose();
	  }
	  
		@Override
		protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {}
		@Override
		protected Insets getContentBorderInsets(int tabPlacement) {
			return borderInsets;
		}
	
	
	

}
