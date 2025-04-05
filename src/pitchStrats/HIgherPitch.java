package pitchStrats;

public class HIgherPitch {
	public int modifyPitch(int note) {
		return Math.min(note + 2, 127);
	}
}
