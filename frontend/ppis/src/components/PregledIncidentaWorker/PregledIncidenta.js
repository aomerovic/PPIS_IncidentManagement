import React, { Component } from 'react';
import NavBar from '../NavBarManager/NavBar';
import { Form} from 'react-bootstrap';
import './PregledIncidenta.css';
import {Redirect} from 'react-router-dom';

class HomePage extends Component {

  constructor(props) {
    super(props);

      this.state = {
        isLoading:true,
        incident:null,
        izvjestaji:[],
        sid:"",
        category:"",
        categoryid:null,
        priority:"",
        priorityid:null,
        escalated:0,
        handle:null,
        noviizvjestaj:""
      }
  }
    
  componentDidMount(){
    fetch('/incident/getincident/'+localStorage.getItem('iid'))
    .then((response) => response.json())
    .then((responseJson) => {
    var h="ne"
    if(responseJson.escalated===1){
      h="da"
    }  
    this.setState({
    incident:responseJson,
    sid:responseJson.sid,
    category:responseJson.category.category,
    categoryid:responseJson.category.id,
    priority:responseJson.priority.priority,
    priorityid:responseJson.priority.id,
    escalated:h,
    handle:responseJson.handle_id
    
    }
    )
    }).then(()=>{
      fetch('/incident_report/getincidentreports/'+localStorage.getItem('iid'))
                 .then((response)=>response.json())
                 .then((responseJson)=>{

                  this.setState({
                    izvjestaji:responseJson,
                    isLoading:false
                  })

                 })
    })
  }


  render() {
    
    
    if(localStorage.getItem('role')!=="uposleni"){
      return <Redirect to="/login"></Redirect>
    }
    if(this.state.isLoading){
      return(
      <div>Loading</div>
      )
      }
      var esc=0
      if(this.state.escalated==="da"){
        esc=1
      }
      var incident=this.state.incident
      var inc={
        id:incident.id,
        service:incident.service,
        category: {
            id: this.state.categoryid,
            category: this.state.category
        },
        description: this.state.incident.description,
        priority: {
            id: this.state.priorityid,
            priority: this.state.priority
        },
        sid:	this.state.sid,
        report_date: incident.report_date,
        user:this.state.incident.user,
        handle_id: this.state.handle,
        escalated: esc
      }
      
      var date=incident.report_date
          
      date = date.substring(0,10);
      var report={
        incident:this.state.incident,
        report:this.state.noviizvjestaj
      }  
      var izv=this.state.izvjestaji.map(function(izvjestaj){
        return(
          <p className="naziv">{izvjestaj.report}</p>
        )
      })
    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> Pregled incidenta</div>

        <div className="prijavljeniincident">
        <p className="naziv">IncidnetId:{incident.id}</p>
            <p className="naziv">Usluga:{incident.service.service}</p>
            <p className="naziv">Prjavio: {incident.user.first_name} {incident.user.last_name},{incident.user.username}</p>
            <p className="naziv">Datum prijavljivanja: {date}</p>
            <p className="naziv">Opis incidenta:</p>
            <p className="naziv">{incident.description}</p>
            <div className="kontrolselect">
            <Form >
              <Form.Group controlId="exampleForm.ControlSelect1">
                  <Form.Label>Prioritet: </Form.Label>
                    <Form.Control as="select" value={this.state.priority} 
                    onChange={(e)=>{
                         if(e.target.value==="nizak"){
                           this.setState({
                             priority:e.target.value,
                             priorityid:2
                           })
                         }
                         if(e.target.value==="srednji"){
                          this.setState({
                            priority:e.target.value,
                            priorityid:3
                          })
                        }  
                        if(e.target.value==="visok"){
                          this.setState({
                            priority:e.target.value,
                            priorityid:4
                          })
                        } 
                        if(e.target.value==="vrlo visok"){
                          this.setState({
                            priority:e.target.value,
                            priorityid:5
                          })
                        } 
                    }}>
                      <option>nizak</option>
                      <option>srednji</option>
                      <option>visok</option>
                      <option>vrlo visok</option>
                      
                    </Form.Control>
                    <br></br>
                    <Form.Label>Kategorija: </Form.Label>
                    <Form.Control as="select" value={this.state.category} 
                    onChange={(e)=>{
                      if(e.target.value==="incident"){
                        this.setState({
                          category:e.target.value,
                          categoryid:2
                        })
                      }
                      if(e.target.value==="potencijalni problem"){
                        this.setState({
                          category:e.target.value,
                          categoryid:4
                        })
                      }
                      if(e.target.value==="problem"){
                        this.setState({
                          category:e.target.value,
                          categoryid:3
                        })
                      }
                    }} >
                      <option>incident</option>
                      <option>problem</option>
                      <option>potencijalni problem</option>
                    </Form.Control>
                    <br></br>
                    <Form.Label>Status: </Form.Label>
                    <Form.Control as="select" value={this.state.sid} 
                    onChange={(e)=>{
                      this.setState({
                        sid:e.target.value
                      })
                    }}>
                      <option>prijavljen</option>
                      <option>aktivan</option>
                      <option>riješen</option>
                      <option>prosljeđen</option>
                      <option>ponovo prijavljen</option>
                      <option>ceka potvrdu</option>
                      <option>odbijen</option>
                    </Form.Control>
                    <br></br>
                    <Form.Label>Eskaliraj: </Form.Label>
                    <Form.Control as="select" value={this.state.escalated} 
                    onChange={(e)=>{
                      this.setState({
                        escalated:e.target.value
                      })
                    }}> 
                      <option>da</option>
                      <option>ne</option>
                      
                    </Form.Control>
                </Form.Group>
            </Form>
            </div>
            <button className="incident" 
            onClick={()=>{
              fetch('/incident/'+incident.id,{
                method: "PUT",
                body: JSON.stringify(inc),  
                headers:{
                  'Content-Type': 'application/json'
                 }
            
              }).then((response) => response.json())
              .then(
                (responseJson) => {
                  alert("Promjene uspješno spašene")
                 
            
                })
            }}>Sačuvaj promjene</button>
            <br></br>
            <br></br>
            <p className="naziv">Izvještaji:</p>
            {izv}
            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Novi izvještaj</Form.Label>
              <Form.Control as="textarea" rows="5" value={this.state.noviizvjestaj} onChange={
                (e)=>{
                  this.setState({
                    noviizvjestaj:e.target.value
                  })
                }
              }/>
            </Form.Group>
            <button className="incident" 
            onClick={()=>{
              if(this.state.noviizvjestaj!==""){
                fetch('/incident_report',{
                  method: "POST",
                  body: JSON.stringify(report),  
                  headers:{
                    'Content-Type': 'application/json'
                   }
            
                }).then((response) => response.json())
                .then((responseJson)=>{
                  alert("Izvještaj uspješno dodan")
                  var l=this.state.izvjestaji
                  l.push(responseJson)
                  this.setState({
                    izvjestaji:l,
                    noviizvjestaj:""
                  })
                })
              }
              else{
                alert("Report ne može biti prazan")
              }
              
            }}>Dodaj izvještaj</button>  
          </div>

          

       
        

      </div>
    );
  }
}

export default HomePage;
