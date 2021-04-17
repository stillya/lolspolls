import React, { useCallback, useState } from 'react';
import { useLocalStore, useObserver } from "mobx-react-lite";
import { RadioButton } from 'react-native-paper';
import { View, Text } from 'react-native';

function Elements(props) {

    const questionsStore = props.store
    const data = props.data
    const type = props.data.type

    const [v, setV] = useState(false)

    // for radio buttons
    const handleSelectRadio = useCallback((item) => {
        console.log(questionsStore.elementsMap.get(item.questionId) === item.value);
        questionsStore.elementsMap.set(item.questionId, item.value)
        console.log(questionsStore.elementsMap);

    }, [questionsStore])

    // for check box
    const handleSelectCheck = useCallback((item) => {

    }, questionsStore)

    // for forms
    const handleUpdateForm = useCallback((item) => {

    }, questionsStore)

    return (
        <View>
            {data.elements.map((item) => (
                <View>
                    {type === 'radio' &&
                        <RadioButton value="fefe" onPress={() => handleSelectRadio(item)}
                            status={questionsStore.elementsMap.get(item.questionId) == item.value
                                ? 'checked' : 'unchecked'} />
                    }
                </View>
            ))}
        </View>
    )

}

export default Elements;