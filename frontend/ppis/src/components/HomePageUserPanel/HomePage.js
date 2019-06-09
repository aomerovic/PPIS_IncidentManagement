import React, { Component } from 'react';
import { Form} from 'react-bootstrap';
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
    odbijen:"",
    ceka:"",
    redirect:false,
    ids:[2,3,4,5],
    incidneti:[]
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
    }
    )
    }).then(

    fetch('/incident/getincidents/'+localStorage.getItem('id'))
    .then((response)=>response.json())
    .then((responseJson)=>{

      this.setState({
        incidneti:responseJson,      
      })
    }).then(
       ()=>{
        global.that=this 
        global.incidenti=this.state.incidneti.map(function(incident){
          var date=incident.report_date
          
          date = date.substring(0,10);   

          if(incident.sid==="ceka potvrdu"){
            return (
  
              <div className="prijavljeniincident">
              <p className="naziv">IncidnetId:{incident.id}</p>
              <p className="naziv">Usluga:{incident.service.service}</p>
              <p className="naziv">Datum prijavljivanja: {date}</p>
              <p className="naziv">Opis incidenta:</p>
              <p className="naziv">{incident.description}</p>
              <p className="naziv">Status: {incident.sid}</p>
              <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Novi opis incidenta</Form.Label>
              <Form.Control as="textarea" rows="5" onChange={(e)=>{
              global.that.setState({
                ceka:e.target.value
              })
            }}/>
            </Form.Group>
                
              <button className="odjavi" onClick={()=>{
                 fetch('/incident_report/getincidentreports/'+incident.id)
                 .then((response)=>response.json())
                 .then((responseJson)=>{
                  var o=Object.keys(responseJson).length
                  var l=[]
                  for( var i=0;i<o;i++){
                     l.push(responseJson[i].report)
                  }
                  if(l.length===0){
                    alert("Nema izvještaja")
                  }
                  else{
                    alert(l)
                  }
                 
                   
                 })
                 
                }
              }>Prkaži izvještaje</button>
              
              
              <a href="/userpanel"><button className="odjavi" onClick={
                ()=>{
                  var inc={
                    id:incident.id,
                    service: incident.service,
                    category:incident.category,
                    description: global.that.state.ceka,
                    priority: {
                        id: 3,
                        priority: "srednji"
                    },
                    sid:"ponovo prijavljen",
                    report_date: incident.report_date,
                    user: incident.user,
                    handle_id: 2,
                    escalated: incident.escalated
                  }
                
                  fetch('/incident/'+incident.id,{
                    method: "PUT",
                    body: JSON.stringify(inc),  
                    headers:{
                      'Content-Type': 'application/json'
                     }
                
                  }).then((response) => response.json())
                  .then(
                    (responseJson) => {
                      
                     
                
                    })
                   
                  
                  
                }
              }>Prijavi ponovo</button></a>    
          </div>
            )

          }
          
          if(incident.sid==="odbijen"){
            var t=incident.description
            return (
  
              <div className="prijavljeniincident">
              <p className="naziv">IncidnetId:{incident.id}</p>
              <p className="naziv">Usluga:{incident.service.service}</p>
              <p className="naziv">Datum prijavljivanja: {date}</p>
              <p className="naziv">Opis incidenta:</p>
              <p className="naziv">{incident.description}</p>
              <p className="naziv">Status: {incident.sid}</p>
              <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Opis incidenta</Form.Label>
              <Form.Control as="textarea" rows="5" onChange={(e)=>{
              global.that.setState({
                odbijen:e.target.value
              })
            }}/>
            </Form.Group>
                
              <button className="odjavi" onClick={()=>{
                 fetch('/incident_report/getincidentreports/'+incident.id)
                 .then((response)=>response.json())
                 .then((responseJson)=>{
                  var o=Object.keys(responseJson).length
                  var l=[]
                  for( var i=0;i<o;i++){
                     l.push(responseJson[i].report)
                  }
                  if(l.length===0){
                    alert("Nema izvještaja")
                  }
                  else{
                    alert(l)
                  }
                 
                   
                 })
                 
                }
              }>Prkaži izvještaje</button>
              
              
              <a href="/userpanel"><button className="odjavi" onClick={
                ()=>{
                  var inc={
                    id:incident.id,
                    service: incident.service,
                    category:incident.category,
                    description: global.that.state.odbijen,
                    priority: {
                        id: 3,
                        priority: "srednji"
                    },
                    sid:"ponovo prijavljen",
                    report_date: incident.report_date,
                    user: incident.user,
                    handle_id: 2,
                    escalated: incident.escalated
                  }
                
                  fetch('/incident/'+incident.id,{
                    method: "PUT",
                    body: JSON.stringify(inc),  
                    headers:{
                      'Content-Type': 'application/json'
                     }
                
                  }).then((response) => response.json())
                  .then(
                    (responseJson) => {
                      
                     alert(JSON.stringify(responseJson))
                
                    })
                   
                  
                  
                }
              }>Prijavi ponovo</button></a>        
          </div>
            )

          }
         
            return (
  
            <div className="prijavljeniincident">
            <p className="naziv">IncidnetId:{incident.id}</p>
            <p className="naziv">Usluga:{incident.service.service}</p>
            <p className="naziv">Datum prijavljivanja: {date}</p>
            <p className="naziv">Opis incidenta:</p>
            <p className="naziv">{incident.description}</p>
            <p className="naziv">Status: {incident.sid}</p>
              
            <button className="odjavi" onClick={()=>{
               fetch('/incident_report/getincidentreports/'+incident.id)
               .then((response)=>response.json())
               .then((responseJson)=>{
                var o=Object.keys(responseJson).length
                var l=[]
                for( var i=0;i<o;i++){
                   l.push(responseJson[i].report)
                }
                if(l.length===0){
                  alert("Nema izvještaja")
                }
                else{
                  alert(l)
                }
               
                 
               })
               
              }
            }>Prkaži izvještaje</button>
                
        </div>
          )

          

        
          

        })

       

       }
     
      
      

    ).then(()=>{
      this.setState({
        isLoading:false
      })
    })

    )

    

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
          <a href="/userpanel"><button className="odjavi" onClick={()=>{
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
            }>Odjavi uslugu</button></a>
        
          </div>

        )  
        
        
        });
      

        var neprijavljeneusluge = this.state.neprijavljeneusluge.map(function(usluga){
          if(t_id[usluga.id-3]!=0){
          return(
            <div className="prijavljenausluga">
            
            <p className="naziv">{usluga.service}</p> 
            <a href="/userpanel"><button className="odjavi" onClick={()=>{
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
                  
                 

                })
              }
            }>Prijavi uslugu</button></a>
          
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

        {global.incidenti}
        

        <div className="body">

       
          
          
        </div>
        

      </div>
    );
  }
}

export default HomePage;
