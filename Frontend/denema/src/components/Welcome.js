import React from 'react';
import { Link } from 'react-router-dom';//router işlemleri için router dom methodu.
import './Welcome.css';//harici css.

const Welcome = () => { //html tarafı.
    return (
        <container>
            <div className={"hgdiv2"}>
                <div className={"hgdiv"}>
                    <h1 className={"hgh1"}>Not Uygulamasına Hoş Geldiniz..</h1>
                    <p className={"paragraf"}>Notlarım Butonuna basarak not tutmaya başlayabilirsiniz</p>
                    <Link to="/notes">
                        <button className={"btn"}>Notlarım</button>
                    </Link>
                </div>
            </div>

        </container>

    );
};

export default Welcome;
