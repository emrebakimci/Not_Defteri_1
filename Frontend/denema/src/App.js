import React from 'react';
import {
    BrowserRouter,
    Routes,
    Route,
    Link
} from 'react-router-dom'
import Welcome from './components/Welcome';

import Notes from './components/Notes';

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route exact path="/" element={ <Welcome/>} />
                <Route path="/notes" element={<Notes />} />
            </Routes>
        </BrowserRouter>
    );
};

export default App;
