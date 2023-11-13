import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
    const isLoggedIn = false;
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
             <div id="contentDiv" style={{ clear: 'right' }}>
               <nav style={{ clear: 'right' }}>
                 <div className="nav nav-tabs" id="nav-tab" role="tablist">
                   <Link
                     to="/files"
                     className="nav-item nav-link active"
                     id="nav-files-tab"
                   >
                     Files
                   </Link>
                   <Link
                     to="/notes"
                     className="nav-item nav-link"
                     id="nav-notes-tab"
                   >
                     Notes
                   </Link>
                 </div>
               </nav>
               {/* The rest of your HTML content goes here */}
             </div>
           </div>
    );

}

export default Home;