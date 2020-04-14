package note.dao;

import java.util.HashMap;
import java.util.List;

import note.util.SplitPage;
import note.vo.Note;

public interface NoteDAO {
      public void insert(Note note) throws Exception;
      public void update(Note note) throws Exception;
      public void delete(int id) throws Exception;
      public Note queryById(int id) throws Exception;
      public List<Note> queryAll() throws Exception;
      public List<Note> findAll(SplitPage sp)throws Exception;
      public int getRows(HashMap tm) throws Exception;
      public List<Note>  queryByLike(HashMap cond)throws Exception;
      public List<Note> queryByLike(HashMap cond,SplitPage sp)throws Exception;

}
