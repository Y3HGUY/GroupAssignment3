package factories;
/**
 * Abstract factory that produces Legato
 */
public class LegattoMidiEventAbstract implements MidiEventFactoryAbsInterface {
	public MidiEventFactory createFactory() {
		return new LegatoMidiEvent();	
	}
}
