import React, { Component } from 'react';
import PrijavaForm from './PrijavaIncidentaForm';
import NavBar from '../NavBarUser/NavBar';



import './PrijavaIncidenta.css';

class PrijavaIncidenta extends Component {
  render() {
    return (
     
      <div className="LoginPage">
        
        <NavBar />
        
        <div className="naslov"> Prijava incidenta </div>
        
        <div className="body">

          <PrijavaForm />

        </div>
        

      </div>
      
    );
  }
}

export default PrijavaIncidenta;
