package timetracker.model.activity;
import java.awt.Color;
import java.util.Objects;
import java.util.Random;

/**
 * Category of activities.
 * Enable grouping of activities into categories,
 * and utilizes color to differentiate when displaying
 * categories.
 * @author Daniel S. Wagner
 *
 */

//todo enable choice of color. These things are really personal. Add color picker.

public class ActivityCategory {
	private String name;
	private Color color;
	private int totalMinutes;
	
	public ActivityCategory(String name, Color color) {
		this.name = name;
		this.color = color;
		this.totalMinutes = 0;
	}
	
	public ActivityCategory(String name) {
		this.name = name;
		this.color = getRandomColor();
		this.totalMinutes = 0;
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

	@Override
	public int hashCode() {
		return Objects.hash(color, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityCategory other = (ActivityCategory) obj;
		return Objects.equals(color, other.color) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Category: " + name;
	}

}
