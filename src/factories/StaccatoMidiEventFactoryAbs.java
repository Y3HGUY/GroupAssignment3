package factories;
/**
 * Abstract factory that produces StaccatoMidiEventFactory 
 */
public class StaccatoMidiEventFactoryAbs implements MidiEventFactoryAbsInterface {
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEvent();
	}
	
}
