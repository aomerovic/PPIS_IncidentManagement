import React, { Component } from 'react';
import NavBar from '../NavBarUser/NavBar';
import './HomePage.css';
import {Redirect} from 'react-router-dom';
class HomePage extends Component {

  constructor(props){
    super(props);
    this.state ={ 
    isLoading: true,
    prijavljeneusluge:[],
    neprijavljeneusluge:[],
    redirect:false,
    ids:[2,3,4,5]
    }
    }
    componentDidMount(){

      var l=[]


      for(var i=2;i<=5;i++){
        
        fetch('/services/'+i).then((response) => response.json())
        .then((responseJson) => {
        l.push(responseJson)  
        this.setState({
        neprijavljeneusluge:l
        }
        )
        })
      }  

    fetch('/services/korisnikusluge/'+localStorage.getItem('id'))
    .then((response) => response.json())
    .then((responseJson) => {
    this.setState({
    prijavljeneusluge:responseJson,
    isLoading:false
    }
    )
    })

    

    }

    
  render() {
    if(localStorage.getItem('prijavljen')==="false"){
      return <Redirect to="/login"></Redirect>
    }
    if(this.state.isLoading){
      return(
      <div>Loading</div>
      )
      }

      var t_id=this.state.ids

      var prijavljeneusluge = this.state.prijavljeneusluge.map(function(usluga){
        t_id[usluga.id-3]=0
        return(
          <div className="prijavljenausluga">
          
          <p className="naziv">{usluga.service}</p> 
          <button className="odjavi" onClick={()=>{
              let newDate = new Date()
              let date = newDate.getDate();
              let month = newDate.getMonth() + 1;
              let year = newDate.getFullYear();
              
              var d = year+"-"+month+"-"+date;
              var data={
                username:localStorage.getItem('username'),
                end_date:d
              }
               fetch('/services_users/'+usluga.id,{
                method: "PUT",
                body: JSON.stringify(data),  
                headers:{
                  'Content-Type': 'application/json'
                 }
          
              }).then((response) => response.json())
              .then(
                (responseJson) => {
                  
                  this.setState({
                    isLoading:true
                  })

                })
              }
            }>Odjavi uslugu</button>
        
          </div>

        )  
        
        
        });

        var neprijavljeneusluge = this.state.neprijavljeneusluge.map(function(usluga){
          if(t_id[usluga.id-3]!=0){
          return(
            <div className="prijavljenausluga">
            
            <p className="naziv">{usluga.service}</p> 
            <button className="odjavi" onClick={()=>{
              let newDate = new Date()
              let date = newDate.getDate();
              let month = newDate.getMonth() + 1;
              let year = newDate.getFullYear();
              
              var d = year+"-"+month+"-"+date;
              var data={
                username:localStorage.getItem('username'),
                start_date:d
              }
               fetch('/services_users/'+usluga.id,{
                method: "POST",
                body: JSON.stringify(data),  
                headers:{
                  'Content-Type': 'application/json'
                 }
          
              }).then((response) => response.json())
              .then(
                (responseJson) => {
                  
                  this.setState({
                    isLoading:true
                  })

                })
              }
            }>Prijavi uslugu</button>
          
            </div>
  
          )  
          }
          
          });

    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> User Panel</div>

        <div className="podnaslov"> Prijavljenje usluge</div>

        {prijavljeneusluge}


        <div className="podnaslov"> Neprijavljenje usluge</div>

        {neprijavljeneusluge}

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
