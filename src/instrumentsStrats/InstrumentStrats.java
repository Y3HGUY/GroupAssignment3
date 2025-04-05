package instrumentsStrats;

import javax.sound.midi.*;


public interface InstrumentStrats {
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException ;
}
