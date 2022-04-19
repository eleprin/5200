package timetracker.trackinglist;
import java.awt.Color;
import java.util.Random;

/**
 * Category of activities.
 * Enable grouping of activities into categories,
 * and utilizes color to differentiate when displaying
 * categories.
 * @author Daniel S. Wagner
 *
 */
public class ActivityCategory {
	private String name;
	private Color color;
	
	public ActivityCategory(String name, Color color) {
		this.name = name;
		this.color = color;
	}
	
	public ActivityCategory(String name) {
		this.name = name;
		this.color = getRandomColor();
	}
	
	private Color getRandomColor() {
		Random random = new Random();
		final float hue = random.nextFloat();
		// Saturation between 0.1 and 0.3
		final float saturation = (random.nextInt(2000) + 1000) / 10000f;
		final float luminance = 0.9f;
		final Color color = Color.getHSBColor(hue, saturation, luminance);
		return color;
	}

}