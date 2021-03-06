import React from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';

export default class App extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Text>Open up App.js to start working on your app!</Text>
        <Text>Changes you make will automatically reload.</Text>
        <Text>Shake your phone to open the developer menu.</Text>
        <Button style={but.container} title="TEST" onPress={() => alertss('Simple Button pressed')}></Button>
      </View>
    );
  }
}

const but = StyleSheet.create({
  container: {
    backgroundColor: '#FFFFFF',
  }
});

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#cef',
    alignItems: 'center',
    justifyContent: 'center',
  },
});