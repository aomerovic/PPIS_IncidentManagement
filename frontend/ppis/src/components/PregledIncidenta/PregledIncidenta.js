import React, { Component } from 'react';
import NavBar from '../NavBarManager/NavBar';
import { Form} from 'react-bootstrap';
import './PregledIncidenta.css';
import {Redirect} from 'react-router-dom';

class HomePage extends Component {

  
    



  render() {
    
    if(localStorage.getItem('role')!=="incidentmanager"){
      return <Redirect to="/login"></Redirect>
    }
    

    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> Pregled incidenta</div>

        <div className="prijavljeniincident">
            <p className="naziv">IncidnetId: 10</p>
            <p className="naziv">Usluga: Održavanje web stranice</p>
            <p className="naziv">Datum prijavljivanja: 20.5.2019</p>
            <p className="naziv">Prjavio: username, Ime Prezime</p>
            <div className="kontrolselect">
            <Form >
              <Form.Group controlId="exampleForm.ControlSelect1">
                  <Form.Label>Prioritet: </Form.Label>
                    <Form.Control as="select">
                      <option>nizak</option>
                      <option>srednji</option>
                      <option>visok</option>
                      <option>vrlo visok</option>
                      
                    </Form.Control>
                    <br></br>
                    <Form.Label>Kategorija: </Form.Label>
                    <Form.Control as="select">
                      <option>incident</option>
                      <option>problem</option>
                      <option>potencijalni problem</option>
                    </Form.Control>
                    <br></br>
                    <Form.Label>Status: </Form.Label>
                    <Form.Control as="select">
                      <option>prijavljen</option>
                      <option>aktivan</option>
                      <option>rješen</option>
                      <option>prosljeđen</option>
                      <option>odbijen</option>
                    </Form.Control>
                    <br></br>
                    <Form.Label>Eskaliraj: </Form.Label>
                    <Form.Control as="select">
                      <option>ne</option>
                      <option>da</option>
                    </Form.Control>
                </Form.Group>
            </Form>
            </div>
            <p className="naziv">Izvještaji:</p>
            <p className="naziv">Datum:dd.mm.yyyy </p>
            <p className="naziv">izvještaj1</p>
            <p className="naziv">Datum:dd.mm.yyyy </p>
            <p className="naziv">izvještaj2</p>
            <Form.Group controlId="exampleForm.ControlTextarea1">
              <Form.Label>Novi izvještaj</Form.Label>
              <Form.Control as="textarea" rows="5" />
            </Form.Group>
            <button className="incident">Sačuvaj promjene</button>  
          </div>

          

       
        

      </div>
    );
  }
}

export default HomePage;
