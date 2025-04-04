package parser;

import data.MidiEventData;

import java.io.*;
import java.util.*;
import javax.sound.midi.ShortMessage;

public class EventParser {
	public static List<MidiEventData> parseCsv(String path) throws IOException{
		List<MidiEventData> events = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) continue;
				
				String[] tokens = line.split(",");
				int startEndTick = Integer.parseInt(tokens[0].trim());
				int note_on_off = tokens[1].contains("on") ? javax.sound.midi.ShortMessage.NOTE_ON : javax.sound.midi.ShortMessage.NOTE_OFF;
				int channel = Integer.parseInt(tokens[2].trim());
				int note = Integer.parseInt(tokens[3].trim());
				int velocity = Integer.parseInt(tokens[4].trim());
				int instrument = Integer.parseInt(tokens[5].trim());
				
				events.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, note_on_off));
			}
		}
		return events;
	}
}
