import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import { Card, CardItem } from "native-base";
import { Divider } from 'react-native-elements';

function QuestionElement(props) {

    return (
        <View>
            <Card style={styles.item}>
                <CardItem style={styles.container}>
                <Divider style={{ backgroundColor: '#CDCDC5', }}></Divider>
                    <Text style={styles.text}>{props.data.name}</Text>
                </CardItem>

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
    },
    text: {
        fontSize: 15,
        color: '#000000',
    },
    subtext: {
        color: '#CDCDC5',
        paddingLeft: 10,
        paddingTop: 3
    }
})

export default QuestionElement;