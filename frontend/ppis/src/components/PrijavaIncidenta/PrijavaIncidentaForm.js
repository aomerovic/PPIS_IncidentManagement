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
        opis:''
      };
      this.onPrijava = this.onPrijava.bind(this)
  }

    
  onPrijava() {
   if(this.state.opis===""){
     alert("opis incidenta ne može biti prazan")
     return
   }

   
  
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
                  usluga:2
                })
              }
              if(e.target.value==="Upravljanje rezervacijama"){
                this.setState({
                  usluga:3
                })
              }
              if(e.target.value==="Upravljanje uposlenicima"){
                this.setState({
                  usluga:4
                })
              }
              if(e.target.value==="Upravljanje poslovanjem"){
                this.setState({
                  usluga:5
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
