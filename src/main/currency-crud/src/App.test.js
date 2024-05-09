import { render, screen } from '@testing-library/react';
import App from './App';
import Dropdown from 'react-dropdown';
import 'react-dropdown/style.css';
import React from 'react';
import { ReactDOM } from 'react';


  it("renders 'number' ", () => {
  render(<App />);
  const linkElement = screen.getByRole("num");
  expect(linkElement).toBeInTheDocument();
  });

  it("renders 'content' ", () => {
    render(<App />);
    const linkElement = screen.getByRole("content");
    expect(linkElement).toBeInTheDocument();
  });
   
    it('renders Currency Converter ', () =>{
      render(<App/>);
      const linkElement = screen.getByText("Currency Converter");
      expect(linkElement).toBeInTheDocument();
    });

     test.skip("renders 'dropdown' ", () => {
      render(<App />);
      const linkElement = screen.getByTestId("dropdown");
      expect(linkElement).toBeInTheDocument();
    });

    it('renders button ', () => {
      render(<App/>);
      const linkElement = screen.getByRole("btn");
      expect(linkElement).toBeInTheDocument();
    });