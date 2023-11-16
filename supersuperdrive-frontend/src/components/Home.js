import React, {useState} from 'react';
import { Link } from 'react-router-dom';
import {Modal, Button, Form} from 'react-bootstrap';

function Home() {
    const isLoggedIn = false;
    const[show, setShow] = useState(false);
    const[notes, setNotes] = useState([]);
    const[files, setFiles] = useState([]);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
       <div className="container">
             <div id="logoutDiv">
               {isLoggedIn ? (
                 <form action="#" method="POST">
                   <button
                     type="submit"
                     className="btn btn-secondary float-right"
                   >
                     Logout
                   </button>
                 </form>
               ) : (
                 <Link to="/login" className="btn btn-primary float-right">
                   Login
                 </Link>
               )}
             </div>
             <h2>Notes</h2>
                         {notes.map(note => (
                             <div key={note.id}>
                                 <h3>{note.title}</h3>
                                 <p>{note.content}</p>
                             </div>
                         ))}

                         <h2>Files</h2>
                         {files.map(file => (
                             <div key={file.id}>
                                 <h3>{file.name}</h3>
                                 <p>{file.description}</p>
                             </div>
                         ))}

                         <Button variant="primary" onClick={handleShow}>
                             Add Note/File
                         </Button>

                         <Modal show={show} onHide={handleClose}>
                             <Modal.Header closeButton>
                                 <Modal.Title>Add Note/File</Modal.Title>
                             </Modal.Header>
                             <Modal.Body>
                                 <Form>
                                     {/* Replace with your form for adding a note/file */}
                                     <Form.Group controlId="formBasicEmail">
                                         <Form.Label>Title</Form.Label>
                                         <Form.Control type="text" placeholder="Enter title" />
                                     </Form.Group>

                                     <Form.Group controlId="formBasicPassword">
                                         <Form.Label>Content</Form.Label>
                                         <Form.Control type="text" placeholder="Enter content" />
                                     </Form.Group>
                                 </Form>
                             </Modal.Body>
                             <Modal.Footer>
                                 <Button variant="secondary" onClick={handleClose}>
                                     Close
                                 </Button>
                                 <Button variant="primary" onClick={handleClose}>
                                     Save Changes
                                 </Button>
                             </Modal.Footer>
                         </Modal>
           </div>
    );

}

export default Home;