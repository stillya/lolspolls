import React from 'react';
import { useLocalStore, useObserver } from "mobx-react-lite";
import { useParams } from "react-router";
import MainHeader from "./commons/MainHeader";
import QuestionsStore from '../stores/QuestionsStore';
import MainSpinner from './commons/MainSpinner';
import { useCallback, useEffect, useState } from "react";
import { View, Text, ScrollView, RefreshControl } from 'react-native';
import QuestionElement from './QuestionElement';

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
                                <QuestionElement data={item} />
                            ))}
                        </ScrollView>

                    </RefreshControl>

                    :
                    <MainSpinner />
                }
            </View>
        )
    })

}

export default QuestionList;