import React, { useEffect } from 'react';
import { Body, Header, Title, Text } from 'native-base';
import { RefreshControl, StyleSheet } from 'react-native';

function MainHeader(props) {
    return (
            <Header androidStatusBarColor='black' style={styles.container} rounded={false}>
                <Title style={styles.text}>
                    Lolspolls
            </Title>
            </Header >
    )
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: 'black',
        height: 47,
    },
    text: {
        color: '#DCAD76',
        paddingTop: 8,
        fontWeight: 'normal',
        fontFamily: "LeckerliOne-Regular",
        fontSize: 22
    }
});

export default MainHeader