package factories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
/**
 * Legato implementation of MidiEventfactory 
 * Increase duration by 80 ticks
 */
public class LegatoMidiEvent implements MidiEventFactory {
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
		return new MidiEvent(message, tick + 80); //extends duration 
	}

}
