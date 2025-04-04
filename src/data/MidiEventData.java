package data;
/**
 * single MIDI event parsed form CSV file
 */
public class MidiEventData {
	private int startEndTick, velocity, note, channel, instrument, note_on_off;
	
	
	public MidiEventData (int startEndtick, int velocity, int note, int channel, int instrument, int note_on_off) {
		this.startEndTick = startEndtick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.instrument = instrument;
		this.note_on_off = note_on_off;
	}
	
	// Getters
	
	public int getStartEndTick() {
		return startEndTick;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getNote() {
		return note;
	}

	public int getChannel() {
		return channel;
	}

	public int getInstrument() {
		return instrument;
	}

	public int getNote_on_off() {
		return note_on_off;
	}

	//setters
	
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}

	public void setNote_on_off(int note_on_off) {
		this.note_on_off = note_on_off;
	}
	
	
	
	
	
}
