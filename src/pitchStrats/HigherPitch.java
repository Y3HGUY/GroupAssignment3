package pitchStrats;

public class HigherPitch implements PitchStrats{
	public int modifyPitch(int note) {
		return Math.min(note + 2, 127);
	}
}
