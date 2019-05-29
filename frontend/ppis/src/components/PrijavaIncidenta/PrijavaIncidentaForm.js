import React, { Component } from 'react';
import { Form} from 'react-bootstrap';
import {Redirect} from 'react-router-dom'

import "./PrijavaIncidenta.css"



class PrijavaForm extends Component {

  
  constructor(props) {
    super(props);

      this.state = {redirect: false};
      this.onPrijavi = this.onPrijavi.bind(this)
  }

    
  onPrijavi() {
    this.setState(
      ()=>({
        redirect:true
      })
    )
  }

  

  render() {

    if(this.state.redirect === true){
      return <Redirect to="/pregledusluga"></Redirect>
    }

    return (
     
      <div>

      <Form >
      <Form.Group controlId="exampleForm.ControlSelect1">
          <Form.Label>Usluga </Form.Label>
            <Form.Control as="select">
              <option>Izrada web stranice</option>
              <option>Upravljanje rezervacijama</option>
              <option>Upravljanje uposlenicima</option>
              <option>Upravljanje poslovanjem</option>
              <option>Incident se ne odnosi na uslugu</option>
            </Form.Control>
        </Form.Group>
            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Opis incidenta</Form.Label>
              <Form.Control as="textarea" rows="5" />
            </Form.Group>
                    
          
          
      </Form>

      <button className="submit" onClick={this.onPrijavi} >
      Prijavi incident
      </button>

      </div>
    )
  }
}

export default PrijavaForm;
