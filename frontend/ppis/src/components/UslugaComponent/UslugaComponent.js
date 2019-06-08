import React, { Component } from 'react';


import "./UslugaComponent.css"





class UslugaComponent extends Component {



  render() {

    

    return (
     
      <div className="Usluga">

        <div className="usluganame">
            {this.props.name}
        </div>

        <div className="uslugaopis">
            <p className="opis">
              {this.props.kratkiopis}
            </p>
            <p className="cijena">
                {this.props.cijena} KM/Mjesečno
            </p>
            <a href={this.props.url}>
            <button className="vise"  >VIŠE</button>
            </a>
        </div>
        

      </div>
      
    );
  }
}

export default UslugaComponent;
