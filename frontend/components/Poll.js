import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

import { useObserver } from "mobx-react-lite"
import MainHeader from "./commons/MainHeader"

function Poll(props) {

    return useObserver(() => {
        return (
            <View>
                <MainHeader />
                <Text>Hello world</Text>
            </View>
        )
    })
}

export default Poll