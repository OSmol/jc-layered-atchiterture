package edu.examples.java_classes.dao;

import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

	void save(Note n);

	List<Note> allNotes();

}
