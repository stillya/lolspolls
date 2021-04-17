import React from 'react';
import { useLocalStore, useObserver } from "mobx-react-lite";
import { useParams } from "react-router";
import MainHeader from "./commons/MainHeader";
import QuestionsStore from '../stores/QuestionsStore';
import MainSpinner from './commons/MainSpinner';
import { useCallback, useEffect, useState } from "react";
import { View, Text, ScrollView, RefreshControl, StyleSheet } from 'react-native';
import QuestionElement from './QuestionElement';
import { Button } from 'native-base';
import { color } from 'react-native-reanimated';

function QuestionList(props) {
    // stores

    const questionsStore = useLocalStore(
        () => new QuestionsStore())

    // values

    const [refreshing, setRefreshing] = useState(false);
    const { pollId } = useParams();

    // change handlers

    const handleUpdateQuestion = useCallback(() => {
        setRefreshing(true);
        questionsStore.refreshQuestions(pollId)
        setRefreshing(false)
    }, [questionsStore])

    // life cycle

    useEffect(() => {
        questionsStore.loadQuestions(pollId)
    }, [])

    return useObserver(() => {
        return (
            <View>
                <MainHeader />

                {questionsStore.loaded ?

                    <RefreshControl style={{ marginBottom: 100 }}
                        refreshing={refreshing}
                        onRefresh={handleUpdateQuestion}>

                        <ScrollView>
                            {questionsStore.data.map((item) => (
                                <QuestionElement data={item} store={questionsStore} />
                            ))}

                            <Button style={styles.container} rounded dark>
                                <Text style={styles.text}>Send</Text>
                            </Button>
                            
                        </ScrollView>

                    </RefreshControl>

                    :
                    <MainSpinner />
                }
            </View>
        )
    })

}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginTop: 15,
        marginLeft: 80,
        marginRight: 80,
        color: '#fff'
    }, 
    text: {
        color: '#DCAD76',
        fontWeight: 'normal',
        fontFamily: "LeckerliOne-Regular",
        fontSize: 22
    }
})

export default QuestionList;