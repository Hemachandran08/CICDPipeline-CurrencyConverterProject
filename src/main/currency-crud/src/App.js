import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import './App.css';
import Button from '@mui/material/Button';
import { Container, TextField } from '@mui/material';


function App() {
  const [currencies, setCurrencies] = useState([]);
  const [fromCurrency, setFromCurrency] = useState('INR');
  const [toCurrency, setToCurrency] = useState('USD');
  const [amount, setAmount] = useState(1);
  const [convertedAmount, setConvertedAmount] = useState(0);

  useEffect(() => {
    // Fetch available currencies from Spring Boot backend
    axios.get('http://localhost:8001/GetAll')
      .then((response) => {
        setCurrencies(response.data);
      })
      .catch((error) => {
        console.error('Error fetching currencies:', error);
      });
  }, []);

  const handleConvert = () => {
    // Fetch exchange rate and calculate converted amount
    axios.get(`http://localhost:8001/currency-converter/from/${fromCurrency}/to/${toCurrency}/quantity/${amount}`)
      .then((response) => {
        setConvertedAmount(response.data);
      })
      .catch((error) => {
        console.error('Error converting currency:', error);
      });
  };

  return (
    <div>
      <Container id='container' sx={{ bgcolor: 'white', height: '60vh', width: '70vh' }}>
        <h1>Currency Converter</h1>
        <div className="input-container">

          <TextField
            // id="standard-basic" 
            label="Enter the Amount"
            variant="standard"
            type="number"
            role='num'
            id='quantity'
            className='text'
            // value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />

          <h5>From</h5>
          <Dropdown
            // data-testid='dropdown'

            id='fromCurrency'
            className='abc'
            options={currencies.map((currency) => currency.code)}
            value={fromCurrency}
            onChange={(e) => setFromCurrency(e.value)}
          />


          <h5>To</h5>
          <Dropdown
            // data-testid='dropdown'
            className='abc'
            id='toCurrency'
            options={currencies.map((currency) => currency.code)}
            value={toCurrency}
            onChange={(e) => setToCurrency(e.value)}
          />

          <Button
            variant="contained"
            onClick={handleConvert}
            role='btn'
            id='convertButton'
            color="success"
            className='bt'>
            Convert
          </Button>
          {/* <button 
        onClick={handleConvert}
        role='btn'
        id='convertButton'
        >Convert</button> */}
        </div>
        <h6>Converted Amount: {convertedAmount}</h6>
      </Container>


    </div>
  );
}

export default App;
