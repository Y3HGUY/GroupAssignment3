package pitchStrats;

public class LowerPitch implements PitchStrats{
	public int modifyPitch(int note) {
		return Math.max(note -2, 0);
	}
}
