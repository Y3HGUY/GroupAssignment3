package factories;

import javax.sound.midi.*;

/**
 * Implements MidiEventFactory 
 * 
 */
public class StandardMidiEventFactory implements MidiEventFactory {
	public MidiEvent createNoteOn(int tick, int note,int velocity,int channel) throws InvalidMidiDataException{
		ShortMessage message = new ShortMessage();
		//set zero to read from csv
		int safeChannel = 0;
		message.setMessage(ShortMessage.NOTE_ON, safeChannel, note, velocity);
		return new MidiEvent(message, tick);
	}
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		//set zero to read from csv
		int safeChannel = 0;
		message.setMessage(ShortMessage.NOTE_OFF, safeChannel, note, 0 );
		return new MidiEvent(message, tick);
	}
	
}
