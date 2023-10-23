import React from 'react';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./pages/Layout";
import NotFound from "./pages/NotFound";
import Main from "./pages/Main";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route path="*" element={<NotFound/>}/>
                    <Route index element={<Main/>}/>
                    <Route path="not-found" element={<NotFound/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
