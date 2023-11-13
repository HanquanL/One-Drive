import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function Login(){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleLogin = (e) => {
        e.preventDefault();
        // Implement login logic here
        // Example: You might use Axios to send a login request to your backend
        // If login is successful, navigate to the home page
        // If login is unsuccessful, display an error message
        navigate("/",{state: { username: username, password: password }},);
    };

    return (
        <div className="container justify-content-center w-25 p-3" style={{ backgroundColor: '#eeeeee', marginTop: '5em' }}>
              <h1 className="display-5">Login</h1>
              <form onSubmit={handleLogin}>
                <div className="alert alert-danger">
                  Invalid username or password
                </div>
                <div className="alert alert-dark">
                  You have been logged out
                </div>
                <div className="form-group">
                  <label htmlFor="inputUsername">Username</label>
                  <input
                    type="input"
                    className="form-control"
                    name="username"
                    id="inputUsername"
                    placeholder="Enter Username"
                    maxLength="20"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    required
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="inputPassword">Password</label>
                  <input
                    type="password"
                    className="form-control"
                    name="password"
                    id="inputPassword"
                    placeholder="Enter Password"
                    maxLength="20"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                  />
                </div>
                <button type="submit" className="btn btn-primary" id="login-button">Login</button>
              </form>

              <div className="form-group" style={{ marginTop: '0.5em' }}>
                <label><a>Click here to sign up</a></label>
              </div>
            </div>
    );
}

export default Login;