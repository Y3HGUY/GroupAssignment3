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


public class Main {

	public static void main(String[] args) {
		try {
		List<MidiEventData> midiEvents = EventParser.parseCsv("./src/mystery_song.csv");
		
		Sequence sequence = new Sequence(Sequence.PPQ, 384);
		Track track = sequence.createTrack();
		
		MidiEventFactoryAbsInterface factoryAbstract = new StandardMidiEventAbstract();
		MidiEventFactory factory = factoryAbstract.createFactory();
		
		//instrument Strats
		
		PitchStrats pitchStrats = new HigherPitch();
		
		
		for (MidiEventData event : midiEvents) {
			int modifiedNote = pitchStrats.modifyPitch(event.getNote());
			
			if (event.getNote_on_off() == ShortMessage.NOTE_ON) {
				track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getChannel(), event.getVelocity()));
			} else {
				track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
			}
		}
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
