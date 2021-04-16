import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import { Container, Header, Content, Card, CardItem, Body } from 'native-base';

function PollElement(props) {

    return (
        <View>
            <Card style={styles.item}>
                <CardItem style={styles.container} >
                    <Text style={styles.text}>{props.data.name}</Text>
                </CardItem>
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
        paddingBottom: 20,
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
    }
})

export default PollElement