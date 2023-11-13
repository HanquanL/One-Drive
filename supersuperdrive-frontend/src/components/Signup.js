import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Signup(){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [firstname, setFirstName] = useState("");
    const [lastname, setLastName] = useState("");
    const [successMessage, setSuccessMessage] = useState("");
    const [errorMessage, setErrorMessage] = useState("");
    const navigate = useNavigate();

    const handleSignup = (e) => {
        e.preventDefault();
        // Implement signup logic here
        // Example: You might use Axios to send a signup request to your backend
        // If signup is successful, navigate to the login page
        // If signup is unsuccessful, display an error message
        setSuccessMessage("You successfully signed up! Please continue to the login page.");
        navigate(
             '/login',
            {state: { username: username, password: password, firstname: firstname, lastname: lastname }
        },);
    };

    return(
       <div className="container justify-content-center w-50 p-3" style={{ backgroundColor: '#eeeeee', marginTop: '5em' }}>
             <div className="form-group">
               <label><a>Back to Login</a></label>
             </div>

             <h1 className="display-5">Sign Up</h1>
             <form onSubmit={handleSignup}>
               {successMessage && (
                 <div id="success-msg" className="alert alert-dark">
                   {successMessage}
                 </div>
               )}
               {errorMessage && (
                 <div className="alert alert-danger">
                   <span>{errorMessage}</span>
                 </div>
               )}
               <div className="form-row">
                 <div className="form-group col-md-6">
                   <label htmlFor="inputFirstName">First Name</label>
                   <input
                     type="input"
                     name="firstName"
                     className="form-control"
                     id="inputFirstName"
                     placeholder="Enter First Name"
                     maxLength="20"
                     value={firstname}
                     onChange={(e) => setFirstName(e.target.value)}
                     required
                   />
                 </div>
                 <div className="form-group col-md-6">
                   <label htmlFor="inputLastName">Last Name</label>
                   <input
                     type="input"
                     name="lastName"
                     className="form-control"
                     id="inputLastName"
                     placeholder="Enter Last Name"
                     maxLength="20"
                     value={lastname}
                     onChange={(e) => setLastName(e.target.value)}
                     required
                   />
                 </div>
               </div>
               <div className="form-row">
                 <div className="form-group col-md-6">
                   <label htmlFor="inputUsername">Username</label>
                   <input
                     type="input"
                     name="username"
                     className="form-control"
                     id="inputUsername"
                     placeholder="Enter Username"
                     maxLength="20"
                     value={username}
                     onChange={(e) => setUsername(e.target.value)}
                     required
                   />
                 </div>
                 <div className="form-group col-md-6">
                   <label htmlFor="inputPassword">Password</label>
                   <input
                     type="password"
                     name="password"
                     className="form-control"
                     id="inputPassword"
                     placeholder="Enter Password"
                     maxLength="20"
                     value={password}
                     onChange={(e) => setPassword(e.target.value)}
                     required
                   />
                 </div>
               </div>
               <button type="submit" className="btn btn-primary" id="buttonSignUp">
                 Sign Up
               </button>
             </form>
           </div>
    );
}

export default Signup;