package edu.examples.java_classes.dao.impl;

import java.util.List;

import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao{

	@Override
	public void save(Note n) {
		MockSource.add(n);
		
	}

	@Override
	public List<Note> allNotes() {
		return MockSource.get();
	}

}
