import React, { useCallback, useState } from 'react';
import { useLocalStore, useObserver } from "mobx-react-lite";
import { RadioButton, TextInput } from 'react-native-paper';
import { View, Text } from 'react-native';

function useForceUpdate() {
    const [value, setValue] = useState(0); // integer state
    return () => setValue(value => value + 1); // update the state to force render
}

function Elements(props) {

    const questionsStore = props.store
    const data = props.data
    const type = props.data.type

    const forceUpdate = useForceUpdate();

    // for radio buttons
    const handleSelectRadio = useCallback((item) => {
        console.log(questionsStore.elementsRadioMap.get(item.questionId) === item.value);
        questionsStore.elementsRadioMap.set(item.questionId, item.value)
        console.log(questionsStore.elementsRadioMap);
        forceUpdate();
    }, [questionsStore])

    // for check box
    const handleSelectCheck = useCallback((questionId, text) => {
        const prev = questionsStore.elementsAreaMap.get(questionId)
        console.log(prev);
        // if (prev) {
        //     questionsStore.elementsAreaMap.set(questionId, prev + text)
        // }
        questionsStore.elementsAreaMap.set(questionId, text)
        console.log(questionsStore.elementsAreaMap.get(questionId));
    }, questionsStore)

    const [text, setText] = React.useState('');


    // for forms
    const handleUpdateForm = useCallback((item) => {
        console.log(item);
    }, questionsStore)

    return (
        <View>
            {data.elements.map((item) => (
                <View>
                    {type === 'radio' &&
                        <View>
                            <Text>{item.value}</Text>
                            <RadioButton color='#DCAD76' onPress={() => handleSelectRadio(item)}
                                status={questionsStore.elementsRadioMap.get(item.questionId) == item.value
                                    ? 'checked' : 'unchecked'} />
                        </View>
                    }
                    {type === 'text' &&
                        <View>
                            <Text>{item.value}</Text>
                            <TextInput
                                value={questionsStore.elementsAreaMap.get(item.questionId)}
                                onChangeText={text => handleSelectCheck(item.questionId, text)}
                                selectionColor='#DCAD76' mode='outlined'
                            />
                        </View>
                    }
                </View>
            ))}
        </View>
    )

}

export default Elements;