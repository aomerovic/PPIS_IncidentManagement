import React, { Component } from 'react';
import { Form } from 'react-bootstrap';
import {Redirect} from 'react-router-dom'
import "./PrijavaPage.css"



class PrijavaForm extends Component {

  constructor(props) {
    super(props);

      this.state = {redirect: false};
      this.onLogin = this.onLogin.bind(this)
  }

    
  onLogin() {
    this.setState(
      ()=>({
        redirect:true
      })
    )
  }

  render() {

    if(this.state.redirect === true){
      return <Redirect to="/incidentmanageradmin"></Redirect>
    }



    return (
      <div>
      <Form>
  <Form.Group>   
    <Form.Control type="username" placeholder="Ime" />
  </Form.Group>

  <Form.Group>   
    <Form.Control type="username" placeholder="Prezime" />
  </Form.Group>

  <Form.Group controlId="formBasicPassword">

    <Form.Control type="password" placeholder="Šifra" />
  </Form.Group>

  <Form.Group controlId="formBasicPassword">

    <Form.Control type="password" placeholder="Ponovite šifru" />
  </Form.Group>

</Form>
<button className="submit" onClick={this.onLogin}>
    Prijavi se
  </button>
  </div>
    )
  }
}

export default PrijavaForm;
