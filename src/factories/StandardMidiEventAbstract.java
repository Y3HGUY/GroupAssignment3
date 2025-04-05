package factories;
/**
 * Abstract factory that produces StandardMidiEventFactory 
 */
public class StandardMidiEventAbstract implements MidiEventFactoryAbsInterface {
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}
	
	
}
