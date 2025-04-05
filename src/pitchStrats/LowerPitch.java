package pitchStrats;

public class LowerPitch {
	public int modifyPitch(int note) {
		return Math.max(note -2, 0);
	}
}
