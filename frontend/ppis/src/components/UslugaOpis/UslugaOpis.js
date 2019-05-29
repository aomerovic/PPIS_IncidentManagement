import React, { Component } from 'react';

import NavBar from '../NavBar/NavBar'

import './UslugaOpis.css'

class UslugaOpis extends Component {

  


  render() {
    return (
      <div className="HomePage">
        
        <NavBar></NavBar>
        <div className="naslov"> {this.props.name}</div>
        
        <div className="op">

        <p className="detaljno">{this.props.opis} 
        <p className="cijenaopis">{this.props.cijena} KM/Mjesečno</p>
        </p> 
        
        

        </div> 
      </div>
    );
  }
}

export default UslugaOpis;
