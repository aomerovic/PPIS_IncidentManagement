import React, { Component } from 'react';
import PrijavaForm from './PrijavaIncidentaForm';
import NavBar from '../NavBarUser/NavBar';
import {Redirect} from 'react-router-dom';



import './PrijavaIncidenta.css';

class PrijavaIncidenta extends Component {

  


  render() {
    if(localStorage.getItem('prijavljen')==="false"){
      return <Redirect to="/login"></Redirect>
    }
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
