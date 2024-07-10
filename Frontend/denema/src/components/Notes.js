import React, { useState, useEffect } from 'react';//gereli hookların importu.
import axios from 'axios';//axios kütüphanesi.
import './Notes.css';

const Notes = () => {
    const [notes, setNotes] = useState([]);//notlar dizisini güncellemek için method.
    const [newNoteTitle, setNewNoteTitle] = useState('');//yeni notun başlığını saklamak için state.(dto)
    const [newNoteContent, setNewNoteContent] = useState('');
    const [error, setError] = useState('');//hata yı saklamak.

    useEffect(() => { //sayfa yüklendiğinde notları getir.
        fetchNotes();
    }, []);

    const fetchNotes = async () => {
        try {
            //axios.default.baseURL = http://localhost:8080
            const response = await axios.get('http://localhost:8080/api/notes');//notları backend ten getirme.
            setNotes(response.data);//gelen notları state e alma.
        } catch (error) {
            setError('Failed to fetch notes.');//hata durumları.
        }
    };

    const handleSaveNote = async () => {
        if (!newNoteTitle || !newNoteContent) {
            setError('Title and content cannot be empty.'); //kullanıcı alanları boş bırakamasın.
            return;
        }

        try {
            const response = await axios.post('http://localhost:8080/api/notes/add-note', {//yeni notları backend e yollama.
                title: newNoteTitle,
                content: newNoteContent,
            });
            if (response.data) {//not başarılı kaydedilirse.
                setNewNoteTitle('');//yeni not başlığını sıfırla.
                setNewNoteContent('');
                fetchNotes();//güncellenmiş notları getir.
            }
        } catch (error) {
            setError('Failed to save note.');
        }
    };

    const deleteNote = async (id) => { //silme işlemi.
        try {
            await axios.delete(`http://localhost:8080/api/notes/${id}`);
            fetchNotes();
        } catch (error) {
            setError('Failed to delete note.');
        }
    };

    return ( //html kısmı.
        <div className={"ntdiv"}>
            <h2 className={"nth1"}>Notes</h2>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <input

                type="text"
                className={"txtfield"}
                value={newNoteTitle}
                onChange={(e) => setNewNoteTitle(e.target.value)}
                placeholder="Enter your note title..."

            />
            <br/>
            <textarea

                className={"txtarea"}
                value={newNoteContent}
                onChange={(e) => setNewNoteContent(e.target.value)}
                placeholder="Enter your note content..."
                rows="4"
                cols="50"

            />
            <br />
            <button onClick={handleSaveNote} className={"ntbtn"}>Save Note</button>
            <hr />
            <h3>Existing Notes:</h3>
            {notes.map((note) => (
                <div key={note.id} className="card">
                    <h4>{note.title}</h4>
                    <p>{note.content}</p>
                    <button onClick={() => deleteNote(note.id)} className="delbtn">Delete</button>
                </div>
            ))}
        </div>
    );
};

export default Notes;
