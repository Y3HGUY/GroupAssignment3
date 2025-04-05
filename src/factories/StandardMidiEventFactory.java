package factories;

import javax.sound.midi.*;

public class StandardMidiEventFactory implements MidiEventFactory {
	public MidiEvent createNoteOn(int tick, int note,int velocity,int channel) throws InvalidMidiDataException{
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(message, tick);
	}
	
}
