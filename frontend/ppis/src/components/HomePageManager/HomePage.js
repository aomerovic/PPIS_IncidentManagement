import React, { Component } from 'react';
import NavBar from '../NavBarManager/NavBar';
import {Redirect} from 'react-router-dom';
import { Form} from 'react-bootstrap';
import './HomePage.css';


class HomePage extends Component {

  constructor(props) {
    super(props);

      this.state = {
        redirect: false,
        id:0,
        isLoading:true,
        incidenti:[],
      };
      this.vise = this.vise.bind(this)
  }

    
  vise(r) {
    this.setState(
      ()=>({
        redirect:true,
        id:r,
    
      })
    )
  }

  componentDidMount(){
    fetch('/incident')
    .then((response) => response.json())
    .then((responseJson) => {
    this.setState({
    incidenti:responseJson,
    select:"prijavljen",
    isLoading:false
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
    if(this.state.redirect === true){
      return <Redirect to="/pregledincidenta"></Redirect>
    }
    var that=this  
    var incidenti=this.state.incidenti.map(function(incident){
      var date=incident.report_date
          
      date = date.substring(0,10); 
      if(incident.sid===that.state.select){
        return(

          <div className="prijavljeniincident">
            <p className="naziv">IncidnetId:{incident.id}</p>
            <p className="naziv">Usluga:{incident.service.service}</p>
            <p className="naziv">Prjavio: {incident.user.first_name} {incident.user.last_name},{incident.user.username}</p>
            <p className="naziv">Datum prijavljivanja: {date}</p>
            <p className="naziv">Status: {incident.sid}</p>
            <p className="naziv">Prioritet: {incident.priority.priority}</p>
            <p className="naziv">Kategorija: {incident.category.category}</p>
            <p className="naziv">Opis incidenta:</p>
            <p className="naziv">{incident.description}</p>
        
            <button className="incident" onClick={() => {this.setState(
                                                                        {
                                                                          redirect:true,
                                                                          id:1
                                                                        })
                                                         }
                                                    }>Više</button>  
          </div>

        )
      }
    })

    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> Pregled incidenata</div>
        <Form.Group controlId="exampleForm.ControlSelect1" className="select">
          <Form.Label> </Form.Label>
            <Form.Control as="select" onChange={
              (e)=>{
                this.setState({
                  select:e.target.value
                })
              }
            }>
              <option>prijavljen</option>
              <option>aktivan</option>    
              <option>ponovo prijavljen</option>
              <option>odbijen</option>
            </Form.Control>
        </Form.Group>

        
        {incidenti}
          

        <div className="body">          


          
          
        </div>
        

      </div>
    );
  }
}

export default HomePage;
