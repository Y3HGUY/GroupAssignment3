package instrumentsStrats;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
/**
 * implementation of the ElectricBass instrument strategy 
 */

public class ElectricBassGuitarStrat implements InstrumentStrats{
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage msg = new ShortMessage();
		msg.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
		track.add(new MidiEvent(msg,0));
	}
}
