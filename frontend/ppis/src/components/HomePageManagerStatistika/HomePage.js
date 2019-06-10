import React, { Component } from 'react';
import NavBar from '../NavBarManager/NavBar';
import {
  BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend,
} from 'recharts';
import {Redirect} from 'react-router-dom';
import './HomePage.css'

class HomePage extends Component {

  constructor(props) {
    super(props);

      this.state = {
        isLoading:true,
        incidenti:[],
        u1:0,
        u1r:0,
        u2:0,
        u2r:0,
        u3:0,
        u3r:0,
        u4:0,
        u4r:0,
      };
      
  }

  componentDidMount(){
    fetch('/incident')
    .then((response) => response.json())
    .then((responseJson) => {
      var o=Object.keys(responseJson).length
      var u1=0;
      var u1r=0;
      var u2=0;
      var u2r=0;
      var u3=0;
      var u3r=0;
      var u4=0;
      var u4r=0;
      for( var i=0;i<o;i++){

        if(responseJson[i].service.service==="Izrada web stranice"){
            u1=u1+1
            if(responseJson[i].sid==="riješen" || responseJson[i].sid==="odbijen"){
              u1r=u1r+1
            }
        }    

        if(responseJson[i].service.service==="Upravljanje rezervacijama"){
          u2=u2+1
          if(responseJson[i].sid==="riješen" || responseJson[i].sid==="odbijen"){
            u2r=u2r+1
          }
        } 

        if(responseJson[i].service.service==="Upravljanje uposlenicima"){
          u3=u3+1
          if(responseJson[i].sid==="riješen" || responseJson[i].sid==="odbijen"){
            u3r=u3r+1
          }
        }   
        
        if(responseJson[i].service.service==="Upravljanje poslovanjem"){
          u4=u4+1
          if(responseJson[i].sid==="riješen" || responseJson[i].sid==="odbijen"){
            u4r=u4r+1
          }
        }  

      }       
    this.setState({
    incidenti:responseJson,
    isLoading:false,
    u1:u1,
    u1r:u1r,
    u2:u2,
    u2r:u2r,
    u3:u3,
    u3r:u3r,
    u4:u4,
    u4r:u4r

    }
    )
    })
  }


  render() {
    if(localStorage.getItem('role')!=="incidentmanager"){
      return <Redirect to="/login"></Redirect>
    }
    if(this.state.isLoading){
      return(
      <div>Loading</div>
      )
      }
    var webstranica = [
      {
        name: 'riješeni', rijeseni: this.state.u1r, aktivni: this.state.u1-this.state.u1r, ukupno: this.state.u1,
      }
    ];
    var rezervacije = [
      {
        name: 'riješeni', rijeseni: this.state.u2r, aktivni: this.state.u2-this.state.u2r, ukupno: this.state.u2,
      }
    ];

    var uposleni = [
      {
        name: 'riješeni', rijeseni: this.state.u3r, aktivni: this.state.u3-this.state.u3r, ukupno: this.state.u3,
      }
    ];

    var poslovanje = [
      {
        name: 'riješeni', rijeseni: this.state.u4r, aktivni: this.state.u4-this.state.u4r, ukupno: this.state.u4,
      }
    ];
    
  
    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> Statistika</div>

       

        <div className="podnaslov"> Web stranica</div>
        <div className="podaci">

          <p className="naziv">Ukupna broj prijavljenih incidenata: {this.state.u1}</p>
          <p className="naziv">Ukupna broj aktivnih incidenata: {this.state.u1-this.state.u1r}</p>
          <p className="naziv">Ukupna broj riješenih incidenata: {this.state.u1r}</p>
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
              
              <Bar dataKey="rijeseni" fill="#498fff" />
              <Bar dataKey="aktivni" fill="red" />
              
        </BarChart>
        </div>

        </div>
        
       
        <div className="podnaslov"> Sistem za upravljanje uposlenicima</div>
        <div className="podaci">

          <p className="naziv">Ukupna broj prijavljenih incidenata: {this.state.u3}</p>
          <p className="naziv">Ukupna broj aktivnih incidenata: {this.state.u3-this.state.u3r}</p>
          <p className="naziv">Ukupna broj riješenih incidenata: {this.state.u3r}</p>
          <br></br>
          <div className="chart">
          <BarChart
              width={300}
              height={300}
              data={uposleni}
              margin={{
                top: 5, right: 30, left: -20, bottom: 5,
              }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <YAxis />
              <Tooltip />
              <Legend />
              
              <Bar dataKey="rijeseni" fill="#498fff" />
              <Bar dataKey="aktivni" fill="red" />
              
        </BarChart>
        </div>

        </div>
        <div className="podnaslov"> Sistem za upravljanje poslovanjem</div>

        <div className="podaci">

            <p className="naziv">Ukupna broj prijavljenih incidenata: {this.state.u4}</p>
            <p className="naziv">Ukupna broj aktivnih incidenata: {this.state.u4-this.state.u4r}</p>
            <p className="naziv">Ukupna broj riješenih incidenata: {this.state.u4r}</p>
            <br></br>
            <div className="chart">
            <BarChart
                width={300}
                height={300}
                data={poslovanje}
                margin={{
                  top: 5, right: 30, left: -20, bottom: 5,
                }}
              >
                <CartesianGrid strokeDasharray="3 3" />
                <YAxis />
                <Tooltip />
                <Legend />
                
                <Bar dataKey="rijeseni" fill="#498fff" />
                <Bar dataKey="aktivni" fill="red" />
                
            </BarChart>
            </div>

        </div>      

        <div className="podnaslov"> Sistem za upravljanje rezervacijama</div>

        <div className="podaci">

          <p className="naziv">Ukupna broj prijavljenih incidenata: {this.state.u2}</p>
          <p className="naziv">Ukupna broj aktivnih incidenata: {this.state.u2-this.state.u2r}</p>
          <p className="naziv">Ukupna broj riješenih incidenata: {this.state.u2r}</p>
          <br></br>
          <div className="chart">
          <BarChart
              width={300}
              height={300}
              data={rezervacije}
              margin={{
                top: 5, right: 30, left: -20, bottom: 5,
              }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <YAxis />
              <Tooltip />
              <Legend />
              
              <Bar dataKey="rijeseni" fill="#498fff" />
              <Bar dataKey="aktivni" fill="red" />
              
        </BarChart>
        </div>

        </div>

        <div className="body">          
        

          
          
        </div>
        

      </div>
    );
  }
}

export default HomePage;
