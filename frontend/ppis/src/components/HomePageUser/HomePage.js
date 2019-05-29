import React, { Component } from 'react';
import {Container,Row,Col} from 'react-bootstrap';
import NavBar from '../NavBarUser/NavBar';
import Usluga from "../UslugaComponent/UslugaComponent"
import './HomePage.css'

class HomePage extends Component {

  constructor(props) {
    super(props);
    this.state = {

      opiskratki1:"Naš tim web programera će dovesti vašu stranicu od koncepta do stvarnosti.Od početne ideje mi ćemo biti s Vama na svakom koraku i pomoći u razvoju dizajna i implementaciji web stranice prema Vašoj želji.",
      opiskratki2:"Rezervacijski sistemi koje razvija naš tim imaju veliki značaj za poslovanje jer se ujedno pojavljuju i kao sistemi online baza podataka koji turističkim firmama omogućuju bolje upravljanje kapacitetima. Naš sistem nudi mogućnosti rezervacije putem web stranice.",
      opiskratki3:"Sistem upravljanja je alat koji unapređuje i olakšava poslovanje firmi, kroz efikasnije upravljanje uposlenicima i procesima unutar firme. Isplativost uvođenja našeg sistema je velika i rezultuje značajno bržem ostvarenju poslovnih ciljeva, kroz efikasniju upotrebu resursa, povećanju ukupne produktivnosti i pouzdanosti",
      opiskratki4:"Naše softversko rješenje namijenjeno je cjelovitom upravljanju poslovanjem hotelskih objekata. Jednostavno je za korištenje i lahko prilagodljivo različitim kategorijama, veličinama i potrebama hotela.",

    };
  }


  render() {
    return (
      
      <div className="HomePage">
        <NavBar></NavBar>
       
        <div className="naslov"> Pregled usluga</div>

        <div className="body">

        <Container>

         
          <Row>

              <Col sm>
                  <Usluga name="Izrada web stranice" cijena="35.00" kratkiopis={this.state.opiskratki1} url="/usluga1u"/>
              </Col>

              <Col sm>
                  <Usluga name="Upravljanje rezervacijama" cijena="50.00" kratkiopis={this.state.opiskratki2} url="/usluga2u"/>
              </Col>

          </Row>

          <Row>

              <Col sm>
                <Usluga name="Upravljanje uposlenicima" kratkiopis={this.state.opiskratki3} cijena="50.00" url="/usluga3u"/>
              </Col>

              <Col sm>
              <Usluga name="Upravljanje poslovanjem" kratkiopis={this.state.opiskratki4} cijena="50.00" url="/usluga4u"/>
              </Col>



          </Row>

        </Container>
          

            

            

            

            


          
          
        </div>
        

      </div>
    );
  }
}

export default HomePage;
