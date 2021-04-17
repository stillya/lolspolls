import React from 'react';
import { useCallback } from "react";
import { View, Text, StyleSheet } from 'react-native';
import { Container, Header, Content, Card, CardItem, Body } from 'native-base';
import { useHistory, Link } from 'react-router';
import { Divider } from 'react-native-elements';

function PollElement(props) {

    let history = useHistory()

    const handleClick = useCallback((pollId) => {
        history.push("/poll/" + pollId)
    }, [history])

    return (
        <View>
            <Card style={styles.item} onPress={() => handleClick(props.data.id)}>
                <CardItem style={styles.container} button onPress={() => handleClick(props.data.id)}>
                    <Text style={styles.text}>{props.data.name}</Text>
                </CardItem>
                <Divider style={{ backgroundColor: '#CDCDC5' }}></Divider>
                <Text style={styles.subtext}>{props.data.date} | {props.data.owner.name}</Text>
            </Card>
        </View>
    )

}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        height: 50
    },
    item: {
        marginRight: 30,
        marginLeft: 30,
        marginTop: 10,
        paddingTop: 20,
        paddingBottom: 10,
        borderRadius: 10,
        borderWidth: 1,
        height: 130
    },
    text: {
        fontSize: 20,
        color: '#000000',
        justifyContent: 'center',
        alignItems: 'center'
    },
    subtext: {
        color: '#CDCDC5',
        paddingLeft: 10,
        paddingTop: 3
    }
})

export default PollElement