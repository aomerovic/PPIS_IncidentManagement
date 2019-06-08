import React, { Component } from 'react';
import NavBar from '../NavBarWorker/NavBar';
import {Redirect} from 'react-router-dom';
import { Form} from 'react-bootstrap';
import './HomePage.css';


class HomePage extends Component {

  constructor(props) {
    super(props);

      this.state = {
        redirect: false,
        id:0
      };
      this.vise = this.vise.bind(this)
  }

    
  vise(r) {
    this.setState(
      ()=>({
        redirect:true,
        id:r
      })
    )
  }


  render() {
    if(localStorage.getItem('role')!=="uposleni"){
      return <Redirect to="/login"></Redirect>
    }

    if(this.state.redirect === true){
      return <Redirect to="/pregledincidentauposleni"></Redirect>
    }

    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> Pregled incidenata</div>
        <Form.Group controlId="exampleForm.ControlSelect1" className="select">
          <Form.Label> </Form.Label>
            <Form.Control as="select">
              <option>prijavljeni</option>
              <option>aktivni</option>    
            </Form.Control>
        </Form.Group>

        <div className="prijavljeniincident">
            <p className="naziv">IncidnetId: 10</p>
            <p className="naziv">Usluga: Održavanje web stranice</p>
            <p className="naziv">Datum prijavljivanja: 20.5.2019</p>
            <p className="naziv">Prjavio: username, Ime Prezime</p>
            <p className="naziv">Prioritet: srednji</p>
            <p className="naziv">Kategorija: incident</p>
            <p className="naziv">Status: prijavljen</p>
            <button className="incident" onClick={() => {this.setState(
                                                                        {
                                                                          redirect:true,
                                                                          id:1
                                                                        })
                                                         }
                                                    }>Više</button>  
          </div>

          

        <div className="body">          


          
          
        </div>
        

      </div>
    );
  }
}

export default HomePage;
