import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import { Card, CardItem } from "native-base";
import { Divider } from 'react-native-elements';
import Elements from './Elements';

function QuestionElement(props) {

    return (
        <View>
            <Card style={styles.item}>
                <Text style={styles.text}>{props.data.name}</Text>
                <Divider style={{ backgroundColor: '#CDCDC5', bottom: 10 }}></Divider>
                <CardItem style={styles.container}>
                    <Elements data={props.data} store={props.store} />
                </CardItem>

            </Card>
        </View>
    )

}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
    },
    item: {
        marginRight: 30,
        marginLeft: 30,
        marginTop: 10,
        paddingTop: 20,
        paddingBottom: 10,
        borderRadius: 10,
        borderWidth: 1,
    },
    text: {
        fontSize: 15,
        color: '#000000',
        bottom: 13,
        paddingLeft: 10, 
        fontWeight: "bold"
    },
    subtext: {
        color: '#CDCDC5',
        paddingLeft: 10,
        paddingTop: 3
    }
})

export default QuestionElement;