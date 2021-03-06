import React, { Component } from 'react';
import {Redirect} from 'react-router-dom';
import NavBar from '../NavBarUser/NavBar';

import './UslugaOpis.css';

class UslugaOpis extends Component {

  


  render() {
    if(localStorage.getItem('prijavljen')==="false"){
      return <Redirect to="/login"></Redirect>
    }
    return (
      <div className="HomePage">
        
        <NavBar></NavBar>
        <div className="naslov"> {this.props.name}</div>
        
        <div className="op">

        <p className="detaljno">{this.props.opis} 
        <p className="cijenaopis">{this.props.cijena} KM/Mjesečno</p>

        <a href="/userpanel">
        <button className="prijaviodjavi">Prijavi/Odjavi uslugu</button>
        </a>
        </p> 
        
       
        

        </div> 
      </div>
    );
  }
}

export default UslugaOpis;
