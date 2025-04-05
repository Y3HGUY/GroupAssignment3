package instrumentsStrats;

import javax.sound.midi.*;
/**
 * Defines instrument strats
 */

public interface InstrumentStrats {
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException ;
}
