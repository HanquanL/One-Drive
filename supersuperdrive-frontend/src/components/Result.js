import React from 'react';
import {Link} from 'react-router-dom';

function Result(){
  return(
     <div className="container justify-content-center w-50 p-3" style={{ marginTop: '5em' }}>
          <div className="alert alert-success fill-parent">
            <h1 className="display-5" id="success">Success</h1>
            <span>Your changes were successfully saved. Click <Link to="/">here</Link> to continue.</span>
          </div>
          <div className="alert alert-danger fill-parent">
            <h1 className="display-5">Error</h1>
            <span>Your changes were not saved. Click <Link to="/">here</Link> to continue.</span>
          </div>
          <div className="alert alert-danger fill-parent">
            <h1 className="display-5">Error</h1>
            <span>Example Error Message</span>
            <span>Click <Link to="/">here</Link> to continue.</span>
          </div>
        </div>
  );
}

export default Result;