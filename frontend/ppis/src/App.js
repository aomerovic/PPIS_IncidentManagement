import React, { Component } from 'react';
import {BrowserRouter ,Route,Switch} from 'react-router-dom';
import HomePage from './components/HomePage/HomePage';
import UslugaOpis from "./components/UslugaOpis/UslugaOpis";
import UslugaOpisU from "./components/UslugaOpisUser/UslugaOpis";
import Login from './components/LoginPage/LoginPage'
import Prijava from './components/PrijavaPage/PrijavaPage';
import User from './components/HomePageUser/HomePage';
import PrijavaInidenta from './components/PrijavaIncidenta/PrijavaIncidenta'
import HomePageManager from './components/HomePageManager/HomePage';
import Statistika from './components/HomePageManagerStatistika/HomePage';
import UserPanel from './components/HomePageUserPanel/HomePage';
import PregledIncidenta from './components/PregledIncidenta/PregledIncidenta';
import './App.css';

const opis1="Naš tim web programera će dovesti vašu stranicu od koncepta do stvarnosti. Od početne ideje mi ćemo biti s Vama na svakom koraku i pomoći u razvoju dizajna i implementaciji web stranice prema Vašoj želji. Vaša stranica će izgledati sjajno i biti će prilagođena današnjem turističkom tržištu. Osim toga, imamo iskustva u integraciji web stranica s raznim drugim tehnologijama uključujući i našu bazu podataka koja pruža personalizirana rješenja koja ce zadovoljiti sve vaše potrebe.";
const opis2="Rezervacijski sistemi koje razvija naš tim imaju veliki značaj za poslovanje jer se ujedno pojavljuju i kao sistemi online baza podataka koji turističkim firmama omogućuju bolje upravljanje kapacitetima. Tehnologije koje koristimo u našem sistemu primjenjuju se za različite poslovne funkcije, komunikacije, pružanje usluge gostu i za same goste. Hotelsko poslovanje, sa svim svojim specifičnostima, zahtijeva maksimalnu ažurnost podataka. Naš sistem nudi mogućnosti rezervacije putem web stranice. Nakon izrade sistema rezervacije nudimo i mogućnost održavanja sistema što uključuje ispravku bugova, unapređenje sistema i dodavanja eventualno novih funkcionalnosti.";
const opis3="Sistem upravljanja je alat koji unapređuje i olakšava poslovanje firmi, kroz efikasnije upravljanje uposlenicima i procesima unutar firme. Isplativost uvođenja našeg sistema je velika i rezultuje značajno bržem ostvarenju poslovnih ciljeva, kroz efikasniju upotrebu resursa, povećanju ukupne produktivnosti i pouzdanosti, razvoju kompetencija uposlenih i smanjenje broja grešaka. Akcenat je na samom sistemu koji se implementira i koji doprinosi unapređenju poslovanja, a softverska podrška često olakšava implementaciju i kontinualno sprovođenje sistema.";
const opis4="Naše softversko rješenje namijenjeno je cjelovitom upravljanju poslovanjem hotelskih objekata. Jednostavno je za korištenje i lahko prilagodljivo različitim kategorijama, veličinama i potrebama hotela. Omogućava upravljanje poslovanjem malih, obiteljskih hotela, ali jednako tako i zahtjevnih velikih hotelskih poduzeća koja imaju potrebu za istovremenim vođenjem više odvojenih smještajnih objekata.Kroz održavanje sistema, podržavamo kontinuirani razvoj istog i mogućnost uključivanja i isključivanja različitih modula po želji klijenta.";

const Home = () => (
  <HomePage />
);

const Usluga1 = () => (
  <UslugaOpis name="Web stranica" opis={opis1} cijena="35.00" />
);

const Usluga2 = () => (
  <UslugaOpis name="Sistem za rezervacije" opis={opis2} cijena="50.00"/>
);

const Usluga3 = () => (
  <UslugaOpis name="Sistema za upravljanje uposlenicima" opis={opis3} cijena="50.00"/>
);

const Usluga4 = () => (
  <UslugaOpis name="Sistem za upravljanje poslovanjem" opis={opis4} cijena="50.00"/>
);

const Usluga1u = () => (
  <UslugaOpisU name="Web stranica" opis={opis1} cijena="35.00" />
);

const Usluga2u = () => (
  <UslugaOpisU name="Sistem za rezervacije" opis={opis2} cijena="50.00"/>
);

const Usluga3u = () => (
  <UslugaOpisU name="Sistem za upravljanje uposlenicima" opis={opis3} cijena="50.00"/>
);

const Usluga4u = () => (
  <UslugaOpisU name="Sistema za upravljanje poslovanjem" opis={opis4} cijena="50.00"/>
);

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
        
          <Route exact path="/" component={Home} />
          <Route path="/usluga1" component={Usluga1} />
          <Route path="/usluga2" component={Usluga2} />
          <Route path="/usluga3" component={Usluga3} />
          <Route path="/usluga4" component={Usluga4} />
          <Route path="/usluga1u" component={Usluga1u} />
          <Route path="/usluga2u" component={Usluga2u} />
          <Route path="/usluga3u" component={Usluga3u} />
          <Route path="/usluga4u" component={Usluga4u} />
          <Route path="/login" component={Login} />
          <Route path="/prijava" component={Prijava} />
          <Route path="/pregledusluga" component={User} />
          <Route path="/prijavaincidenta" component={PrijavaInidenta} />
          <Route path="/incidentmanageradmin" component={HomePageManager} />
          <Route path="/statistika" component={Statistika} />
          <Route path="/userpanel" component={UserPanel} />
          <Route path="/pregledincidenta" component={PregledIncidenta} />

        </Switch>
      </BrowserRouter>
    );
  }
}

export default App;