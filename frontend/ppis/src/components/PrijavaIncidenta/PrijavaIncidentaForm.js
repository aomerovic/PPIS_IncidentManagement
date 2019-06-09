import React, { Component } from 'react';
import { Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom'

import "./PrijavaIncidenta.css"



class PrijavaForm extends Component {

  
  constructor(props) {
    super(props);

      this.state = {
        redirect: false,
        usluga:2,
        ime:"Izrada web stranice",
        cijena:"35.00",
        opis:'',
      };
      this.onPrijava = this.onPrijava.bind(this)
  }

    
  onPrijava() {
   if(this.state.opis===""){
     alert("opis incidenta ne može biti prazan")
     return
   }
   var incident={
    
    service: {
        id: this.state.usluga,
        service: this.state.ime,
        service_price: this.state.cijena
    },
    category: {
        id: 2,
        category: "incident"
    },
    description: this.state.opis,
    priority: {
        id: 3,
        priority: "srednji"
    },
    sid:	"prijavljen",
    report_date: "2019-06-29T00:00:00.000+0000",
    user: {
        id: localStorage.getItem('id'),
        first_name: "korisnik1",
        last_name: "korinik1",
        username: localStorage.getItem('username'),
        password: localStorage.getItem('password'),
        role: {
            id: 2,
            role: "user"
        }
    },
    handle_id: 2,
    escalated: 0
  }

  fetch('/incident',{
    method: "POST",
    body: JSON.stringify(incident),  
    headers:{
      'Content-Type': 'application/json'
     }

  }).then((response) => response.json())
  .then(
    (responseJson) => {
      
      if(responseJson.message==="User not assigned to service"){
        alert("Da bi ste prijavili incident morate biti korisnik usluge")
      }
      else{
        alert("Uspješno prijavljen incident")
      }

    })
   
  
  }

  

  render() {

    

    return (
     
      <div>

      <Form >
      <Form.Group controlId="exampleForm.ControlSelect1">
          <Form.Label>Usluga </Form.Label>
            <Form.Control as="select" onChange={(e)=>{
              if(e.target.value==="Izrada web stranice"){
                this.setState({
                  usluga:2,
                  ime:"Izrada web stranice",
                  cijena:"35.00"
                })
              }
              if(e.target.value==="Upravljanje rezervacijama"){
                this.setState({
                  usluga:3,
                  ime:"Upravljanje rezervacijama",
                  cijena:"50.00"
                })
              }
              if(e.target.value==="Upravljanje uposlenicima"){
                this.setState({
                  usluga:4,
                  ime:"Upravljanje uposlenicima",
                  cijena:"50.00"
                })
              }
              if(e.target.value==="Upravljanje poslovanjem"){
                this.setState({
                  usluga:5,
                  ime:"Upravljanje poslovanjem",
                  cijena:"50.00"
                })
              }
              
              }}>
              <option>Izrada web stranice</option>
              <option>Upravljanje rezervacijama</option>
              <option>Upravljanje uposlenicima</option>
              <option>Upravljanje poslovanjem</option>
            </Form.Control>
        </Form.Group>
            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Opis incidenta</Form.Label>
              <Form.Control as="textarea" rows="5" value={this.state.opis} onChange={(e)=>{
              this.setState({
                opis:e.target.value
              })
            }}/>
            </Form.Group>
                    
          
          
      </Form>

      <button className="submit" onClick={this.onPrijava} >
      Prijavi incident
      </button>

      </div>
    )
  }
}

export default PrijavaForm;
