package main;

import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import data.MidiEventData;
import parser.EventParser;
import pitchStrats.*;
import factories.*;
import instrumentsStrats.*;


public class Main {
/**
 * Main for interacting and playing midi sound 
 * choosing pitch 
 * choosing instruments
 * plays result in sequncer
 * @param args
 */
	public static void main(String[] args) {
		try {
		List<MidiEventData> midiEvents = EventParser.parseCsv("./src/mystery_song.csv");
		
		Sequence sequence = new Sequence(Sequence.PPQ, 384);
		Track track = sequence.createTrack();
		
		//implements factories
		MidiEventFactoryAbsInterface factoryAbstract = new StandardMidiEventAbstract();
		MidiEventFactory factory = factoryAbstract.createFactory();
		
		/**
		 * Set instrument to track zero - CSV track is zero 
		 */
		InstrumentStrats instrumentStrats = new TrumpetStrat();
		instrumentStrats.applyInstrument(track, 1);
		InstrumentStrats instrumentStrats1 = new ElectricBassGuitarStrat();
		instrumentStrats1.applyInstrument(track, 0);
		InstrumentStrats instrumentStrats2 = new AcousticGrandPianoStrat();
		instrumentStrats.applyInstrument(track, 2);
		
		
		//Pitch Strats
		PitchStrats pitchStrats = new HigherPitch();
		//PitchStrats pitchStrats = new LowerPitch();
		
		/**
		 * Generates events / uses pitch 
		 * 
		 */
		
		for (MidiEventData event : midiEvents) {
			
			int modifiedNote = pitchStrats.modifyPitch(event.getNote());
	
			if (event.getNote_on_off() == ShortMessage.NOTE_ON) {
				track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getChannel(), event.getVelocity()));
			} else {
				track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
			}
		}
		/**
		 * Start sequencer -> used from documentation 
		 */
		Sequencer sequencer = MidiSystem.getSequencer();
		sequencer.open();
		sequencer.setSequence(sequence);
		sequencer.start();
		
		while (sequencer.isRunning()) {
			Thread.sleep(100);
		}
		
		sequencer.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
