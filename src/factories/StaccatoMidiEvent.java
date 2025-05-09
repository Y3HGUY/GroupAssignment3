package factories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
/**
 * Staccato implementation of MidiEvetFactory
 * Shortens tick - 120 for shorten notes 
 */
public class StaccatoMidiEvent implements MidiEventFactory {
	@Override
	public MidiEvent createNoteOn(int tick, int note,int velocity,int channel) throws InvalidMidiDataException{
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(message, tick);
	}
	
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0 );
		return new MidiEvent(message, tick - 120 ); // Shorten
	}
}
