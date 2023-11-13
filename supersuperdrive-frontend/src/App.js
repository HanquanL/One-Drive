import React from 'react';
import{ BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Home from './components/Home';
import Login from './components/Login';
import Signup from './components/Signup';
import Result from './components/Result';

function App() {

  return (
    <Router>
        <div className="App">
            <Routes>
                <Route path="/" element={<Home />}/>
                <Route path="/login" element={<Login />}/>
                <Route path="/signup" element={<Signup />}/>
                <Route path="/result" element={<Result />}/>
            </Routes>
        </div>
    </Router>
    );
}

export default App;
