import React from 'react';
import { StyleSheet } from 'react-native';
import { Spinner } from 'native-base';

function MainSpinner(props) {
    return (
        <Spinner style={styles.container} color='#DCAD76' />
    )
}


const styles = StyleSheet.create({
    container: {
        position: 'absolute',
        top: "750%",
        left: "48%"
    }
});

export default MainSpinner