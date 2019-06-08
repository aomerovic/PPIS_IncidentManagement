import React, { Component } from 'react';
import NavBar from '../NavBarManager/NavBar';
import {
  BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend,
} from 'recharts';
import './HomePage.css'

class HomePage extends Component {

 

  render() {
    var webstranica = [
      {
        name: 'rješeni', rjeseni: 7, aktivni: 3, ukupno: 10,
      }
    ];
    
  
    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> Statistika</div>

       

        <div className="podnaslov"> Web stranica</div>
        <div className="podaci">

          <p className="naziv">Ukupna broj prijavljenih incidenata: 10</p>
          <p className="naziv">Ukupna broj aktivnih incidenata: 3</p>
          <p className="naziv">Ukupna broj rješenih incidenata: 7</p>
          <br></br>
          <div className="chart">
          <BarChart
              width={300}
              height={300}
              data={webstranica}
              margin={{
                top: 5, right: 30, left: -20, bottom: 5,
              }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <YAxis />
              <Tooltip />
              <Legend />
              
              <Bar dataKey="rjeseni" fill="#498fff" />
              <Bar dataKey="aktivni" fill="red" />
              
        </BarChart>
        </div>

        </div>
        
       
        <div className="podnaslov"> Sistem za upravljanje uposlenicima</div>
        <div className="podnaslov"> Sistem za upravljanje poslovanjem</div>
        <div className="podnaslov"> Sistem za upravljanje rezervacijama</div>

        <div className="body">          
        

          
          
        </div>
        

      </div>
    );
  }
}

export default HomePage;
