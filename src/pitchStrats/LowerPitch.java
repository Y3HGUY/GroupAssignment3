package pitchStrats;
/**
 * Modifies pitch for lower notes by - 2
 */
public class LowerPitch implements PitchStrats{
	public int modifyPitch(int note) {
		return Math.max(note -2, 0);
	}
}
