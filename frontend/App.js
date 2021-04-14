import React from 'react';
import {NativeRouter,Route,Link} from "react-router-native";
import Routes from './app/Routes';

export default class App extends React.Component {
  render() {
    return (
        <NativeRouter>
          <Routes/>
        </NativeRouter>
    );
  }
}