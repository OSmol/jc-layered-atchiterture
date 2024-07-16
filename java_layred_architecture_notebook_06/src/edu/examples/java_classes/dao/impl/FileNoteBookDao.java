package edu.examples.java_classes.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

	@Override
	public void save(Note n) throws DaoException{

		FileReader reader = null;
		try {
			reader = new FileReader("stub.txt");
			// ....
		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					throw new DaoException(e1);
				}
			}
		}
	}

	@Override
	public List<Note> allNotes() throws DaoException{
		return null;
	}

}
