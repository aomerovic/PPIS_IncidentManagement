import React, { Component } from 'react';
import {Navbar,Nav} from 'react-bootstrap';
import './NavBar.css'

class NavBar extends Component {

render(){
    return(
     <div className="navbar"> 
      <Navbar  expand="lg">
      <Navbar.Brand href="/" style={{color:'#498fff'}}><h3>Hotel IT Solutions</h3></Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
       <Nav className="mr-auto"></Nav>
      
        <Nav.Link href="/"><p className="textlink">Pregled usluga</p> </Nav.Link>
        <Nav.Link href="/login"><p className="textlink">Login</p> </Nav.Link>
        <Nav.Link href="/prijava"><p className="textlink">Prijava</p> </Nav.Link>
       
      </Navbar.Collapse>
      </Navbar>
    </div>  
    );
}

}

export default NavBar;