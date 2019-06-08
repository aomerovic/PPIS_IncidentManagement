import React, { Component } from 'react';
import NavBar from '../NavBarUser/NavBar';
import './HomePage.css';
import {Redirect} from 'react-router-dom';
class HomePage extends Component {

 

  render() {
    if(localStorage.getItem('prijavljen')==="false"){
      return <Redirect to="/login"></Redirect>
    }
    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> User Panel</div>

        <div className="podnaslov"> Prijavljenje usluge</div>

        <div className="prijavljenausluga">
            <p><p className="naziv">Web stranica</p> </p><button className="odjavi">Odjavi uslugu</button>
            
        </div>

        <div className="prijavljenausluga">
            <p><p className="naziv">Sistem za upravljanje uposlenicima</p> </p><button className="odjavi">Odjavi uslugu</button>
            
        </div>

        <div className="podnaslov"> Neprijavljenje usluge</div>

        <div className="prijavljenausluga">
            <p><p className="naziv">Sistem za upravljanje poslovanjem</p> </p><button className="odjavi">Prijavi uslugu</button>
            
        </div>

        <div className="prijavljenausluga">
            <p><p className="naziv">Sistem za rezervacije</p> </p><button className="odjavi">Prijavi uslugu</button>
            
        </div>

        <div className="podnaslov"> Prijavljeni incidenti</div>

        <div className="prijavljeniincident">
            <p className="naziv">IncidnetId: 10</p>
            <p className="naziv">Usluga: Održavanje web stranice</p>
            <p className="naziv">Datum prijavljivanja: 20.5.2019</p>
            <p className="naziv">Opis incidenta:</p>
            <p className="naziv">Potrebno dodati novi broj telefona hotela</p>
            <p className="naziv">Status: Rješen</p>
            <p className="naziv">Odgovor:</p>
            <p className="naziv">Dodan novi broj telefona hotela</p>

            
        </div>

        <div className="prijavljeniincident">
            <p className="naziv">IncidnetId: 12</p>
            <p className="naziv">Usluga: Sistem za rezervacije</p>
            <p className="naziv">Datum prijavljivanja: 25.5.2019</p>
            <p className="naziv">Opis incidenta:</p>
            <p className="naziv">Ne radi</p>
            <p className="naziv">Status: Odbijen</p>
            <p className="naziv">Odgovor:</p>
            <p className="naziv">Nedovoljo jasan opis incidenta</p>
            
        </div>
        

        <div className="body">

       
          
          
        </div>
        

      </div>
    );
  }
}

export default HomePage;
