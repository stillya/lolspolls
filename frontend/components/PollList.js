import React from 'react';
import { useLocalStore, useObserver } from "mobx-react-lite";
import { useCallback, useEffect, useState } from "react";
import PollsStore from "../stores/PollsStore";
import { View, Text } from 'react-native';
import { observer } from 'mobx-react';

function PollList(props) {
  // stores

  const pollsStore = useLocalStore(
    () => new PollsStore())

  // values

  const [creationModalOpened, setCreationModalOpened] = useState(false)
  const [updateModalOpened, setUpdateModalOpened] = useState(false)

  // change handlers

  const handleCreatePoll = useCallback((poll) => {
    return pollsStore.createPoll(poll).then(() => {
      pollsStore.loadPolls()
      setCreationModalOpened(false)
    })
  })

  // life cycle

  useEffect(() => {
    pollsStore.loadPolls();
  })
  
  return useObserver(() => {
    console.log(pollsStore.loaded)
    return (
    <View>
        {pollsStore.loaded ? pollsStore.data.map((prop, key) => {
        (
          <Text key={key}>{prop[1]}</Text>
        )
      }) : <Text>Loading...</Text> }
    </View>
    )
  })
}

export default PollList;