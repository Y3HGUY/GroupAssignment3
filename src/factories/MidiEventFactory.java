package factories;

import javax.sound.midi.*;

/**
 * Core interface to for factories
 * 
 */

public interface MidiEventFactory {
	/**
	 * Creates midi notes
	 * 
	 * @param tick, when the note should begin
	 * @param note, pitch of sound
	 * @param velocity, volume of sound
	 * @param channel, place to send messages
	 * @return For midiEvent to be on 
	 * 
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	/**
	 * 
	 * @param tick when note should end 
	 * @param note pitch sound
	 * @param channel where to send message
	 * @return midiEvent for off
	 * @throws InvalidMidiDataException
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;
}
